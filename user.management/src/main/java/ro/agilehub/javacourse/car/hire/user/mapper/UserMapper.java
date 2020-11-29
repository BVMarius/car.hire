package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserEntity userRequestToUserEntity(CreateUserRequest createUserRequest);
}
