
package Entidades;

import java.util.ArrayList;

public class ModelAdministrador {
    ConexaoBD bd = new ConexaoBD();
    ArrayList<Administrador> arrAdm = new ArrayList();
    
    public void cadastrarAdm (Administrador adm){
        bd.criarAdministrador(arrAdm, adm);
    }

    public boolean verificar(Administrador adm) {
        bd.LerAdministrador(arrAdm);
        boolean aux = false;
        for (Administrador item : this.arrAdm){
           
            
            String nome1 = adm.getUsuario();
            String nome2 = item.getUsuario();
            String senha1 = adm.getSenha();
            String senha2 = item.getSenha();
            if(nome1.equals(nome2) && senha1.equals(senha2)){
                aux = true;
                break;
            }
             
            
        }
    return aux;
    }
    
}
