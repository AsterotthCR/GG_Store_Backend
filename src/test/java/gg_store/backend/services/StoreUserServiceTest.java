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

    @Test
    void createUser() {
        // Arrange
        StoreUser user = new StoreUser();
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhone("+1234567890");
        user.setAddress("123 Main St");
        user.setZipcode("12345");
        user.setRole((byte) 1);
        user.setPhoto("profile.jpg");

        // Act
        storeUserService.createUser(user);

        // Assert
        verify(storeUserRepo).save(user);
    }
}

