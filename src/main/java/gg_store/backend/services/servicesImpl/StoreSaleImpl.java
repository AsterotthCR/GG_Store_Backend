package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreSale;
import gg_store.backend.repositories.StoreSaleRepo;
import gg_store.backend.services.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StoreSaleImpl implements StoreSaleService {

    @Autowired
    StoreSaleRepo storeSaleRepo;

    @Override
    public void createSale(StoreSale storeSale) {
        storeSaleRepo.save(storeSale);
    }

    @Override
    public List<StoreSale> getStoreSale(String id) {
        return storeSaleRepo.findByStoreUserId(id);
    }

    @Override
    public void updateSale(StoreSale storeSale) {
        storeSaleRepo.save(storeSale);
    }

    @Override
    public void deleteSale(String id) {
        storeSaleRepo.deleteById(id);
    }

    @Override
    public List<StoreSale> getAllSale() {
        return storeSaleRepo.findAll();
    }
}
