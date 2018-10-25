package Clases;
import java.sql.*;

public class Usuarios {
    private int _idUsuario;
    private String _usuario;
    private String _clave;
    private Conexion _cn;
    
    public Usuarios(){
        this._cn = new Conexion();
    }
    
    public ResultSet consultar(){
        ResultSet res = null;
        String[] campos = {"*"};
        res = this._cn.consulta("usuarios", campos, "");
        return res;        
    }
    
}
