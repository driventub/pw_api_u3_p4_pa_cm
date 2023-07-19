package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;

@Repository
@Transactional
public class HorarioRepoImpl implements IHorarioRepo{

    @PersistenceContext
	private EntityManager em;

    @Override
    public Horario consultarPorCodigo(String codigo) {
        TypedQuery<Horario> myQuery = this.em
				.createQuery("SELECT m FROM Horario m WHERE m.codigo =:codigo", Horario.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();    
    }

    @Override
    public void insertarHorario(Horario e) {
        this.em.persist(e);    
    }

    @Override
    public void actualizarHorario(Horario e) {
        this.em.merge(e); 
    }

    @Override
    public void eliminarHorario(String codigo) {
        Horario mateBorrado=this.consultarPorCodigo(codigo);
        this.em.remove(mateBorrado);
    }

    @Override
    public List<Horario> buscarTodos() {
        TypedQuery<Horario> myQuery = this.em
				.createQuery("SELECT h FROM Horario h ", Horario.class);

		return myQuery.getResultList();    
    }
}
