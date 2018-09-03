/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import java.util.ArrayList;
import Modelos.Movimiento;
/**
 *
 * @author Usuario
 */
public class RepositorioMovimiento {
    
    private static ArrayList<Movimiento> movimientosGuardados;
    
    public RepositorioMovimiento(){
        this.movimientosGuardados = new ArrayList<>();
    }
    
    public void guardarMovimiento(Movimiento movimiento){
        movimientosGuardados.add(movimiento);
    }
    
    public ArrayList<Movimiento> obtenerMovimientosGuardados(){
        return movimientosGuardados;
    }
}
