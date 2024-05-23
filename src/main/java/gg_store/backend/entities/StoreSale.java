package gg_store.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StoreSale {
    @Id
    @UuidGenerator
    private String id;
    private double total;
    private Date date;
    @ManyToOne(optional = false,cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private StoreUser storeUser;
    @ManyToOne(optional = false,cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private StoreBuyDetail buyDetails;
}
