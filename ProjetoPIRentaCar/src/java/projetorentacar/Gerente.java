

package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Gerente extends Usuario{
    
    public Gerente(String nome, String rg, String cpf, String login, String senha, int cargo, int filial){
        super(nome, rg, cpf, login, senha, cargo, filial);
    }
    public void cadastrarNovoUsuario(){
        Scanner in = new Scanner(System.in);
        System.out.println("CADASTRAR NOVO USUÁRIO");
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        System.out.println("RG: ");
        String rg = in.next();
        System.out.println("CPF: ");
        String cpf = in.next();
        System.out.println("Login: ");
        String lg = in.next();
        System.out.println("Senha: ");
        String pass = in.next();
        System.out.println("Cargo: ");
        int cargo = in.nextInt();
        //precisa chamar lista de cargos
        System.out.println("Filial: ");
        int filial = in.nextInt();
        //precisa chamar lista de filiais
        Usuario novo = new Usuario(nome,rg,cpf,lg,pass,cargo,filial);
        cadastrarUsuarioDB(novo);
        
    }
    public void cadastrarUsuarioDB(Usuario novo) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_USUARIOS (NOME_USUARIO, RG, CPF, LOGIN, SENHA, ATIVO, CARGO_ID, FILIAL_ID_"
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, novo.getNome());
            pstmt.setString(2, novo.getRg());
            pstmt.setString(3, novo.getCpf());
            pstmt.setString(4, novo.getLogin());
            pstmt.setString(5, novo.getSenha());
            pstmt.setBoolean(6, novo.isAtivo());
            pstmt.setInt(7, novo.getCargo());
            pstmt.setInt(8, novo.getFilial());
            pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
