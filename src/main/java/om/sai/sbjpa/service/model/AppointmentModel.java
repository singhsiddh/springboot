package om.sai.sbjpa.service.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class AppointmentModel {
    private long Id;
    private long name;

}
