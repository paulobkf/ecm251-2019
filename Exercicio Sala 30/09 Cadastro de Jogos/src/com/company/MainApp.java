package com.company;

import com.company.model.Jogo;
import com.company.model.SingletonJogosDAO;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private Scanner scanner;
    private List<Jogo> jogos;
    private Jogo jogo;
    public MainApp(){
        scanner = new Scanner(System.in);
    }

    public void mainLoop(){
        while(true){
            menu();
            int op = scanner.nextInt();
            if(op == 0)
                break;
            else
                avaliarOp(op);
            }
        }

    private void avaliarOp(int op) {
        switch (op){
            case 1:
                jogos = SingletonJogosDAO.getInstance().getAll();
                for(Jogo j: jogos){
                    System.out.print("ID: " + j.getId());
                    System.out.println(" Nome: " + j.nome);
                    System.out.println(" Gênero: " + j.genero);
                    System.out.println(" Plataforma: " + j.plataforma);
                    System.out.println(" Lançamento: " + j.lancamento);
                }
                break;
            case 2:
                String nome, genero, plataforma, lancamento;
                System.out.println("Informe:");
                System.out.println("Nome: ");
                nome = scanner.next();
                System.out.println("Genero: ");
                genero = scanner.next();
                System.out.println("Plataforma: ");
                plataforma = scanner.next();
                System.out.println("Lançamento: ");
                lancamento = scanner.next();

                Jogo jogo = new Jogo(nome,genero,plataforma,lancamento);
                SingletonJogosDAO.getInstance().insertGame(jogo);
                break;
            case 3:
                System.out.println("Informe o nome: ");
                nome = scanner.next();
                jogo = SingletonJogosDAO.getInstance().getJogo(nome);
                if(jogo == null){
                    System.out.println("Jogo não cadastrado");
                } else{
                    System.out.print("ID: " + jogo.getId());
                    System.out.println(" Nome: " + jogo.nome);
                    System.out.println(" Gênero: " + jogo.genero);
                    System.out.println(" Plataforma: " + jogo.plataforma);
                    System.out.println(" Lançamento: " + jogo.lancamento);
                }
                break;
            case 4:
                System.out.println("Informe o nome:");
                nome = scanner.next();
                jogo = SingletonJogosDAO.getInstance().getJogo(nome);
                if(jogo == null){
                    System.out.println("Jogo não cadastrado");
                } else{
                    System.out.print("ID: " + jogo.getId());
                    System.out.println(" Nome: " + jogo.nome);
                    System.out.println(" Gênero: " + jogo.genero);
                    System.out.println(" Plataforma: " + jogo.plataforma);
                    System.out.println(" Lançamento: " + jogo.lancamento);
                    System.out.println("Qual campo atualizar? ");
                    System.out.println("1 - NOME");
                    System.out.println("2 - GENERO");
                    System.out.println("3 - PLATAFORMA");
                    System.out.println("4 - LANCAMENTO");
                    op = scanner.nextInt();
                    System.out.println("Novo valor: ");
                    String temp = scanner.next();
                    switch (op){
                        case 1:
                            jogo.nome = temp;
                            break;
                        case 2:
                            jogo.genero = temp;
                            break;
                        case 3:
                            jogo.plataforma = temp;
                            break;
                        case 4:
                            jogo.lancamento = temp;
                            break;
                    }
                    if (SingletonJogosDAO.getInstance().updateGame(jogo))
                        System.out.println("Atualizado com Sucesso");
                    else
                        System.out.println("Falha na atualização");
                }
                break;
            case 5:
                System.out.println("Informe o nome: ");
                nome = scanner.next();
                SingletonJogosDAO.getInstance().deleteGame(nome);
                break;
        }
    }

    private void menu() {
        System.out.println("1 - Exibir Tudos");
        System.out.println("2 - Cadastrar Jogo");
        System.out.println("3 - Pesquisar");
        System.out.println("4- Atualizar");
        System.out.println("5- Deletar");
        System.out.println("0 - Sair");
    }

}



