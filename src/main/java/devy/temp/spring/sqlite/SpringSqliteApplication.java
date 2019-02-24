package devy.temp.spring.sqlite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;

@SpringBootApplication
public class SpringSqliteApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringSqliteApplication.class);

	private static final String SQL_NAME 	  = "create.sql";
	private static final String DB_NAME       = "sqlite.db";
	private static final String SQLITE 		  = "sqlite3";
	private static final File FILE_DB 		  = new File(DB_NAME);
	private static final File FILE_CREATE_SQL = new File(SQL_NAME);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringSqliteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String cmd = SQLITE + " " + DB_NAME;
		logger.info(cmd);
		if(!FILE_DB.exists()) {
			Runtime.getRuntime().exec(cmd);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_CREATE_SQL)));
		StringBuilder sb = new StringBuilder();
		String temp;
		while((temp = br.readLine()) != null) {
			sb.append(temp);
		}

		String[] sqlArr = sb.toString().split(";");
		for(String sql : sqlArr) {
			logger.info("Execute DDL '" + sql + "'");
			this.jdbcTemplate.execute(sql);
		}
	}
}
