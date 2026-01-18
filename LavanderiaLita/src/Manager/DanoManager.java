package Manager;

import DAO.DanoDao;
import DAO.DaoManager;
import DAO.MaquinaDao;
import Entidade.Dano;
import Entidade.Maquina;
import enums.EstadoMaquina;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.Main;

/**
 *
 * @author kovalek
 */
public class DanoManager {
    private DaoManager daoManager = Main.daoManager;
    
    public void interditarMaquina(int idMaquina){
        MaquinaDao dao = daoManager.getMaquinaDao();
        Maquina maquina = dao.retrive(idMaquina);
        maquina.setEstado(EstadoMaquina.Interditada);
        dao.update(dao.retrive(idMaquina), maquina);
    }
    
    public void relatarDano(int idMaquina, String descricao){
        MaquinaDao maquinaDao = daoManager.getMaquinaDao();
        Maquina maquina = maquinaDao.retrive(idMaquina);
        
        DanoDao daoDano = daoManager.getDanoDao();
        Dano dano = new Dano();
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String dateNow = now.format(formatterDate);
        String timeNow = now.format(formatterTime);
        
        dano.setData(dateNow);
        dano.setHora(timeNow);
        dano.setDescricao(descricao);
        dano.setMaquina(maquina);
        
        daoDano.create(dano);
    }
}
