package DAO;

import Entidade.Feedback;

/**
 *
 * @author Eduardo
 */
public class FeedbackDao extends DaoBehavior<Feedback, Integer>{
    
    public FeedbackDao(){
        savePath = "../saves/Feedback.txt";
    }
    
    @Override
    public void create(Feedback t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Feedback retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Mensagem;Resposta;Data;Hora;Cliente;Administrador";
    }
    
    @Override
    protected Feedback createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Feedback t = new Feedback(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], aux[6]);
        Feedback t = new Feedback();
        t.setId(Integer.parseInt(aux[0]));
        t.setMensagem(aux[1]);
        t.setResposta(aux[2]);
        t.setData(aux[3]);
        t.setHora(aux[4]);
        t.setCliente(aux[5]);
        t.setAdministrador(aux[6]);
        return t;
    }
    
    
}
