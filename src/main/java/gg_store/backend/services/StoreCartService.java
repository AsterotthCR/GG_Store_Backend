package gg_store.backend.services;

import gg_store.backend.entities.StoreCart;

import java.util.List;

public interface StoreCartService {
    public void addNewProduct(StoreCart storeCart);
    public void UpdateProduct(StoreCart storeCart);
    public void deleteProduct(String productId);
    public List<StoreCart> findProductsByUserID (String userID);
}
