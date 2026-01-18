package Manager;

import DAO.ClienteDao;
import DAO.DaoManager;
import DAO.OperadorDao;
import DAO.UtilizacaoDao;
import Entidade.Cliente;
import Entidade.Operador;
import Entidade.Utilizacao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import main.Main;

/**
 *
 * @author kovalek
 */
public class UtilizacaoManager {
    private DaoManager daoManager = Main.daoManager;
    
    public void iniciarRegistroDeUtilizacao(int idCliente, int idOperador){//idOperador esta com idAtendente no documento
        ClienteDao daoCliente = daoManager.getClienteDao();
        Cliente cliente = daoCliente.retrive(idCliente);
        
        OperadorDao daoOperador = daoManager.getOperadorDao();
        Operador operador = daoOperador.retrive(idOperador);
        
        UtilizacaoDao utilizacaoDao = daoManager.getUtilizacaoDao();
        Utilizacao utilizacao = new Utilizacao();
        
        utilizacao.setCliente(cliente);
        utilizacao.setOperador(operador);
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String dateNow = now.format(formatterDate);
        String timeNow = now.format(formatterTime);
        
        utilizacao.setData(dateNow);
        utilizacao.setHoraDoRegistro(timeNow);
    }
    
    public void listarHistoricoDeUtilizacoes(int idCliente){
        UtilizacaoDao dao = daoManager.getUtilizacaoDao();
        List<String> aux = dao.listar();
        for(int i = 0; i < aux.size(); i++){
            if(Integer.parseInt(aux.get(i).split(";")[1]) == idCliente) System.out.println(aux.get(i));;
        }
        
    }
}
