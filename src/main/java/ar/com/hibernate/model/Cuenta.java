/*
 * Cuenta.java
 *
 * Created on 17 de noviembre de 2008, 14:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package ar.com.hibernate.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;

@Entity
@Table(name = "cuenta")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cu_id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cuentas_clientes",
            joinColumns = @JoinColumn(name = "fk_cu"),
            inverseJoinColumns = @JoinColumn(name = "fk_cli"))
    private List<Cliente> clientes;

    @Column(name = "cu_saldo")
    private Double saldo;

    public Cuenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
