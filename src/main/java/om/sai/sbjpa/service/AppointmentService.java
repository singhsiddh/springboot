package om.sai.sbjpa.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service//("Appointment")
@Slf4j

@AllArgsConstructor
public class AppointmentService {
    @Autowired
    private  AppointmentRepository appointmentRepository;

    public Object getTestdata(){
      return   appointmentRepository.findAll();
    }
}