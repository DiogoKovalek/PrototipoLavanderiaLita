package DAO;

import Entidade.Cliente;

/**
 *
 * @author kovalek
 */
public class ClienteDao extends DaoBehavior<Cliente, Integer>{
    
    public ClienteDao(){
        savePath = "src/txt/Cliente.txt";
    }
    
    @Override
    public void create(Cliente t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Cliente retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }

    @Override
    protected Cliente createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Cliente c = new Cliente(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5]);
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(aux[0]));
        c.setNome(aux[1]);
        c.setCpf_cnpj(aux[2]);
        c.setEndereco(aux[3]);
        c.setEmail(aux[4]);
        c.setSenha(aux[5]);
        return c;
    }
    
    
}
