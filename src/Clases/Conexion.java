
package Clases;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    private Connection _conn;
    private String _url;
    private String _user;
    private String _pass;
    private int _port;
    private Statement _stmt;
    private String _databaseName;
    
    public Conexion(){
        this._user = "root";
        this._pass = "12345678";
        this._port = 3306;
        this._databaseName = "pruebaCRUD";
        this._url = "jdbc:mysql://localhost:"+this._port+"/"+this._databaseName;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this._conn = DriverManager.getConnection(this._url, this._user, this._pass);
            this._stmt = this._conn.createStatement();
        }catch(ClassNotFoundException|SQLException ex){
            JOptionPane.showMessageDialog(null, "Se ha producido el siguiente error:"+ex.getMessage());
        }        
    }
}
