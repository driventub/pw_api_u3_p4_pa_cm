package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

import java.util.List;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IMateriaService;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.to.MateriaTO;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
    
    @Autowired
    private IMateriaService materiaService;
    
    @GetMapping()
    public List<MateriaTO> consultarMateria(){
        return this.materiaService.buscarTodosService();
    }

    @GetMapping(path = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> consultarConCedula(@PathVariable Integer id){
        
        MateriaTO m = this.materiaService.buscarMateriaIdService(id);
       
        Link myLink = linkTo(methodOn(MateriaController.class).consultarMateria(m.getId())).withRel("materia");
            m.add(myLink);

        return new ResponseEntity<>(m, null, 0);
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

    @GetMapping(path = "/uno/{id}")
    public ResponseEntity<MateriaTO> consultarMateria(@PathVariable Integer id){
        return new ResponseEntity<MateriaTO>(this.materiaService.buscarMateriaIdService(id),null,200);
    }
}
