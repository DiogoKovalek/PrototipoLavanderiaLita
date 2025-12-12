package DAO;

/**
 *
 * @author kovalek
 */
public class DaoManager {
    
    private static ClienteDao clienteDao;
    
    public DaoManager(){
        initDaos();
    }
    
    private void initDaos(){
        clienteDao = new ClienteDao();
        clienteDao.initDao();
    }
    
    public void endDaos(){
        clienteDao.closeDao();
    }
    
    public ClienteDao getClienteDao(){
        return clienteDao;
    }
}
