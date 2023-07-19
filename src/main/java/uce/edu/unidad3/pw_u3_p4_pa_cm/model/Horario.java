package uce.edu.unidad3.pw_u3_p4_pa_cm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity

@Table(name = "horario")

public class Horario {
    @Id
    @Column(name = "hora_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "hora_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "hora_codigo")
    private String codigo;

    @Column(name = "hora_inicio")
    private String inicio;

    @Column(name = "hora_fin")
    private String fin;

    @Column(name = "hora_dia_semana")
    private String diaSemana;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

}
