package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;


@Controller
@RequestMapping("/brouwers")
class BrouwerController {

	private final BrouwerService brouwerService;
	
	@Autowired
	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
		
		
	}

	//Alle brouwers
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView findAll() {
	  return new ModelAndView("brouwers/brouwersoverzicht","brouwers", brouwerService.findAll());
	}
	
	//Bieren van een brouwer
	@RequestMapping(value="{brouwerNr}", method = RequestMethod.GET)
	public ModelAndView read(@PathVariable long brouwerNr) {
	  ModelAndView modelAndView = new ModelAndView("brouwers/bieren");
	  modelAndView.addObject("brouwer", brouwerService.read(brouwerNr));
	  return modelAndView;
	}
}
