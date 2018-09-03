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
public class Movimiento {
    private String cuitCuenta;
    private String cuitConcepto;
    private double debito;
    private double credito;
    private double saldo;
    private String movimientoToString[] = new String[4];

    public Movimiento(String cuitCuenta,String cuitConcepto, double debito, double credito, double saldo) {
        this.cuitCuenta = cuitCuenta;
        this.cuitConcepto = cuitConcepto;
        this.debito = debito;
        this.credito = credito;
        this.saldo = saldo;
        movimientoToString[0] = cuitConcepto;
        movimientoToString[1] = String.valueOf(debito);
        movimientoToString[2] = String.valueOf(credito);
        movimientoToString[3] = String.valueOf(saldo);
    }

    public String getCuitCuenta() {
        return cuitCuenta;
    }

    public String getCuitConcepto() {
        return cuitConcepto;
    }

    public double getDebito() {
        return debito;
    }

    public double getCredito() {
        return credito;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public String[] getMovimientoToString() {
        return movimientoToString;
    }
    
    
}
