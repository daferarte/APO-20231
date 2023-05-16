/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

//importar el DAO desde el jar
import DAO.UsuariosDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 * clase usuarios controller implementa el dao para funcionar
 * @author sistemas
 */
public class UsuariosController extends UnicastRemoteObject implements UsuariosDAO{
    
    //variable estatica del singleton
    private static UsuariosController usuarioController;
    
    // simulacion de base de datos en matriz
    private String[][] datos;
    
    //Control de registros de la matriz
    private int control=1;
    
    /**
     * @method UsuariosController
     * metodo contructor privado para manejar el singleton
     */
    private UsuariosController() throws RemoteException{
        //ejecuto clase padre UnicastRemoteObject
        super();
        
        //matriz de 6 columnas y 50 filas
        datos=new String[50][6];
        
        //defino usuario por defecto
        datos[0][0]="daniel";
        datos[0][1]="12345";
        datos[0][2]="daniel@daniel.com";
        datos[0][3]="daniel";
        datos[0][4]="arteaga";
        datos[0][5]="3016889827";
    }
    
    /**
     * @method getUsuariosController
     * @return usuarioController
     * metodo para retornar la instancia de ususario del patron singleton
     */
    
    public static UsuariosController getUsuariosController(){
        if(usuarioController==null){
            try {
                usuarioController=new UsuariosController();
            } catch (RemoteException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return usuarioController;
    }

    @Override
    public boolean login(String usuario, String contrasenia) throws RemoteException {
        boolean estado = false;
        
        for(int i=0;i<this.control;i++){
            if((this.datos[i][0].equals(usuario)) && (this.datos[i][1].equals(contrasenia))){
                estado=true;
                break;
            }
        }
        
        return estado;
    }

    @Override
    public void AgregarUsuario(String usuario, String contrasenia, String mail, String nombre, String apellido, String celular) throws RemoteException {
        datos[this.control][0]=usuario;
        datos[this.control][1]=contrasenia;
        datos[this.control][2]=mail;
        datos[this.control][3]=nombre;
        datos[this.control][4]=apellido;
        datos[this.control][5]=celular;
        
        control++;
    }

    @Override
    public void EditarUsuario(String usuario, String contrasenia, String mail, String nombre, String apellido, String celular) throws RemoteException {
        
        for(int i=0;i<this.control;i++){
            if(this.datos[i][0].equals(usuario)){
                datos[i][0]=usuario;
                datos[i][1]=contrasenia;
                datos[i][2]=mail;
                datos[i][3]=nombre;
                datos[i][4]=apellido;
                datos[i][5]=celular;
                
                break;
            }
        }
        
        
    }

    @Override
    public void EliminarUsuario(String usuario) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultListModel MostrarUsuario(String usuario) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String MostrarContrasenia(String usuario) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String RecuperarContrasenia(String usuario) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel MostrarUsuarios() throws RemoteException {
        DefaultTableModel modelo=new DefaultTableModel();
        
        //titulos de columnas
        modelo.addColumn("Id");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Correo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        
        // Recorrido de datos
        for(int i=0;i<this.control;i++){
            //creo un objeto para insertarlo en la tabla
            Object[] fila = new Object[7];
            
            // agregando datos al objeto
            fila[0]=(i+1);
            fila[1]=this.datos[i][0];
            fila[2]=this.datos[i][1];
            fila[3]=this.datos[i][2];
            fila[4]=this.datos[i][3];
            fila[5]=this.datos[i][4];
            fila[6]=this.datos[i][5];
            
            //Inserto el objeto en la fila
            modelo.addRow(fila);
        }
        
        // Retorno el objeto
        return modelo;
    }
    
}
