
package Entidades;


import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    public static Connection Conectar(){
        Connection conectar=null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String endereco = "jdbc:mysql://localhost:3306/dblivros";
        String usuario = "root";
        String senha = "1234";
        try {
            Class.forName( driver);
            conectar = (Connection) DriverManager.getConnection(endereco, usuario, senha);
        } catch (Exception e) {
            return null;
        }
        return conectar;
    }
    
    public void inserirLivro(Livros livro){
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
        } catch (Exception e) {
        }
        
    }
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
        } catch (Exception e) {
        }
        return livros;
    }

}
