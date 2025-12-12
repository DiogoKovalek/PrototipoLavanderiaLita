package Entidade;

/**
 *
 * @author Eduardo
 */
public class Servico {
    
    private String nome;
    private float valorUnitario;
    private String descricao;
    
    public Servico(){
        
    }
    public Servico(String nome, float valorUnitario, String descricao){
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return nome + ";" + valorUnitario + ";" + descricao;
    }
    
    
}
