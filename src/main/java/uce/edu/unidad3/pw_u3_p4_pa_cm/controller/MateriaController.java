package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
    
    @Autowired
    private IMateriaService materiaService;

     @GetMapping(path = "/buscar")
    public Materia consultarMateria(){
        String materia = "C001-AI";
        return this.materiaService.consultarMateria(materia);
    }

    @PostMapping(path = "/ingresar")
    public void ingresarMateria(@RequestBody Materia mate){
        this.materiaService.ingresarMateria(mate);
    }

    @PutMapping(path = "/actualizar/{id}")
    public void actualizarMateria(@RequestBody Materia materia, @PathVariable Integer id){
        
        materia.setId(id);
        

        this.materiaService.actualizarMateria(materia);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrarCedula(@PathVariable Integer id){
        // Integer idd = 2;
        this.materiaService.borrar(id);
    }

}
