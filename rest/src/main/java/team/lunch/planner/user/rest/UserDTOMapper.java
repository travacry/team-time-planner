package team.lunch.planner.user.rest;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import team.lunch.planner.user.domain.User;

@Component
@RequiredArgsConstructor
class UserDTOMapper {

    public User map(UserDTO userDTO) {
        return new User(userDTO.getDatabaseId(), userDTO.getEmail(), "", userDTO.getFirstname(), userDTO.getLastname());
    }

    public UserDTO map(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getFirstname(), user.getLastname());
    }
}
