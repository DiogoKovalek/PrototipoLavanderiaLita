package DAO;

import Entidade.Saldo;

/**
 *
 * @author Eduardo
 */
public class SaldoDao extends DaoBehavior<Saldo, Integer>{
    
    public SaldoDao(){
        savePath = "../saves/Saldo.txt";
    }
    
    @Override
    public void create(Saldo t) {
        if(retrive(t.getIdCliente()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Saldo retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getIdCliente() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID Cliente;Quantidade De Lavagens;Quantidade De Secagens";
    }
    
    @Override
    protected Saldo createObjectFromString(String str) {
        String[] aux = str.split(";");
        
        Saldo t = new Saldo();
        t.setIdCliente(Integer.parseInt(aux[0]));
        t.setQuantidadeDeLavagens(Integer.parseInt(aux[1]));
        t.setQuantidadeDeSecagens(Integer.parseInt(aux[2]));
        return t;
    }
    
    
}
