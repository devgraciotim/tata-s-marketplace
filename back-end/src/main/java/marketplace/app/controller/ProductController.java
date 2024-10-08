package marketplace.app.controller;

import marketplace.app.entity.Product;
import marketplace.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Product product) {
        String message = productService.save(product);
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        String message = productService.deleteById(id);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @Valid @RequestBody Product product) {
        String message = productService.updateById(id, product);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Product product = productService.findByName(name);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/topProduct")
    public ResponseEntity<?> topProduct() {
        Product product = productService.topProduct();
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/mostExpensive")
    public ResponseEntity<?> mostExpensive() {
        Product product = productService.mostExpensive();
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
