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
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Saldo retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "QuantidadeDeLavagens;QuantidadeDeSecagens;Cliente";
    }
    
    @Override
    protected Saldo createObjectFromString(String str) {
        String[] aux = str.split(";");
        
        Saldo t = new Saldo();
        t.setQuantidadeDeLavagens(Integer.parseInt(aux[0]));
        t.setQuantidadeDeSecagens(Integer.parseInt(aux[1]));
        t.setCliente(aux[2]);
        return t;
    }
    
    
}
