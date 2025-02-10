package lt.techin.demo.dto;


import lt.techin.demo.model.Movie;
import lt.techin.demo.model.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRoles());
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setRoles(userDTO.roles());
        return user;
    }
}
