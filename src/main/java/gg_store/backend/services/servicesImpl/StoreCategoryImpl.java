package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreCategory;
import gg_store.backend.repositories.StoreCategoryRepo;
import gg_store.backend.repositories.StoreProductRepo;
import gg_store.backend.services.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreCategoryImpl implements StoreCategoryService {

    @Autowired
    StoreCategoryRepo storeCategoryRepo;

    @Override
    public void createCategory(StoreCategory storeCategory) {
        storeCategoryRepo.save(storeCategory);
    }

    @Override
    public void updateCategory(StoreCategory storeCategory) {
        storeCategoryRepo.save(storeCategory);
    }

    @Override
    public void deleteCategory(String id) {
        storeCategoryRepo.deleteById(id);
    }

    @Override
    public Optional<StoreCategory> findCategoryById(String id) {
        return storeCategoryRepo.findById(id);
    }

    @Override
    public List<StoreCategory> findAllCategories() {
        return storeCategoryRepo.findAll();
    }
}
