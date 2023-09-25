package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@TestConfiguration
@Slf4j
public class TestConfig {
    @Bean
    public DataSource getDataSource() {
        DataSource db= null;
        try {

            //Class.forName("oracle.jdbc.driver.OracleDriver");

            db = DataSourceBuilder.create()
                    .driverClassName("oracle.jdbc.driver.OracleDriver")
                    .url("jdbc:oracle:thin:@localhost:1521:xe")
                    .username("gautam")
                    .password("gautam")
                    .build();
            Connection dbConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "gautam", "gautam");
            log.info(" dbConn.. "+dbConn);

        }catch(Exception e){
            e.printStackTrace();
        }
        log.info(" DB.. "+db);
        return db;
    }
}
