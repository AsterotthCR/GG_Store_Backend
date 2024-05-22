package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreBuyDetail;
import gg_store.backend.repositories.StoreBuyDetailRepo;
import gg_store.backend.services.StoreBuyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreBuyDetaillmpl implements StoreBuyDetailService {
    @Autowired
    StoreBuyDetailRepo storeBuyDetailRepo;
    @Override
    public void createNewDetail(StoreBuyDetail storeBuyDetail) {
        storeBuyDetailRepo.save(storeBuyDetail);
    }
    @Override
    public void updateDetails(StoreBuyDetail storeBuyDetail) {
        storeBuyDetailRepo.save(storeBuyDetail);
    }
    @Override
    public List<StoreBuyDetail> findBySaleId(String saleId) {
        return storeBuyDetailRepo.findByStoreSale_Id(saleId);
    }
}

