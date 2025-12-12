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

    protected SCREENMODE screenMode = SCREENMODE.SELECT;

    protected void abliteRawMode() {
        try {
            enableRawMode();
            try {
                runMenu();
            } finally {
                disableRawMode();
            }
        } catch (IOException | InterruptedException ex) { // enable e disable RawMode gerao execoes
            System.out.println("Erro ao manipular o rawMode no terminal");
        }
    }

    private void runMenu() throws IOException {
        switch (screenMode) {
            case SCREENMODE.SELECT:
                runScreenModeSelect();
                break;
            case SCREENMODE.CRUD:
                runScreenModeCRUD();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void runScreenModeSelect() throws IOException {
        while (true) {
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
            
            /*
            KEYBOARD key = readKey();
            int next;
            if(key != KEYBOARD.DEFAULT){
                switch (key) {
                    case KEY_UP:
                        next = numOp - 1;
                        numOp = next < 0 ? options.length - 1 : next;
                        break;
                    case KEY_DOWN:
                        next = numOp + 1;
                        numOp = next > options.length - 1 ? 0 : next;
                        break;
                    case KEY_ENTER:
                        executeComand();
                        System.out.println("Executa comando 1");
                        break;
                    case KEY_ESC:
                        executeComand();
                        System.out.println("Executa comando 2");
                        break;
                }
                printMenu();
            }
            */
        }
    }

    private void runScreenModeCRUD() {

    }

    private void executeComand() {
        comandsOptions[numOp].run();
    }

    private KEYBOARD readKey() throws IOException {
        if (System.in.available() > 0) { // Verifica se ha bytes de leitura
            int ch = System.in.read();
            // Leitura do teclado
            // seta cima e baixo sao caracteres especiais
            // seta cima  -> 27, 91, 65
            // seta baixo -> 27, 91, 66
            if (ch == 27) { // ESC
                if (System.in.read() == 91) {
                    int code = System.in.read();
                    if (code == 65) {
                        return KEYBOARD.KEY_UP;
                    }
                    if (code == 66) {
                        return KEYBOARD.KEY_DOWN;
                    }
                }
                return KEYBOARD.KEY_ESC;
            }
            else if (ch == 10 || ch == 13) {
                return KEYBOARD.KEY_ENTER;
            }
        }
        return KEYBOARD.DEFAULT;
    }

    protected void logoLita() {
        System.out.println("\r|>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>|");
        System.out.println("\r|       _        _  * _______    _______     * |");
        System.out.println("\r|  *   | |      | |  |__   __|  |  ___ *|      |");
        System.out.println("\r|      | |      | |     | |     | |   | |      |");
        System.out.println("\r|    * | |      | |     | |     | |___| |  *   |");
        System.out.println("\r|      | |___   | |  *  | |     |  ___  |      |");
        System.out.println("\r|      |_____|  |_|     |_|  *  |_|   |_|      |");
        System.out.println("\r|    *                                         |");
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

enum SCREENMODE {
    SELECT,
    CRUD
}

enum KEYBOARD {
    DEFAULT,
    KEY_UP,
    KEY_DOWN,
    KEY_ESC,
    KEY_ENTER
}
