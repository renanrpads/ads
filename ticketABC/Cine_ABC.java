/* 
            SENAI FATESG
            ADS 1º PERIODO (02.19)
            PROJETO INTEGRADOR
            COORDENADOR PROJETO: BETE
            EQUIPE: MARCOS JOB | RENAN | WATLAS

 */
package cine_abc;

import java.util.Scanner;

public class Cine_ABC {

    public static void main(String[] args) {

//------------------------------------------------------------------------------
//                    CADASTRO DE POLTRONAS POR SESSÃO
//------------------------------------------------------------------------------        

        /*
Declarar 2 vetores referênciais linhas (A a J) e colunas (1 a 10)

Declarar 9 matrizes int para apresetação e seleção de poltrona
poltronas1, poltronas2, poltronas3, poltronas4, poltronas5, poltronas6
poltronas7, poltronas8, poltronas9

Incluir lógica para poltronas oculpadas 0 (inteira) e -1 (meia)

montar lógica para preencher aleatoriamente 20% de todas matrizes

         */
//------------------------------------------------------------------------------
//                               MENU MÓDULOS
//------------------------------------------------------------------------------        
        Scanner sc = new Scanner(System.in);
        boolean valida = true;
        int opcaoM = 0;

        System.out.print("Bem-vindo(a) ao CINE ABC\n\n");

        System.out.println("MENU:\n\n"
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
        if (opcaoM == 1) {

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
}