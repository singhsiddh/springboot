package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import om.sai.sbjpa.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@Slf4j
public class AppointmentServiceImplIntegrationTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public AppointmentService employeeService() {
            return new AppointmentService();
        }
    }

    @Autowired
    private AppointmentService appointmentService;

    //@MockBean
    @Autowired
   private AppointmentRepository appointmentRepository;

    @Test
    public void testService(){
        log.info("info service ");
     Object obj=   appointmentService.getTestdata();
     log.info(" obj="+obj);

    }
}
