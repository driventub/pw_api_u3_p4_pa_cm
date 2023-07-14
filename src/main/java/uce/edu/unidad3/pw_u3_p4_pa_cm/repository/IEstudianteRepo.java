package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;

public interface IEstudianteRepo {
    public Estudiante consultarPorCedula(String cedula);
    public void insertarEstudiante(Estudiante e);
    public void actualizarEstudiante(Estudiante e);
    void eliminarEstudiante(String cedula);
    void borrar(Integer id);
    void actualizaParcial(String cedulaActual, String cedulaNueva);
    List<Estudiante> buscarTodos(String provincia);
}
