package om.sai.sbjpa.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import om.sai.sbjpa.sdo.entity.AppointmentEntity;
import om.sai.sbjpa.sdo.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
@Service//("Appointment")
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor

public class AppointmentService {
    @Autowired
    private  AppointmentRepository appointmentRepository;

    public Object getTestdata(){
    Object obj= appointmentRepository.findAll();
    log.info("obj"+obj);
    return obj;
    }
    public Object getTestdata(long id){
        Object obj= appointmentRepository.findById(id);
        log.info("obj"+obj);
        return obj;
    }
    public AppointmentEntity save(AppointmentEntity en){
        return appointmentRepository.save(en);
    }
}
