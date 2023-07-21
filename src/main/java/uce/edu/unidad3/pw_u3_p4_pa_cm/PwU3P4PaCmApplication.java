package uce.edu.unidad3.pw_u3_p4_pa_cm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PwU3P4PaCmApplication implements CommandLineRunner{

	// @Autowired
	// private IEstudianteService estudianteService;
	public static void main(String[] args) {
		SpringApplication.run(PwU3P4PaCmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Estudiante e = this.estudianteService.consultarPorCedula("12345690870");
		// System.out.println(e.getNombre());
	}

}
