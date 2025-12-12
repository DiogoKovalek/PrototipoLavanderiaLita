package Entidade;

/**
 *
 * @author Eduardo
 */
public class ItemDeServico {
    
    private int id;
    private Servico servico;
    private String estado;
    private boolean usaMaquina;
    private boolean usaSaldo;
    private Saldo saldo;
    private Maquina maquina;
    private String horaDeInicio;
    private String horaDoFim;
    
    public ItemDeServico(){
        
    }
    public ItemDeServico(int id, Servico servico, String estado, boolean usaMaquina, boolean usaSaldo, Saldo saldo, Maquina maquina, String horaDeInicio, String horaDoFim){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isUsaMaquina() {
        return usaMaquina;
    }

    public void setUsaMaquina(boolean usaMaquina) {
        this.usaMaquina = usaMaquina;
    }

    public boolean isUsaSaldo() {
        return usaSaldo;
    }

    public void setUsaSaldo(boolean usaSaldo) {
        this.usaSaldo = usaSaldo;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(String horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public String getHoraDoFim() {
        return horaDoFim;
    }

    public void setHoraDoFim(String horaDoFim) {
        this.horaDoFim = horaDoFim;
    }

    

    @Override
    public String toString() {
        return id + ";" + servico + ";" + estado + ";" + usaMaquina + ";" + usaSaldo + ";" + saldo + ";" + maquina + ";" + horaDeInicio + ";" + horaDoFim;
    }
    
    
}
