package Manager;

import DAO.ClienteDao;
import DAO.DaoManager;
import DAO.FeedbackDao;
import Entidade.Cliente;
import Entidade.Feedback;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import main.Main;

/**
 *
 * @author kovalek
 */
public class FeedbackManager {
    
    private DaoManager daoManager = Main.daoManager;
    
    public void iniciarFeedback(int idCliente){
        ClienteDao clienteDao = daoManager.getClienteDao();
        Cliente cliente = clienteDao.retrive(idCliente);
        
        FeedbackDao feedbackDao = daoManager.getFeedbackDao();
        Feedback feedback = new Feedback();
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String dateNow = now.format(formatterDate);
        String timeNow = now.format(formatterTime);
        
        feedback.setData(dateNow);
        feedback.setHora(timeNow);
        feedback.setCliente(cliente);
        
        feedbackDao.create(feedback);
    }
    
    public void insereFeedback(int idFeedback, String mensagem){
        FeedbackDao dao = daoManager.getFeedbackDao();
        Feedback feedback = dao.retrive(idFeedback);
        feedback.setMensagem(mensagem);
        dao.update(dao.retrive(idFeedback), feedback); // é apenas a maneira que eu gosto de fazer
    }
}
