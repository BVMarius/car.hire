package ro.agilehub.javacourse.car.hire.rental.service.impl;

import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Override
    public RentalEntity createRental(RentalEntity createRentalRequest) {
        return null;
    }

    @Override
    public void deleteRental(int rentalId) {

    }

    @Override
    public RentalEntity getRentalById(int rentalId) {
        return null;
    }

    @Override
    public List<RentalResponse> listRental() {
        return null;
    }
}
