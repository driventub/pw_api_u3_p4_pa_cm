package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;


public interface IEstudianteService {
    public Estudiante consultarPorCedula(String cedula);
    public void insertarEstudianteService(Estudiante e);
    public void actualizarEstudianteService(Estudiante e);
    public void eliminarEstudianteService(String cedula);
}
