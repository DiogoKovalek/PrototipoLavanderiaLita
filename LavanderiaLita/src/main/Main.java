package main;

import Screen.IScreen;
import Screen.ScreenCliente;
import Screen.ScreenFuncionario;
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
        
        /*//Para Debug
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        */
        String username = "";
        String password = "";
        IScreen screen;
        switch (args[0]) {
            case "-h":
                System.out.println("-h -> Mostra os Comandos\n" +
                                   "-c <Username> -p <Senha> -> Loga como cliente\n" +
                                   "-c <Username> --ask -> Loga como cliente depois de perguntar a senha\n" +
                                   "-f <Username> -p <Password> -> Loga como funcioanário\n" +
                                   "-f <Username> --ask -> Loga como funcionário depois de perguntar a senha");
                break;
            case "-c":
                username = args[1];
                try{
                    if(args[2].equals("-p")) password = args[3];
                    else if(args[2].equals("--ask")){
                        Scanner sc = new Scanner(System.in);
                        password = sc.nextLine();
                        sc = null; // desabilitar scanner
                    }else{
                        System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                        break;
                    }
                }catch(Exception e){
                    System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                    break;
                }
                // Check User
                // Method for search the user
                
                //Before aproved
                screen = new ScreenCliente();
                screen.initScreen(new String[] {username});
                break;
            case "-f":
                username = args[1];
                try{
                    if(args[2].equals("-p")) password = args[3];
                    else if(args[2].equals("--ask")){
                        Scanner sc = new Scanner(System.in);
                        password = sc.nextLine();
                        sc = null; // desabilitar scanner
                    }else{
                        System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                        break;
                    }
                }catch(Exception e){
                    System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                    break;
                }
                // Check User
                // Method for search the user
                
                //Before aproved
                screen = new ScreenFuncionario();
                screen.initScreen(new String[] {username});
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
}
