package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;


public interface CarRepository extends JpaRepository<CarEntity,Integer> {

    boolean existsCarEntityByRegistration(String registration);

}
