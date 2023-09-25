package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class TestRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Test
    public void test(){
     Object object=   appointmentRepository.findAll();
     log.info("Sai repo obj "+ object);
    }
}