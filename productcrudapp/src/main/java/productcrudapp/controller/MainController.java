package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getAllProducts();
		m.addAttribute("product",products);
		return "index";
	}
	
	// show add product form
	@RequestMapping("addProduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "addProductForm";
	}
	
//	handle add product form
	@RequestMapping(path="/productHandler",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView view = new RedirectView();
		view.setUrl(req.getContextPath()+"/");
		return view;
	}
	
	
	// delete handler
	@RequestMapping("delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int pid, HttpServletRequest req){
		productDao.deleteProducts(pid);
		RedirectView view = new RedirectView();
		view.setUrl(req.getContextPath()+"/");
		return view;
	}
	
	// update handler
	@RequestMapping("update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model m){
		Product product = this.productDao.getProduct(pid);
		m.addAttribute("product",product);
		return "updateForm";
	}
	
	
	
	
}
