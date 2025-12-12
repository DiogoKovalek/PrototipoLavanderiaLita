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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public DocumentoDePagamento getDocumentoDePagamento() {
        return documentoDePagamento;
    }

    public void setDocumentoDePagamento(DocumentoDePagamento documentoDePagamento) {
        this.documentoDePagamento = documentoDePagamento;
    }

    

    @Override
    public String toString() {
        return id + ";" + quantidade + ";" + valorTotal + ";" + data + ";" + pacote + ";" + documentoDePagamento;
    }
    
    
}
