package gg_store.backend.services;

import gg_store.backend.entities.StoreProduct;

import java.util.List;
import java.util.Optional;

public interface StoreProductService {
    public void createProduct(StoreProduct storeProduct);
    public void updateProduct(StoreProduct storeProduct);
    public void deleteProduct(String id);
    public Optional<StoreProduct> getProductById(String id);
    public List<StoreProduct> getAllProducts();
    public List<StoreProduct> getProductsByCategory(String category);
}
