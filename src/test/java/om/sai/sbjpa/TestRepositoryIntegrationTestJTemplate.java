package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import om.sai.sbjpa.sdo.repo.JdbcTemplateExample;
import om.sai.sbjpa.service.model.AppointmentModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class TestRepositoryIntegrationTestJTemplate {


    @Autowired
    private JdbcTemplateExample jdbcTemplateExample;


    @Test
    public void testJdbcTemplate() {
        List<AppointmentModel> list = new ArrayList<>();
        AppointmentModel model = new AppointmentModel();
        model.setName(55l);
        list.add(model);
        model = new AppointmentModel();
        model.setName(66l);
        list.add(model);
        int[] jj = jdbcTemplateExample.insertBulk(list);
        log.info("jj" + jj);
    }


}
