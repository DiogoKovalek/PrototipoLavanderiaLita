package Manager;

import DAO.DaoManager;
import DAO.ItemDeServicoDao;
import Entidade.ItemDeServico;
import main.Main;
/**
 *
 * @author kovalek
 */
public class ItemDeServicoManager {
    
    private DaoManager daoManager = Main.daoManager;
    
    public void atualizarEstado(int idItemDeServico, String estado){
        ItemDeServicoDao itemDeServicoDao = daoManager.getItemDeServicoDao();
        ItemDeServico itemDeServico = itemDeServicoDao.retrive(idItemDeServico);
        itemDeServico.setEstado(estado);
        itemDeServicoDao.update(itemDeServicoDao.retrive(idItemDeServico), itemDeServico);
    }
    
}
