/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import java.util.ArrayList;
import Modelos.Cuenta;

/**
 *
 * @author Usuario
 */
public class RepositorioCuenta {
    
    private static ArrayList<Cuenta> cuentasGuardadas;
    
    public RepositorioCuenta(){
        
        this.cuentasGuardadas = new ArrayList<>();
        
    }
    
    public void guardarCuenta (Cuenta cuenta){
        this.cuentasGuardadas.add(cuenta);
    }
    
    public ArrayList<Cuenta> obtenerCuentasGuardadas(){
        return this.cuentasGuardadas;
    }
    
}
