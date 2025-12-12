package DAO;

import Entidade.ItemDeServico;
import main.Main;

/**
 *
 * @author Eduardo
 */
public class ItemDeServicoDao extends DaoBehavior<ItemDeServico, Integer>{
    
    public ItemDeServicoDao(){
        savePath = "../saves/ItemDeServico.txt";
    }
    
    @Override
    public void create(ItemDeServico t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public ItemDeServico retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;TipoServico;Estado;UsaMaquina;UsaSaldo;Saldo;Maquina;HorarioDeInicio;HoraDoFim";
    }
    
    @Override
    protected ItemDeServico createObjectFromString(String str) {
        String[] aux = str.split(";");
        //ItemDeServico t = new ItemDeServico(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7], aux[8]);
        ItemDeServico t = new ItemDeServico();
        t.setId(Integer.parseInt(aux[0]));
        t.setServico(Main.daoManager.getServicoDao().retrive(aux[1]));
        t.setEstado(aux[2]);
        t.setUsaMaquina(Boolean.parseBoolean(aux[3]));
        t.setUsaSaldo(Boolean.parseBoolean(aux[4]));
        t.setSaldo(Main.daoManager.getSaldoDao().retrive((int) Integer.parseInt(aux[5])));
        t.setMaquina(Main.daoManager.getMaquinaDao().retrive((int) Integer.parseInt(aux[6])));
        t.setHoraDeInicio(aux[7]);
        t.setHoraDoFim(aux[8]);
        return t;
    }
    
    
}
