package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;


@Mapper(componentModel = "spring", uses=CountryMapper.class)
public interface UserMapper {


    UserEntity userRequestToUserEntity(CreateUserRequest createUserRequest);
    SuccessResponse userEntityToUserResponse(UserEntity userEntity);


}
