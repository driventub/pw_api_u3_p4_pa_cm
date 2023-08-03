package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;


public interface IProfesorService {
    public Profesor consultarPorCedula(String cedula);
    public void insertarProfesorService(Profesor p);
    public void actualizarProfesorService(Profesor p);
    public void eliminarProfesorService(String cedula);
    List<Profesor> buscarTodos();
}
