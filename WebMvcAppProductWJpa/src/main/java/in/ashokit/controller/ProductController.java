package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.bindings.Product;
import in.ashokit.service.ProductService;

@Controller
public class ProductController {
    @Autowired
	private ProductService service;
    @GetMapping("/product")
    public ModelAndView loadForm() {
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("productObject", new Product());
    	mav.setViewName("index");
    	return mav;
    }
    @PostMapping("/product")
    public ModelAndView saveProduct(Product p) {
    	ModelAndView mav=new ModelAndView();
    	boolean saveProduct=service.saveProduct(p);
    	if(saveProduct) {
    	mav.addObject("msg", "Product Details Saved....");
    	}
    	else {
    		mav.addObject("msg", "Error occured...");
    	}
    	mav.addObject("productObject", new Product());
    	mav.setViewName("index");
    	return mav;
    }
    @GetMapping("/allProducts")
    public ModelAndView getAllProducts() {
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("products", service.getProducts());
    	mav.setViewName("data");
    	return mav;
    }
    @GetMapping("/delete")
    public ModelAndView deleteProduct(Integer pid)
    {
    	ModelAndView mav=new ModelAndView();
    	boolean val=service.deleteProductsById(pid);
    	if(val)
    	{
    		mav.addObject("productdeleted","Record deleted successfully....");
    		//System.out.println("The updated table after being deleted ....");
    		mav.addObject("msg", "The updated table after being deletd......");
    		mav.addObject("products", service.getProducts());
    		mav.setViewName("data");
    	}
    	else
    	{
    		System.out.println("Records not deleted successfully...");
    		mav.addObject("products", service.getProducts());
    		mav.setViewName("data");
    	}
    	return mav;
    }
    }
    

