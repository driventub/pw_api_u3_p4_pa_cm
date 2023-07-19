package uce.edu.unidad3.pw_u3_p4_pa_cm.controller;

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
@RequestMapping(path = "/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horaService;

    
    @GetMapping(path = "/{codigo}")
    public Horario consultarPorCodigo(@PathVariable String codigo) {
        // String codigo = "12345690870";
        return this.horaService.consultarPorCodigo(codigo);
    }

    @PostMapping
    public void ingresarHorario(@RequestBody Horario hora) {
        this.horaService.insertarHorario(hora);
    }

    @PatchMapping(path = "/{codigo}")
    public void actualizarParcialHorario(@RequestBody Horario hora, @PathVariable String codigo) {
        // Integer id = 1;

        Horario hora1 = this.horaService.consultarPorCodigo(codigo);
        hora1.setPeriodo(hora.getPeriodo());

        this.horaService.actualizarHorario(hora1);
    }

    @PutMapping(path = "/{id}")
    public void actualizarHorario(@RequestBody Horario hora, @PathVariable Integer id) {

        hora.setId(id);

        this.horaService.actualizarHorario(hora);
    }

    @DeleteMapping(path = "/{codigo}")
    public void borrarPorCodigo(@PathVariable String codigo) {
        this.horaService.eliminarHorario(codigo);
    }

}
