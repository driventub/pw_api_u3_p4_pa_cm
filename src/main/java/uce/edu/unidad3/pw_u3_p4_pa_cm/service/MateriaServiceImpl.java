package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IMateriaRepo;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private IMateriaRepo materiaRepo;

    @Override
    public Materia consultarMateria(String codigo) {
        return this.materiaRepo.buscarMateria(codigo);
        
    }

    @Override
    public void ingresarMateria(Materia m) {
        this.materiaRepo.insertarMateria(m);
    }
    
    @Override
    public void actualizarMateria(Materia e) {
        this.materiaRepo.actualizarMateria(e);
    }

    @Override
    public void borrar(Integer id) {
        this.materiaRepo.borrar(id);
    }

    @Override
    public List<MateriaTO> buscarTodosService() {
        this.materiaRepo.buscarTodos();
        return null;
    }

    @Override
    public List<MateriaTO> buscarPorCedulaEstuService(String cedula) {
        List<Materia> lista = this.materiaRepo.buscarPorCedulaEstu(cedula);    
        List<MateriaTO> listaTO = lista.stream().map(materia->this.convertir(materia)).collect(Collectors.toList());
        return listaTO;
    }

    private MateriaTO convertir(Materia materia){
        MateriaTO mat=new MateriaTO();
        mat.setCodigo(materia.getCodigo());
        mat.setId(materia.getId());
        mat.setNombre(materia.getNombre());
        mat.setCreditos(materia.getCreditos());
        mat.setCurso(materia.getCurso());
        mat.setProfesor(materia.getProfesor());
    
        return mat;

    }

    @Override
    public MateriaTO buscarMateriaIdService(Integer id) {
        Materia m= this.materiaRepo.buscarMateriaId(id);
        return convertir(m);
    }  

}
