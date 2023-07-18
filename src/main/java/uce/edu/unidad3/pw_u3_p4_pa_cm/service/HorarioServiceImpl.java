package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IHorarioRepo;

@Service
public class HorarioServiceImpl implements IHorarioService {

    @Autowired
    private IHorarioRepo horaRepo;

    @Override
    public Horario consultarPorCodigo(String cedula) {
        return this.horaRepo.consultarPorCodigo(cedula);
    }

    @Override
    public void insertarHorario(Horario hora) {
        this.horaRepo.insertarHorario(hora);
    }

    @Override
    public void eliminarHorario(String cedula) {
        this.horaRepo.eliminarHorario(cedula);
    }

    @Override
    public void actualizarHorario(Horario hora) {
        this.horaRepo.actualizarHorario(hora);
    }

    @Override
    public void actualizarParcial(String codigo, String periodo) {

        this.horaRepo.actualizarParcial(codigo, periodo);
    }

}
