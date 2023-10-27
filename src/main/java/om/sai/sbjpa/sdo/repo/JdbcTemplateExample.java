package om.sai.sbjpa.sdo.repo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import om.sai.sbjpa.service.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Simple / Bulk Insert, update ,delete
 */
@Service("jdbcTemplateExample")
@RequiredArgsConstructor
@AllArgsConstructor
public class JdbcTemplateExample {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_APPOINTMENT = " insert into Test() values (?,?)";

    public int[] insertBulk(List<AppointmentModel> modelList) {
        List<Object[]> listObj = modelList.stream().map(data -> setParameter(data)).collect(Collectors.toList());
        return jdbcTemplate.batchUpdate(INSERT_APPOINTMENT, listObj);

    }
    public int insert(AppointmentModel model) {
      // Object[] attributes =  { (new Random()).nextInt(),model.getName()};

        return jdbcTemplate.update(INSERT_APPOINTMENT, (new Random()).nextInt(),model.getName());

    }

    private Object[] setParameter(AppointmentModel model) {
        List<Object> attributes = new ArrayList<>();
        attributes.add((new Random()).nextInt());
        attributes.add(model.getName());
        return attributes.toArray();
    }
}
