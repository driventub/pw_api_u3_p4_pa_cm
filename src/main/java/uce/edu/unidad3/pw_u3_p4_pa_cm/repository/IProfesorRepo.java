package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;

public interface IProfesorRepo {
    Profesor consultarPorCedula(String cedula);
    void insertarProfesor(Profesor p);
    void actualizarProfesor(Profesor p);
    void eliminarProfesor(String cedula);
    List<Profesor> buscarTodos();
}
