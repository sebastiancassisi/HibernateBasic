/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.hibernate.app;

import ar.com.hibernate.conf.SessionManager;
import ar.com.hibernate.dao.ClienteDao;
import ar.com.hibernate.model.CajaAhorro;
import ar.com.hibernate.model.Cliente;
import ar.com.hibernate.model.CuentaCorriente;
import ar.com.hibernate.model.Poliza;
import ar.com.hibernate.model.Seguro;

/**
 *
 * @author alumno
 */
public class Application {

    public static void main(String[] args) {

        //creo Cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("juan perez");
        cliente.setDirrecion("calle falsa 1234");
        //creo Caja de Ahorro
        CajaAhorro ch = new CajaAhorro();
        ch.setIntereses(0.5f);
        ch.setSaldo(10000d);
        //creo Cuenta Corriente
        CuentaCorriente cc = new CuentaCorriente();
        cc.setDescubierto(10000d);
        cc.setSaldo(9000000d);
        //agrego Cuenta Corriente y  Caja de Ahorro al cliente
        cliente.getCuentas().add(cc);
        cliente.getCuentas().add(ch);
        //Creo un seguro
        Seguro seguro = new Seguro();
        seguro.setSumaAsegurada(10000d);
        // creo una poliza
        Poliza poliza = new Poliza();
        poliza.setTextoPoliza("poliza por seguro $ 10000");
        //Agrego  poliza a seguro
        seguro.setPoliza(poliza);
        //Agrego cliente a seguro
        cliente.getSeguros().add(seguro);
        
        ClienteDao cdao = new ClienteDao();
        cdao.grabar(cliente);
        SessionManager.cerrar();
        
    }
}
