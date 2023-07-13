package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
