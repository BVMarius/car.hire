package ro.agilehub.javacourse.car.hire.user.service.impl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.user.entity.CountryEntity;
import ro.agilehub.javacourse.car.hire.user.entity.UserEntity;
import ro.agilehub.javacourse.car.hire.user.repository.CountryRepository;
import ro.agilehub.javacourse.car.hire.user.repository.UserRepository;
import ro.agilehub.javacourse.car.hire.user.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  public static final String NO_USER_FOUND_FOR_THE_SPECIFIED_ID =
      "no user found for the specified id";
  private final UserRepository userRepository;

  private final CountryRepository countryRepository;

  @Override
  public UserEntity createUser(UserEntity userEntity) {

    String password = userEntity.getPassword();

    String hash = getArgonHashedPassword(password);

    userEntity.setPassword(hash);
    userEntity.setInsertedAt(LocalDateTime.now());
    userEntity.setUpdatedAt(LocalDateTime.now());
    CountryEntity country =
        countryRepository
            .findById(userEntity.getCountry().getId())
            .orElseThrow(() -> new RuntimeException("no country found for the specified id"));

    userEntity.setStatus("active");
    userEntity.setCountry(country);

    return userRepository.save(userEntity);
  }

  private String getArgonHashedPassword(String password) {
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    return argon2.hash(4, 1024 * 1024, 8, password);
  }

  @Override
  public List<UserEntity> listUsers() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity getUserById(Integer id) {

    return userRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException(NO_USER_FOUND_FOR_THE_SPECIFIED_ID));
  }

  @Override
  public void deleteUser(Integer id) {
    UserEntity userEntity =
        userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException(NO_USER_FOUND_FOR_THE_SPECIFIED_ID));
    userRepository.delete(userEntity);
  }

  @Override
  public void updateUser(
      String email,
      String password,
      String username,
      String firstName,
      String lastName,
      Integer country,
      Integer id) {
    UserEntity userEntity =
        userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException(NO_USER_FOUND_FOR_THE_SPECIFIED_ID));
    String hashedPassword = this.getArgonHashedPassword(userEntity.getPassword());
    userRepository.detachEntity(userEntity);
    userRepository.updateUser(email, hashedPassword, username, firstName, lastName, country, id);
  }
}
