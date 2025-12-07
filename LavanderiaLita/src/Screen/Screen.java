package Screen;

import static Screen.ScreenCliente.disableRawMode;
import static Screen.ScreenCliente.enableRawMode;
import java.io.IOException;

/**
 *
 * @author kovalek
 */
public abstract class Screen {
    protected String[] options = {};
    protected Runnable[] comandsOptions;
    protected int numOp = 0;
    
    protected void abliteRawMode(){
        try{    
            enableRawMode();
            try{
                runMenu();
            }finally{
                disableRawMode();
            }
        }catch (IOException | InterruptedException ex){ // enable e disable RawMode gerao execoes
            System.out.println("Erro ao manipular o rawMode no terminal");
        }
    }
    
    private void runMenu() throws IOException{
        while(true){
            printMenu();
            int key = System.in.read(); // Leitura do teclado
            // seta cima e baixo sao caracteres especiais
            // seta cima  -> 27, 91, 65
            // seta baixo -> 27, 91, 66
            if(key == 27){ //Caractere Especial
                if(System.in.available() > 0 && System.in.read() == 91){
                    int arrow = System.in.read();
                    if(arrow == 65){ //UP
                        int next = numOp - 1;
                        numOp = next < 0 ? options.length - 1 : next;
                    }else if(arrow == 66){ //Down
                        int next = numOp + 1;
                        numOp = next > options.length - 1 ? 0 : next;
                    }
                }
            }else if(key == 10 || key == 13){ // ENTER
                executeComand();
                break;
            }
            
        }
    }
    
    private void executeComand(){
        comandsOptions[numOp].run();
    }
    
    protected void logoLita(){
        System.out.println("\r|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>|");
        System.out.println("\r|       _        _  * _______    _______     * |");
        System.out.println("\r|  *   | |      | |  |__   __|  |  ___ *|      |");
        System.out.println("\r|      | |      | |     | |     | |   | |      |");
        System.out.println("\r|    * | |      | |     | |     | |___| |  *   |");
        System.out.println("\r|      | |___   | |  *  | |     |  ___  |      |");
        System.out.println("\r|      |_____|  |_|     |_|  *  |_|   |_|      |");
        System.out.println("\r|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>|");
    }
    
    
    // Linux/Mac – modo raw
    static void enableRawMode() throws IOException, InterruptedException {
        new ProcessBuilder("sh", "-c", "stty raw -echo </dev/tty").inheritIO().start().waitFor();
    }
    
    static void disableRawMode() throws IOException, InterruptedException {
        new ProcessBuilder("sh", "-c", "stty cooked echo </dev/tty").inheritIO().start().waitFor();
    }
    
    protected abstract void printMenu();
}
