package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IMateriaRepo;

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
    
}
