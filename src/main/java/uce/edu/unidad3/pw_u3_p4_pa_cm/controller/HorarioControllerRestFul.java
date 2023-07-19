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

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.IHorarioService;

@RestController
@RequestMapping(path = "/horario")
public class HorarioControllerRestFul {

    @Autowired
    private IHorarioService horarioService;

    @GetMapping(path = "/{codigo}")
    public Horario consultarPorCodigo(@PathVariable String codigo){
        return this.horarioService.consultarPorCodigo(codigo);
    }

    @PostMapping
    public void ingresarHorario(@RequestBody Horario hora){
        this.horarioService.insertarHorarioService(hora);
    }

    @GetMapping
    public List<Horario> buscarTodos(){
        return this.horarioService.buscarTodos();
    }

    @PutMapping(path = "/{id}")
    public void actualizarHorario(@RequestBody Horario hora,@PathVariable Integer id){
        hora.setId(id);
        this.horarioService.actualizarHorarioService(hora);
    }

    @PatchMapping(path = "/{codigo}")
    public void actualizarParcialHorario(@RequestBody Horario hora, @PathVariable String codigo){
        
        Horario hora1 = this.horarioService.consultarPorCodigo(codigo);
        hora1.setCodigo(hora.getCodigo());
        this.horarioService.actualizarHorarioService(hora1);  
    }

    @DeleteMapping(path =  "/{codigo}")
    public void borrarCodigo(@PathVariable String codigo){
        this.horarioService.eliminarHorarioService(codigo);
    }
}
