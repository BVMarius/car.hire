package ro.agilehub.javacourse.car.hire.user.service.impl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.user.entity.CountryEntity;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;
import ro.agilehub.javacourse.car.hire.user.repository.CountryRepository;
import ro.agilehub.javacourse.car.hire.user.repository.UserRepository;
import ro.agilehub.javacourse.car.hire.user.service.UserService;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash = argon2.hash(4, 1024 * 1024, 8, userEntity.getPassword());

        userEntity.setPassword(hash);
        userEntity.setInsertedAt(LocalDateTime.now());
        userEntity.setUpdatedAt(LocalDateTime.now());
        CountryEntity country = countryRepository.findById(userEntity.getCountry().getId())
                .orElseThrow(()->new RuntimeException("no country found for the specified id"));


        userEntity.setStatus("active");
        userEntity.setCountry(country);

        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> listUsers(){
       return userRepository.findAll();
    }
}
