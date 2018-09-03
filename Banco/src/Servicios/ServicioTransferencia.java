/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.ArrayList;

import Modelos.Transferencia;
import Modelos.Cuenta;
import Repositorios.RepositorioTransferencia;
import Repositorios.RepositorioCuenta;

/**
 *
 * @author Usuario
 */
public class ServicioTransferencia {
    
    private RepositorioTransferencia repositorioTransferencia;
    
    private RepositorioCuenta repositorioCuenta;
    
    public ServicioTransferencia(){
        this.repositorioTransferencia = new RepositorioTransferencia();
        this.repositorioCuenta = new RepositorioCuenta();
    }
    
    public void guardarTransferencia(String cuitOrigen, String cuitDestino, String monto){
        validarCuentas(cuitOrigen, cuitDestino);
        double montoConvertido = convertirMonto(cuitOrigen, monto);
        
        Transferencia transferencia = new Transferencia (cuitOrigen, cuitDestino, monto);
        
        this.repositorioTransferencia.guardarTransferencia(transferencia);
        
        actualizarSaldo(cuitOrigen, cuitDestino, montoConvertido);
    }
    
    private void validarCuentas(String cuitOrigen, String cuitDestino){
        
        if (cuitOrigen.equals(cuitDestino)){
            throw new IllegalArgumentException ("!El CUIT de destino es el mismo que el CUIT de origen!");
        }
    }
    
    private double convertirMonto(String cuitOrigen, String monto){
        
        try{
            
            double montoParseado = Double.valueOf(monto);
            
            if (montoParseado < 0){
                throw new IllegalArgumentException ("¡El monto ingresado debe ser mayor o igual a cero!");
            }
            
            ArrayList<Cuenta> cuentasGuardadas = this.repositorioCuenta.obtenerCuentasGuardadas();
            
            for (Cuenta cuenta : cuentasGuardadas){
                if (cuenta.getCuit() == cuitOrigen && cuenta.getSaldo() < montoParseado){
                    throw new IllegalArgumentException ("¡El monto ingresado es mayor al saldo disponible en la cuenta de origen!");
                }
            }
            
            return montoParseado;
        
        }catch(NumberFormatException exception){
            throw new NumberFormatException ("¡El monto ingresado es inválido!");
        }
    }
    
    public void actualizarSaldo(String cuitOrigen, String cuitDestino, double monto){
        
        ArrayList<Cuenta> cuentasGuardadas = this.repositorioCuenta.obtenerCuentasGuardadas();
        
        for (Cuenta cuenta : cuentasGuardadas){
            if (cuenta.getCuit() == cuitOrigen){
                cuenta.setSaldo(cuenta.getSaldo() - monto);
            }
            if (cuenta.getCuit() == cuitDestino){
                cuenta.setSaldo(cuenta.getSaldo() + monto);
            }
        }
    }
}
