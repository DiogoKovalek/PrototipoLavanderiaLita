package DAO;

import Entidade.Utilizacao;

/**
 *
 * @author Eduardo
 */
public class UtilizacaoDao extends DaoBehavior<Utilizacao, Integer>{
    
    public UtilizacaoDao(){
        savePath = "../saves/Utilizacao.txt";
    }
    
    @Override
    public void create(Utilizacao t) {
        if(retrive(t.getId()) == null) listaObjetos.add(t);
    }
    
    @Override
    public Utilizacao retrive(Integer key) {
        for(int i = 0; i < listaObjetos.size(); i++){
            if(listaObjetos.get(i).getId() == key) return listaObjetos.get(i);
        }
        return null;
    }
    
    @Override
    public String listarAtributos() {
        return "ID;Cliente;Operador;DocumentoDePagamento;ValorBruto;ValorDeDesconto;ValorTotal;Data;HoraDoRegistro;HoraDeFechamento;NumeroDeServico";
    }
    
    @Override
    protected Utilizacao createObjectFromString(String str) {
        String[] aux = str.split(";");

        Utilizacao t = new Utilizacao();
        t.setId(Integer.parseInt(aux[0]));
        t.setCliente(aux[1]);
        t.setOperador(aux[2]);
        t.setDocumentoDePagamento(aux[3]);
        t.setValorBruto(Float.parseFloat(aux[4]));
        t.setValorDeDesconto(Float.parseFloat(aux[5]));
        t.setValorTotal(Float.parseFloat(aux[6]));
        t.setData(aux[7]);
        t.setHoraDoRegistro(aux[8]);
        t.setHoraDoFechamento(aux[9]);
        t.setNumeroDeServico(Integer.parseInt(aux[10]));
        return t;
    }
    
    
}
