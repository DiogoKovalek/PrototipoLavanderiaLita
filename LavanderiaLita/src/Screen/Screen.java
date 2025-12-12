package Screen;

import static Screen.ScreenCliente.disableRawMode;
import static Screen.ScreenCliente.enableRawMode;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kovalek
 */
public abstract class Screen {
    
    protected String[] options = {};
    protected Runnable[] comandsOptions;
    protected int numOp = 0;

    protected SCREENMODE screenMode = SCREENMODE.SELECT;
    
    protected boolean isRunScreen = true;
    
    private Scanner sc = new Scanner(System.in);

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
        printMenu();
        int next;
        while(isRunScreen){
            KEYBOARD key = readKey();
            
            if (key != KEYBOARD.DEFAULT) {
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
                        isRunScreen = false;
                        break;
                    case KEY_ESC:
                        executeComand();
                        isRunScreen = false;
                        break;
                }
                printMenu();
            }
        }
    }

    private void runScreenModeCRUD() throws IOException {
        printMenu();
        int next;
        while(isRunScreen){
            KEYBOARD key = readKey();
            
            if (key != KEYBOARD.DEFAULT) {
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
                        break;
                    case KEY_ESC:
                        executeComand();
                        isRunScreen = false;
                        break;
                }
                printMenu();
            }
        }
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
            } else if (ch == 10 || ch == 13) {
                return KEYBOARD.KEY_ENTER;
            }
        }
        return KEYBOARD.DEFAULT;
    }
    
    protected void printField(String text, int index) {
        if (index == numOp) System.out.println("\r>>> " + text);
        else System.out.println("\r    " + text);
    }

    protected String readLine(String msg) {
        disableRawModeSilently(); // para usar Scanner normalmente

        System.out.print("\r:" + msg);
        String value = sc.nextLine();

        enableRawModeSilently(); // volta ao modo raw
        return value;
    }
    
    protected void printErrorSatyEnter(String msg){
        System.out.println("\r" + msg);
        System.out.println("\rPrescione enter para continuar");
        
        sc.next();
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

    private void disableRawModeSilently() {
        try {
            disableRawMode();
        } catch (Exception ignored) {
        }
    }

    private void enableRawModeSilently() {
        try {
            enableRawMode();
        } catch (Exception ignored) {
        }
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
