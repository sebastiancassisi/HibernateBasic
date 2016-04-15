/*
 * CajaAhorro.java
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
@Table(name = "caja_ahorro")
public class CajaAhorro extends Cuenta{
    
    @Column(name = "intereses")
    private Float intereses;
    
    public CajaAhorro() {
    }
    
   
    public Float getIntereses() {
        return intereses;
    }

    public void setIntereses(Float intereses) {
        this.intereses = intereses;
    }
    
    @Override
    public String toString(){
        return "Tipo Cuenta : Caja de Ahorro "+" saldo : "+getSaldo()+" intereses :" + getIntereses();
    }
    
}
