package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo estuRepo;

    @Override
    public Estudiante consultarPorCedula(String cedula) {
        // TODO Auto-generated method stub
        return this.estuRepo.consultarPorCedula(cedula);
    }
    
}
