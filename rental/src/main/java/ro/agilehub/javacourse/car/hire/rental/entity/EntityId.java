package ro.agilehub.javacourse.car.hire.rental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class EntityId {

    @SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="gen_id_seq", name="gen_id_seq")
    @GeneratedValue(generator="gen_id_seq", strategy= GenerationType.SEQUENCE)
    @Id
    @Column(name="id")
    private Integer id;
}
