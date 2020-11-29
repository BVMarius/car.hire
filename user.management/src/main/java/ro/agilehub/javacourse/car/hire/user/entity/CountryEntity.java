package ro.agilehub.javacourse.car.hire.user.entity;

import lombok.*;
import ro.agilehub.javacourse.car.hire.fleet.entity.EntityId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class CountryEntity extends EntityId {

  private String name;
  @Column(name = "isocode")
  private String isoCode;
}
