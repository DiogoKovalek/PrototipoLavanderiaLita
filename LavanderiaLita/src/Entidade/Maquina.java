package Entidade;

/**
 *
 * @author kovalek
 */
public class Maquina {
    
    private int id;
    private String tipo;
    private String estado;
    private float valorDeAquisicao;
    private String dataDeAquisicao;
    private String dataDeInativacao;
    private boolean podeOperar;
    private Operador cadastradoPor;
    
    public Maquina(){
        
    }
    public Maquina(int id, String tipo, String estado, float valorDeAquisicao, String dataDeAquisicao, String dataDeInativacao, boolean podeOperar, Operador cadastradoPor){
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
        this.valorDeAquisicao = valorDeAquisicao;
        this.dataDeAquisicao = dataDeAquisicao;
        this.dataDeInativacao = dataDeInativacao;
        this.podeOperar = podeOperar;
        this.cadastradoPor = cadastradoPor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValorDeAquisicao() {
        return valorDeAquisicao;
    }

    public void setValorDeAquisicao(float valorDeAquisicao) {
        this.valorDeAquisicao = valorDeAquisicao;
    }

    public String getDataDeAquisicao() {
        return dataDeAquisicao;
    }

    public void setDataDeAquisicao(String dataDeAquisicao) {
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public String getDataDeInativacao() {
        return dataDeInativacao;
    }

    public void setDataDeInativacao(String dataDeInativacao) {
        this.dataDeInativacao = dataDeInativacao;
    }

    public boolean isPodeOperar() {
        return podeOperar;
    }

    public void setPodeOperar(boolean podeOperar) {
        this.podeOperar = podeOperar;
    }

    public Operador getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(Operador cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }

    

    @Override
    public String toString() {
        return id + ";" + tipo + ";" + estado + ";" + valorDeAquisicao + ";" + dataDeAquisicao + ";" + dataDeInativacao + ";" + podeOperar + ";" + cadastradoPor;
    }
    
    
}
