package lt.techin.demo.controler;

import jakarta.validation.Valid;
import lt.techin.demo.dto.UserDTO;
import lt.techin.demo.dto.UserMapper;
import lt.techin.demo.model.User;
import lt.techin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(UserMapper.toUserDTOList(userService.findAllUsers()));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id) {
        Optional<User> userFind = userService.findUserBYID(id);

        if (userFind.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UserMapper.toUserDTO(userFind.get()));
    }

    @PostMapping("/users")
    // Kai kursite patys, būtinai naudokite DTO!
    public ResponseEntity<User> addUser(@RequestBody User user) {

        // Slatpažodis yra šifruojamas prieš saugant į duomenų bazę
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userService.saveUser(user);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(savedUser.getId())
                                .toUri())
                .body(savedUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable long id, @Valid @RequestBody UserDTO userDTO) {

        if (userService.existsUserById(id)) {
            User userFind = userService.findUserBYID(id).get();

            UserMapper.updateUserFromDTO(userFind, userDTO);

            userService.saveUser(userFind);

            return ResponseEntity.ok((userService.saveUser(userFind)));
        }
        User savedUser = userService.saveUser(UserMapper.toUser(userDTO));

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .replacePath("/users/{id}")
                                .buildAndExpand(savedUser.getId())
                                .toUri())
                .body(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {

        if (!userService.existsUserById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
