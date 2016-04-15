/*
 * Poliza.java
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "poliza")
public class Poliza implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "po_id")
    private Long id;

    @Column(name = "po_texto")
    private String textoPoliza;

    @OneToOne(mappedBy = "poliza")
    private Seguro seguro;

    public Poliza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoPoliza() {
        return textoPoliza;
    }

    public void setTextoPoliza(String textoPoliza) {
        this.textoPoliza = textoPoliza;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

}
