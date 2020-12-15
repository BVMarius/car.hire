package ro.agilehub.javacourse.car.hire.fleet.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ro.agilehub.javacourse.car.hire.fleet.entity.CarEntity;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarRepository carRepository;

    private int check;

    @Before
    public void setUp() {
        CarEntity car = new CarEntity();
        car.setRegistration("a");

        testEntityManager.persist(car);


    }

    @Test
    public void findByRegistration_whenMatch_ReturnTrue(){
       boolean value = carRepository.existsCarEntityByRegistration("a");
       assertTrue(value);
    }

    @Test
    public void findByRegistration_whenNoMatch_ReturnFalse(){
        boolean value = carRepository.existsCarEntityByRegistration("ab");
        assertFalse(value);
    }

    @Test
    public void findById_whenMatchReturn(){
        assertTrue(carRepository.findById(1).isPresent());
    }


}