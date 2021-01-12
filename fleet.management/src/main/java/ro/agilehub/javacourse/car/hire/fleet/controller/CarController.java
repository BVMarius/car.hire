package ro.agilehub.javacourse.car.hire.fleet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.agilehub.javacourse.car.hire.api.model.*;

import ro.agilehub.javacourse.car.hire.api.specification.CarApi;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;
import ro.agilehub.javacourse.car.hire.fleet.mapper.CarMapper;
import ro.agilehub.javacourse.car.hire.fleet.service.FleetManagementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole(MANAGER)")
public class CarController implements CarApi {

  private final CarMapper carMapper;
  private final FleetManagementService fleetManagementService;

  @Override
  public ResponseEntity<SuccessResponse> createCar(CreateCarRequest createCarRequest) {

    CarEntity carEntity = carMapper.carRequestCreateToEntity(createCarRequest);
    fleetManagementService.createCar(carEntity);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteCar(Integer carId) {
    fleetManagementService.deleteCar(carId);
    return new ResponseEntity<>(HttpStatus.valueOf(200));
  }

  @Override
  public ResponseEntity<CarResponse> getCarById(Integer carId) {
    CarEntity carEntity = fleetManagementService.getCarById(carId);
    CarResponse carResponse = carMapper.carEntityToResponse(carEntity);
    return new ResponseEntity<>(carResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<CarResponse>> listCars() {

    return new ResponseEntity<>(carMapper.carListToCarResponse(fleetManagementService.listCars()),HttpStatus.NOT_IMPLEMENTED);
  }

  @Override
  public ResponseEntity<Void> updateCar(Integer carId, CreateCarRequest createCarRequest) {
    CarEntity carEntity = fleetManagementService.getCarById(carId);
    carMapper.carRequestUpdateToEntity(createCarRequest, carEntity);
    fleetManagementService.updateCar(carEntity);

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
