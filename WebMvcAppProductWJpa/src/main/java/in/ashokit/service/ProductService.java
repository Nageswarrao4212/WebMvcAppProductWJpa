package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Product;
import in.ashokit.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
   private ProductRepo prepo;
   public boolean saveProduct(Product p) {
	   try {
           prepo.save(p);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
   public List<Product> getProducts(){
	   return prepo.findAll();
   }
   public boolean deleteProductsById(Integer pid) {
	  if(prepo.existsById(pid)) {
	   prepo.deleteById(pid);
	   return true;
       }
	  else {
		  return false;
	  }
}
}
