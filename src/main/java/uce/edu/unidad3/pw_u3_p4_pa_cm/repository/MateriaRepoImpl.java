package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Materia consultarPorCodigo(String codigo) {
       TypedQuery<Materia> myQuery = this.em
				.createQuery("SELECT m FROM Materia m WHERE m.codigo =:codigo", Materia.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
    }

    @Override
    public void insertarMateria(Materia m) {
        this.em.persist(m);   
    }

    @Override
    public void actualizarMateria(Materia m) {
        this.em.persist(m);
    }

    @Override
    public void eliminarMateria(String codigo) {
       Materia mateBorrado=this.consultarPorCodigo(codigo);
        this.em.remove(mateBorrado);    
    }
    
}
