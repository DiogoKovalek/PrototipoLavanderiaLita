package DAO;

import Entidade.Cliente;

/**
 *
 * @author kovalek
 */
public class ClienteDao extends DaoBehavior<Cliente, Integer>{
    
    public ClienteDao(){
        savePath = "../saves/Cliente.txt";
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
    public String listarAtributos() {
        return "ID;Nome;CPF/CNPJ;Endereço;e-mail;Senha";
    }
    
    @Override
    protected Cliente createObjectFromString(String str) {
        String[] aux = str.split(";");
        Cliente t = new Cliente();
        t.setId(Integer.parseInt(aux[0]));
        t.setNome(aux[1]);
        t.setCpf_cnpj(aux[2]);
        t.setEndereco(aux[3]);
        t.setEmail(aux[4]);
        t.setSenha(aux[5]);
        return t;
    }
    
    public Cliente getUserPassword(String user, String password){
        for(int i = 0; i < listaObjetos.size(); i++){
            Cliente c = listaObjetos.get(i);
            if(c.getNome().equals(user) && c.getSenha().equals(password)){
                return c;
            }
        }
        return null;
    }
}
