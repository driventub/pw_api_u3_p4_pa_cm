package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/{cedula}")
    
    public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula){
        
        return ResponseEntity.status(227)
        .body(this.estudianteService.consultarPorCedula(cedula));
    }

    @GetMapping(path = "/status/{cedula}")
    
    public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable String cedula){
        
        return ResponseEntity.status(HttpStatus.OK)
        .body(this.estudianteService.consultarPorCedula(cedula));
    }

    @PostMapping
    public void ingresarEstudiante(@RequestBody Estudiante estu){
        this.estudianteService.insertarEstudianteService(estu);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> buscarTodos(){
        List<Estudiante> lista = this.estudianteService.buscarTodos();

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
        cabeceras.add("valorAPI", "No aplicable");

        return new ResponseEntity<List<Estudiante>>(lista, cabeceras, 227) ;
    }

    // @PostMapping
    // public List<Estudiante> buscarTodos(){
        
    //     return this.estudianteService.buscarTodos();
    // }
    
    @PutMapping(path = "/{id}")
    public void actualizarEstudiante(@RequestBody Estudiante estu, @PathVariable Integer id){
        // Integer id = 1;
        estu.setId(id);
        

        this.estudianteService.actualizarEstudianteService(estu);
    }

    @PatchMapping(path = "/{cedula}")
    public void actualizarParcialEstudiante(@RequestBody Estudiante estu, @PathVariable String cedula ){
        Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);

        if(estu.getNombre()==null){

        }

        estu1.setCedula(estu.getCedula());
        this.estudianteService.actualizarEstudianteService(estu1);
    }

    // @DeleteMapping(path = "/{id}")
    // public void borrarId(@PathVariable Integer id){
    //     // Integer idd = 2;
    //     this.estudianteService.borrar(id);
    // }

    @DeleteMapping(path = "/{cedula}")
    public void borrarCedula(@PathVariable String cedula){
        this.estudianteService.eliminarEstudianteService(cedula);
    }

    // @GetMapping(path = "/{provincia}")
    // public List<Estudiante> buscarTodos(@RequestParam String provincia){
    //     // buscarTodos?provincia = pichincha
    //     return this.estudianteService.buscarTodos(provincia);
    // }
    
    
}
