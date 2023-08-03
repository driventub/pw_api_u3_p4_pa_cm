package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IEstudianteRepo;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IProfesorRepo;

@Service
public class ProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorRepo profRepo;

    @Override
    public Profesor consultarPorCedula(String cedula) {
        return this.profRepo.consultarPorCedula(cedula);
    }

    @Override
    public void insertarProfesorService(Profesor e) {
        this.profRepo.insertarProfesor(e);
    }

    @Override
    public void actualizarProfesorService(Profesor e) {
        this.profRepo.actualizarProfesor(e);
    }

    @Override
    public void eliminarProfesorService(String cedula) {
        this.profRepo.eliminarProfesor(cedula);
    }
    @Override
    public List<Profesor> buscarTodos() {
       return this.profRepo.buscarTodos();
    }

}
