/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import java.util.ArrayList;
import Modelos.Transferencia;

/**
 *
 * @author Usuario
 */
public class RepositorioTransferencia {
    
    private static ArrayList<Transferencia> transferenciasGuardadas;

    public RepositorioTransferencia() {
        this.transferenciasGuardadas = new ArrayList<>();
    }
    
    public void guardarTransferencia (Transferencia transferencia){
        transferenciasGuardadas.add(transferencia);
    }
    
    
    
}
