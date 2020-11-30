package ro.agilehub.javacourse.car.hire.user.repository;

public interface UserJdbcRepository {

    void updateUser(String email, String password
    , String username, String firstName,
                    String lastName, Integer country, Integer id);

     <T> void detachEntity(T entity);
}
