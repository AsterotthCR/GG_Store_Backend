package gg_store.backend.services;

import gg_store.backend.entities.StoreSale;

import java.util.List;

public interface StoreSaleService {
    public List<StoreSale> getStoreSale(String id);
    public void deleteSale(String id);
    public List<StoreSale> getAllSale();
    public void createStoreSale(StoreSale request);
}
