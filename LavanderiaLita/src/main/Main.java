package main;

import Screen.IScreen;
import Screen.ScreenCliente;
import java.util.Scanner;

/**
 *
 * @author kovalek
 */
public class Main {
    public static void main(String[] args) {
        // -h -> Mostra os Comandos
        // -c <Username> -p <Senha> -> Loga como cliente
        // -c <Username> --ask -> Loga como cliente depois de perguntar a senha
        // -f <Username> -p <Senha> -> Loga como funcioanário
        // -f <Username> --ask -> Loga como funcionário depois de perguntar a senha
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        
        switch (args[0]) {
            case "-h":
                System.out.println("-h -> Mostra os Comandos\n" +
                                   "-c <Username> -p <Senha> -> Loga como cliente\n" +
                                   "-c <Username> --ask -> Loga como cliente depois de perguntar a senha\n" +
                                   "-f <Username> -p <Password> -> Loga como funcioanário\n" +
                                   "-f <Username> --ask -> Loga como funcionário depois de perguntar a senha");
                break;
            case "-c":
                String username = "";
                String password = "";
                username = args[1];
                if(args[2].equals("-p")) password = args[3];
                else if(args[2].equals("--ask")){
                    Scanner sc = new Scanner(System.in);
                    password = sc.nextLine();
                    sc.close();
                }else{
                    System.out.println("Ops, something it`s wrong. try the comand -h for check the comand list.");
                    break;
                }
                // Check User
                // Method for search the user
                
                //Before aproved
                IScreen screen = new ScreenCliente();
                screen.initScreen(new String[] {username});
                break;
            case "-f":    
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
