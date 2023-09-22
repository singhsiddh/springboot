package om.sai.sbjpa.sdo.repo;

import jdk.jfr.Registered;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
