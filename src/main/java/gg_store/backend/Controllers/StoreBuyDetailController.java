package gg_store.backend.Controllers;

import gg_store.backend.entities.StoreBuyDetail;
import gg_store.backend.services.StoreBuyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy-details")
public class StoreBuyDetailController {
    private StoreBuyDetailService buyDetailService;

    @Autowired
    public void BuyDetailController(StoreBuyDetailService buyDetailService) {
        this.buyDetailService = buyDetailService;
    }

    @PostMapping
    public ResponseEntity<String> createNewDetail(@RequestBody StoreBuyDetail storeBuyDetail) {
        buyDetailService.createNewDetail(storeBuyDetail);
        return new ResponseEntity<>("Detalle de compra creado exitosamente", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateDetails(@RequestBody StoreBuyDetail storeBuyDetail) {
        buyDetailService.updateDetails(storeBuyDetail);
        return new ResponseEntity<>("Detalle de compra actualizado exitosamente", HttpStatus.OK);
    }

}
