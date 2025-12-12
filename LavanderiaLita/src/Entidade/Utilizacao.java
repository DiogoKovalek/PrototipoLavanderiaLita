package Entidade;

/**
 *
 * @author Eduardo
 */
public class Utilizacao {
    
    private int id;
    private Cliente cliente;
    private Operador operador;
    private DocumentoDePagamento documentoDePagamento;
    private float valorBruto;
    private float valorDeDesconto;
    private float valortotal;
    private String data;
    private String horaDoRegistro;
    private String horaDoFechamento;
    private int numeroDeServico;
    
    public Utilizacao(){
        
    }
    public Utilizacao(int id, Cliente cliente, Operador operador, DocumentoDePagamento documentoDePagamento, float valorBruto, float valorDeDesconto, float valortotal, String data, String horaDoRegistro, String horaDoFechamento, int numeroDeServico){
        this.id = id;
        this.cliente = cliente;
        this.operador = operador;
        this.documentoDePagamento = documentoDePagamento;
        this.valorBruto = valorBruto;
        this.valorDeDesconto = valorDeDesconto;
        this.valortotal = valortotal;
        this.data = data;
        this.horaDoRegistro = horaDoRegistro;
        this.horaDoFechamento = horaDoFechamento;
        this.numeroDeServico = numeroDeServico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public DocumentoDePagamento getDocumentoDePagamento() {
        return documentoDePagamento;
    }

    public void setDocumentoDePagamento(DocumentoDePagamento documentoDePagamento) {
        this.documentoDePagamento = documentoDePagamento;
    }

    public float getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(float valorBruto) {
        this.valorBruto = valorBruto;
    }

    public float getValorDeDesconto() {
        return valorDeDesconto;
    }

    public void setValorDeDesconto(float valorDeDesconto) {
        this.valorDeDesconto = valorDeDesconto;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValorTotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraDoRegistro() {
        return horaDoRegistro;
    }

    public void setHoraDoRegistro(String horaDoRegistro) {
        this.horaDoRegistro = horaDoRegistro;
    }

    public String getHoraDoFechamento() {
        return horaDoFechamento;
    }

    public void setHoraDoFechamento(String horaDoFechamento) {
        this.horaDoFechamento = horaDoFechamento;
    }

    public int getNumeroDeServico() {
        return numeroDeServico;
    }

    public void setNumeroDeServico(int numeroDeServico) {
        this.numeroDeServico = numeroDeServico;
    }
    

    @Override
    public String toString() {
        return id + ";" + cliente + ";" + operador + ";" + documentoDePagamento + ";" + valorBruto + ";" + valorDeDesconto + ";" + valortotal + ";" + data + ";" + horaDoRegistro + ";" + horaDoFechamento + ";" + numeroDeServico;
    }
    
    
}
