/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores;


import Vistas.VistaPrincipal;
import Servicios.ServicioCuenta;
import Servicios.ServicioTransferencia;
import Servicios.ServicioMovimiento;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class PresentadorVistaPrincipal {
    
    private VistaPrincipal vistaPrincipal;
    private ServicioCuenta servicioCuenta;
    private ServicioTransferencia servicioTransferencia;
    private ServicioMovimiento servicioMovimiento;
    
    private String cuitGuardado;
    
      
    
    
    public PresentadorVistaPrincipal (VistaPrincipal vistaPrincipal){
        this.vistaPrincipal = vistaPrincipal;
        
        this.servicioCuenta = new ServicioCuenta();
        
        this.servicioTransferencia = new ServicioTransferencia();
        
        this.servicioMovimiento = new ServicioMovimiento();
        
        String [] cuitGuardado = new String[1];
    }
    
    public void guardarDatosCuenta(){
        String nombre = this.vistaPrincipal.getNombreTextField().getText();
        String apellido = this.vistaPrincipal.getApellidoTextField().getText();
        String cuit1 = this.vistaPrincipal.getCuit1TextField().getText();
        String cuit2 = this.vistaPrincipal.getCuit2TextField().getText();
        String cuit3 = this.vistaPrincipal.getCuit3TextField().getText();
        String saldoInicial = this.vistaPrincipal.getSaldoInicialTextField().getText();
        
        try{
            this.servicioCuenta.guardarDatosCuenta(nombre, apellido, cuit1, cuit2, cuit3, saldoInicial);
            
            cuitGuardado = cuit1 + "-" + cuit2 + "-" + cuit3;
            
            
            
            JOptionPane.showMessageDialog(null, "¡Los datos de la cuenta fueron guardados exitosamente!");
        }
        catch(IllegalArgumentException exception){
            cuitGuardado = null;
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        
        this.vistaPrincipal.getNombreTextField().setText("");
            this.vistaPrincipal.getApellidoTextField().setText("");
            this.vistaPrincipal.getCuit1TextField().setText("");
            this.vistaPrincipal.getCuit2TextField().setText("");
            this.vistaPrincipal.getCuit3TextField().setText("");
            this.vistaPrincipal.getSaldoInicialTextField().setText("");
        
    }
    
    public void guardarTransferencia(){
        String cuitOrigen = this.vistaPrincipal.getCuitOrigenComboBox().getSelectedItem().toString();
        String cuitDestino = this.vistaPrincipal.getCuitDestinoComboBox().getSelectedItem().toString();
        String monto = this.vistaPrincipal.getMontoTextField().getText();
        
        try{
            
            this.servicioTransferencia.guardarTransferencia(cuitOrigen, cuitDestino, monto);
            
        }catch(IllegalArgumentException exception){
            JOptionPane.showMessageDialog(null, exception);
        }
        
        this.servicioMovimiento.guardarMovimiento(cuitOrigen, cuitDestino, monto);
        
        
        
        this.vistaPrincipal.getMontoTextField().setText("");
        
        JOptionPane.showMessageDialog(null, "¡La transferencia fué guardada exitosamente");
    }
    
    public String getCuitGuardado(){
        
        return cuitGuardado;
    }
    
    public ArrayList<String[]> mostrarMovimientos(){
        String cuitMovimientos = this.vistaPrincipal.getCuitMovimientosComboBox().getSelectedItem().toString();
        
        ArrayList<String[]> movimientosToString = servicioMovimiento.mostrarMovimientos(cuitMovimientos);
        
        return movimientosToString;        
    }
    
    
    
    
}
