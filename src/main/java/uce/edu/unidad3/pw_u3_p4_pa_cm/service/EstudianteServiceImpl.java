package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo estuRepo;

    @Override
    public Estudiante consultarPorCedula(String cedula) {
        return this.estuRepo.consultarPorCedula(cedula);
    }

    @Override
    public void insertarEstudianteService(Estudiante e) {
        this.estuRepo.insertarEstudiante(e);
    }

    @Override
    public void actualizarEstudianteService(Estudiante e) {
        this.estuRepo.actualizarEstudiante(e);
    }

    @Override
    public void eliminarEstudianteService(String cedula) {
        this.estuRepo.eliminarEstudiante(cedula);
    }

    @Override
    public void borrar(Integer id) {
        this.estuRepo.borrar(id);
    }

    @Override
    public void actualizarCedula(String cedulaActual, String cedulaNueva) {
       this.estuRepo.actualizaParcial(cedulaActual, cedulaNueva);
    }

    @Override
    public List<Estudiante> buscarTodos(String provincia) {
       return this.estuRepo.buscarTodos(provincia);
    }
    

}
