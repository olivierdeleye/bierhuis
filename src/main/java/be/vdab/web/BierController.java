package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
@RequestMapping("/bieren")
class BierController {

 private final BierService bierService;
	
	@Autowired
	public BierController(BierService bierService) {
		this.bierService = bierService;
	}
	
	
	//Details geselecteerd bier
	@RequestMapping(method = RequestMethod.GET, params ="bierNr")
	public ModelAndView read(@RequestParam long bierNr) {
	  ModelAndView modelAndView = new ModelAndView("brouwers/bierdetails");
	  modelAndView.addObject("bier", bierService.read(bierNr));
	  modelAndView.addObject("aantalForm", new AantalForm(null));
	  return modelAndView;
	}
	
	
}
