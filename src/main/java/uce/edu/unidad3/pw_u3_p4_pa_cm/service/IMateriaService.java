package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.to.MateriaTO;

public interface IMateriaService {
    public Materia consultarMateria(String codigo);

    public void ingresarMateria(Materia m);
    public void actualizarMateria(Materia e);
    public void borrar(Integer id);
    public List<MateriaTO> buscarTodosService();
    public List<MateriaTO> buscarPorCedulaEstuService(String cedula);
    public MateriaTO buscarMateriaIdService(Integer id);
}
