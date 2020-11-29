package ro.agilehub.javacourse.car.hire.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.api.model.UserResponse;

import ro.agilehub.javacourse.car.hire.api.specification.UserApi;
import ro.agilehub.javacourse.car.hire.user.mapper.UserMapper;
import ro.agilehub.javacourse.car.hire.user.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController implements UserApi {

  @Autowired private UserService userService;
  @Autowired private UserMapper userMapper;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  @Override
  public ResponseEntity<SuccessResponse> createUser(@Valid CreateUserRequest createUserRequest) {
    userService.createUser(userMapper.userRequestToUserEntity(createUserRequest));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(String userId) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserResponse> getUserById(Long userId) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(2523);
    userResponse.setFirstName("Jhon");
    return new ResponseEntity<>(userResponse, HttpStatus.valueOf(200));
  }

  @Override
  public ResponseEntity<Void> updateUser(Long userId, CreateUserRequest createUserRequest) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Override
  public ResponseEntity<List<UserResponse>> listUsers() {

    UserResponse userResponse = new UserResponse();
    userResponse.setId(12355);
    userResponse.setFirstName("Jhon");
    List<UserResponse> userResponseList = Collections.singletonList(userResponse);

    return new ResponseEntity<>(userResponseList, HttpStatus.valueOf(200));
  }
}
