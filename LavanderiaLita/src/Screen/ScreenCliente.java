package Screen;

/**
 *
 * @author kovalek
 */
public class ScreenCliente extends Screen implements IScreen{
    
    private String username = "";
    
    @Override
    public void initScreen(String[] args) {
        options = new String[] {"Option 1", "Option 2", "Option 3", "Option 4", "Exit"};
        
        comandsOptions = new Runnable[] {
            this::comandTest,
            this::comandTest,
            this::comandTest,
            this::comandTest,
            this::comandTest
        };
        
        username = args[0];
        
        abliteRawMode();
    }
    
    protected void printMenu(){
        System.out.print("\033[H\033[2J"); // limpa terminal
        System.out.flush();
        logoLita();
        System.out.println("");
        System.out.println("\r=======================================================");
        System.out.println("\r   *Seja bem vindo %s".formatted(username));
        System.out.println("\r   *Escolha a opção");
        System.out.println("\r=======================================================");
        for(int i = 0; i < options.length; i++){
            if(numOp == i) System.out.println("\r>>> " + options[i]);
            else System.out.println("\r    " + options[i]);
        }
    }
    
    private void comandTest(){
        System.out.println("\r Teste");
    }
    
    
    
    
}
