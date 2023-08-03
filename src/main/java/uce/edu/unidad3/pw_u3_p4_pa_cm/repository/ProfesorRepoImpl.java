package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;

@Repository
@Transactional
public class ProfesorRepoImpl implements IProfesorRepo{

    @PersistenceContext
	private EntityManager em;


    @Override
    public Profesor consultarPorCedula(String cedula) {
        TypedQuery<Profesor> myQuery = this.em
				.createQuery("SELECT a FROM Profesor a WHERE a.cedula =:cedula", Profesor.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
        
    }


    @Override
    public void insertarProfesor(Profesor e) {
        this.em.persist(e);    
    }


    @Override
    public void actualizarProfesor(Profesor e) {
        this.em.merge(e);
    }


    @Override
    public void eliminarProfesor(String cedula) {
        Profesor estudBorrado=this.consultarPorCedula(cedula);
        this.em.remove(estudBorrado);    
    }

    @Override
    public List<Profesor> buscarTodos() {
       TypedQuery<Profesor> myQuery = this.em
				.createQuery("SELECT a FROM Profesor a  ", Profesor.class);

		return myQuery.getResultList();
    }
    
}
