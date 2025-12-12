package Entidade;

/**
 *
 * @author kovalek
 */
public class Operador {
    
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private float salario;
    private String tipo;
    private String contaParaPagamento;
    private String expediente;
    private String diasEmQueTrabalha;
    
    public Operador(){
        
    }
    public Operador(int id, String nome, String cpf, String telefone, String email, String senha, float salario, String tipo, String contaParaPagamento, String expediente, String diasEmQueTrabalha){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.salario = salario;
        this.tipo = tipo;
        this.contaParaPagamento = contaParaPagamento;
        this.expediente = expediente;
        this.diasEmQueTrabalha = diasEmQueTrabalha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContaParaPagamento() {
        return contaParaPagamento;
    }

    public void setContaParaPagamento(String contaParaPagamento) {
        this.contaParaPagamento = contaParaPagamento;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getDiasEmQueTrabalha() {
        return diasEmQueTrabalha;
    }

    public void setDiasEmQueTrabalha(String diasEmQueTrabalha) {
        this.diasEmQueTrabalha = diasEmQueTrabalha;
    }

    
    

    @Override
    public String toString() {
        return id + ";" + nome + ";" + cpf + ";" + telefone + ";" + email + ";" + senha + ";" + salario + ";" + tipo + ";" + contaParaPagamento + ";" + expediente + ";" + diasEmQueTrabalha;
    }
    
    
}
