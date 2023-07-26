package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Profesor;

@Repository
@Transactional
public class ProfesorRepoImpl implements IProfesorRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Profesor consultarPorCedula(String cedula) {
        TypedQuery<Profesor> myQuery = this.em
                .createQuery("SELECT p FROM Profesor p WHERE p.cedula =:cedula", Profesor.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();

    }

    @Override
    public void insertarProfesor(Profesor profe) {
        this.em.persist(profe);
    }

    @Override
    public void eliminarProfesor(String cedula) {
        Profesor estudBorrado = this.consultarPorCedula(cedula);
        this.em.remove(estudBorrado);
    }

    @Override
    public void actualizarProfesor(Profesor profe) {
        this.em.merge(profe);
    }

    @Override
    public void actualizarParcial(String cedula, BigDecimal salario) {
        Query myQuery = this.em
                .createQuery("UPDATE Profesor p SET p.salario = :datoSalario WHERE p.cedula =:datoCondicion");
        myQuery.setParameter("datoSalario", salario);
        myQuery.setParameter("datoCondicion", cedula);
        myQuery.executeUpdate();

    }

}
