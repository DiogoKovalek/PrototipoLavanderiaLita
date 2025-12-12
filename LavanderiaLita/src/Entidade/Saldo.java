package Entidade;

/**
 *
 * @author Eduardo
 */
public class Saldo {
    
    private int quantidadeDeLavagens;
    private int quantidadeDeSecagens;
    private Cliente cliente;
    
    public Saldo(){
        
    }
    public Saldo( int quantidadeDeLavagens, int quantidadeDeSecagens, Cliente cliente){
        this.quantidadeDeLavagens = quantidadeDeLavagens;
        this.quantidadeDeSecagens = quantidadeDeSecagens;
        this.cliente = cliente;
    }

    

    @Override
    public String toString() {
        return quantidadeDeLavagens + ";" + quantidadeDeSecagens + ";" + cliente;
    }
    
    
}
