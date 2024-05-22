package gg_store.backend.services;

import gg_store.backend.entities.StoreSale;

import java.util.List;

public interface StoreSaleService {
    public void createSale(StoreSale storeSale);
    public List<StoreSale> getStoreSale(String id);
    public void updateSale(StoreSale storeSale);
    public void deleteSale(String id);
    public List<StoreSale> getAllSale();
}
