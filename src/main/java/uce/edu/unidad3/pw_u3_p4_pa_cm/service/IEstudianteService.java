package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.to.EstudianteTO;


public interface IEstudianteService {
    public Estudiante consultarPorCedula(String cedula);
    public void insertarEstudianteService(Estudiante e);
    public void actualizarEstudianteService(Estudiante e);
    public void eliminarEstudianteService(String cedula);
    public void borrar(Integer id);
    public void actualizarCedula(String cedulaActual, String cedulaNueva);
    List<Estudiante> buscarTodos(String provincia);
    List<Estudiante> buscarTodos();
    public List<EstudianteTO> buscarTodosH();
}
