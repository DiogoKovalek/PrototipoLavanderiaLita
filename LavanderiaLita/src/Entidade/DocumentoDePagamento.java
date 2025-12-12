package Entidade;

/**
 *
 * @author Eduardo
 */
public class DocumentoDePagamento {
    
    private int id;
    private String hora;
    private String data;
    private float valor;
    private String situacao;
    
    public DocumentoDePagamento(){
        
    }
    public DocumentoDePagamento(int id, String hora, String data, float valor, String situacao){
        this.id = id;
        this.hora = hora;
        this.data = data;
        this.valor = valor;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    

    @Override
    public String toString() {
        return id + ";" + hora + ";" + data + ";" + valor + ";" + situacao;
    }
    
    
}
