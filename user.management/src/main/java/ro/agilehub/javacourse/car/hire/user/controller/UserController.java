package ro.agilehub.javacourse.car.hire.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.api.model.UserResponse;

import ro.agilehub.javacourse.car.hire.api.specification.UserApi;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;
import ro.agilehub.javacourse.car.hire.user.mapper.UserEntityToResponseMapper;
import ro.agilehub.javacourse.car.hire.user.mapper.UserMapper;
import ro.agilehub.javacourse.car.hire.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController implements UserApi {

  @Autowired private UserService userService;
  @Autowired private UserMapper userMapper;
  @Autowired private UserEntityToResponseMapper userEntityToResponseMapper;



  @Override
  public ResponseEntity<SuccessResponse> createUser(@Valid CreateUserRequest createUserRequest) {
    UserEntity userEntity =
        userService.createUser(userMapper.userRequestToUserEntity(createUserRequest));

    return new ResponseEntity<>(userMapper.userEntityToUserResponse(userEntity), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Integer userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<>(HttpStatus.valueOf(204));
  }

  @Override
  public ResponseEntity<UserResponse> getUserById(Integer userId) {

    return new ResponseEntity<>(
        userEntityToResponseMapper.userToUserResponse(userService.getUserById(userId)),
        HttpStatus.valueOf(200));
  }

  @Override
  public ResponseEntity<Void> updateUser(Integer userId, CreateUserRequest createUserRequest) {
    String email = createUserRequest.getEmail();
    String username = createUserRequest.getUsername();
    String firstName = createUserRequest.getFirstName();
    String lastName = createUserRequest.getLastName();
    String password = createUserRequest.getPassword();
    Integer country = createUserRequest.getCountry();
    userService.updateUser(email,password,username,firstName,lastName,country,userId);
    return new ResponseEntity<>(HttpStatus.valueOf(200));
  }

  @Override
  public ResponseEntity<List<UserResponse>> listUsers() {

    List<UserEntity> userEntityList = userService.listUsers();

    return new ResponseEntity<>(
        userEntityToResponseMapper.listOfUserEntityToUserResponse(userEntityList),
        HttpStatus.valueOf(200));
  }
}
