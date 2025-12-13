package Entidade;

import enums.EstadoMaquina;
import enums.TipoMaquina;

/**
 *
 * @author kovalek
 */
public class Maquina {
    
    private int id;
    private TipoMaquina tipo;
    private EstadoMaquina estado;
    private float valorDeAquisicao;
    private String dataDeAquisicao;
    private String dataDeInativacao;
    private boolean podeOperar;
    private Operador cadastradoPor;
    
    public Maquina(){
        
    }
    public Maquina(int id, TipoMaquina tipo, EstadoMaquina estado, float valorDeAquisicao, String dataDeAquisicao, String dataDeInativacao, boolean podeOperar, Operador cadastradoPor){
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

    public TipoMaquina getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaquina tipo) {
        this.tipo = tipo;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
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
