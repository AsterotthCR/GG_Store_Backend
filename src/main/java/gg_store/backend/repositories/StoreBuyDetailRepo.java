package gg_store.backend.repositories;

import gg_store.backend.entities.StoreBuyDetail;
import gg_store.backend.entities.StoreSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreBuyDetailRepo extends JpaRepository<StoreBuyDetail, String> {
    List<StoreBuyDetail> findByStoreSale_Id(String storeSale);
}
