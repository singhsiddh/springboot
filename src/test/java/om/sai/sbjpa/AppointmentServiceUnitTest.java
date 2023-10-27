package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import om.sai.sbjpa.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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
    @Captor
    ArgumentCaptor<AppointmentEntity> entityArgumentCaptor;
    @MockBean

    private AppointmentRepository appointmentRepository;

    @Test
    public void testService() {
        log.info("info service ");
        Object obj = appointmentService.getTestdata();
        verify(appointmentRepository).findAll();

        log.info(" obj=" + obj);

    }

    @Test
    public void testService1() {
        log.info("info service ");
        when(appointmentRepository.findAll()).thenReturn(getApp());
        AppointmentEntity en = new AppointmentEntity();
        en.setId(1);
        en.setName(23l);
        when(appointmentRepository.save(en)).thenReturn(en);
        Object obj = appointmentService.getTestdata();
        log.info(" obj=" + obj);
        appointmentService.save(en);
        //https://www.baeldung.com/mockito-argumentcaptor
         verify(appointmentRepository).save(entityArgumentCaptor.capture()); //OR
        AppointmentEntity ent =
        entityArgumentCaptor.getValue();
        log.info(" name=" + ent.getName());
        verify(appointmentRepository, atLeast(1)).findAll();
        verifyNoMoreInteractions(appointmentRepository);
    }
    @Test
    public void testService2() {
        log.info("info service ");
        //when(appointmentRepository.findById(any())).thenReturn(()-> return getAppId(););
        Object obj = appointmentService.getTestdata(1l);
        log.info(" obj=" + obj);
        ;
        // verify(appointmentRepository).findAll(); //OR
        verify(appointmentRepository, atLeast(1)).findById(any());
        verifyNoMoreInteractions(appointmentRepository);
    }

    private List<AppointmentEntity> getApp() {
        List<AppointmentEntity> list = new ArrayList<>();
        AppointmentEntity en = new AppointmentEntity();
        en.setId(1);
        list.add(en);
        en = new AppointmentEntity();
        en.setId(2);
        list.add(en);
        return list;

    }
    private AppointmentEntity getAppId() {

        AppointmentEntity en = new AppointmentEntity();
        en.setId(1);

        return en;

    }
}
