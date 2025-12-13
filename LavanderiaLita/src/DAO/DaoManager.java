package DAO;

/**
 *
 * @author kovalek
 */
public class DaoManager {
    
    private static ClienteDao clienteDao;
    private static DocumentoDePagamentoDao documentoDePagamentoDao;
    private static FeedbackDao feedbackDao;
    private static ItemDePacoteDao itemDePacoteDao;
    private static ItemDeServicoDao itemDeServicoDao;
    private static MaquinaDao maquinaDao;
    private static OperadorDao operadorDao;
    private static PacoteDao pacoteDao;
    private static SaldoDao saldoDao;
    private static ServicoDao servicoDao;
    private static UtilizacaoDao utilizacaoDao;
    private static DanoDao danoDao;
    
    public DaoManager(){
        initDaos();
    }
    
    private void initDaos(){
        clienteDao = new ClienteDao();
        clienteDao.initDao();
        
        documentoDePagamentoDao = new DocumentoDePagamentoDao();
        documentoDePagamentoDao.initDao();

        feedbackDao = new FeedbackDao();
        feedbackDao.initDao();

        itemDePacoteDao = new ItemDePacoteDao();
        itemDePacoteDao.initDao();

        itemDeServicoDao = new ItemDeServicoDao();
        itemDeServicoDao.initDao();

        maquinaDao = new MaquinaDao();
        maquinaDao.initDao();

        operadorDao = new OperadorDao();
        operadorDao.initDao();

        pacoteDao = new PacoteDao();
        pacoteDao.initDao();

        saldoDao = new SaldoDao();
        saldoDao.initDao();

        servicoDao = new ServicoDao();
        servicoDao.initDao();

        utilizacaoDao = new UtilizacaoDao();
        utilizacaoDao.initDao();
        
        danoDao = new DanoDao();
        danoDao.initDao();
    }
    
    public void endDaos(){
        clienteDao.closeDao();
        documentoDePagamentoDao.closeDao();
        feedbackDao.closeDao();
        itemDePacoteDao.closeDao();
        itemDeServicoDao.closeDao();
        maquinaDao.closeDao();
        operadorDao.closeDao();
        pacoteDao.closeDao();
        saldoDao.closeDao();
        servicoDao.closeDao();
        utilizacaoDao.closeDao();
        danoDao.closeDao();
    }
    
    public ClienteDao getClienteDao(){
        return clienteDao;
    }

    public static DocumentoDePagamentoDao getDocumentoDePagamentoDao() {
        return documentoDePagamentoDao;
    }

    public static FeedbackDao getFeedbackDao() {
        return feedbackDao;
    }

    public static ItemDePacoteDao getItemDePacoteDao() {
        return itemDePacoteDao;
    }

    public static ItemDeServicoDao getItemDeServicoDao() {
        return itemDeServicoDao;
    }

    public static MaquinaDao getMaquinaDao() {
        return maquinaDao;
    }

    public static OperadorDao getOperadorDao() {
        return operadorDao;
    }

    public static PacoteDao getPacoteDao() {
        return pacoteDao;
    }

    public static SaldoDao getSaldoDao() {
        return saldoDao;
    }

    public static ServicoDao getServicoDao() {
        return servicoDao;
    }

    public static UtilizacaoDao getUtilizacaoDao() {
        return utilizacaoDao;
    }
    
    public static DanoDao getDanoDao(){
        return danoDao;
    }
    
}
