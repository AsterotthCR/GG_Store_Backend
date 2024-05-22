package gg_store.backend.services;

import gg_store.backend.entities.StoreUser;

import java.util.List;
import java.util.Optional;

public interface StoreUserService {

    public void createUser(StoreUser storeUser);
    public Optional<StoreUser> getUser(String id);
    public void updateUser(StoreUser storeUser);
    public void deleteUser(String id);
    public List<StoreUser> getAllUsers();
}
