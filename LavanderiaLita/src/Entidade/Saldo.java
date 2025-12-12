package Entidade;

/**
 *
 * @author Eduardo
 */
public class Saldo {
    
    private int idCliente;
    private int quantidadeDeLavagens;
    private int quantidadeDeSecagens;
    
    
    public Saldo(){
        
    }
    public Saldo(int idCliente, int quantidadeDeLavagens, int quantidadeDeSecagens){
        this.idCliente = idCliente;
        this.quantidadeDeLavagens = quantidadeDeLavagens;
        this.quantidadeDeSecagens = quantidadeDeSecagens;
    }

    public int getQuantidadeDeLavagens() {
        return quantidadeDeLavagens;
    }

    public void setQuantidadeDeLavagens(int quantidadeDeLavagens) {
        this.quantidadeDeLavagens = quantidadeDeLavagens;
    }

    public int getQuantidadeDeSecagens() {
        return quantidadeDeSecagens;
    }

    public void setQuantidadeDeSecagens(int quantidadeDeSecagens) {
        this.quantidadeDeSecagens = quantidadeDeSecagens;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

    @Override
    public String toString() {
        return idCliente + ";" + quantidadeDeLavagens + ";" + quantidadeDeSecagens + ";";
    }
    
    
}
