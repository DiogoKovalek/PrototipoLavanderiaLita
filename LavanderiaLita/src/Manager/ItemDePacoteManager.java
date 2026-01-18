package Manager;

import DAO.DaoManager;
import DAO.ItemDePacoteDao;
import Entidade.ItemDePacote;
import Entidade.Pacote;
import main.Main;

/**
 *
 * @author kovalek
 */
public class ItemDePacoteManager {
    
    private DaoManager daoManager = Main.daoManager;
    
    /* Erro de projeto
    public void selecionarPacote(String nomePacote, int quantidade){
        ItemDePacoteDao itemDePacoteDao = daoManager.getItemDePacoteDao();
        ItemDePacote itemDePacote = new ItemDePacote();
        //itemDePacote.setPacote(daoManager.getPacoteDao().retrive(nomePacote)); // aqui deu erro de projeto, antes o nome era chave primaria de Pacote
        itemDePacote.setValorTotal(quantidade*);
    }
    */
    
    public void selecionarPacote(int idPacote, int quantidade){
        ItemDePacoteDao itemDePacoteDao = daoManager.getItemDePacoteDao();
        ItemDePacote itemDePacote = new ItemDePacote();
        
        Pacote pacote = daoManager.getPacoteDao().retrive(idPacote);
        itemDePacote.setPacote(pacote);
        itemDePacote.setQuantidade(quantidade);
        itemDePacote.setValorTotal(quantidade*pacote.getValor());
        
        itemDePacoteDao.create(itemDePacote);
    }
}
