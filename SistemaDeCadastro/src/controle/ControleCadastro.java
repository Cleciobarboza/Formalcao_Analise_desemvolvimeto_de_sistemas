package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloCadastro;

public class ControleCadastro {

    ModeloCadastro mod = new ModeloCadastro();
    ConectaBanco connCadastro = new ConectaBanco();
    ConectaBanco conexao = new ConectaBanco();

    public void InserirCadastro(ModeloCadastro mod) {
        connCadastro.conexao();
        try {
            PreparedStatement pst = connCadastro.conn.prepareStatement("insert into cadcliente(codcliente,nome,cpf,endereco,numeroend,bairro,telefone,email,celular,cidade,cep,rg,estado)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getCod());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getEndereco());
            pst.setInt(5, mod.getNumero());
            pst.setString(6, mod.getBairro());
            pst.setString(7, mod.getTelefone());
            pst.setString(8, mod.getEmail());
            pst.setString(9, mod.getCelular());
            pst.setString(10, mod.getCidade());
            pst.setString(11, mod.getCep());
            pst.setString(12, mod.getRg());
            pst.setString(13, mod.getEstado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados armazenados com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados. \nERRO:" + ex);

        }

    }

    public ModeloCadastro buscaCadastro(ModeloCadastro modelo) {
        conexao.conexao();
        conexao.executaSQL("select * from cadcliente where nome like '%" + modelo.getPesquisa() + "%'");
        try {
            conexao.rs.first();
            mod.setCod(conexao.rs.getInt("codcliente"));
            mod.setNome(conexao.rs.getString("nome"));
            mod.setRg(conexao.rs.getString("rg"));
            mod.setCpf(conexao.rs.getString("cpf"));
            mod.setEndereco(conexao.rs.getString("endereco"));
            mod.setNumero(conexao.rs.getInt("numeroend"));
            mod.setBairro(conexao.rs.getString("bairro"));
            mod.setCep(conexao.rs.getString("cep"));
            mod.setCidade(conexao.rs.getString("cidade"));
            mod.setEstado(conexao.rs.getString("estado"));
            mod.setTelefone(conexao.rs.getString("telefone"));
            mod.setCelular(conexao.rs.getString("celular"));
            mod.setEmail(conexao.rs.getString("email"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome da pessoa não existe no cadastro!"+ex);
           
        }

        conexao.desconecta();
        return mod;

    }

    /*public void ExcluiCadastro(ModeloCadastro mod) {
     connCadastro.conexao();
     try {
     PreparedStatement pst = connCadastro.conn.prepareStatement("deletae from cadcliente where nome=?");
     pst.setString(1,mod.getNome());
     pst.execute();
     JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!\nErro: " + ex);
     }

     */
    public void AlterarCadastro(ModeloCadastro mod) {
        connCadastro.conexao();
        try {
            PreparedStatement pst = connCadastro.conn.prepareStatement("update cadcliente set codcliente=?,nome=?,cpf=?,endereco=?,numeroend=?,bairro=?,telefone=?,email=?,celular=?,cidade=?,cep=?,rg=?,estado=?");
            pst.setInt(1, mod.getCod());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getEndereco());
            pst.setInt(5, mod.getNumero());
            pst.setString(6, mod.getBairro());
            pst.setString(7, mod.getTelefone());
            pst.setString(8, mod.getEmail());
            pst.setString(9, mod.getCelular());
            pst.setString(10, mod.getCidade());
            pst.setString(11, mod.getCep());
            pst.setString(12, mod.getRg());
            pst.setString(13, mod.getEstado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\nErro: ");
        }

    }
}
