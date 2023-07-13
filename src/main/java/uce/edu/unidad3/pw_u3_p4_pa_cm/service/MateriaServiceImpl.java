package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IMateriaRepo;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private IMateriaRepo mateRepo;

    @Override
    public Materia consultarPorCodigo(String codigo) {
        return this.mateRepo.consultarPorCodigo(codigo);
    }

    @Override
    public void insertarMateriaService(Materia m) {
        this.mateRepo.insertarMateria(m);   
    }

    @Override
    public void actualizarMateriaService(Materia m) {
        this.mateRepo.actualizarMateria(m);
    }

    @Override
    public void eliminarMateriaService(String codigo) {
        this.mateRepo.eliminarMateria(codigo);
    }

    
    
}
