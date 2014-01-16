package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bestelling")
class bestellingController {
	
	

	//VALIDATIE INVOERVAK BESTELDETAILFORM
    @InitBinder("bestelbonlijn") //naam van de form
	public void initBinderBestelDetailForm(DataBinder dataBinder) { 
		dataBinder.initDirectFieldAccess();
	}
    
	//VALIDATIE INVOERVAK BESTELBON
    @InitBinder("bestelbon") //naam van de form
	public void initBinderBestelbon(DataBinder dataBinder) { 
		dataBinder.initDirectFieldAccess();
	}
	
}
