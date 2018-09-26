package SweetMartFront.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.CartItem;

@Controller

public class HomeController {
public HomeController(){
	System.out.println("HomeController bean is instantiated");
}
//http://localhost:8080/project1frontend/home - This request will be handled
//by this handler method homePage()
/*@RequestMapping(value="/index",method=RequestMethod.GET)
public String Security(HttpSession session,@AuthenticationPrincipal Principal principal){
	session.setAttribute("categories",categoryDao.getAllCategories());
	String email=principal.getName();
	List<CartItem> cartItems=cartItemDao.getCart(email);
	session.setAttribute("cartSize",cartItems.size());
	return "index";
}
*/
//@RequestMapping(value="searchbycategory{pid}")


@RequestMapping(value="/")
public String homePage(){
	return "index";
}


@RequestMapping(value="/index")
public String homePages(){
	return "index";
}

@RequestMapping(value="/aboutus")
public String aboutusPage(){
	return "aboutus";
}


	//@RequestMapping(value="/login")
	//public String login(){
		//return "login";
//}
	
	@RequestMapping(value="/header")
	public String admin(){
		return "header";
}
	
	@RequestMapping(value="/Signup")
	public String signup(){
		return "Signup";
}
	@RequestMapping(value="/Signin")
	public String signin(){
		return "Signin";
}
	
	@RequestMapping(value="/logout")
	public String signout(){
		return "login";
}
	@RequestMapping(value="/Barfi")
	public String barfi(){
		return "Barfi";
}
	
	
	@RequestMapping(value="/loginerror")
	public String loginFailed(Model model){
		model.addAttribute("error","Invalid credentials..");
		return "login";
	}
	@RequestMapping(value="/login")
	public String logout(Model model){
		model.addAttribute("msg","Loggedout successfully...");
		return "login";
}
	//@RequestMapping(value="/Register")
	//public String register(Model model){
		//model.addAttribute("msg","Loggedout successfully...");
		//return "Register";
//}
	
	@RequestMapping(value ="/login",method =RequestMethod.POST)
	public String loginProcess(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException 
	{
		System.out.println("inside validation method");
		String uname=request.getParameter("username");
		System.out.println(uname);
		String upassword=request.getParameter("pwd");
		System.out.println(upassword);
		while(uname !=null && upassword !=null)
			{
			if(uname.equals("admin") && (upassword.equals("admin")))
				{
			System.out.println("username and password are correct");
			return "header";
				}	
		else 
		{
			return "login";
		}
			}
		return "login";
		
				
	
	}
}