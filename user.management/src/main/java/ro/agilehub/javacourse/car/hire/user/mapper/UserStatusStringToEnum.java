package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.UserResponse;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

@Mapper
public interface UserStatusStringToEnum {

    default UserResponse.StatusEnum map(UserEntity userEntity) {



        return UserResponse.StatusEnum.fromValue(userEntity.getStatus().toUpperCase());
    }
}
