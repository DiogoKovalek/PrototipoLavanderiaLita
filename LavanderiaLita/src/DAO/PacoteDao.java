package DAO;

import Entidade.Pacote;

/**
 *
 * @author Eduardo
 */
public class PacoteDao extends DaoBehavior<Pacote, Integer>{
    
    public PacoteDao(){
        savePath = "../saves/Pacote.txt";
    }
    
    @Override
    public void create(Pacote t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Pacote retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Nome;SaldoDeLavagens;SaldoDeSecagens;Valor;Disponivel";
    }
    
    @Override
    protected Pacote createObjectFromString(String str) {
        String[] aux = str.split(";");

        Pacote t = new Pacote();
        t.setId(Integer.parseInt(aux[0]));
        t.setNome(aux[1]);
        t.setSaldoDeLavagens(Integer.parseInt(aux[2]));
        t.setSaldoDeSecagens(Integer.parseInt(aux[3]));
        t.setValor(Float.parseFloat(aux[4]));
        t.setDisponivel(Boolean.parseBoolean(aux[5]));
        return t;
    }
    
    
}
