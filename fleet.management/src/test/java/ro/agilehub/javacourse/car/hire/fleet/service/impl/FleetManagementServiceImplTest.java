package ro.agilehub.javacourse.car.hire.fleet.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;
import ro.agilehub.javacourse.car.hire.fleet.repository.CarRepository;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FleetManagementServiceImplTest {

  @Mock CarRepository carRepository;

  @InjectMocks FleetManagementServiceImpl fleetManagementService;

  @Test
  public void findAllCars_whenEmpty_thenException() {
    List<CarEntity> carEntities = Collections.emptyList();

    when(carRepository.findAll()).thenReturn(carEntities);

    assertThrows(NoSuchElementException.class, () -> fleetManagementService.listCars());
  }

  @Test
  public void findAllCars_whenCars_thenResult() {
    CarEntity carEntity = mock(CarEntity.class);
    List<CarEntity> carEntityList = List.of(carEntity);

    when(carRepository.findAll()).thenReturn(carEntityList);

    assertEquals(1, fleetManagementService.listCars().size());
  }

  @Test
  public void getCar_whenCar_thenResult(){

    CarEntity carEntity = mock(CarEntity.class);


    when(carRepository.findById(any())).thenReturn(Optional.of(carEntity));

    fleetManagementService.getCarById(any());

    verify(carRepository,times(1)).findById(any());


  }

  @Test
  public void getCar_whenEmpty_thenResult(){

    CarEntity carEntity = null;


    when(carRepository.findById(any())).thenReturn(Optional.empty());

    assertThrows(NoSuchElementException.class, () -> fleetManagementService.getCarById(any()));



  }
}
