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
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping(path = "/buscar/{cedula}")
    public Estudiante consultarPorCedula(@PathVariable String cedula){
        // String cedula = "12345690870";
        return this.estudianteService.consultarPorCedula(cedula);
    }

    @PostMapping(path = "/ingresar")
    public void ingresarEstudiante(@RequestBody Estudiante estu){
        this.estudianteService.insertarEstudianteService(estu);
    }

    @PutMapping(path = "/actualizar/{id}")
    public void actualizarEstudiante(@RequestBody Estudiante estu, @PathVariable Integer id){
        // Integer id = 1;
        estu.setId(id);
        

        this.estudianteService.actualizarEstudianteService(estu);
    }

    @PatchMapping(path = "/actualizaParcial/{cedula}")
    public void actualizarParcialEstudiante(@RequestBody Estudiante estu, @PathVariable String cedula ){
        // Integer id = 1;
        
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
        estu1.setCedula(estu.getCedula());
        this.estudianteService.actualizarEstudianteService(estu1);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrarCedula(@PathVariable Integer id){
        // Integer idd = 2;
        this.estudianteService.borrar(id);
    }

    @DeleteMapping(path = "/eliminarCedula")
    public void borrarId(String cedula){
        this.estudianteService.eliminarEstudianteService(cedula);
    }

    @GetMapping(path = "/buscarTodos")
    public List<Estudiante> buscarTodos(@RequestParam String provincia){
        // buscarTodos?provincia = pichincha
        return this.estudianteService.buscarTodos(provincia);
    }
    
}
