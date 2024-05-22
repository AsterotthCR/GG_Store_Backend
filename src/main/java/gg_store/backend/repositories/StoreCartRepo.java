package gg_store.backend.repositories;

import gg_store.backend.entities.StoreCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreCartRepo extends JpaRepository<StoreCart, String> {
    List<StoreCart> findByStoreUserId(String s);
}
