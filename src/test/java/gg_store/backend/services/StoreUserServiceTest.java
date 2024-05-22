package gg_store.backend.services;

import gg_store.backend.entities.StoreUser;
import gg_store.backend.repositories.StoreUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
class StoreUserServiceTest {

    @Autowired
    private StoreUserService storeUserService;
    @MockBean
    private StoreUserRepo storeUserRepo;

    @BeforeEach
    void setUp() {

    }

}

