package com.example.productsAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsAPIController {

    @Autowired
    private ProductRepository productRepository;

    // https://dummyjson.com/products?limit=10&skip=10&select=title,price&sortBy=title&order=asc
    @GetMapping("/page")
    public List<Product> getAllProductsPage(@RequestParam(required = false) Integer limit,
                                        @RequestParam(required = false) Integer skip,
                                        @RequestParam(required = false) String select,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(required = false) String order) {
        Pageable pageable = PageRequest.of(skip != null ? skip : 0, limit != null ? limit : Integer.MAX_VALUE,
                Sort.by(order != null && order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                        sortBy != null ? sortBy : "id"));
        Page<Product> page = productRepository.findAll(pageable);
        return page.getContent();
    }
    @GetMapping
    public List<Product> getAllProductsAll() {
        return productRepository.findAll();
         
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Search based on title - @Query("SELECT p FROM Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String q) {
        return productRepository.searchProducts(q);
    }
    
    // http://localhost:8080/api/products/sort?sortBy=title&order=asc
    @GetMapping("/sort")
    public List<Product> sortProductsByTitle(@RequestParam String sortBy,@RequestParam String order) {
        return productRepository.sortProducts(sortBy,order);
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return productRepository.findDistinctCategories();
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
 interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Product> searchProducts(@Param("query") String query);
    
	/*
	 * @Query("SELECT p FROM Product p ORDER BY " +
	 * "CASE WHEN :order = 'asc' AND :column = 'title' THEN p.title END ASC, " +
	 * "CASE WHEN :order = 'desc' AND :column = 'title' THEN p.title END DESC")
	 * List<Product> sortProducts(@Param("column") String column, @Param("order")
	 * String order);
	 */
    @Query(value = "SELECT * FROM product ORDER BY :column :order", nativeQuery = true)
    List<Product> sortProducts(@Param("column") String column1, @Param("order") String order1);
    

	@Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findDistinctCategories();

    List<Product> findByCategory(String category);
}