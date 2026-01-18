package DAO;

import Entidade.Dano;
import main.Main;
/**
 *
 * @author kovalek
 */
public class DanoDao extends DaoBehavior<Dano, Integer>{
    
    public DanoDao(){
        savePath = "../saves/Dano.txt";
    }
    @Override
    public void create(Dano t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }

    @Override
    public Dano retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }

    @Override
    public String listarAtributos() {
        return "ID;Relator;Descricao;Data;Hora;Maquina";
    }

    @Override
    protected Dano createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Maquina c = new Maquina(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7]);
        Dano c = new Dano();
        c.setId(Integer.parseInt(aux[0]));
        c.setRelator(Main.daoManager.getOperadorDao().retrive((int) Integer.valueOf(aux[1])));
        c.setDescricao(aux[2]);
        c.setData(aux[3]);
        c.setHora(aux[4]);
        c.setMaquina(Main.daoManager.getMaquinaDao().retrive((int) Integer.valueOf(aux[5])));
        return c;
    }
    
}
