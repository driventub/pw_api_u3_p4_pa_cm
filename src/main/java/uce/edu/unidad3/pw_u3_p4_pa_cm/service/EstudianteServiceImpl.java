package uce.edu.unidad3.pw_u3_p4_pa_cm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;
import uce.edu.unidad3.pw_u3_p4_pa_cm.repository.IEstudianteRepo;
import uce.edu.unidad3.pw_u3_p4_pa_cm.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    @Autowired
    private IEstudianteRepo estuRepo;

    @Override
    public Estudiante consultarPorCedula(String cedula) {
        return this.estuRepo.consultarPorCedula(cedula);
    }

    @Override
    public void insertarEstudianteService(Estudiante e) {
        this.estuRepo.insertarEstudiante(e);
    }

    @Override
    public void actualizarEstudianteService(Estudiante e) {
        this.estuRepo.actualizarEstudiante(e);
    }

    @Override
    public void eliminarEstudianteService(String cedula) {
        this.estuRepo.eliminarEstudiante(cedula);
    }

    @Override
    public void borrar(Integer id) {
        this.estuRepo.borrar(id);
    }

    @Override
    public void actualizarCedula(String cedulaActual, String cedulaNueva) {
       this.estuRepo.actualizaParcial(cedulaActual, cedulaNueva);
    }

    @Override
    public List<Estudiante> buscarTodos(String provincia) {
       return this.estuRepo.buscarTodos(provincia);
    }
    
    @Override
    public List<Estudiante> buscarTodos() {
       return this.estuRepo.buscarTodos();
    }

    @Override
    public List<EstudianteTO> buscarTodosH() {
        List<Estudiante> lista = this.estuRepo.buscarTodos();
        List<EstudianteTO> listaTO =  lista.stream().map(estudiante -> this.convertir(estudiante)).collect(Collectors.toList());
        // for (Estudiante estudiante : lista) {
        //     estu.
        // }
        return listaTO;
    }
    
    private EstudianteTO convertir(Estudiante estu){
         EstudianteTO estuTo = new EstudianteTO();
         estuTo.setId(estu.getId());
         estuTo.setNombre(estu.getNombre());
         estuTo.setApellido(estu.getApellido());
         estuTo.setCedula(estu.getCedula());
         estuTo.setProvincia(estu.getProvincia());
         estuTo.setFechaNacimiento(estu.getFechaNacimiento());

         return estuTo;
    }

}
