package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import om.sai.sbjpa.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Slf4j
public class AppointmentServiceUnitTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public AppointmentService employeeService() {
            return new AppointmentService();
        }
    }

    @Autowired
    private AppointmentService appointmentService;

    @MockBean

    private AppointmentRepository appointmentRepository;

    @Test
    public void testService(){
        log.info("info service ");
        Object obj=   appointmentService.getTestdata();
        log.info(" obj="+obj);

    }
    @Test
    public void testService1(){
        log.info("info service ");
        when(appointmentRepository.findAll()).thenReturn(getApp());
        Object obj=   appointmentService.getTestdata();
        log.info(" obj="+obj);

    }
    private List<AppointmentEntity>  getApp(){
        List<AppointmentEntity> list= new ArrayList<>();
       AppointmentEntity en = new AppointmentEntity();
       en.setId(1);
       list.add(en);
        en = new AppointmentEntity();
        en.setId(2);
        list.add(en);
       return list;

    }
}
