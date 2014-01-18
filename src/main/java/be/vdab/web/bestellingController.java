package be.vdab.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bier;
import be.vdab.services.BestelbonService;
import be.vdab.services.BierService;
import be.vdab.valueobjects.BestelbonLijn;


@Controller
@RequestMapping("/bestelling")
class bestellingController {
	
	private final BierService bierService;
	private final BestelbonService bestelbonService;
	private final Winkelwagen winkelwagen;
	
	@Autowired
	public bestellingController(BierService bierService, BestelbonService bestelbonService, Winkelwagen winkelwagen) {
		this.bierService = bierService;
		this.bestelbonService = bestelbonService;
		this.winkelwagen = winkelwagen;
	}
	
	//WINKELWAGEN BESTELLING TOEVOEGEN
	@RequestMapping(value="toevoegen", method= RequestMethod.POST)
	public ModelAndView toevoegenWinkelwagen(@RequestParam long bierNr, @Valid AantalForm aantalForm, BindingResult bindingResult){
		Bier bier = bierService.read(bierNr);
		 if (! bindingResult.hasErrors()) {
			 Integer aantal = aantalForm.getAantal();
			 winkelwagen.addBestelbonLijn(new BestelbonLijn(bier, aantal));
			 return new ModelAndView("redirect:/bestelling/winkelwagen");
		 }
		 ModelAndView modelAndView = new ModelAndView("brouwers/bierdetails");//indien aantal niet correct gevalideerd
		 modelAndView.addObject("aantalForm", aantalForm);
		 modelAndView.addObject("bier",bier);
		 return modelAndView; 
	}
	
	//LEGE FORM BESTELBON 
	@RequestMapping(value="winkelwagen", method = RequestMethod.GET)
	public ModelAndView createBestelbonForm(){
		ModelAndView modelAndView = new ModelAndView("bestellingen/winkelwagen");
		modelAndView.addObject("winkelwagen", winkelwagen);
		modelAndView.addObject("bestelbon", new Bestelbon());
		return modelAndView;
	}
	
    //BESTELBON BEVESTIGEN (CREATE BESTELBON)
	@RequestMapping(value="bevestigen", method= RequestMethod.POST)
	public ModelAndView createBestelbon(@Valid Bestelbon bestelbon, BindingResult bindingResult, 
			  RedirectAttributes redirectAttributes, SessionStatus sessionStatus){
		 if (! bindingResult.hasErrors()) {
		   bestelbon.setBestelbonLijnen(winkelwagen.getBestelbonLijnen());
		   Bestelbon toegevoegdeBestelbon = (Bestelbon)bestelbonService.create(bestelbon);
		   ModelAndView modelAndView = new ModelAndView("redirect:/bestelling/bevestigd");
		   sessionStatus.setComplete(); //werkt niet !!!
		   winkelwagen.removeRestelbonLijnen(); //manueel winkelwagen ledigen 
		   redirectAttributes.addAttribute("bestelbonNr", toegevoegdeBestelbon.getBonNr());
		   return modelAndView;
		 }//indien form niet correct gevalideerd
		 ModelAndView modelAndView = new ModelAndView("bestellingen/winkelwagen");
		 modelAndView.addObject("bestelbon", bestelbon);
		 modelAndView.addObject("winkelwagen", winkelwagen); // normaal niet nodig daar die op session staat
		 return modelAndView; 
	} 
	
	//BESTELBON BEVESTIGD
	@RequestMapping(value="bevestigd", method= RequestMethod.GET)
	public ModelAndView bestelbonBevestigd(@RequestParam long bestelbonNr){
		return new ModelAndView("bestellingen/bevestigd","bestelbonNr", bestelbonNr);
	}

	//VALIDATIE INVOERVAKKEN VANTOTPOSTCODE
    @InitBinder("aantalForm") //naam van de form
	public void initBinderBestelForm(DataBinder dataBinder) { 
		//dataBinder.initDirectFieldAccess();
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
