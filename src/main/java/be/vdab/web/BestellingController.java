package be.vdab.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;


@Controller
@RequestMapping("/bestelling")
class BestellingController {
	
	private final BierService bierService;
	private final BestelbonService bestelbonService;
	private final Winkelwagen winkelwagen;
	
	@Autowired
	public BestellingController(BierService bierService, BestelbonService bestelbonService, Winkelwagen winkelwagen) {
		this.bierService = bierService;
		this.bestelbonService = bestelbonService;
		this.winkelwagen = winkelwagen;
		
	}
	
	//WINKELWAGEN BESTELLING TOEVOEGEN
	@RequestMapping(value="toevoegen/{bierNr}", method= RequestMethod.POST)
	public ModelAndView toevoegenWinkelwagen(@PathVariable long bierNr, @Valid AantalForm aantalForm, 
			        BindingResult bindingResult, RedirectAttributes redirectAttributes){

		 Bier bier = bierService.read(bierNr);
		 if (! bindingResult.hasErrors()) {
			 Integer aantal = aantalForm.getAantal();
			 winkelwagen.itemToevoegen(bierNr, aantal);
			 ModelAndView modelAndView = new ModelAndView("redirect:/bestelling/winkelwagen");
			 return modelAndView;
		 }
		 ModelAndView modelAndView = new ModelAndView("brouwers/bierdetails");//indien aantal niet correct gevalideerd
		 modelAndView.addObject("aantalForm", aantalForm);
		 modelAndView.addObject("bier",bier);
		 return modelAndView; 
	}
	
	//LEGE FORM BESTELBON - BESTELBONLIJNEN OP SESSION SCOPE PLAATSEN
	@RequestMapping(value="winkelwagen", method = RequestMethod.GET)
	public ModelAndView createBestelbonForm(){
		Bestelbon bestelbon = new Bestelbon();

		if(! winkelwagen.getWinkelwagenItems().isEmpty()) {
			Set<Long> bierNrs = winkelwagen.getWinkelwagenItems().keySet();
			Iterable<Bier> bieren = bierService.findBierenMetNummers(bierNrs);
		  for(Bier bier : bieren) {
			bestelbon.addBestelbonLijn(new BestelbonLijn(bier, 

					winkelwagen.getWinkelwagenItems().get(bier.getBierNr())));
		    }
		  }
	    
		ModelAndView modelAndView = new ModelAndView("bestellingen/winkelwagen");
		modelAndView.addObject("bestelbon", bestelbon);
		return modelAndView;
	}
	
    //BESTELBON BEVESTIGEN (CREATE)
	@RequestMapping(value="bevestigen", method= RequestMethod.POST)
	public ModelAndView createBestelbon(@Valid Bestelbon bestelbon, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes){
	   if(! winkelwagen.getWinkelwagenItems().isEmpty()) {
		 Set<Long> bierNrs = winkelwagen.getWinkelwagenItems().keySet();
		 Iterable<Bier> bieren = bierService.findBierenMetNummers(bierNrs);
		 for(Bier bier : bieren) {
			bestelbon.addBestelbonLijn(new BestelbonLijn(bier, 
					winkelwagen.getWinkelwagenItems().get(bier.getBierNr())));
		 }
	   }
		/**for(Map.Entry<Long, Integer> item : winkelwagen.getWinkelwagenItems().entrySet()) {
			Bier bier = bierService.read(item.getKey());
			bestelbon.addBestelbonLijn(new BestelbonLijn(bier, item.getValue()));
		}**/
	   if (! bindingResult.hasErrors()) {
		   Bestelbon toegevoegdeBestelbon = bestelbonService.create(bestelbon);
		   ModelAndView modelAndView = new ModelAndView("redirect:/bestelling/bevestigd");
		   winkelwagen.removeItems(); // MANUEEL WINKELWAGEN MAP OP NULL 
		   redirectAttributes.addAttribute("bestelbonNr", toegevoegdeBestelbon.getBonNr());
		   return modelAndView;
	    }//indien form niet correct gevalideerd
		ModelAndView modelAndView = new ModelAndView("bestellingen/winkelwagen");
		modelAndView.addObject("bestelbon", bestelbon);
		return modelAndView; 
	} 
	
	//BESTELBON BEVESTIGD
	@RequestMapping(value="bevestigd", method= RequestMethod.GET ,params = "bestelbonNr")
	public String bestelbonBevestigd(){
		return "bestellingen/bevestigd";//,"bestelbonNr", bestelbonNr);
	}

	//VALIDATIE INVOERVAKKEN VANTOTPOSTCODE
    @InitBinder("aantalForm") //naam van de form
	public void initBinderBestelForm(DataBinder dataBinder) { 
		
	}
    
    
	//VALIDATIE INVOERVAKKEN BESTELBON
    @InitBinder("bestelbon") 
    public void initBinderBestelbon(DataBinder dataBinder) { 
      Bestelbon bestelbon = (Bestelbon) dataBinder.getTarget(); 
      if (bestelbon.getAdres() == null) {  
        bestelbon.setAdres(new AdresForm()); 
      }
      else { 
    	    bestelbon.setAdres(new AdresForm(bestelbon.getAdres())); 
    	  } 
    	}
	}
