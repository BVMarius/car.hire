package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity,Integer> {

   // @Query(value="select * from CarEntity a where a.registration= :registration", nativeQuery=true)

    boolean existsCarEntityByRegistration(String registration);

}
