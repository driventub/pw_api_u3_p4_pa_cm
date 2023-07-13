package uce.edu.unidad3.pw_u3_p4_pa_cm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity

@Table(name = "materia")

public class Materia {
    @Id
    @Column(name = "mate_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "mate_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_codigo")
    private String codigo;
    
    @Column(name = "mate_descripcion")
    private String descripcion;

    @Column(name = "mate_creditos")
    private String creditos;

    //set
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    //get
    public Integer getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getCreditos() {
        return creditos;
    }
    public String getDescripcion() {
        return descripcion;
    }
}
