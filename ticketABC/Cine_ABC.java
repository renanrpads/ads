/* 
            SENAI FATESG
            ADS 1º PERIODO (02.19)
            PROJETO INTEGRADOR
            COORDENADOR PROJETO: ELISABETH
            EQUIPE: MARCOS JOB | RENAN | WATLAS

 */
package cine_abc;

import java.util.Random;
import java.util.Scanner;

public class Cine_ABC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // variáveis imutáveis
        String disponivel = "[ ]", meia = "[I]", inteira = "[M]";
        int maxLin = 10, maxCol = 10;

//------------------------------------------------------------------------------
//                GESTÃO DE POLTRONAS (CARGA INICIAL E ALTERAÇÕES)
//------------------------------------------------------------------------------        
        // Cadastro de poltronas sessão 1
        String[][] sessao1 = new String[maxLin][maxCol];
        char fileiras = 'A';
        int poltronas = 1;

        for (int lin = 0; lin < maxLin; lin++) {
            for (int col = 0; col < maxCol; col++) {
                if (col == 9) {
                    sessao1[lin][col] = String.valueOf(fileiras)
                            + String.valueOf(poltronas)
                            + disponivel;
                } else {
                    sessao1[lin][col] = String.valueOf(fileiras)
                            + "0"
                            + String.valueOf(poltronas)
                            + disponivel;
                }
                poltronas++;
                System.out.print(sessao1[lin][col] + "\t");
            }
            fileiras++;
            poltronas = 1;
            System.out.println("");
        }

        // Escolha de poltronas aleatória (20%)        
        int limInfTipo = 1, limSupTipo = 2;
        int tipoIngresso = sorteiaTipo(limInfTipo, limSupTipo);

        /*
        System.out.println("Informe o código da poltrona que deseja reservar:");
        String poltrona = "";
        poltrona = sc.nextLine();

        // reserva de poltrona
        for (int lin = 0; lin < maxLin; lin++) {
            for (int col = 0; col < maxCol; col++) {
                if (sessao1[col][lin].equals(poltrona + disponivel)) {
                    if (tipoIngresso == 1) {
                        sessao1[col][lin] = poltrona + inteira;
                    } else {
                        sessao1[col][lin] = poltrona + meia;
                    }
                }
            }
        } */

 /*   
        algoritimo para comparar entre legendas
        if (p1[1][1].substring(3).equals("[DIS.]")) {
            System.out.println("OK");
        } */
        // LEGENDAS
        // O código da poltrona é composto por 3 caractéres 
        // letra da fileira + Nº da poltrona com 2 casas decimais (exemplo: A01)
        // [**DIS] = POLTRONA DISPONÍVEL , 
        // [--MEI] = POLTRONA OCULPADA (INGRESSO MEIA)
        // [--INT] = POLTRONA OCULPADA (INGRESSO INTEIRA)
//------------------------------------------------------------------------------
//                               MENU MÓDULOS
//------------------------------------------------------------------------------        
        boolean valida = true;
        int opcaoM = 0;

        System.out.print(
                "Bem-vindo(a) ao CINE ABC\n\n");

        System.out.println(
                "MENU:\n\n"
                + "[1] Vendas de ingressos\n"
                + "[2] Histórico de ingressos\n"
                + "[3] Relatórios\n"
                + "[4] Sair\n");

        while (valida) {
            try {
                System.out.print("RESPOSTA: ");
                opcaoM = Integer.parseInt(sc.nextLine());

                while (opcaoM < 1 || opcaoM > 4) {
                    System.out.println("Entrada invalida! "
                            + "Tente novamente!");
                    System.out.print("RESPOSTA: ");
                    opcaoM = Integer.parseInt(sc.nextLine());
                }
                valida = false;

            } catch (Exception e) {
                System.out.println("Entrada invalida! "
                        + "Tente novamente!");
            }
        }

//------------------------------------------------------------------------------
//                                MENU SESSÕES
//------------------------------------------------------------------------------          
        if (opcaoM
                == 1) {

            // cadatro das sessões
            int opcaoS = 0;
            System.out.println(""
                    + "__________________________________________________________________\n"
                    + "MANHÃ\n"
                    + "[1] SALA A | AS PANTERAS | 118 MIN | DUB | 14 ANOS\n"
                    + "[2] SALA B | MALEVOLA - DONA DO MAL | 120 MIN | DUB | 10 ANOS\n"
                    + "[3] SALA C | TURMA DA MÔNICA - LAÇOS | 118 MIN | DUB | 14 ANOS\n"
                    + "__________________________________________________________________\n"
                    + "TARDE\n"
                    + "[4] SALA A | HEBE - A ESTRELA DO BRASIL | 122 MIN | DUB | 14 ANOS\n"
                    + "[5] SALA B | VAI QUE COLA - O COMEÇO | 88 MIN | DUB | 12 ANOS\n"
                    + "[6] SALA C | CORINGA | 16 ANOS | 121 MIN | LEG\n"
                    + "__________________________________________________________________\n"
                    + "NOITE\n"
                    + "[7] SALA A | MUSSUN, UM FILME DO CACILDIS | 75 MIN | DUB | 10 ANOS\n"
                    + "[8] SALA B | OS PARÇAS 2 | 97 MIN | DUB | 12 ANOS\n"
                    + "[9] SALA C | BATE CORAÇÃO | 94 MIN | DUB | 12 ANOS\n"
                    + "__________________________________________________________________\n"
            );

            while (valida) {
                try {
                    System.out.print("RESPOSTA: ");
                    opcaoS = Integer.parseInt(sc.nextLine());

                    while (opcaoS < 1 || opcaoS > 9) {
                        System.out.println("Entrada invalida! "
                                + "Tente novamente!");
                        System.out.print("RESPOSTA: ");
                        opcaoS = Integer.parseInt(sc.nextLine());
                    }
                    valida = false;

                } catch (Exception e) {
                    System.out.println("Entrada invalida! "
                            + "Tente novamente!");
                }
            }
        }

//------------------------------------------------------------------------------
//                             ESCOLHA POLTRONAS
//------------------------------------------------------------------------------          
        /* 

Desenvolver template (IF == 1) M. JOB / WATLAS 
Replicar para os demais modelos (edição vinculo matriz) WATLAS

         */
    }

    public static int sorteiaTipo(int limInfTipo, int limSupTipo) {
        Random rd = new Random();
        return rd.nextInt(limSupTipo - limInfTipo + 1) + limInfTipo;

    }

    public static int sorteiaPoltrona(int limInfTipo, int limSupTipo) {
        Random rd = new Random();
        return rd.nextInt(limSupTipo - limInfTipo + 1) + limInfTipo;

    }

}
