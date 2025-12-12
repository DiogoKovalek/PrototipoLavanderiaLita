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

    
    

    @Override
    public String toString() {
        return id + ";" + nome + ";" + cpf + ";" + telefone + ";" + email + ";" + senha + ";" + salario + ";" + tipo + ";" + contaParaPagamento + ";" + expediente + ";" + diasEmQueTrabalha;
    }
    
    
}
