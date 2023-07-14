package uce.edu.unidad3.pw_u3_p4_pa_cm.repository;



import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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


    @Override
    public void insertarEstudiante(Estudiante e) {
        this.em.persist(e);    
    }


    @Override
    public void actualizarEstudiante(Estudiante e) {
        this.em.merge(e);
    }


    @Override
    public void eliminarEstudiante(String cedula) {
        Estudiante estudBorrado=this.consultarPorCedula(cedula);
        this.em.remove(estudBorrado);    
    }


    @Override
    public void actualizaParcial(String cedulaActual, String cedulaNueva) {
       Query myQuery = this.em.createQuery("UPDATE Estudiante e SET e.cedula= : datoCedula WHERE e.cedula: datoCondicion");
       myQuery.setParameter("datoCedula", cedulaNueva);
       myQuery.setParameter("datoCondicion", cedulaActual);
       myQuery.executeUpdate();
    }



    @Override
    public void borrar(Integer id) {

        this.em.remove(this.buscarPorId(id));
    }
    
    public Estudiante buscarPorId(Integer id){
        return this.em.find(Estudiante.class, id);
    }


    @Override
    public List<Estudiante> buscarTodos(String provincia) {
       TypedQuery<Estudiante> myQuery = this.em
				.createQuery("SELECT a FROM Estudiante a WHERE a.provincia = : provinicia ", Estudiante.class).setParameter("provincia", provincia);

		return myQuery.getResultList();
    }
}
