package gg_store.backend.Controllers;

import gg_store.backend.entities.StoreCart;
import gg_store.backend.services.StoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class StoreCartController {

    private StoreCartService cartService;

    @Autowired
    public void CartController(StoreCartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<String> addNewProduct(@RequestBody StoreCart storeCart) {
        cartService.addNewProduct(storeCart);
        return new ResponseEntity<>("Producto añadido al carrito exitosamente", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody StoreCart storeCart) {
        cartService.UpdateProduct(storeCart);
        return new ResponseEntity<>("Producto actualizado en el carrito exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        cartService.deleteProduct(productId);
        return new ResponseEntity<>("Producto eliminado del carrito exitosamente", HttpStatus.OK);
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<StoreCart>> findProductsByUserID(@PathVariable String userID) {
        List<StoreCart> products = cartService.findProductsByUserID(userID);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
