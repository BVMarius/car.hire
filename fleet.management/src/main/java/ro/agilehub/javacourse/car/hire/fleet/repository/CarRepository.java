package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;


@Repository
public interface CarRepository extends JpaRepository<CarEntity,Integer> {

    boolean existsCarEntityByRegistration(String registration);

}
