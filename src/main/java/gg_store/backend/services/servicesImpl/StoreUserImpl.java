package gg_store.backend.services.servicesImpl;

import gg_store.backend.entities.StoreUser;
import gg_store.backend.repositories.StoreUserRepo;
import gg_store.backend.services.StoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreUserImpl implements StoreUserService {

    @Autowired
    private StoreUserRepo storeUserRepo;


    @Override
    public void createUser(StoreUser storeUser) {
        storeUserRepo.save(saveUser(storeUser));
    }

    @Override
    public Optional<StoreUser> getUser(String id) {
        Optional<StoreUser> users = storeUserRepo.findById(id);
        List<StoreUser> filteredUser = users.stream().map(this::filterUserData).toList();
        return filteredUser.stream().filter(x-> x.getId().equals(id)).findFirst();
    }

    @Override
    public void updateUser(StoreUser storeUser) {
        storeUserRepo.save(saveUser(storeUser));
    }

    @Override
    public void deleteUser(String id) {
        storeUserRepo.deleteById(id);
    }

    @Override
    public List<StoreUser> getAllUsers() {
        List<StoreUser> users = storeUserRepo.findAll();
        List<StoreUser> filteredUsers = users.stream().map(this::filterUserData).toList();
        return filteredUsers.stream().toList();
    }

    //Logic Methods
    private StoreUser filterUserData(StoreUser storeUser) {
        return StoreUser.builder()
                .id(storeUser.getId())
                .firstName(storeUser.getFirstName())
                .lastName(storeUser.getLastName())
                .username(storeUser.getUsername())
                .email(storeUser.getEmail())
                .build();
    }

    private StoreUser saveUser(StoreUser storeUser) {
        StoreUser.StoreUserBuilder userBuilder = StoreUser
                .builder()
                .username(storeUser.getUsername())
                .role((byte)1)
                .password(storeUser.getPassword())
                .email(storeUser.getEmail())
                .zipcode(storeUser.getZipcode())
                .firstName(storeUser.getFirstName())
                .lastName(storeUser.getLastName());

        if (storeUser.getId() != null) {
            userBuilder.id(storeUser.getId());
        }

        return userBuilder.build();
    }
}
