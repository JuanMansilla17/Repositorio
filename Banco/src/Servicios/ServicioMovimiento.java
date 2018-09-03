/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.ArrayList;

import Modelos.Movimiento;
import Modelos.Cuenta;
import Repositorios.RepositorioMovimiento;
import Repositorios.RepositorioCuenta;


/**
 *
 * @author Usuario
 */
public class ServicioMovimiento {
    
    private RepositorioMovimiento repositorioMovimiento;
    
    private RepositorioCuenta repositorioCuenta;
    
    public ServicioMovimiento(){
        
        this.repositorioMovimiento = new RepositorioMovimiento();
        
        this.repositorioCuenta = new RepositorioCuenta();
    }
    
    public void guardarMovimiento(String cuitOrigen, String cuitDestino, String monto){
        
        String cuitCuenta = cuitOrigen;
        String cuitConcepto = cuitDestino;
        double debito=0;
        double credito = Double.valueOf(monto);
        double saldo=0;
        
        ArrayList<Cuenta> cuentasGuardadas = this.repositorioCuenta.obtenerCuentasGuardadas();
        for (Cuenta cuenta : cuentasGuardadas){
            if (cuenta.getCuit() == cuitCuenta){
                saldo = cuenta.getSaldo() - credito;
            }
        }
        
        Movimiento movimientoOrigen = new Movimiento (cuitCuenta, cuitConcepto, debito, credito, saldo);
        
        this.repositorioMovimiento.guardarMovimiento(movimientoOrigen);
        
        cuitCuenta = cuitDestino;
        cuitConcepto = cuitOrigen;
        debito = Double.valueOf(monto);
        credito = 0;
        
        for (Cuenta cuenta : cuentasGuardadas){
            if (cuenta.getCuit() == cuitCuenta){
                saldo = cuenta.getSaldo() + credito;
            }
        }
        
        Movimiento movimientoDestino = new Movimiento (cuitCuenta, cuitConcepto, debito, credito, saldo);
        
        this.repositorioMovimiento.guardarMovimiento(movimientoDestino);
    }
    
    public ArrayList<String[]> mostrarMovimientos (String cuitMovimiento){
        
        ArrayList<String[]> movimientosToString = new ArrayList<>();
        
        ArrayList<Movimiento> movimientosGuardados = this.repositorioMovimiento.obtenerMovimientosGuardados();
        
        for (Movimiento movimiento : movimientosGuardados){
            if (movimiento.getCuitCuenta() == cuitMovimiento){
                movimientosToString.add(movimiento.getMovimientoToString());
            }
        }      
        
        return movimientosToString;
    } 
}
