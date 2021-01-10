package ro.agilehub.javacourse.car.hire.rental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.api.model.CreateRentalRequest;
import ro.agilehub.javacourse.car.hire.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.api.model.SuccessResponse;
import ro.agilehub.javacourse.car.hire.api.specification.RentalApi;

import java.util.List;

@RestController
public class RentalController implements RentalApi {

  @Override
  public ResponseEntity<SuccessResponse> createRental(CreateRentalRequest createRentalRequest) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
