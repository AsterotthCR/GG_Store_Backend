package gg_store.backend.services;

import gg_store.backend.entities.StoreBuyDetail;

import java.util.List;

public interface StoreBuyDetailService {
    public void createNewDetail(StoreBuyDetail storeBuyDetail);
    public void updateDetails(StoreBuyDetail storeBuyDetail);
    public List<StoreBuyDetail> findBySaleId(String saleId);
}
