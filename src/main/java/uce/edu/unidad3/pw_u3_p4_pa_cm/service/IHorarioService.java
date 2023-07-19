package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;


public interface IHorarioService {
    public Horario consultarPorCodigo(String codigo);
    public void insertarHorarioService(Horario e);
    public void actualizarHorarioService(Horario e);
    public void eliminarHorarioService(String codigo);
    List<Horario> buscarTodos();
}
