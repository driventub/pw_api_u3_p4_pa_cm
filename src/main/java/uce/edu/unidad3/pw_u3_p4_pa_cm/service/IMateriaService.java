package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

public interface IMateriaService {
    Materia consultarMateria(String codigo);

    void ingresarMateria(Materia m);
}
