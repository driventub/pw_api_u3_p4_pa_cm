package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;

public interface IHorarioRepo {
    public Horario consultarPorCodigo(String cedula);

    public void insertarHorario(Horario hora);

    public void eliminarHorario(String cedula);

    public void actualizarHorario(Horario hora);

    public void actualizarParcial(String codigo, String periodo);

}