package gg_store.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreProduct {


    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String description;
    private float price;
    private String image;
    @ManyToOne(optional = false,cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private StoreCategory category;
    private int stock;

}
