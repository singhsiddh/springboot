package om.sai.sbjpa.sdo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Embeddable
@AllArgsConstructor
@Table(name="TEST")
public class AppointmentEntity {
    @Id
    @Column(name = "ID")
    private long Id;

    @Column(name = "NAME")
    private long name;

}
