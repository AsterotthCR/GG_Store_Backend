package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreCart;
import gg_store.backend.repositories.StoreCartRepo;
import gg_store.backend.services.StoreCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class StoreCartImpl implements StoreCartService {

    @Autowired
    StoreCartRepo storeCartRepo;

    @Override
    public void addNewProduct(StoreCart storeCart) {
       storeCartRepo.save(saveProduct(storeCart));
    }

    @Override
    public void UpdateProduct(StoreCart storeCart) {
        storeCartRepo.save(saveProduct(storeCart));
    }

    @Override
    public void deleteProduct(String cartId) {
        storeCartRepo.deleteById(cartId);
    }

    @Override
    public List<StoreCart> findProductsByUserID(String userID) {
        return storeCartRepo.findByStoreUserId(userID);
    }

    //Logic metHods
    private StoreCart saveProduct(StoreCart storeCart) {
        StoreCart.StoreCartBuilder builder = StoreCart.builder()
                .products(storeCart.getProducts())
                .date(new Date())
                .storeUser(storeCart.getStoreUser())
                .quantity(storeCart.getQuantity());

        if (storeCart.getId() != null) {
            builder.id(storeCart.getId());
        }

        return builder.build();
    }
}

