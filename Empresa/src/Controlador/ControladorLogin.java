/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author sistemas
 */
public class ControladorLogin {

    private String usuario;
    private String contrasenia;

    public ControladorLogin(String usuario, String contrasenia) {
        
        if(this.VerificarUsuarios(usuario, contrasenia)){
            this.usuario = usuario;
            this.contrasenia = contrasenia; 
        }
        
    }
    
    public boolean VerificarUsuarios(String usuario, String contrasenia){
        boolean estado=false;
        
        if((usuario.equals("daniel"))&&(contrasenia.equals("12345")))
            estado=true;
        
        return estado;
    }
    
    
    
    
}
