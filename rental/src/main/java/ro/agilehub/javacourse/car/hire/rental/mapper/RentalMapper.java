package ro.agilehub.javacourse.car.hire.rental.mapper;

import org.mapstruct.*;

import ro.agilehub.javacourse.car.hire.api.model.CreateRentalRequest;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;

import ro.agilehub.javacourse.car.hire.rental.entity.RentalEntity;

@Mapper(componentModel = "spring", uses = StatusEnumToString.class)
public interface RentalMapper {

  @BeanMapping(
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
      nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
  @Mapping(source = "userId", target = "consumerId")
  RentalEntity mapRequestToEntity(CreateRentalRequest carRequest);

  SuccessResponse carEntityToResponse(RentalEntity rentalEntity);
}
