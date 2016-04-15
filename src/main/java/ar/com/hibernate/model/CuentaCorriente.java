/*
 * CuentaCorriente.java
 *
 * Created on 17 de noviembre de 2008, 14:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ar.com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_corriente")
public class CuentaCorriente extends Cuenta{
    
    @Column(name = "descubierto")
    private Double descubierto;
    
    public CuentaCorriente() {
    }
  
    public Double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(Double descubierto) {
        this.descubierto = descubierto;
    }
    
     @Override
    public String toString(){
        return "Tipo Cuenta : Cuenta Corriente "+" saldo : "+getSaldo()+" descubierto :" + getDescubierto();
    }
    
}
