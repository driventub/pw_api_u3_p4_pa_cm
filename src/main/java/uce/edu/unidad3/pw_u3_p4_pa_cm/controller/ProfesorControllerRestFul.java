package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {
    
    @Autowired
    private IProfesorService profeService;

    @GetMapping(path = "/{cedula}",produces ="application/xml")
    @ResponseStatus(HttpStatus.OK)
    public Profesor consultarPorCedula(@PathVariable String cedula){  
        return this.profeService.consultarPorCedula(cedula);
    }

    @PostMapping(consumes = "application/xml")
    public void ingresarProfesor(@RequestBody Profesor pro){
        this.profeService.insertarProfesorService(pro);
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> buscarTodos(){
        List<Profesor> lista = this.profeService.buscarTodos();
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
        cabeceras.add("valorAPI", "No aplicable");

        return new ResponseEntity<List<Profesor>>(lista, cabeceras, 227) ;
    }
    
    @PutMapping(path = "/{id}")
    public void actualizarProfesor(@RequestBody Profesor pro, @PathVariable Integer id){
        pro.setId(id);
        this.profeService.actualizarProfesorService(pro);
    }

    @PatchMapping(path = "/{cedula}")
    public void actualizarParcialProfesor(@RequestBody Profesor pro, @PathVariable String cedula ){
        Profesor pro1 = this.profeService.consultarPorCedula(cedula);
        pro1.setCedula(pro.getCedula());
        this.profeService.actualizarProfesorService(pro1);
    }

    @DeleteMapping(path = "/{cedula}")
    public void borrarCedula(@PathVariable String cedula){
        this.profeService.eliminarProfesorService(cedula);
    }

    @PostMapping(path = "/{cedula}",produces = MediaType.APPLICATION_XML_VALUE, consumes = "application/xml")
    public Profesor ingresarEstudiantePersonalizado(@PathVariable String cedula , @RequestBody Profesor pro){
        pro.setCedula(cedula);
        this.profeService.insertarProfesorService(pro);
        return this.profeService.consultarPorCedula(pro.getCedula());
    }
}
