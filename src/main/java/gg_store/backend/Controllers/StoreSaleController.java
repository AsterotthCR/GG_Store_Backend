package gg_store.backend.Controllers;

import gg_store.backend.entities.StoreSale;
import gg_store.backend.services.StoreSaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class StoreSaleController {
    StoreSaleService service;

    @GetMapping("/client/{client_id}")
    public ResponseEntity<List<StoreSale>> getSalesByClient(@PathVariable("client_id") String client) {
        return new ResponseEntity<>(service.getStoreSale(client), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createSale(@RequestBody StoreSale sale) {
        service.createSale(sale);
        return new ResponseEntity<>("Compra exitosa", HttpStatus.OK);
    }
}
