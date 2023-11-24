
package Entidades;

import java.util.ArrayList;

public class ModelAdministrador {
    ConexaoBD bd = new ConexaoBD();
    ArrayList<Administrador> arrAdm = new ArrayList();
    
    public void cadastrarAdm (Administrador adm){
        bd.criarAdministrador(arrAdm, adm);
    }

    public boolean verificar(Administrador adm) {
        boolean aux = false;
        for (Administrador item : this.arrAdm){
           
            
            String nome1 = adm.getNome();
            String nome2 = item.getNome();
            String senha1 = adm.getSenha();
            String senha2 = item.getSenha();
            
            aux = nome1.equals(nome2) && senha1.equals(senha2);
            
        }
    return aux;
    }
    
}
