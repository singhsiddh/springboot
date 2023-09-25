package om.sai.sbjpa;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class SbjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbjpaApplication.class, args);
	}


	@Bean
	public DataSource getDataSource() {
		DataSource db= null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

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
