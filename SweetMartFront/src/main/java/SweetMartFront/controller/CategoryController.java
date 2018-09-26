package SweetMartFront.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dao.CategoryDao;
import com.models.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDao objs;
	//private Category c;
	
public CategoryController(){
	System.out.println("CategoryController Bean is Created");
}
@RequestMapping(value="/all/getallcategory")
public String getAllCategory(Model model){
	List<Category> cl=objs.getAllCategory();
	//Attribute name is the Key - productList
	//value - List<Product> products is the data
	model.addAttribute("CategoryList",cl);
	//                 attributename   data
	return "listofCategory";//logical view name
	//in listofproducts.jsp,access the model attribute "productsList"
}

@RequestMapping(value="/all/getcategory/{id}")
public String getProduct(@PathVariable int id,Model model){
	Category category=objs.getCategory(id);
	model.addAttribute("categoryObj",category);
	return "viewCategory";
}
@RequestMapping(value="/admin/deletecategory/{id}")
public String deleteProduct(@PathVariable int id,Model model){
	Category c=objs.getCategory(id);
	objs.deleteCategory(c);
	return "redirect:/all/getallcategory";
}

@RequestMapping(value="/admin/addcategory")
public String addCategory(@ModelAttribute(name="category") Category category ,BindingResult result,Model model ,HttpServletRequest request  ){
	objs.saveCategory(category);
	if(result.hasErrors()){//if it is true, result has errors
		model.addAttribute("categories",objs.getAllCategory());
		return "Category";
	}
	
//productDao.saveProduct(product);
	
	MultipartFile img=category.getImage();
	System.out.println(request.getServletContext().getRealPath("/"));
	//Defining a path
	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+category.getId()+".png");
	//transfer the image to the file
	if(!img.isEmpty()&&img!=null){
		try {
			img.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return "redirect:/all/getallcategory";
}

@RequestMapping(value="/admin/updatecategory")
public String updateCategory(@ModelAttribute (name="category") Category category ,BindingResult result,Model model ,HttpServletRequest request ){
	objs.updateCategory(category);
	MultipartFile img=category.getImage();
	System.out.println(request.getServletContext().getRealPath("/"));
	//Defining a path
	Path path=Paths.get(request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+category.getId()+".png");
	//transfer the image to the file
	if(!img.isEmpty()&&img!=null){
		try {
			img.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return "redirect:/all/getallcategory";
}



@RequestMapping(value="/admin/updatecategory/{id}")
public String getUpdateCategoryForm(@PathVariable int id,Model model)
{
	Category category=objs.getCategory(id); 
	model.addAttribute("category",category);
	//objs.saveCategory(category);
	
	return "Cupdateform";
}
@RequestMapping(value="/admin/getcategoryform")
public String getcategoryform(Model model){
	Category c=new Category();
	model.addAttribute("category",c);
	model.addAttribute("categories",objs.getAllCategory());
//	//In productform, access  the values of all the properties of product p
	//in the form, p.getId(),p.getProductname(),p.getPrice(),p.getQuantity(),p.getProductdesc()
	return "Category";
}


}

