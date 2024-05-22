package gg_store.backend.Controllers;


import gg_store.backend.entities.StoreProduct;
import gg_store.backend.services.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class StoreProductController{

    public StoreProductService productService;

    @Autowired
    public void ProductController(StoreProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new-product")
    public ResponseEntity<String> createProduct(@RequestBody StoreProduct storeProduct) {
        productService.createProduct(storeProduct);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping("/update-product")
    public ResponseEntity<String> updateProduct(@RequestBody StoreProduct storeProduct) {
        productService.updateProduct(storeProduct);
        return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreProduct> getProductById(@PathVariable String id) {
        Optional<StoreProduct> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<StoreProduct>> getAllProducts() {
        List<StoreProduct> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<StoreProduct>> getProductsByCategory(@PathVariable String category) {
        List<StoreProduct> products = productService.getProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
