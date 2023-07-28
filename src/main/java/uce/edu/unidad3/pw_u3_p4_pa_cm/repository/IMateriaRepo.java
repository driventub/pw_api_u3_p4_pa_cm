package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

public interface IMateriaRepo {
    public Materia buscarMateria(String codigo);
    void insertarMateria(Materia m);
    public void actualizarMateria(Materia m);
    public void borrar(Integer id);
    public List<Materia> buscarTodos();
    public List<Materia> buscarPorCedulaEstu(String cedula);
    public Materia buscarMateriaId(Integer id);
}
