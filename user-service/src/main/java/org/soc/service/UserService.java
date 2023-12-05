package org.soc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.soc.dto.UserRequest;
import org.soc.dto.UserResponse;
import org.soc.model.User;
import org.soc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    public void addUser(UserRequest userRequest) {
        User user = User.builder()
                .email(userRequest.getEmail())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .password(userRequest.getPassword())
                .address(userRequest.getAddress())
                .build();
        userRepository.save(user);
        log.info("new user @ID "+user.getId() +"added");

    }

    public List<UserResponse> getAllUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).toList();
    }


    public UserResponse getUserById(String id) {
        return userRepository.findById(id).map(this::mapToUserResponse).orElseThrow();
    }

    public void deleteUser(String id) {
        User userToDelete = userRepository.findById(id).orElseThrow();
        userRepository.delete(userToDelete);
    }

    public void updateUser(UserRequest userRequest, String id) {
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setEmail(userRequest.getEmail());
        userToUpdate.setPassword(userRequest.getPassword());
        userToUpdate.setAddress(userRequest.getAddress());
        userToUpdate.setFirstName(userRequest.getFirstName());
        userToUpdate.setLastName(userRequest.getLastName());

        userRepository.save(userToUpdate);
        log.info(" user @ID "+userToUpdate.getId() +"updated");



    }

    private UserResponse mapToUserResponse(User user) {
        return  UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .address(user.getAddress())
                .build();
    }

}
