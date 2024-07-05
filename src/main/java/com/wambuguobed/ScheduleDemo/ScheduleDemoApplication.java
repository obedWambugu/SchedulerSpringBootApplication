package com.wambuguobed.ScheduleDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wambuguobed.ScheduleDemo.Domain.Designation;
import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Repository.TeacherRepository;
import com.wambuguobed.ScheduleDemo.Repository.TimeTableRepository;
import com.wambuguobed.ScheduleDemo.Service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.wambuguobed.ScheduleDemo.Domain.Designation.BABY;

@ComponentScan("com.wambuguobed.ScheduleDemo.Repository")
@ComponentScan("com.wambuguobed.ScheduleDemo.Controller")
@ComponentScan("com.wambuguobed.ScheduleDemo.Service")
@SpringBootApplication
@Configuration
@EnableWebSecurity
public class ScheduleDemoApplication{

	/*@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	TimeTableRepository timeTableRepository;*/
	public static void main(String[] args) {

		SpringApplication.run(ScheduleDemoApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception
	{
		// Inserting the data in the mysql table.
		Teacher first = new Teacher(1, "Obed","Wambugu", BABY,"wambuguobed@gmail.com");
		TimeTable table = new TimeTable(1,"2020-07-05","5:00:00","Lordship","BABY","Obed");
		// ob.save() method
		teacherRepository.save(first);
		timeTableRepository.save(table);
	}*/
	/*@Bean
	CommandLineRunner timeTable(TimeTableService timeTableService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<TimeTable>> typeReference = new TypeReference<List<TimeTable>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/timeTables.json");
			try {
				List<TimeTable> timeTables = mapper.readValue(inputStream,typeReference);
				timeTableService.save(timeTables);
				System.out.println("TimeTables Saved!");
			} catch (IOException e){
				System.out.println("Unable to save timetables: " + e.getMessage());
			}
		};
	}*/

}
