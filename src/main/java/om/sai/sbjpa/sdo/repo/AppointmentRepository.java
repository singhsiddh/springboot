package om.sai.sbjpa.sdo.repo;

import jdk.jfr.Registered;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
@Query(value ="select t.* from test t where t.name = :name " ,nativeQuery = true)
List<AppointmentEntity> getEntityByNam(Long name);
}
