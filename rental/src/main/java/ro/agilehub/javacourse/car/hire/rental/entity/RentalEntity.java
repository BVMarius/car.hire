package ro.agilehub.javacourse.car.hire.rental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="rentals")
public class RentalEntity extends TimestampedEntityId {

    @Column(name="consumer_id")
    private int consumerId;
    @Column(name="car_id")
    private int carId;
    @Column(name="start_at")
    private OffsetDateTime startDate;
    @Column(name="end_at")
    private OffsetDateTime endDate;
    @Column
    private String status;

}
