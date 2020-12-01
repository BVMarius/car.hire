package ro.agilehub.javacourse.car.hire.fleet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;
import ro.agilehub.javacourse.car.hire.fleet.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.fleet.repository.CarRepository;
import ro.agilehub.javacourse.car.hire.fleet.service.FleetManagementService;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FleetManagementServiceImpl implements FleetManagementService {
  @Autowired private final CarRepository carRepository;

  @Override
  public CarEntity createCar(CarEntity carEntity) {
    if (carEntity.getStatus() == null) {
      carEntity.setStatus(StatusEnum.ACTIVE.getValue());
    }
    return carRepository.save(carEntity);
  }

  @Override
  public List<CarEntity> listCars() {
    return Collections.emptyList();
  }

  @Override
  public CarEntity getCarById(Integer id) {
    return null;
  }

  @Override
  public void deleteCar(Integer id) {
    //TO DO
  }

  @Override
  public void updateCar(CarEntity carEntity, Integer id) {

    CarEntity carToBeUpdated =
        carRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("no car found in repository"));

    if (carEntity.getMake() != null) {
      carToBeUpdated.setMake(carEntity.getMake());
    }

    if (carEntity.getModel() != null) {
      carToBeUpdated.setModel(carEntity.getModel());
    }

    if (carEntity.getYear() != null) {
      carToBeUpdated.setYear(carEntity.getYear());
    }

    if (carEntity.getMileageInKilometers() != null) {
      carToBeUpdated.setYear(carEntity.getMileageInKilometers());
    }

    carRepository.save(carToBeUpdated);
  }
}
