package ro.agilehub.javacourse.car.hire.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.agilehub.javacourse.car.hire.user.entity.CountryEntity;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity,Integer> {

    @Override
    Optional<CountryEntity> findById(Integer integer);
}
