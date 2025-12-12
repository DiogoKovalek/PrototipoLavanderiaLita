package Entidade;

/**
 *
 * @author Eduardo
 */
public class Feedback {
    
    private int id;
    private String mensagem;
    private String resposta;
    private String data;
    private String hora;
    private Cliente cliente;
    private Operador operador;
    
    public Feedback(){
        
    }
    public Feedback(int id, String mensagem, String resposta, String data, String hora, Cliente cliente, Operador operador){
        this.id = id;
        this.mensagem = mensagem;
        this.resposta = resposta;
        this.data = data;
        this.hora = hora;
        this.cliente = cliente;
        this.operador = operador;
    }

    

    @Override
    public String toString() {
        return id + ";" + mensagem + ";" + resposta + ";" + data + ";" + hora + ";" + cliente + ";" + operador;
    }
    
    
}
