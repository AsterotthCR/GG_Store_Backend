package gg_store.backend.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreSaleRequest {
    private String id;
    private double total;
    private Date date;
    private String storeUserId;
    private List<StoreBuyDetailRequest> buyDetails;
}
