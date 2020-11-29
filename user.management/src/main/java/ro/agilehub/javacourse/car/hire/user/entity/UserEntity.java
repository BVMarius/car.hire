package ro.agilehub.javacourse.car.hire.user.entity;

import lombok.*;
import ro.agilehub.javacourse.car.hire.fleet.entity.TimestampedEntityId;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "consumers")
public class UserEntity extends TimestampedEntityId {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String username;
  private String email;
  private String password;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "drivers_license_number")
  private String licenseNumber;

  private String status;

  @ManyToOne
  @JoinColumn(name = "country_id")
  private CountryEntity country;

}
