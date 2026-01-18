package main;

import DAO.DaoManager;
import Entidade.Cliente;
import Entidade.Operador;
import Manager.DanoManager;
import Manager.FeedbackManager;
import Manager.ItemDePacoteManager;
import Manager.ItemDeServicoManager;
import Manager.UtilizacaoManager;
import Screen.CRUDScreenCliente;
import Screen.IScreen;
import Screen.ScreenCliente;
import Screen.ScreenOperador;
import java.util.Scanner;

/**
 * 3
 *
 * @author kovalek
 */
public class Main {

    public static final DaoManager daoManager = new DaoManager();

    public static void main(String[] args) {
        // -h -> Mostra os Comandos
        // -c <Username> -p <Senha> -> Loga como cliente
        // -c <Username> --ask -> Loga como cliente depois de perguntar a senha
        // -s -> Cadastrar cliente\n
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
                System.out.println(
                        "-h -> Mostra os comandos\n"
                        + "-c <Username> -p <Senha> -> Loga como cliente\n"
                        + "-c <Username> --ask -> Loga como cliente depois de perguntar a senha\n"
                        + "-s -> Cadastrar cliente\n"
                        + "-f <Username> -p <Password> -> Loga como funcionário\n"
                        + "-f <Username> --ask -> Loga como funcionário depois de perguntar a senha\n"
                        + "\n"
                        + "Comandos de função (--func):\n"
                        + "--func interditarMaquina <idMaquina>\n"
                        + "--func relatarDano <idMaquina> <descricao>\n"
                        + "--func iniciarFeedback <idCliente>\n"
                        + "--func insereFeedback <idFeedback> <mensagem>\n"
                        + "--func selecionarPacote <idPacote> <quantidade>\n"
                        + "--func atualizarEstado <idItemDeServico> <estado>\n"
                        + "--func iniciarRegistroDeUtilizacao <idCliente> <idOperador>\n"
                        + "--func listarHistoricoDeUtilizacoes <idCliente>"
                );
                break;
            case "-c":
                username = args[1];
                try {
                    if (args[2].equals("-p")) {
                        password = args[3];
                    } else if (args[2].equals("--ask")) {
                        Scanner sc = new Scanner(System.in);
                        password = sc.nextLine();
                        sc = null; // desabilitar scanner
                    } else {
                        System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                    break;
                }
                // Check User
                // Method for search the user
                Cliente c = daoManager.getClienteDao().getUserPassword(username, password);

                if (c != null) {
                    //Before aproved
                    screen = new ScreenCliente();
                    screen.initScreen(new String[]{String.valueOf(c.getId()), username});
                } else {
                    System.out.println("Senha ouusuario invalido, tente novamente");
                }
                break;
            case "-f":
                username = args[1];
                try {
                    if (args[2].equals("-p")) {
                        password = args[3];
                    } else if (args[2].equals("--ask")) {
                        Scanner sc = new Scanner(System.in);
                        password = sc.nextLine();
                        sc = null; // desabilitar scanner
                    } else {
                        System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                    break;
                }
                // Check User
                Operador o = daoManager.getOperadorDao().getUserPassword(username, password);

                if (o != null) {
                    //Before aproved
                    screen = new ScreenOperador();
                    screen.initScreen(new String[]{String.valueOf(o.getId()), username});
                } else {
                    System.out.println("Senha ou usuario invalidos, tente novamente");
                }
                break;
            case "-s":
                screen = new CRUDScreenCliente();
                screen.initScreen(args);
                break;
            case "--func":
                initFunc(args);
                break;
            default:
                System.out.println("Ops, alguma coisa está errada, de o comando -h para listar os comandos");
                break;
        }
        //Finaliza e salva todos os DAOS
        daoManager.endDaos();
    }

    private static void initFunc(String[] aux) {
        String func = aux[1];
        DanoManager danoManager = new DanoManager();
        FeedbackManager feedbackManager = new FeedbackManager();
        ItemDePacoteManager itemDePacoteManager = new ItemDePacoteManager();
        ItemDeServicoManager itemDeServicoManager = new ItemDeServicoManager();
        UtilizacaoManager utilizacaoManager = new UtilizacaoManager();

        // interditarMaquina(int idMaquina)
        if (func.equals("interditarMaquina")) {
            int idMaquina = Integer.parseInt(aux[2]);
            danoManager.interditarMaquina(idMaquina);
        } // relatarDano(int idMaquina, String descricao)
        else if (func.equals("relatarDano")) {
            int idMaquina = Integer.parseInt(aux[2]);
            String descricao = aux[3];
            danoManager.relatarDano(idMaquina, descricao);
        } // iniciarFeedback(int idCliente)
        else if (func.equals("iniciarFeedback")) {
            int idCliente = Integer.parseInt(aux[2]);
            feedbackManager.iniciarFeedback(idCliente);
        } // insereFeedback(int idFeedback, String mensagem)
        else if (func.equals("insereFeedback")) {
            int idFeedback = Integer.parseInt(aux[2]);
            String mensagem = aux[3];
            feedbackManager.insereFeedback(idFeedback, mensagem);
        } // selecionarPacote(int idPacote, int quantidade)
        else if (func.equals("selecionarPacote")) {
            int idPacote = Integer.parseInt(aux[2]);
            int quantidade = Integer.parseInt(aux[3]);
            itemDePacoteManager.selecionarPacote(idPacote, quantidade);
        } // atualizarEstado(int idItemDeServico, String estado)
        else if (func.equals("atualizarEstado")) {
            int idItemDeServico = Integer.parseInt(aux[2]);
            String estado = aux[3];
            itemDeServicoManager.atualizarEstado(idItemDeServico, estado);
        } // iniciarRegistroDeUtilizacao(int idCliente, int idOperador)
        else if (func.equals("iniciarRegistroDeUtilizacao")) {
            int idCliente = Integer.parseInt(aux[2]);
            int idOperador = Integer.parseInt(aux[3]);
            utilizacaoManager.iniciarRegistroDeUtilizacao(idCliente, idOperador);
        } // listarHistoricoDeUtilizacoes(int idCliente)
        else if (func.equals("listarHistoricoDeUtilizacoes")) {
            int idCliente = Integer.parseInt(aux[2]);
            utilizacaoManager.listarHistoricoDeUtilizacoes(idCliente);
        } else {
            System.out.println("Função desconhecida: " + func);
        }
    }
}
