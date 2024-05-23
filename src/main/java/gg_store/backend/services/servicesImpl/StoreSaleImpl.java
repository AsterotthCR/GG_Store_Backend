package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreCart;
import gg_store.backend.entities.StoreSale;
import gg_store.backend.repositories.*;
import gg_store.backend.services.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreSaleImpl implements StoreSaleService {
    @Autowired
    private StoreSaleRepo storeSaleRepo;

    @Override
    public List<StoreSale> getStoreSale(String id) {
        return storeSaleRepo.findByStoreUserId(id);
    }

    @Override
    public void deleteSale(String id) {
        storeSaleRepo.deleteById(id);
    }

    @Override
    public List<StoreSale> getAllSale() {
        return storeSaleRepo.findAll();
    }

    @Override
    public void createStoreSale(StoreSale request) {
        storeSaleRepo.save(createSale(request));
    }

    //Logic

    private StoreSale createSale(StoreSale request) {
        StoreSale.StoreSaleBuilder newStoreSale = StoreSale.builder()
                .storeUser(request.getStoreUser())
                .date(new Date())
                .buyDetails(request.getBuyDetails())
                .total(request.getTotal());

        if (request.getId() != null) {
            newStoreSale.id(request.getId());
        }

        return newStoreSale.build();
    }

}
