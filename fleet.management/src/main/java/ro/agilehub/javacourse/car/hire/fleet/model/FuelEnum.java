package ro.agilehub.javacourse.car.hire.fleet.model;

public enum FuelEnum {
    GASOLINE("GASOLINE"),
    DIESEL("DIESEL"),
    LIQUEFIED_NATURAL_GAS("LIQUEFIED_NATURAL_GAS"),
    HYBRID("HYBRID"),
    ELECTRIC("ELECTRIC");

    private String value;

     FuelEnum(String value) {
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

