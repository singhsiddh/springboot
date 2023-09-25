package om.sai.sbjpa.se;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import om.sai.sbjpa.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sai")
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
public class AppointmenRest {

    @Autowired
    private  AppointmentService appointmentService;

    @GetMapping("/baba")
    public Object getBaba() {
        log.info("Sai baba");
        return appointmentService.getTestdata();
    }
}
