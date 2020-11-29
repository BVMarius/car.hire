package ro.agilehub.javacourse.car.hire.user.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.user.entity.CountryEntity;

@Mapper(componentModel = "spring")
public interface CountryToStringMapper {


    default String map(CountryEntity countryEntity) {



        return countryEntity.getName();
    }

}
