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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private StoreCategory category;
    private int stock;

}
