package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.agilehub.javacourse.car.hire.api.model.CreateUserRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;


@Mapper(componentModel = "spring", uses=CountryMapper.class)
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    UserEntity userRequestToUserEntity(CreateUserRequest createUserRequest);
    SuccessResponse userEntityToUserResponse(UserEntity userEntity);


}
