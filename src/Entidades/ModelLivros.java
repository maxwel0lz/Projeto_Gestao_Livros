
package Entidades;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModelLivros extends AbstractTableModel{
    
    ArrayList<Livros> livro = new ArrayList();
    String[] coluna = {"Título","Categoria","Ano","Autor","Valor","Quantidade" }; 
    
    @Override
    public int getRowCount() {
        return livro.size();
    }
    public void cadastarLivro(Livros l){
        livro.add(l);
        this.fireTableDataChanged();
    }
    public void EditarLivro(int index, Livros l){
        livro.set(index, l);
        this.fireTableDataChanged();
    }
    public void ExcluirLivro(int index){
        livro.remove(index);
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
                return livro.get(rowIndex).getTitulo();
            case 1:
                return livro.get(rowIndex).getCategoria();
            case 2:
                return livro.get(rowIndex).getAno();
            case 3:
                return livro.get(rowIndex).getAutor();
            case 4:
                return livro.get(rowIndex).getValor();
            default:
                return livro.get(rowIndex).getQuantidade();

        }
    
    }
    
}
