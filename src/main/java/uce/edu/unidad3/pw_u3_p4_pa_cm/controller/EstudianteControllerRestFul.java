package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    private Estudiante consultarPorCedula(){
        String cedula = "12345690870";
        return this.estudianteService.consultarPorCedula(cedula);
    }
    
}
