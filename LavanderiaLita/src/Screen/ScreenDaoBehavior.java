package Screen;

/**
 *
 * @author kovalek
 */
public class ScreenDaoBehavior<T> extends Screen implements IScreen{
    
    @Override
    public void initScreen(String[] args) {
        
    }
    
    @Override
    protected void printMenu() {
        System.out.print("\033[H\033[2J"); // limpa terminal
        System.out.flush();
        System.out.println("");
        System.out.println("\r================================================");
        System.out.println("\r   *Cadastrar");
        System.out.println("\r================================================");
    }
}
