package gg_store.backend.repositories;

import gg_store.backend.entities.StoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreUserRepo extends JpaRepository<StoreUser, String> {
}
