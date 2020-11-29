package ro.agilehub.javacourse.car.hire.user.service;


import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

import java.util.List;

public interface UserService {

     UserEntity createUser(UserEntity userEntity);
     List<UserEntity> listUsers();
}
