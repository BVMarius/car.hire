package ro.agilehub.javacourse.car.hire.fleet.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "cars")
public class CarEntity extends TimestampedEntityId {

  @Column(name = "fuel_type")
  private String fuelType;

  private String make;
  private String model;
  private String registration;
  private String transmission;
  private String vin;
  private Integer year;
  private String tyres;

  @Column(name = "car_class")
  private String carClass;

  @Column(name = "mileage_in_kilometres")
  private String mileageInKilometers;

  @Column(name = "engine_size")
  private Double engineSize;

  private String status;
}
