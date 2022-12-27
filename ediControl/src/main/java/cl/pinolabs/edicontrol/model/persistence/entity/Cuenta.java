package cl.pinolabs.edicontrol.model.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "id_tipo")
    private Integer idTipo;
    @Column(nullable = false, name = "id_banco")
    private Integer idBanco;
    @ManyToOne
    @JoinColumn(name = "id_tipo", insertable = false, updatable = false)
    private TipoCuenta tipo;
    @ManyToOne
    @JoinColumn(name = "id_banco", insertable = false, updatable = false)
    private Banco banco;
    @Column(nullable = false, length = 25,unique = true)
    private String numero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
