package ro.agilehub.javacourse.car.hire.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.CreateRentalRequest;
import ro.agilehub.javacourse.car.hire.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.api.specification.RentalApi;
import ro.agilehub.javacourse.car.hire.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentalApi {

  private final RentalService rentalService;
  private final RentalMapper rentalMapper;

  @Override
  public ResponseEntity<SuccessResponse> createRental(CreateRentalRequest createRentalRequest) {

    RentalEntity rentalEntity =rentalService.createRental(rentalMapper.mapRequestToEntity(createRentalRequest));
    return new ResponseEntity<>(rentalMapper.carEntityToResponse(rentalEntity),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteRental(Integer rentalId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Override
  public ResponseEntity<RentalResponse> getRentalById(Integer rentalId) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Override
  public ResponseEntity<List<RentalResponse>> listRental() {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
