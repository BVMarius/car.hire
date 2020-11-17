package ro.agilehub.javacourse.car.hire.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.api.model.UserResponse;
import ro.agilehub.javacourse.car.hire.api.specification.ApiApi;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController implements ApiApi {



    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<SuccessResponse> createUser(@Valid CreateUserRequest createUserRequest) {
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
        return new ResponseEntity<>(userResponse,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> updateUser(String userId, @Valid CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponse>> listUsers() {


        UserResponse userResponse = new UserResponse();
        userResponse.setId(12355);
        userResponse.setFirstName("Jhon");
        List<UserResponse> userResponseList = Collections.singletonList(userResponse);


        return new ResponseEntity<>(userResponseList,HttpStatus.valueOf(200));
    }
}
