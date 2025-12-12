package Entidade;

/**
 *
 * @author Eduardo
 */
public class ItemDeServico {
    
    private int id;
    private String servico;
    private String estado;
    private boolean usaMaquina;
    private boolean usaSaldo;
    private Saldo saldo;
    private Maquina maquina;
    private String horaDeInicio;
    private String horaDoFim;
    
    public ItemDeServico(){
        
    }
    public ItemDeServico(int id, String servico, String estado, boolean usaMaquina, boolean usaSaldo, Saldo saldo, Maquina maquina, String horaDeInicio, String horaDoFim){
        this.id = id;
        this.servico = servico;
        this.estado = estado;
        this.usaMaquina = usaMaquina;
        this.usaSaldo = usaSaldo;
        this.saldo = saldo;
        this.maquina = maquina;
        this.horaDeInicio = horaDeInicio;
        this.horaDoFim = horaDoFim;
    }

    

    @Override
    public String toString() {
        return id + ";" + servico + ";" + estado + ";" + usaMaquina + ";" + usaSaldo + ";" + saldo + ";" + maquina + ";" + horaDeInicio + ";" + horaDoFim;
    }
    
    
}
