package ro.agilehub.javacourse.car.hire.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.api.model.RentalResponse;
import ro.agilehub.javacourse.car.hire.rental.entity.RentalEntity;
import ro.agilehub.javacourse.car.hire.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    @Override
    public RentalEntity createRental(RentalEntity rentalEntity) {

      //  RentalEntity rentalEntity = new RentalEntity();
      //  rentalMapper.mapRequestToEntity(createRentalRequest,rentalEntity);

        return rentalRepository.save(rentalEntity);
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
