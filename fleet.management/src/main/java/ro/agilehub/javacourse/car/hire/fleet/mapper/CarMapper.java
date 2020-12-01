package ro.agilehub.javacourse.car.hire.fleet.mapper;

import org.mapstruct.*;
import ro.agilehub.javacourse.car.hire.api.model.CreateCarRequest;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void carRequestUpdateToEntity(CreateCarRequest carRequest, @MappingTarget CarEntity carEntity);

    @Mapping(source="mileage", target="mileageInKilometers")
    CarEntity carRequestCreateToEntity(CreateCarRequest createCarRequest);


}
