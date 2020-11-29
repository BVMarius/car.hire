package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.UserResponse;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses={CountryToStringMapper.class,UserStatusStringToEnum.class})
public interface UserEntityToResponseMapper {

    UserResponse userToUserResponse(UserEntity userEntity);


    default List<UserResponse> listOfUserEntityToUserResponse(List<UserEntity> userEntityList){
        List<UserResponse> userResponseList = new ArrayList<>();
        for(UserEntity userEntity: userEntityList){
            userResponseList.add(userToUserResponse(userEntity));
        }
        return  userResponseList;
    }
}
