package DAO;

/**
 *
 * @author kovalek
 */
public class DaoManager {
    
    private ClienteDao clienteDao;
    
    public DaoManager(){
        clienteDao = new ClienteDao();
    }
    
    public ClienteDao getClienteDao(){
        return clienteDao;
    }
}
