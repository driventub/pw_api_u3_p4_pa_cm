package uce.edu.unidad3.pw_u3_p4_pa_cm.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity

@Table(name = "estudiante")

public class Estudiante {
    @Id
    @Column(name = "estu_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "estu_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_fecha_naci")
    private LocalDateTime fechaNacimiento;
    @Column(name = "estu_cedula")
    private String cedula;

    @Column(name = "estu_provincia")
    private String provincia;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Materia> materias;
    
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFecha() {
        return fechaNacimiento;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaNacimiento = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

}
