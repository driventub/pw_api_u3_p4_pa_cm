package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.unidad3.pw_u3_p4_pa_cm.model.Horario;

@Repository
@Transactional
public class HorarioRepoImpl implements IHorarioRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Horario consultarPorCodigo(String cedula) {
        TypedQuery<Horario> myQuery = this.em
                .createQuery("SELECT a FROM Horario a WHERE a.cedula =:cedula", Horario.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();

    }

    @Override
    public void insertarHorario(Horario hora) {
        this.em.persist(hora);
    }

    @Override
    public void eliminarHorario(String cedula) {
        Horario estudBorrado = this.consultarPorCodigo(cedula);
        this.em.remove(estudBorrado);
    }

    @Override
    public void actualizarHorario(Horario hora) {
        this.em.merge(hora);
    }

    @Override
    public void actualizarParcial(String codigo, String periodo) {
        Query myQuery = this.em
                .createQuery("UPDATE Horario e SET e.periodo= : datoCodigo WHERE e.codigo: datoCondicion");
        myQuery.setParameter("datoCodigo", periodo);
        myQuery.setParameter("datoCondicion", codigo);
        myQuery.executeUpdate();

    }

}
