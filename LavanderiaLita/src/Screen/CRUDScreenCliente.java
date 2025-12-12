package Screen;

import DAO.ClienteDao;
import Entidade.Cliente;
import main.Main;

/**
 *
 * @author kovalek
 */
public class CRUDScreenCliente extends Screen implements IScreen{
    private Cliente objAux = new Cliente();
            
    @Override
    public void initScreen(String[] args) {
        screenMode = SCREENMODE.CRUD;
        ClienteDao clienteDao = Main.daoManager.getClienteDao();
        
        options = (clienteDao.listarAtributos() + ";<< Terminar E Salvar >>;<< Sair Sem Salvar >>").split(";");
        comandsOptions = new Runnable[]{
            this::editId,
            this::editNome,
            this::editCpf_cnpj,
            this::editEndereco,
            this::editEmail,
            this::editSenha,
            this::finish,
            this::exit
        };
        
        abliteRawMode();
    }
    
    private void editId(){
        String id = readLine(options[0] + " >> ");
        try {
            int idInt = Integer.parseInt(id);
            //Para verificar se existe chave primaria repetida
            if(Main.daoManager.getClienteDao().retrive(idInt) != null){
                printErrorSatyEnter("O ID já existe, tente outo numero");
            }
            objAux.setId(idInt);
        } catch (Exception e) {
            printErrorSatyEnter("ID invalido, tente um numero");
        }
    }
    private void editNome(){
        String nome = readLine(options[1] + " >> ");
        objAux.setNome(nome);
    }
    private void editCpf_cnpj(){
        String cpf_cnpj = readLine(options[2] + " >> ");
        objAux.setCpf_cnpj(cpf_cnpj);
    }
    private void editEndereco(){
        String endereco = readLine(options[3] + " >> ");
        objAux.setEndereco(endereco);
    }
    private void editEmail(){
        String email = readLine(options[4] + " >> ");
        objAux.setEmail(email);
    }
    private void editSenha(){
        String senha = readLine(options[5] + " >> ");
        objAux.setSenha(senha);
    }
    private void finish(){
        ClienteDao clienteDao = Main.daoManager.getClienteDao();
        if(clienteDao.retrive(objAux.getId()) == null){
            clienteDao.create(objAux);
            isRunScreen = false;
        }else{
            /*
            System.out.println("\r" + objAux.toString());
            System.out.println("\r" + clienteDao.retrive(objAux.getId()));
            for(String s : clienteDao.listar()){
                System.out.println("\r" + s);
            }
            */
            printErrorSatyEnter("Existe Cliente com essa chave primaria");
        }
    }
    private void exit(){
        isRunScreen = false;
    }
    
    @Override
    protected void printMenu() {
        System.out.print("\033[H\033[2J"); // limpa terminal
        System.out.flush();
        logoLita();
        System.out.println("");
        System.out.println("\r================================================");
        System.out.println("\r   *Cadastrar Cliente");
        System.out.println("\r================================================");
        String[] aux = (objAux.toString()).split(";");
        String str = "";
        for(int i = 0; i < aux.length; i++){
            if(!aux[i].equals("null")) str = options[i] + " -> " + aux[i];
            else str = options[i];
            printField(str,i);
        }
        for(int i = aux.length; i < options.length; i++){
            printField(options[i], i);
        }
        System.out.println("\r");
    }
}
