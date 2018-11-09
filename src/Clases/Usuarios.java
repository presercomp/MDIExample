package Clases;
import java.sql.*;

public class Usuarios {

    
    private int _idUsuario;
    private String _usuario;
    private String _clave;

    public int getIdUsuario() {
        return _idUsuario;
    }

    public String getUsuario() {
        return _usuario;
    }

    public String getClave() {
        return _clave;
    }
    private Conexion _cn;
    
    public Usuarios(){
        this._cn = new Conexion();
    }
    
    public void setIdUsuario(int _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public void setUsuario(String _usuario) {
        this._usuario = _usuario;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
    }
    
    public ResultSet consultar(){
        ResultSet res = null;
        String[] campos = {"*"};
        res = this._cn.consulta("usuarios", campos, "");
        return res;        
    }
    
    public int crear(){
        String query = "insert into usuarios (usuario, clave) VALUES ('"+this._usuario+"', '"+this._clave+"')";
        return this._cn.ejecutar(query);       
    }
    
    public int editar(){
        String query = "update usuarios set usuario = '"+this._usuario+"', clave='"+this._clave+"' where idUsuario = "+this._idUsuario+";";        
        return this._cn.ejecutar(query);       
    }
    
}
