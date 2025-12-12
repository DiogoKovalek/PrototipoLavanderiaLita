package DAO;

import Entidade.Maquina;

/**
 *
 * @author Eduardo
 */
public class MaquinaDao extends DaoBehavior<Maquina, Integer>{
    
    public MaquinaDao(){
        savePath = "../saves/Maquina.txt";
    }
    
    @Override
    public void create(Maquina t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Maquina retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Tipo;Estado;ValorDeAquisicao;DataDeAquisicao;DataDeInativacao;PodeOperar;CadastradoPor";
    }
    
    @Override
    protected Maquina createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Maquina c = new Maquina(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7]);
        Maquina c = new Maquina();
        c.setId(Integer.parseInt(aux[0]));
        c.setTipo(aux[1]);
        c.setEstado(aux[2]);
        c.setValorDeAquisicao(Float.parseFloat(aux[3]));
        c.setDataDeAquisicao(aux[4]);
        c.setDataDeInativacao(aux[5]);
        c.setPodeOperar(aux[6]);
        c.setCadastradoPor(aux[7]);
        return c;
    }
    
    
}
