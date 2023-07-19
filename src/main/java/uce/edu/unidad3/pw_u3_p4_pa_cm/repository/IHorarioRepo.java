package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;

public interface IHorarioRepo {
    Horario consultarPorCodigo(String codigo);
    void insertarHorario(Horario e);
    void actualizarHorario(Horario e);
    void eliminarHorario(String codigo);
    List<Horario> buscarTodos();
}
