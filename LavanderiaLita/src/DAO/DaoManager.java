package DAO;

/**
 *
 * @author kovalek
 */
public class DaoManager {
    
    private ClienteDao clienteDao;
    
    public DaoManager(){
        initDaos();
    }
    
    private void initDaos(){
        clienteDao = new ClienteDao();
        clienteDao.initDao();
    }
    
    private void endDaos(){
        clienteDao.closeDao();
    }
    
    public ClienteDao getClienteDao(){
        return clienteDao;
    }
}
