package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;


public interface IMateriaService {
    public Materia consultarPorCodigo(String codigo);
    public void insertarMateriaService(Materia m);
    public void actualizarMateriaService(Materia m);
    public void eliminarMateriaService(String codigo);
}
