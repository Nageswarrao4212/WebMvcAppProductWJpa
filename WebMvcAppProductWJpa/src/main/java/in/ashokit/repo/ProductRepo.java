package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.bindings.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
