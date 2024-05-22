package gg_store.backend.repositories;

import gg_store.backend.entities.StoreCategory;
import gg_store.backend.entities.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepo extends JpaRepository<StoreProduct, String> {
    public List<StoreProduct> getStoreProductsByCategory_Name(String categoryId);
}
