package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

@Controller
@RequestMapping("/")
public class IndexController {

	private final BierService bierService;
	
	 @Autowired
	  public IndexController(BierService bierService) {
	      this.bierService = bierService;
	  }
	 
	 @RequestMapping(method = RequestMethod.GET)
	  public ModelAndView index() {
	    ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("aantalBieren", bierService.count());
	    return modelAndView;
	  }
	 
}
