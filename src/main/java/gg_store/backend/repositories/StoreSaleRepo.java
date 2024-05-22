package gg_store.backend.repositories;

import gg_store.backend.entities.StoreSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreSaleRepo extends JpaRepository<StoreSale, String> {
    public List<StoreSale> findByStoreUserId(String store);
}
