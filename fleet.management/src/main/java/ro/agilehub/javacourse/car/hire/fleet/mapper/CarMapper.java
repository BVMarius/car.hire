package ro.agilehub.javacourse.car.hire.fleet.mapper;

import org.mapstruct.*;
import ro.agilehub.javacourse.car.hire.api.model.CarResponse;
import ro.agilehub.javacourse.car.hire.api.model.CreateCarRequest;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

import java.util.List;

@Mapper(componentModel = "spring", uses = CarFuelEnumToString.class)
public interface CarMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source="mileage", target="mileageInKilometers")
    @Mapping(source = "fuel", target="fuelType")
    @Mapping(source ="plateNumber", target="registration")
    void carRequestUpdateToEntity(CreateCarRequest carRequest, @MappingTarget CarEntity carEntity);

    @Mapping(source="mileage", target="mileageInKilometers")
    @Mapping(source = "fuel", target="fuelType")
    @Mapping(source ="plateNumber", target="registration")
    CarEntity carRequestCreateToEntity(CreateCarRequest createCarRequest);

    @Mapping(source="mileageInKilometers", target="mileage")
    CarResponse carEntityToResponse(CarEntity carEntity);

    @Mapping(source="mileageInKilometers", target="mileage")
    @Mapping(source = "fuelType", target="fuel")
    @Mapping(source ="registration", target="plateNumber")
    List<CarResponse> carListToCarResponse(List<CarEntity> carEntities);


}
