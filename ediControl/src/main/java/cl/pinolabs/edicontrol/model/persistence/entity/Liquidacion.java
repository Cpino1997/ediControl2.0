package cl.pinolabs.edicontrol.model.persistence.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "liquidaciones")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer liquido;
    private Integer tributable;
    private Integer bruto;
    private Integer descuentos;
    private Integer movilizacion;
    private Integer colacion;

    private Integer viatico;
    private Integer imponible;
    private String fecha;

    @Column(name = "asistencias")
    private Integer asistencias;
    @Column(name = "ausencias")
    private Integer ausencias;
    @Column(name = "id_trabajador")
    private Integer idTrabajador;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trabajador",insertable = false,updatable = false)
    private Trabajador trabajador;

    private boolean pagada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLiquido() {
        return liquido;
    }

    public void setLiquido(Integer liquido) {
        this.liquido = liquido;
    }

    public Integer getTributable() {
        return tributable;
    }

    public void setTributable(Integer tributable) {
        this.tributable = tributable;
    }

    public Integer getBruto() {
        return bruto;
    }

    public void setBruto(Integer bruto) {
        this.bruto = bruto;
    }

    public Integer getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Integer descuentos) {
        this.descuentos = descuentos;
    }

    public Integer getMovilizacion() {
        return movilizacion;
    }

    public void setMovilizacion(Integer movilizacion) {
        this.movilizacion = movilizacion;
    }

    public Integer getColacion() {
        return colacion;
    }

    public void setColacion(Integer colacion) {
        this.colacion = colacion;
    }

    public Integer getViatico() {
        return viatico;
    }

    public void setViatico(Integer viatico) {
        this.viatico = viatico;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getAusencias() {
        return ausencias;
    }

    public void setAusencias(Integer ausencias) {
        this.ausencias = ausencias;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Integer getImponible() {
        return imponible;
    }

    public void setImponible(Integer imponible) {
        this.imponible = imponible;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}