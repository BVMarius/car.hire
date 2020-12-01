package ro.agilehub.javacourse.car.hire.fleet.service;

import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

import java.util.List;

public interface FleetManagementService {

    CarEntity createCar(CarEntity carEntity);
    List<CarEntity> listCars();
    CarEntity getCarById(Integer id);
    void deleteCar(Integer id);
    void updateCar(CarEntity carEntity);
}
