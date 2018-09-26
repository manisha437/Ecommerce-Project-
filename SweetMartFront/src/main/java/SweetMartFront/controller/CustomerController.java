package SweetMartFront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.CustomerDao;
import com.models.Customer;

@Controller

public class CustomerController {
	
		@Autowired
		private CustomerDao customerDao;
	@RequestMapping(value="/all/registrationform", method = RequestMethod.GET)
	public String getRegistrationForm(Model model){
		model.addAttribute("customer",new Customer());
		return "Registrationform";
	}
	@RequestMapping(value="/all/registercustomer")
	public String registerCustomer(@ModelAttribute(name="customer") Customer customer){

		//Call DAO to persist customer details
		customerDao.registerCustomer(customer);
		return "login";
	}
	}




