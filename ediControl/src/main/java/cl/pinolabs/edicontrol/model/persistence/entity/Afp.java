package cl.pinolabs.edicontrol.model.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "afp")
public class Afp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false)
    private Float descuento;

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

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Afp{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
