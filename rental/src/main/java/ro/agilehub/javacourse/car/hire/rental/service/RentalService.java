package ro.agilehub.javacourse.car.hire.rental.service;

import ro.agilehub.javacourse.car.hire.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.entity.RentalEntity;

import java.util.List;

public interface RentalService {

  RentalEntity createRental(RentalEntity createRentalRequest);

  void deleteRental(int rentalId);

  RentalEntity getRentalById(int rentalId);

  List<RentalResponse> listRental();
}
