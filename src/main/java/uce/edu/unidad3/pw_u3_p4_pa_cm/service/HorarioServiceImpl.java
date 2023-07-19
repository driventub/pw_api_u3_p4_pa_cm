package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IHorarioRepo;

@Service
public class HorarioServiceImpl implements IHorarioService{

    @Autowired
    private IHorarioRepo horaRepo;

    @Override
    public Horario consultarPorCodigo(String codigo) {
        return this.horaRepo.consultarPorCodigo(codigo);
    }

    @Override
    public void insertarHorarioService(Horario e) {
        this.horaRepo.insertarHorario(e);    
    }

    @Override
    public void actualizarHorarioService(Horario e) {
        this.horaRepo.actualizarHorario(e);    
    }

    @Override
    public void eliminarHorarioService(String codigo) {
        this.horaRepo.eliminarHorario(codigo);    
    }

    @Override
    public List<Horario> buscarTodos() {
        return this.horaRepo.buscarTodos(); 
    }

    

}
