package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProfesorController {
    @Autowired
    private IProfesorService profeService;


    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Profesor consultarPorCedula(@PathVariable String cedula){
        // String cedula = "12345690870";
        return this.profeService.consultarPorCedula(cedula);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void ingresarProfesor(@RequestBody Profesor profe){
        this.profeService.insertarProfesor(profe);
    }


    @PatchMapping(path = "/{cedula}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void actualizarParcialProfesor(@RequestBody Profesor profe, @PathVariable String cedula ){
        
        this.profeService.actualizarParcial(cedula, profe.getSalario());

        
        
    }
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void actualizarProfesor(@RequestBody Profesor profe, @PathVariable Integer id){
        // Integer id = 1;
        profe.setId(id);
        

        this.profeService.actualizarProfesor(profe);
    }

    @DeleteMapping(path = "/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public void borrarId(@PathVariable String cedula){
        this.profeService.eliminarProfesor(cedula);
    }
   
    
}
