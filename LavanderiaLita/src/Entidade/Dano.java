package Entidade;

/**
 *
 * @author kovalek
 */
public class Dano {
    
    private int id;
    private Operador relator;
    private String descricao;
    private String data;
    private String hora;
    private Maquina maquina;
    //Kovalek: Nao vou colocar despesa de dano pois não vai dar tempo de terminar
    
    public Dano(){
        
    }

    public Dano(int id, Operador relator, String descricao, String data, String hora, Maquina maquina) {
        this.id = id;
        this.relator = relator;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.maquina = maquina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operador getRelator() {
        return relator;
    }

    public void setRelator(Operador relator) {
        this.relator = relator;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public Maquina getMaquina(){
        return maquina;
    }
    public void setMaquina(Maquina maquina){
        this.maquina = maquina;
    }

    @Override
    public String toString() {
        return id + ";" + relator.getId() + ";" + descricao + ";" + data + ";" + hora + ";" + maquina.getId();
    }
    
}
