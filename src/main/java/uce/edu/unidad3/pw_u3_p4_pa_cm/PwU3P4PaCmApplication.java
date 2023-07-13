package uce.edu.unidad3.pw_u3_p4_pa_cm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IEstudianteService;

@SpringBootApplication
public class PwU3P4PaCmApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	public static void main(String[] args) {
		SpringApplication.run(PwU3P4PaCmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	

		
	}

}
