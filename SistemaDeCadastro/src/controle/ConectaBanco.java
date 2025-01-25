
package controle;

import java.sql.*;
import javax.swing.JOptionPane;


public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    private String driver = "oracle.jdbc.OracleDriver";
    private String caminho = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private String usuario = "system";
    private String senha = "alexandre";
    public Connection conn;

    public void conexao() {

        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Erro: " +ex.getMessage());
        }
    }
        public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql);
        } catch (SQLException ex) {
            
        }
      
         
        }
    

    public void desconecta(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Erro:"+ex.getMessage());
        }
             
    }
}


