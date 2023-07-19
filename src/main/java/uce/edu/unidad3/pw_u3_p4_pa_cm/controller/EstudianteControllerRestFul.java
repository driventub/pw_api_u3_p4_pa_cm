package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(path = "/cedula")
    public Estudiante consultarPorCedula(@PathVariable String cedula){
        
        return this.estudianteService.consultarPorCedula(cedula);
    }

    @PostMapping
    public void ingresarEstudiante(@RequestBody Estudiante estu){
        this.estudianteService.insertarEstudianteService(estu);
    }

    @GetMapping
    public List<Estudiante> buscarTodos(){
        return this.estudianteService.buscarTodos();
    }

    @PutMapping(path = "/{id}")
    public void actualizarEstudiante(@RequestBody Estudiante estu,@PathVariable Integer id){
        estu.setId(id);
        this.estudianteService.actualizarEstudianteService(estu);
    }

    @PatchMapping(path = "/{cedula}")
    public void actualizarParcialEstudiante(@RequestBody Estudiante estu, @PathVariable String cedula){
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estu.getCedula());
        this.estudianteService.actualizarEstudianteService(estu1);   
    }

    @DeleteMapping(path =  "/{cedula}")
    public void borrarCedula(@PathVariable String cedula){
        this.estudianteService.eliminarEstudianteService(cedula);
    }
    
}
