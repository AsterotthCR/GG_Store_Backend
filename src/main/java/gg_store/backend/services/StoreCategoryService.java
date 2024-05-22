package gg_store.backend.services;

import gg_store.backend.entities.StoreCategory;


import java.util.List;
import java.util.Optional;

public interface StoreCategoryService {
    public void createCategory(StoreCategory storeCategory);
    public void updateCategory(StoreCategory storeCategory);
    public void deleteCategory(String id);
    public Optional<StoreCategory> findCategoryById(String id);
    public List<StoreCategory> findAllCategories();
}
