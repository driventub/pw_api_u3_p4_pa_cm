package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.math.BigDecimal;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;

public interface IProfesorService {
    public Profesor consultarPorCedula(String cedula);
    public void insertarProfesor(Profesor profe);
    public void eliminarProfesor(String cedula);
    public void actualizarProfesor(Profesor profe);
    public void actualizarParcial(String cedula, BigDecimal periodo) ;
}
