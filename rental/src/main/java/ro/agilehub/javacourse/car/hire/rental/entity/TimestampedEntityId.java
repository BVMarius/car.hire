package ro.agilehub.javacourse.car.hire.rental.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class TimestampedEntityId extends EntityId {


    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onPrePersist() {
        auditInserted();
        auditUpdated();
    }

    @PreUpdate
    public void onPreUpdate() {
        auditUpdated();
    }

    private void auditUpdated() {
        setUpdatedAt(LocalDateTime.now());
    }

    private void auditInserted(){
        setInsertedAt(LocalDateTime.now());



    }
}
