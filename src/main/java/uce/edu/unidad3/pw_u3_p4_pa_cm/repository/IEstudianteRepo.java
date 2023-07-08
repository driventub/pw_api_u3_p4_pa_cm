package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;

public interface IEstudianteRepo {
    Estudiante consultarPorCedula(String cedula);
}
