package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.math.BigDecimal;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;

public interface IProfesorRepo {
    public Profesor consultarPorCedula(String cedula);
    public void insertarProfesor(Profesor profe);
    void eliminarProfesor(String cedula);
    public void actualizarProfesor(Profesor profe);
    void actualizarParcial(String cedula, BigDecimal periodo) ;
}
