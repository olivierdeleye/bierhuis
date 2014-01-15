package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bestelling")
class bestellingController {
	
	
	
	
	//VALIDATIE INVOERVAK AANTAL
    @InitBinder("aantalForm") //naam van de form
	public void initBinderAantalForm(DataBinder dataBinder) { 
		dataBinder.initDirectFieldAccess();
	}
}
