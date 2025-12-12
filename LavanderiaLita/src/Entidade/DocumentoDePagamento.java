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

    

    @Override
    public String toString() {
        return id + ";" + hora + ";" + data + ";" + valor + ";" + situacao;
    }
    
    
}
