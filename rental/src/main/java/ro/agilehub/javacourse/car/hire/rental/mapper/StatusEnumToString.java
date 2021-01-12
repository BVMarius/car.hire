package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CreateCarRequest;

@Mapper(componentModel = "spring")
public interface StatusEnumToString {


    default String map(CreateCarRequest.StatusEnum statusEnum) {

        return statusEnum.getValue();
    }
}
