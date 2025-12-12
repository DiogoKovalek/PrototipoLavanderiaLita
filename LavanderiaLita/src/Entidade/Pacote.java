package Entidade;

/**
 *
 * @author Eduardo
 */
public class Pacote {
    
    private int id;
    private String nome;
    private int saldoDeLavagens;
    private int saldoDeSecagens;
    private float valor;
    private boolean disponivel;
    
    public Pacote(){
        
    }
    public Pacote(int id, String nome, int saldoDeLavagens, int saldoDeSecagens, float valor, boolean disponivel){
        this.id = id;
        this.nome = nome;
        this.saldoDeLavagens = saldoDeLavagens;
        this.saldoDeSecagens = saldoDeSecagens;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldoDeLavagens() {
        return saldoDeLavagens;
    }

    public void setSaldoDeLavagens(int saldoDeLavagens) {
        this.saldoDeLavagens = saldoDeLavagens;
    }

    public int getSaldoDeSecagens() {
        return saldoDeSecagens;
    }

    public void setSaldoDeSecagens(int saldoDeSecagens) {
        this.saldoDeSecagens = saldoDeSecagens;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + saldoDeLavagens + ";" + saldoDeSecagens + ";" + valor + ";" + disponivel;
    }
    
    
}
