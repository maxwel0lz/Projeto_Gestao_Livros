
package Entidades;


public class Livros {
    int id;
    private String titulo;
    private String categoria;
    private String ano;
    private String autor;
    private String valor;
    private String quantidade;
    
    public Livros(){
        
    }

    public Livros(int id, String titulo, String categoria, String ano, String autor, String valor, String quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.ano = ano;
        this.autor = autor;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public boolean verificarCampos(Livros l){
        boolean v = true;
        String aux = "";
        if(aux.equals(l.getTitulo().trim())){
            v = false;
        }if(aux.equals(l.getCategoria().trim())){
            v = false;
        }if(aux.equals(l.getAno().trim())){
            v = false;
        }if(aux.equals(l.getAutor().trim())){
            v = false;
        }if(aux.equals(l.getValor().trim())){
            v = false;
        }if(aux.equals(l.getQuantidade().trim())){
            v = false;
        }
        return v;
    }
    public int getId() {
        return id;
    }
    public void SetId(int id){
       this.id = id; 
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    public Object[] livros(){
     return new Object[]{titulo,categoria,ano,autor,valor,quantidade };   
    }
    
    
}
