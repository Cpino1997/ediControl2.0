package cl.pinolabs.edicontrol.model.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="trabajadores")
public class Trabajador {
    /* Propiedades */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(length = 80, nullable = false)
    private String nombre;
    @Column(length = 9, nullable = false)
    private Integer rut;
    @Column(length = 60, nullable = false)
    private String direccion;
    @Email(message = "el correo ingresado no es valido :C")
    @Column(length = 60, nullable = false, unique = true)
    private String correo;

    @Column(length = 9, nullable = false, unique = true)
    private Integer telefono;

    @Column(name = "id_comuna")
    private Integer idComuna;
    @Column(name = "id_afp")
    private Integer idAfp;
    @Column(name = "id_salud")
    private Integer idSalud;
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @Column(name = "id_contrato")
    private Integer idContrato;

    /* Objetos */

    @ManyToOne
    @JoinColumn(name = "id_afp", insertable = false, updatable = false)
    private Afp afp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_contrato", updatable = false,insertable = false)
    private Contrato contrato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_salud", insertable = false, updatable = false)
    private Salud salud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cuenta", insertable = false, updatable = false)
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comuna", insertable = false, updatable = false)
    private Comuna comuna;

    private boolean activo;

    /* Getters y Setters */

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public Integer getIdAfp() {
        return idAfp;
    }

    public void setIdAfp(Integer idAfp) {
        this.idAfp = idAfp;
    }

    public Integer getIdSalud() {
        return idSalud;
    }

    public void setIdSalud(Integer idSalud) {
        this.idSalud = idSalud;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Afp getAfp() {
        return afp;
    }

    public void setAfp(Afp afp) {
        this.afp = afp;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Salud getSalud() {
        return salud;
    }

    public void setSalud(Salud salud) {
        this.salud = salud;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

}
