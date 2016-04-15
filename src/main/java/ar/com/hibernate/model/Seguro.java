/*
 * Seguro.java
 *
 * Created on 17 de noviembre de 2008, 15:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package ar.com.hibernate.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seguro")
public class Seguro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_id")
    private Long id;

    @Column(name = "s_suma")
    private Double SumaAsegurada;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_po")
    private Poliza poliza;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cli")
    private Cliente cliente;

    public Seguro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSumaAsegurada() {
        return SumaAsegurada;
    }

    public void setSumaAsegurada(Double SumaAsegurada) {
        this.SumaAsegurada = SumaAsegurada;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Seguro N� :" + getId() + " suma asegurada :" + getSumaAsegurada() + " poliza n� " + getPoliza().getId() + " texto poliza :" + getPoliza().getTextoPoliza();

    }

}
