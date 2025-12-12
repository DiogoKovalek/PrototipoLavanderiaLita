package DAO;

import Entidade.ItemDePacote;
import main.Main;

/**
 *
 * @author Eduardo
 */
public class ItemDePacoteDao extends DaoBehavior<ItemDePacote, Integer>{
    
    public ItemDePacoteDao(){
        savePath = "../saves/ItemDePacote.txt";
    }
    
    @Override
    public void create(ItemDePacote t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public ItemDePacote retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Quantidade;ValorTotal;Data;Pacote";
    }
    
    @Override
    protected ItemDePacote createObjectFromString(String str) {
        String[] aux = str.split(";");

        ItemDePacote t = new ItemDePacote();
        t.setId(Integer.parseInt(aux[0]));
        t.setQuantidade(Integer.parseInt(aux[1]));
        t.setValorTotal(Float.parseFloat(aux[2]));
        t.setData(aux[3]);
        t.setPacote(Main.daoManager.getPacoteDao().retrive((int) Integer.parseInt(aux[4])));
        return t;
    }
    
    
}
