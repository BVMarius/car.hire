package ro.agilehub.javacourse.car.hire.fleet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;
import ro.agilehub.javacourse.car.hire.fleet.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.fleet.repository.CarRepository;
import ro.agilehub.javacourse.car.hire.fleet.service.FleetManagementService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FleetManagementServiceImpl implements FleetManagementService {
  @Autowired private final CarRepository carRepository;

  @Override
  public CarEntity createCar(CarEntity carEntity) {
    if (carEntity.getStatus() == null) {
      carEntity.setStatus(StatusEnum.ACTIVE.getValue());
    }
    if (carRepository.existsCarEntityByRegistration(carEntity.getRegistration().toLowerCase())) {
      throw new RuntimeException("Id already present in db");
    }
    return carRepository.save(carEntity);
  }

  @Override
  public List<CarEntity> listCars() {

    List<CarEntity> carEntityList = carRepository.findAll();
    if (carEntityList.isEmpty()) {
      throw new NoSuchElementException();
    }

    return carEntityList;
  }

  @Override
  public CarEntity getCarById(Integer id) {
    return carRepository
        .findById(id)
        .orElseThrow(() -> new NoSuchElementException("no car found in repository"));
  }

  @Override
  public void deleteCar(Integer id) {
    carRepository.deleteById(id);
  }

  @Override
  public void updateCar(CarEntity carEntity) {
    if (carRepository.existsCarEntityByRegistration(carEntity.getRegistration().toLowerCase())) {
      throw new RuntimeException("Id already present in db");
    }
    carRepository.save(carEntity);
  }
}
