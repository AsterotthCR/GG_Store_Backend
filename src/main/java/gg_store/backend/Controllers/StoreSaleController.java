package gg_store.backend.Controllers;

import gg_store.backend.core.dtos.StoreSaleRequest;
import gg_store.backend.entities.StoreSale;
import gg_store.backend.services.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class StoreSaleController {
    @Autowired
    private StoreSaleService service;

    @GetMapping
    public ResponseEntity<List<StoreSale>> getAll() {
        return new ResponseEntity<>(service.getAllSale(), HttpStatus.OK);
    }

    @GetMapping("/client/{client_id}")
    public ResponseEntity<List<StoreSale>> getSalesByClient(@PathVariable("client_id") String client) {
        return new ResponseEntity<>(service.getStoreSale(client), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStoreSale(@RequestBody StoreSale storeSale) {
        service.createStoreSale(storeSale);
        return new ResponseEntity<>("Venta Creada Exitosamente", HttpStatus.CREATED);
    }
}
