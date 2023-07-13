package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

public interface IMateriaRepo {
    Materia consultarPorCodigo(String codigo);
    void insertarMateria(Materia m);
    void actualizarMateria(Materia m);
    void eliminarMateria(String codigo);
}
