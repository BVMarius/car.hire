package ro.agilehub.javacourse.car.hire.fleet.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
  ACTIVE("ACTIVE"),
  DELETED("DELETED");

  private String value;

  StatusEnum(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
