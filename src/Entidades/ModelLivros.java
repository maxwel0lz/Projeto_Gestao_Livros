
package Entidades;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelLivros extends AbstractTableModel{
    
    ConexaoBD bd = new ConexaoBD();
    ArrayList<Livros> livro = new ArrayList();
    String[] coluna = {"Id","Título","Categoria","Ano","Autor","Valor","Quantidade" }; 
    
    @Override
    public int getRowCount() {
        return livro.size();
    }
    public void LerLivro(){
        bd.selecionarLivro(livro);
        this.fireTableDataChanged();
        
    }
    
    public void cadastarLivro(Livros l){
        bd.criarLivro(l);
        livro.clear();
        bd.selecionarLivro(livro);
        this.fireTableDataChanged();
        
    }
    
    public void limparLista(){
        livro.clear();
    }
    public int getId (int index){
        Livros li = livro.get(index);
        
        return li.getId();
    }
    
    public void EditarLivro(Livros l){
        bd.editarLivro(l);
        livro.clear();
        bd.selecionarLivro(livro);
        this.fireTableDataChanged();
    }
    public void ExcluirLivro(int index){
        bd.excluirLivro(index);
        livro.clear();
        bd.selecionarLivro(livro);
        this.fireTableDataChanged();
    } 

    @Override
    public int getColumnCount() {
        return coluna.length;
    }
    
    @Override
    public String getColumnName(int column){
        return coluna[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return livro.get(rowIndex).getId();
            case 1:
                return livro.get(rowIndex).getTitulo();
            case 2:
                return livro.get(rowIndex).getCategoria();
            case 3:
               return livro.get(rowIndex).getAno();
            case 4:
                 return livro.get(rowIndex).getAutor();
            case 5:
                return livro.get(rowIndex).getValor();
            default:
                return livro.get(rowIndex).getQuantidade();

        }
    
    }
    
}
