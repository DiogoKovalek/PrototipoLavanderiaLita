package Entidade;

/**
 *
 * @author Eduardo
 */
public class ItemDePacote {
    
    private int id;
    private int quantidade;
    private float valorTotal;
    private String data;
    private Pacote pacote;
    private DocumentoDePagamento documentoDePagamento;
    
    public ItemDePacote(){
        
    }
    public ItemDePacote(int id, int quantidade, float valorTotal, String data, Pacote pacote, DocumentoDePagamento documentoDePagamento){
        this.id = id;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.data = data;
        this.pacote = pacote;
        this.documentoDePagamento = documentoDePagamento;
    }

    

    @Override
    public String toString() {
        return id + ";" + quantidade + ";" + valorTotal + ";" + data + ";" + pacote + ";" + documentoDePagamento;
    }
    
    
}
