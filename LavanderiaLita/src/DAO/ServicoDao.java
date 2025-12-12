package DAO;

import Entidade.Servico;

/**
 *
 * @author Eduardo
 */
public class ServicoDao extends DaoBehavior<Servico, Integer>{
    
    public ServicoDao(){
        savePath = "../saves/Servico.txt";
    }
    
    @Override
    public void create(Servico t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Servico retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "Nome;ValorUnitario;descricao";
    }
    
    @Override
    protected Servico createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Servico t = new Servico(Integer.parseInt(aux[0]), aux[1], aux[2]);
        Servico t = new Servico();
        t.setNome(aux[0]);
        t.setValorUnitario(Float.parseFloat(aux[1]));
        t.setDescricao(aux[2]);
        return t;
    }
    
    
}
