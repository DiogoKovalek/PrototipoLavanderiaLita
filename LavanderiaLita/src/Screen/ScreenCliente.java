package Screen;

/**
 *
 * @author kovalek
 */
public class ScreenCliente extends Screen implements IScreen{
    
    private String username = "";
    
    @Override
    public void initScreen(String[] args) {
        options = new String[] {"Feedback", "Exit"};
        
        comandsOptions = new Runnable[] {
            this::feedback,
            this::exit
        };
        
        username = args[1];
        
        abliteRawMode();
    }
    
    protected void printMenu(){
        System.out.print("\033[H\033[2J"); // limpa terminal
        System.out.flush();
        logoLita();
        System.out.println("");
        System.out.println("\r================================================");
        System.out.println("\r   *Seja bem vindo %s".formatted(username));
        System.out.println("\r   *Escolha a opção");
        System.out.println("\r================================================");
        for(int i = 0; i < options.length; i++){
            if(numOp == i) System.out.println("\r>>> " + options[i]);
            else System.out.println("\r    " + options[i]);
            printField(username, i);
        }
    }
    
    private void feedback(){
        System.out.println("\r Teste");
    }
    
    private void exit(){
        isRunScreen = false;
    }
    
    
}
