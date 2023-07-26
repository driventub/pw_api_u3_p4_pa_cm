package uce.edu.unidad3.pw_u3_p4_pa_cm.service;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IProfesorRepo;

@Service
public class ProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorRepo profeRepo;

    @Override
    public Profesor consultarPorCedula(String cedula) {
        return this.profeRepo.consultarPorCedula(cedula);
    }

    @Override
    public void insertarProfesor(Profesor profe) {
        this.profeRepo.insertarProfesor(profe);
    }


    @Override
    public void eliminarProfesor(String cedula) {
        this.profeRepo.eliminarProfesor(cedula);
    }
    @Override
    public void actualizarProfesor(Profesor profe) {
        this.profeRepo.actualizarProfesor(profe);
    }

    @Override
    public void actualizarParcial(String cedula, BigDecimal periodo) {
        this.profeRepo.actualizarParcial(cedula, periodo);
    }

    

   


   
}
