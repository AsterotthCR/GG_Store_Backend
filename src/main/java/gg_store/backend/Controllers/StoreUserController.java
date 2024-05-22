package gg_store.backend.Controllers;

import gg_store.backend.entities.StoreUser;
import gg_store.backend.services.StoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class StoreUserController {

    private StoreUserService userService;

    @Autowired
    public void UserController(StoreUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody StoreUser storeUser) {
        userService.createUser(storeUser);
        return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreUser> getUser(@PathVariable String id) {
        Optional<StoreUser> user = userService.getUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update-user")
    public ResponseEntity<String> updateUser(@RequestBody StoreUser storeUser) {
        userService.updateUser(storeUser);
        return new ResponseEntity<>("Usuario actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StoreUser>> getAllUsers() {
        List<StoreUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
