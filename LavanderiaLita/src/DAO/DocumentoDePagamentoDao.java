package DAO;

import Entidade.DocumentoDePagamento;

/**
 *
 * @author Eduardo
 */
public class DocumentoDePagamentoDao extends DaoBehavior<DocumentoDePagamento, Integer>{
    
    public DocumentoDePagamentoDao(){
        savePath = "../saves/DocumentoDePagamento.txt";
    }
    
    @Override
    public void create(DocumentoDePagamento t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public DocumentoDePagamento retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Hora;Data;Valor;Situacao";
    }
    
    @Override
    protected DocumentoDePagamento createObjectFromString(String str) {
        String[] aux = str.split(";");
        //DocumentoDePagamento t = new DocumentoDePagamento(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4]);
        DocumentoDePagamento t = new DocumentoDePagamento();
        t.setId(Integer.parseInt(aux[0]));
        t.setHora(aux[1]);
        t.setData(aux[2]);
        t.setValor(Float.parseFloat(aux[3]));
        t.setSituacao(aux[4]);
        return t;
    }
    
    
}
