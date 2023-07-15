package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

public interface IMateriaService {
    public Materia consultarMateria(String codigo);

    public void ingresarMateria(Materia m);
    public void actualizarMateria(Materia e);
    public void borrar(Integer id);
}
