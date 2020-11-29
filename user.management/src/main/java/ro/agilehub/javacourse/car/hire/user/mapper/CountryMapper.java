package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.user.entity.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryMapper {


    default CountryEntity map(Integer value) {
        if ( value == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(value);

        return countryEntity;
    }

}
