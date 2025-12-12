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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Override
    public String toString() {
        return nome + ";" + valorUnitario + ";" + descricao;
    }
    
    
}
