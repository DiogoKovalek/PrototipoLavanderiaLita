package DAO;

import Entidade.Operador;

/**
 *
 * @author Eduardo
 */
public class OperadorDao extends DaoBehavior<Operador, Integer>{
    
    public OperadorDao(){
        savePath = "../saves/Operador.txt";
    }
    
    @Override
    public void create(Operador t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Operador retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Nome;CPF;Telefone;e-mail;Senha;Salario;Tipo;ContaParaPagamento;Expediente;DiasEmQueTrabalha";
    }
    
    @Override
    protected Operador createObjectFromString(String str) {
        String[] aux = str.split(";");
        //Operador t = new Operador(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], aux[6], aux[7], aux[8], aux[9], aux[10]);
        Operador t = new Operador();
        t.setId(Integer.parseInt(aux[0]));
        t.setNome(aux[1]);
        t.setCPF(aux[2]);
        t.setTelefone(aux[3]);
        t.setEmail(aux[4]);
        t.setSenha(aux[5]);
        t.setSalario(Float.parseFloat(aux[6]));
        t.setTipo(aux[7]);
        t.setContaParaPagamento(aux[8]);
        t.setExpediente(aux[9]);
        t.setDiasEmQueTrabalha(aux[10]);
        return t;
    }
    
    
}
