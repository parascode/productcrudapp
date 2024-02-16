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
	ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = this.productDao.getProducts();
		m.addAttribute("products", products);
		return "index";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	@RequestMapping(path = "handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productDao.createProduct(product);
		System.out.println(product);
		RedirectView redirectView = new  RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	@RequestMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid, HttpServletRequest request) {
		this.productDao.deleteProduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	@RequestMapping("/update/{pid}")
	public String updateProduct(@PathVariable("pid") int pid, Model model) {
//		System.out.println(pid);
		Product p = this.productDao.getProduct(pid);
//		System.out.println(p);
		model.addAttribute("title", "Update Product");
		model.addAttribute("product", p);
		return "update_product";
	}
}
