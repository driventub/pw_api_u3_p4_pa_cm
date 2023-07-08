package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Estudiante;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo{

    @PersistenceContext
	private EntityManager em;


    @Override
    public Estudiante consultarPorCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.em
				.createQuery("SELECT a FROM Estudiante a WHERE a.cedula =:cedula", Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
        
    }
    
}
