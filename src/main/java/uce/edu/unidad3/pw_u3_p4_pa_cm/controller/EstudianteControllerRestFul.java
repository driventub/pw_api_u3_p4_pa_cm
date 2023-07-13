package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
    
    @Autowired
    private IEstudianteService estudianteService;

    // @GetMapping(path = "/{cedula}")
    // private Estudiante consultarPorCedula(String estudiante){
    //     return this.estudianteService.consultarPorCedula(estudiante);
    // }
    @GetMapping(path = "/buscar")
    public Estudiante consultarPorCedula(){
        String cedula = "12345690870";
        return this.estudianteService.consultarPorCedula(cedula);
    }

    @PostMapping(path = "/ingresar")
    public void ingresarEstudiante(@RequestBody Estudiante estu){
        this.estudianteService.insertarEstudianteService(estu);
    }

    @PutMapping(path = "/actualizar")
    public void actualizarEstudiante(Estudiante estu){

        // this.estudianteService.actualizarEstudianteService(estu);
    }

    @PatchMapping(path = "/actualizaParcial")
    public void actualizarParcialEstudiante(){

    }

    @DeleteMapping(path = "/eliminar")
    public void borrarEstudiante(){

    }
    
}
