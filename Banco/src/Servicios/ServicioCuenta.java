/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Modelos.Cuenta;
import Repositorios.RepositorioCuenta;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ServicioCuenta {
    
    private RepositorioCuenta repositorioCuenta;
    
    public ServicioCuenta(){
        this.repositorioCuenta = new RepositorioCuenta();
    }
    
    public void guardarDatosCuenta
        (String nombre, 
                String apellido, 
                String cuit1, 
                String cuit2, 
                String cuit3, 
                String saldoInicial){
            
        this.validarNombre(nombre);
        this.validarApellido(apellido);
        String cuit = this.armarCuit(cuit1, cuit2, cuit3);
        double saldoInicialConvertido = parsearSaldoInicial(saldoInicial);
        
        
        
        Cuenta cuenta = new Cuenta(nombre, apellido, cuit, saldoInicialConvertido);
        
        this.repositorioCuenta.guardarCuenta(cuenta);
    }
    
    private void validarNombre(String nombre){
        
        if (nombre.length() == 0){
            throw new IllegalArgumentException ("¡El nombre es vacío!");
        }
    }
    
    private void validarApellido (String apellido){
        
        if (apellido.length() == 0){
            throw new IllegalArgumentException ("¡El apellido es vacío!");
        }
    }
    
    private String armarCuit (String cuit1, String cuit2, String cuit3){
        
        try{
            int cuit1Parseado = Integer.parseInt(cuit1);
            int cuit2Parseado = Integer.parseInt(cuit2);
            int cuit3Parseado = Integer.parseInt(cuit3);
            
            if (cuit1Parseado <= 0 || cuit2Parseado <= 0 || cuit3Parseado <= 0){
                throw new IllegalArgumentException ("¡El CUIT ingresado es inválido!");
            }
            
            String cuit = cuit1 + "-" + cuit2 + "-" + cuit3;
            
            ArrayList<Cuenta> cuentasGuardadas = this.repositorioCuenta.obtenerCuentasGuardadas();
        
        for (Cuenta cuenta : cuentasGuardadas) {
            if (cuit.equals(cuenta.getCuit())){
                throw new IllegalArgumentException ("¡Este CUIT ya fue ingresado!");
            }
        }
            
            return cuit;
        } catch(NumberFormatException exception){
            throw new NumberFormatException ("¡El CUIT ingresado es inválido!");
        }
    }
    
    private double parsearSaldoInicial(String saldoInicial){
        try{
            double saldoIncialParseado = Double.valueOf(saldoInicial);
            
            if (saldoIncialParseado < 0){
                throw new IllegalArgumentException ("¡El saldo ingresado debe ser mayor o igual a cero!");
            }
            
            return saldoIncialParseado;
        } catch(NumberFormatException exception){
            throw new NumberFormatException ("¡El saldo ingresado es inválido!");
        }
    }
    
}
