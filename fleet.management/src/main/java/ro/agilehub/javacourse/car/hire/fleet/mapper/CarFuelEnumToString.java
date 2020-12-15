package ro.agilehub.javacourse.car.hire.fleet.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.api.model.CreateCarRequest;


@Mapper(componentModel = "spring")
public interface CarFuelEnumToString {

  default String map(CreateCarRequest.FuelEnum fuelEnum) {

    return fuelEnum.getValue();
  }
}
