package projetorentacar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ygor.yppessoa
 */
public class AcessoUsuario extends HttpServlet {
    private int usuarioId;
    private String login = null;
    private String senha;
    private String cargo;
    private boolean ativo;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
            try {
        } catch (Exception e){
            
        } finally {
                out.close();
    }
    }
    //String usuario, String senha, String cargo
    public boolean validarUsuario(String log, String pass) {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = conexao.obterConexao();
            String comandoSQL = ("SELECT ID_USUARIO, LOGIN, SENHA, ATIVO, DESCRICAO_CARGO FROM USUARIOS "
                   + "JOIN CARGOS ON CARGO_ID = ID_CARGO WHERE LOGIN = '"+ log+"'");
            System.out.println(comandoSQL);
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet resp = pstmt.executeQuery();
            while(resp.next()){
            this.usuarioId = resp.getInt(1);
            this.login = resp.getString(2);
            this.senha = resp.getString(3);
            this.ativo = resp.getBoolean(4);
            this.cargo = resp.getString(5);
            }
            pstmt.close();
            if(this.login == null){
                System.out.println("Não existe usuario no sistema");
                return false;
            }
         
        } catch (SQLException ex){
            ex.printStackTrace();
            } catch (Exception e){
           e.printStackTrace();
            
        }
        
        return validar(log, pass);
    }
    
    public boolean validar(String log, String pass){
        if(this.login.equalsIgnoreCase(log) && this.senha.equalsIgnoreCase(pass) && this.ativo){
            System.out.println("Credencias OK!");
            return true;
        }
        System.out.println("Credenciais erradas.");
        return false;
    }

    /**
     * @return the usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }
    
    
}
