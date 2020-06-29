package com.converter.task;

import com.converter.task.connection.JdbcConfig;
import com.converter.task.converters.FileConverter;
import com.converter.task.services.AppLogic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(TaskApplication.class, args);
        JdbcConfig config = new JdbcConfig();
        config.dataSource();
		if(args.length > 0){
            File file = new File(args[0]);
            AppLogic appLogic = new AppLogic();
            appLogic.setStrategy(file);
        }
	}

}
