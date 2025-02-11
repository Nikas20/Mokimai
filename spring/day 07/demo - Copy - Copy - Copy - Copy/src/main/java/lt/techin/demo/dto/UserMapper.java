package lt.techin.demo.dto;


import lt.techin.demo.model.Actor;
import lt.techin.demo.model.Movie;
import lt.techin.demo.model.User;

import java.util.List;

public class UserMapper {

    public static List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> result = users.stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getRoles(), user.getAuthorities()))
                .toList();
        return result;
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRoles(), user.getAuthorities());
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setRoles(userDTO.roles());
        return user;
    }

    public static void updateUserFromDTO(User user, UserDTO userDTO) {
        user.setUsername(userDTO.username());
        user.setRoles(userDTO.roles());
    }
}
