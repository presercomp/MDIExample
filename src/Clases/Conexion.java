
package Clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this._url += "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this._conn = DriverManager.getConnection(this._url, this._user, this._pass);
            this._stmt = this._conn.createStatement();
        }catch(ClassNotFoundException|SQLException ex){
            JOptionPane.showMessageDialog(null, "Se ha producido el siguiente error:"+ex.getMessage());
        }        
    }
    
    public ResultSet consulta(String tabla, String[] campos, String filtro){
        
        ResultSet resultado = null;
        String listaCampos = "";
        for(int i = 0; i< campos.length; i++){
            listaCampos += campos[i]+", ";
        }
        listaCampos = listaCampos.substring(0, listaCampos.length()-2);
        String query = "SELECT "+listaCampos+" FROM "+tabla;
        query += filtro.length() > 0 ? " WHERE "+filtro : "";
        try{
            resultado = this._stmt.executeQuery(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Se ha generado un error:\n"+ex.getMessage());
        }
        return resultado;
    }
    
    public int ejecutar(String comandoSQL){
        int lastID = 0;
        try {
            lastID = this._stmt.executeUpdate(comandoSQL, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return lastID;
    }
}
