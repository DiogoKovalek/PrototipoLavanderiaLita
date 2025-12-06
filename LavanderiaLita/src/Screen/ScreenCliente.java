package Screen;

import java.io.IOException;

/**
 *
 * @author kovalek
 */
public class ScreenCliente implements IScreen{
    private static String[] options = {"Option 1", "Option 2", "Option 3", "Option 4", "Exit"};
    private static int numOp = 0;
    
    private String username = "";
    @Override
    public void initScreen(String[] args) {
        username = args[0];
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
        switch (numOp) {
            case 0: comandTest(options[0]);break;
            case 1: comandTest(options[1]);break;
            case 2: comandTest(options[2]);break;
            case 3: comandTest(options[3]);break;
            case 4: comandTest(options[4]);break;
            default:
                throw new AssertionError();
        }
    }
    
    private void comandTest(String teste){
        System.out.println("\r" + teste);
    }
    
    private void printMenu(){
        System.out.print("\033[H\033[2J"); // limpa terminal
        System.out.flush();
        System.out.println("\r=======================================================");
        System.out.println("\rSeja bem vindo %s".formatted(username));
        System.out.println("\rEscolha a opção");
        System.out.println("\r=======================================================");
        for(int i = 0; i < options.length; i++){
            if(numOp == i) System.out.println("\r>>> " + options[i]);
            else System.out.println("\r    " + options[i]);
        }
    }
    
    // Linux/Mac – modo raw
    static void enableRawMode() throws IOException, InterruptedException {
        new ProcessBuilder("sh", "-c", "stty raw -echo </dev/tty").inheritIO().start().waitFor();
    }
    
    static void disableRawMode() throws IOException, InterruptedException {
        new ProcessBuilder("sh", "-c", "stty cooked echo </dev/tty").inheritIO().start().waitFor();
    }
}
