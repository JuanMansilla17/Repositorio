/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class Cuenta {
    private String nombre;
    private String apellido;
    private String cuit;
    private double saldo;

    public Cuenta(String nombre, String apellido, String cuit, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuit = cuit;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCuit() {
        return cuit;
    }
    
    
    
        
}
