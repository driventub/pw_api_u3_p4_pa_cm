package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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

        @Override
    public void actualizarMateria(Materia e) {
        this.em.merge(e);
    }

    @Override
    public void borrar(Integer id) {

        this.em.remove(this.buscarPorId(id));
    }

    
    public Materia buscarPorId(Integer id){
        return this.em.find(Materia.class, id);
    }

    @Override
    public List<Materia> buscarTodos() {
        TypedQuery<Materia> myQuery = this.em
                .createQuery("SELECT m FROM Materia m", Materia.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Materia> buscarPorCedulaEstu(String cedula) {
        TypedQuery<Materia> myQuery = this.em
                .createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =:cedula", Materia.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getResultList();
    }

    @Override
    public Materia buscarMateriaId(Integer id) {
        return this.em.find(Materia.class, id );
    }


}
