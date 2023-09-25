package om.sai.sbjpa;

import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import om.sai.sbjpa.se.AppointmenRest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcRequestBuilders.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AppointmenRest.class)
@AutoConfigureMockMvc
/*@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
        */

public class RestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    //@MockBean // Springboot context
    //private AppointmentRepository appointmentRepository;
    //Http200Save

    //@Autowired
    //private EmployeeRepository repository;
    //@Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {

        //createTestEmployee("bob");

        mvc.perform(get("/sai/baba")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        // .andExpect(jsonPath("$[0].name", is("bob")));
    }
}
