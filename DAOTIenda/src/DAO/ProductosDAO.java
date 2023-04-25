/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author sistemas
 */

//importo las librerias del DAO
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.DefaultListModel;

public interface ProductosDAO extends Remote{
    
    public void AgregarProducto(                
                String nombre,
                String cantidad,
                String codigo,
                double precio
    ) throws RemoteException;
    
    public void EditarProducto(
                String nombre,
                String cantidad,
                String codigo,
                double precio
    ) throws RemoteException;
    
    public void EliminarProducto(
                String codigo
    ) throws RemoteException;
}
