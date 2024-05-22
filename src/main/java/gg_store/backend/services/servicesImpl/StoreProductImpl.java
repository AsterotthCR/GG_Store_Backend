package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreProduct;
import gg_store.backend.repositories.StoreProductRepo;
import gg_store.backend.services.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StoreProductImpl implements StoreProductService {
    @Autowired
    StoreProductRepo storeProductRepo;

    @Override
    public void createProduct(StoreProduct storeProduct) {
        storeProductRepo.save(storeProduct);
    }

    @Override
    public void updateProduct(StoreProduct storeProduct) {
        storeProductRepo.save(storeProduct);
    }

    @Override
    public void deleteProduct(String id) {
        storeProductRepo.deleteById(id);
    }

    @Override
    public Optional<StoreProduct> getProductById(String id) {
        return storeProductRepo.findById(id);
    }

    @Override
    public List<StoreProduct> getAllProducts() {
        return storeProductRepo.findAll();
    }

    @Override
    public List<StoreProduct> getProductsByCategory(String category) {
        return storeProductRepo.getStoreProductsByCategory_Name(category);
    }
}
