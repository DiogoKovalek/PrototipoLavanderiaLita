package DAO;

import Entidade.Cliente;

/**
 *
 * @author kovalek
 */
public class ClienteDao extends DaoBehavior<Cliente, Integer>{
    
    public ClienteDao(){
        
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
    
    public static void main(String[] args){
        ClienteDao clienteDao = new ClienteDao();
        Cliente c = new Cliente(1, "Diogo", "123", "Roncador", "diogo@", "12345");
        clienteDao.create(c);
        c = new Cliente(2, "Caralho", "321", "Pira no Pau", "eduardo@", "67890");
        clienteDao.create(c);
        c = new Cliente(3, "Pedro", "69", "Rebola", "bigass@", "p1k4<3");
        clienteDao.create(c);
        c = new Cliente(4, "Neskiwki", "999", "Soldador", "soladado16@", "selva!");
        clienteDao.create(c);
        
        
        c = clienteDao.retrive(2);
        Cliente cNew = new Cliente(c.getId(), "Eduardo", c.getCpf_cnpj(), c.getEndereco(), c.getEmail(), c.getSenha());
        clienteDao.update(c, cNew);
        for(String a:clienteDao.listar()){
            System.out.println(a);
        }
        
    }
    
    
}
