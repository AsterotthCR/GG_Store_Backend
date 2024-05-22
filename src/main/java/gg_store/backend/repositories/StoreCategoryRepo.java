package gg_store.backend.repositories;

import gg_store.backend.entities.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCategoryRepo extends JpaRepository<StoreCategory, String> {
}
