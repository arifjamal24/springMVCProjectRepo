package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

@Autowired
private HibernateTemplate hibernateTemplate;

@Transactional
public void createProduct(Product product) {
	this.hibernateTemplate.save(product);
}

// get all products
public List<Product> getAllProducts(){
	List<Product> products = this.hibernateTemplate.loadAll(Product.class);
	return products;
}

// delete the single products
@Transactional
public void deleteProducts(int pid) {
	Product p = this.hibernateTemplate.load(Product.class, pid);
	this.hibernateTemplate.delete(p);
}

// get a single product
public Product getProduct(int pid) {
	return this.hibernateTemplate.get(Product.class, pid);
}


}
