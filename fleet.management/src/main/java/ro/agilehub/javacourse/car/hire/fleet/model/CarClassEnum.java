package ro.agilehub.javacourse.car.hire.fleet.model;

public enum CarClassEnum {
  COMPACT("COMPACT"),
  EXECUTIVE("EXECUTIVE"),
  MINIVAN("MINIVAN"),
  SUV("SUV");

  private String value;

  CarClassEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
