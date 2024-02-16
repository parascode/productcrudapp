package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product p) {
		this.hibernateTemplate.save(p);
	}
	
	public List<Product> selectAll() {
		return this.hibernateTemplate.loadAll(Product.class);
	}
	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	public Product selectProduct(int pid) {
		return this.hibernateTemplate.load(Product.class, pid);
	}
}
