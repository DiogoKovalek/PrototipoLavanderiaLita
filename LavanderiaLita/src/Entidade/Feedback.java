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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    

    @Override
    public String toString() {
        return id + ";" + mensagem + ";" + resposta + ";" + data + ";" + hora + ";" + cliente.getId() + ";" + operador.getId();
    }
    
    
}
