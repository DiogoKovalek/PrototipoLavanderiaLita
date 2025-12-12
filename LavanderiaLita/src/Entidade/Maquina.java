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

    

    @Override
    public String toString() {
        return id + ";" + tipo + ";" + estado + ";" + valorDeAquisicao + ";" + dataDeAquisicao + ";" + dataDeInativacao + ";" + podeOperar + ";" + cadastradoPor;
    }
    
    
}
