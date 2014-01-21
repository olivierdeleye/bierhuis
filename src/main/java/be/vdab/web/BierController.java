package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//Details geselecteerd bier en Form met Aantal
	@RequestMapping(value = "{bierNr}" , method = RequestMethod.GET)
	public ModelAndView createForm(@PathVariable long bierNr) {
	  ModelAndView modelAndView = new ModelAndView("brouwers/bierdetails");
	  modelAndView.addObject("bier", bierService.read(bierNr));
	  modelAndView.addObject("aantalForm", new AantalForm(2));
	  return modelAndView;
	}
	
	
}
