
package Entidades;


import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    // Conexão com o banco de dados
    public static Connection Conectar(){
        Connection conectar= null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String endereco = "jdbc:mysql://localhost:3306/dblivros";
        String usuario = "root";
        String senha = "1234";
        try {
            Class.forName( driver);
            conectar = (Connection) DriverManager.getConnection(endereco, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
        return conectar;
    }
    
    //Metodo para adicionar um novo livro no banco de dados
    public void criarLivro(Livros livro){
        String sql = "insert into tblivros(titulo,categoria,ano,autor,valor,quantidade) Values(?,?,?,?,?,?)";
        Connection conectar = Conectar();
        
        try {
            PreparedStatement preparar = conectar.prepareStatement(sql);
            preparar.setString(1, livro.getTitulo());
            preparar.setString(2, livro.getCategoria());
            preparar.setInt(3, parseInt(livro.getAno()));
            preparar.setString(4, livro.getAutor());
            preparar.setFloat(5, parseFloat(livro.getValor()));
            preparar.setInt(6, parseInt(livro.getQuantidade()));
            preparar.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conectar.close();
        } catch (SQLException e) {
        }
        
    }
    
    // Metodo para Ler e retornar informações para o banco de dados e salva na Array de ModelLivros
    public ArrayList<Livros> selecionarLivro(ArrayList<Livros> livros){
        Connection conectar = Conectar();
        String sql = "SELECT * FROM dblivros.tblivros";
        Statement st = null;
        
        try {
            st = conectar.createStatement();
            ResultSet resu = st.executeQuery(sql);
            while(resu.next()){
                Livros livro = new Livros();
                livro.SetId(resu.getInt("idlivros"));
                livro.setTitulo(resu.getString("Titulo"));
                livro.setCategoria(resu.getString("Categoria"));
                livro.setAno(String.valueOf(resu.getInt("Ano")));
                livro.setAutor(resu.getString("Autor"));
                livro.setValor(String.valueOf(resu.getFloat("Valor")));
                livro.setQuantidade(String.valueOf(resu.getInt("Quantidade")));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            conectar.close();
        } catch (Exception e) {
        }
        return livros;
    }
    
    //Metodo para ler Banco de dados
    public ArrayList<Livros> selecionarLivro(){
        Connection conectar = Conectar();
        String sql = "SELECT * FROM dblivros.tblivros";
        Statement st = null;
        ArrayList<Livros> livros = new ArrayList();
        try {
            st = conectar.createStatement();
            ResultSet resu = st.executeQuery(sql);
            
            while(resu.next()){
                Livros livro = new Livros();
                livro.SetId(resu.getInt("idlivros"));
                livro.setTitulo(resu.getString("Titulo"));
                livro.setCategoria(resu.getString("Categoria"));
                livro.setAno(String.valueOf(resu.getInt("Ano")));
                livro.setAutor(resu.getString("Autor"));
                livro.setValor(String.valueOf(resu.getFloat("Valor")));
                livro.setQuantidade(String.valueOf(resu.getInt("Quantidade")));
                livros.add(livro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conectar.close();
        } catch (SQLException e) {}
        return livros;
    }
    
    public void editarLivro(Livros livro){
       Connection conectar = Conectar();
       String sql = "UPDATE  dblivros.tblivros set titulo = ?,categoria = ?,ano = ?,autor = ?,valor = ?,quantidade = ? WHERE idlivros = ?";
       
        try {
            PreparedStatement preparar = conectar.prepareStatement(sql);
            preparar.setString(1, livro.getTitulo());
            preparar.setString(2, livro.getCategoria());
            preparar.setInt(3, parseInt(livro.getAno()));
            preparar.setString(4, livro.getAutor());
            preparar.setFloat(5, parseFloat(livro.getValor()));
            preparar.setInt(6, parseInt(livro.getQuantidade()));
            preparar.setInt(7, livro.getId());
            preparar.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conectar.close();
        } catch (SQLException e) {
        }
       
    }
    
    public void excluirLivro (int id){
      Connection conectar = Conectar();  
      String sql = "DELETE FROM dblivros.tblivros WHERE idlivros = ?";
        try {
            PreparedStatement preparar = conectar.prepareStatement(sql);
            preparar.setInt(1, id);
            preparar.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            conectar.close();
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<Administrador> criarAdministrador(ArrayList<Administrador> arrAdm,Administrador adm){
       Connection conectar = Conectar();
       String sql = "insert into tbusuarios(nome,usuario,senha) Values(?,?,?)";
       
        try {
            PreparedStatement preparar = conectar.prepareStatement(sql);
            preparar.setString(1, adm.getNome());
            preparar.setString(2, adm.getUsuario());
            preparar.setString(3,adm.getSenha());
            preparar.execute();
            arrAdm.add(adm);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conectar.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrAdm;
    }
    
    
}
