package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Materia;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Materia buscarMateria(String codigo) {
        TypedQuery<Materia> myQuery = this.em
                .createQuery("SELECT m FROM Materia m WHERE m.codigo =:cod", Materia.class);
        myQuery.setParameter("cod", codigo);
        return myQuery.getSingleResult();
    }

    @Override
    public void insertarMateria(Materia m) {
        this.em.persist(m);    
    }

}
