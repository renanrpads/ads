/* 

            SENAI FATESG
            ADS 1º PERIODO (02.19)
            SITUAÇÃO DE APRENDIZAGEM
            PROF.: UJEFERSON
            ALUNOS: ANTHONY | DANIEL ELYADES | FLAVIO DANILO | MARCOS JOB




*/
package virtual_pot;

import java.util.Scanner;

public class Virtual_POT {

    public static void main(String[] args) {

//------------------------------------------------------------------------------
//                              SELECAO RECEITA
//------------------------------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        boolean valida = true;
        int receita = 0;

        System.out.print("Bem-vindo(a) ao Virtual POT 1.0\n\n");

        System.out.println("Qual receita iremos analisar?\n\n"
                + "[1] Leite ninho com morangos\n"
                + "[2] Dois amores\n"
                + "[3] Maracuja\n");

        while (valida) {
            try {
                System.out.print("RESPOSTA: ");
                receita = Integer.parseInt(sc.nextLine());

                while (receita < 1 || receita > 3) {
                    System.out.println("Entrada invalida! "
                            + "Tente novamente!");
                    System.out.print("RESPOSTA: ");
                    receita = Integer.parseInt(sc.nextLine());
                }
                valida = false;

            } catch (Exception e) {
                System.out.println("Entrada invalida! "
                        + "Tente novamente!");
            }
        }

//------------------------------------------------------------------------------
//                                RECEITA 1
//------------------------------------------------------------------------------        
        if (receita == 1) {

            // cadatro dos itens da receita
            String[] itensRec1 = {"Açucar (gramas)", "Margarina (gramas)",
                "Ovos (unidades)", "Farinha de trigo com fermento (gramas)",
                "Leite condensado (gramas)", "Creme de leite (gramas)",
                "Leite ninho (gramas)", "Morangos (unidades)",
                "Potes (unidades)"};

            // parametro para calcular qtd de potes
            double[] minExtRec1 = {300, 300, 4, 300, 600, 600, 600, 20, 15};

            // sugestão de receita padrão para 15 potes
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n"
                    + "|  LEITE NINHO COM MORANGOS                      |\n"
                    + "|  ***Sugestão de medidas para 15 potes          |\n"
                    + "|                                                |\n"
                    + "|  Açucar -------------------------- 300 gramas  |\n"
                    + "|  Margarina gelada ---------------- 300 gramas  |\n"
                    + "|  Ovos médios --------------------- 04 unidades |\n"
                    + "|  Farinha de trigo com fermento --- 300 gramas  |\n"
                    + "|  Leite condensado ---------------- 600 gramas  |\n"
                    + "|  Creme de leite ------------------ 600 gramas  |\n"
                    + "|  Leite ninho --------------------- 600 gramas  |\n"
                    + "|  Morangos ------------------------ 20 unidades |\n"
                    + "|  Potes --------------------------- 15 unidades |\n"
                    + "|                                                |\n");
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n\n");

            // entrada de medidas e custos
            int item = 0, entradas = 2;
            double custoCompra = 0;
            double[][] scRec1 = new double[entradas][itensRec1.length];
            System.out.println("INFORME AS MEDIDAS E O CUSTO (POR ITEM)");
            for (int col = 0; col < itensRec1.length; col++) {

                System.out.println("----------------------------------------"
                        + "----------");
                System.out.println(itensRec1[item]);

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Medida: ");
                        scRec1[0][col] = sc.nextDouble();

                        while (scRec1[0][col] < minExtRec1[item]) {
                            System.out.print("A Medida informada"
                                    + " está abaixo do necessário.");
                            System.out.print("\nTente novamente! ");
                            System.out.printf("Medida mínima desse item "
                                    + "= %.0f.\n", minExtRec1[item]);

                            System.out.print("Medida: ");
                            scRec1[0][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Custo(R$): ");
                        scRec1[1][col] = sc.nextDouble();

                        while (scRec1[1][col] < 0) {
                            System.out.println("***Entrada invalida! "
                                    + "Tente novamente!");
                            System.out.print("Custo(R$): ");
                            scRec1[1][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }
                item++;
                custoCompra += scRec1[1][col];
            }

            // calcula qtd de potes possivel por item
            double[] qtdPOT = new double[itensRec1.length];
            for (int col = 0; col < itensRec1.length; col++) {
                qtdPOT[col] = scRec1[0][col] / minExtRec1[col] * 15;
            }

            // calcula menor qtd de potes para utilizar como referência
            double menor = qtdPOT[0];
            for (int col = 1; col < itensRec1.length; col++) {
                if (qtdPOT[col] < menor) {
                    menor = qtdPOT[col];
                }
            }

            // informa ao usuario a qtd de potes possiveis e o custo
            System.out.println("----------------------------------------"
                    + "----------");
            int menorInt = (int) menor;
            System.out.print("Essas medidas rendem " + menorInt + " potes\n");
            System.out.printf("Custo total = R$ %.2f\n", custoCompra);
            System.out.printf("Custo por pote = R$ %.2f\n", (custoCompra / menor));

            if (custoCompra / menor > 2.0) {
                System.out.println("ATENÇÃO: O custo excedeu o limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            } else {
                System.out.println("LEGAL!!! O custo está dentro do limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            }

            // solicita projetado valor de venda (por pote)
            double vlrVndProj = 0;
            valida = true;
            while (valida) {
                try {
                    System.out.print("Qual o valor de venda pretendito"
                            + " (por pote)? ");
                    vlrVndProj = sc.nextDouble();
                    while (vlrVndProj < 0) {
                        System.out.println("Entrada inválida! Tente novamente");
                        System.out.print("Qual o valor de venda pretendito"
                                + " (por pote)? ");
                        vlrVndProj = sc.nextDouble();
                    }
                    valida = false;
                } catch (Exception e) {
                    System.out.println("***Entrada invalida! "
                            + "Tente novamente!");
                }
                sc.nextLine(); // resetBuffer
            }

            // saida final
            System.out.println("----------------------------------------"
                    + "----------");
            System.out.printf("Valor de venda estimado = R$ %.2f\n",
                    vlrVndProj * menorInt);

            if (vlrVndProj * menorInt - custoCompra <= 0) {
                System.out.print("Lucro inviável!");
            } else {
                System.out.printf("Lucro estimado = R$ %.2f\n",
                        vlrVndProj * menorInt - custoCompra);
                System.out.print("Lucro estimado (%) = ");
                System.out.printf("%.0f",
                        (((vlrVndProj * menorInt) - custoCompra) / custoCompra)
                        * 100);
                System.out.print("%");

            }
            System.out.println("\n----------------------------------------"
                    + "----------");
        }
//------------------------------------------------------------------------------
//                                RECEITA 2
//------------------------------------------------------------------------------        
        if (receita == 2) {

            // cadatro dos itens da receita
            String[] itensRec2 = {"Açucar (gramas)", "Margarina (gramas)",
                "Ovos (unidades)", "Farinha de trigo com fermento (gramas)",
                "Leite condensado (gramas)", "Creme de leite (gramas)",
                "Chocolate em PÓ (gramas)", "Potes (unidades)"};

            // parametro para calcular qtd de potes
            double[] minExtRec2 = {300, 300, 4, 300, 600, 600, 600, 15};

            // sugestão de receita padrão para 15 potes
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n"
                    + "|                                                |\n"
                    + "|  DOIS AMORES                                   |\n"
                    + "|  ***Sugestão de medidas para 15 potes          |\n"
                    + "|                                                |\n"
                    + "|  Açucar -------------------------- 300 gramas  |\n"
                    + "|  Margarina gelada ---------------- 300 gramas  |\n"
                    + "|  Ovos médios --------------------- 04 unidades |\n"
                    + "|  Farinha de trigo com fermento --- 300 gramas  |\n"
                    + "|  Leite condensado ---------------- 600 gramas  |\n"
                    + "|  Creme de leite ------------------ 600 gramas  |\n"
                    + "|  Chocolate em pó ----------------- 600 gramas  |\n"
                    + "|  Potes --------------------------- 15 unidades |\n"
                    + "|                                                |\n"
                    + "|  OBS.: Caso informe medidas diferentes iremos  |\n"
                    + "|  calcular e informar a qtd de potes viáveis.   |\n");
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n\n");

            // entrada de medidas e custos
            int item = 0, entradas = 2;
            double custoCompra = 0;
            double[][] scRec2 = new double[entradas][itensRec2.length];
            System.out.println("INFORME AS MEDIDAS E O CUSTO (POR ITEM)");
            for (int col = 0; col < itensRec2.length; col++) {

                System.out.println("----------------------------------------"
                        + "----------");
                System.out.println(itensRec2[item]);

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Medida: ");
                        scRec2[0][col] = sc.nextDouble();

                        while (scRec2[0][col] < minExtRec2[item]) {
                            System.out.print("A Medida informada"
                                    + " está abaixo do necessário.");
                            System.out.print("\nTente novamente! ");
                            System.out.printf("Medida mínima desse item "
                                    + "= %.0f.\n", minExtRec2[item]);

                            System.out.print("Medida: ");
                            scRec2[0][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Custo(R$): ");
                        scRec2[1][col] = sc.nextDouble();

                        while (scRec2[1][col] < 0) {
                            System.out.println("***Entrada invalida! "
                                    + "Tente novamente!");
                            System.out.print("Custo(R$): ");
                            scRec2[1][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }
                item++;
                custoCompra += scRec2[1][col];
            }

            // calcula qtd de potes possivel por item
            double[] qtdPOT = new double[itensRec2.length];
            for (int col = 0; col < itensRec2.length; col++) {
                qtdPOT[col] = scRec2[0][col] / minExtRec2[col] * 15;
            }

            // calcula menor qtd de potes para utilizar como referência
            double menor = qtdPOT[0];
            for (int col = 1; col < itensRec2.length; col++) {
                if (qtdPOT[col] < menor) {
                    menor = qtdPOT[col];
                }
            }

            // informa ao usuario a qtd de potes possiveis e o custo
            System.out.println("----------------------------------------"
                    + "----------");
            int menorInt = (int) menor;
            System.out.print("Essas medidas rendem " + menorInt + " potes\n");
            System.out.printf("Custo total = R$ %.2f\n", custoCompra);
            System.out.printf("Custo por pote = R$ %.2f\n", (custoCompra / menor));

            if (custoCompra / menor > 2.0) {
                System.out.println("ATENÇÃO: O custo excedeu o limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            } else {
                System.out.println("LEGAL!!! O custo está dentro do limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            }

            // solicita projetado valor de venda (por pote)
            double vlrVndProj = 0;
            valida = true;
            while (valida) {
                try {
                    System.out.print("Qual o valor de venda pretendito"
                            + " (por pote)? ");
                    vlrVndProj = sc.nextDouble();
                    while (vlrVndProj < 0) {
                        System.out.println("Entrada inválida! Tente novamente");
                        System.out.print("Qual o valor de venda pretendito"
                                + " (por pote)? ");
                        vlrVndProj = sc.nextDouble();
                    }
                    valida = false;
                } catch (Exception e) {
                    System.out.println("***Entrada invalida! "
                            + "Tente novamente!");
                }
                sc.nextLine(); // resetBuffer
            }

            // saida final
            System.out.println("----------------------------------------"
                    + "----------");
            System.out.printf("Valor de venda estimado = R$ %.2f\n",
                    vlrVndProj * menorInt);

            if (vlrVndProj * menorInt - custoCompra <= 0) {
                System.out.print("Lucro inviável!");
            } else {
                System.out.printf("Lucro estimado = R$ %.2f\n",
                        vlrVndProj * menorInt - custoCompra);
                System.out.print("Lucro estimado (%) = ");
                System.out.printf("%.0f",
                        (((vlrVndProj * menorInt) - custoCompra) / custoCompra)
                        * 100);
                System.out.print("%");

            }
            System.out.println("\n----------------------------------------"
                    + "----------");
        }
//------------------------------------------------------------------------------
//                                RECEITA 3
//------------------------------------------------------------------------------        
        if (receita == 3) {

            // cadatro dos itens da receita
            String[] itensRec3 = {"Açucar (gramas)", "Margarina (gramas)",
                "Ovos (unidades)", "Farinha de trigo com fermento (gramas)",
                "Suco de maracuja (ml)", "Amido de milho (gramas)",
                "Água (ml)", "Leite (ml)", "Manteiga (gramas)",
                "Potes (unidades)"};

            // parametro para calcular qtd de potes
            double[] minExtRec3 = {500, 300, 10, 300, 480, 20, 250, 200, 50, 15};

            // sugestão de receita padrão para 15 potes
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n"
                    + "|                                                |\n"
                    + "|  MARACUJÁ                                      |\n"
                    + "|  ***Sugestão de medidas para 15 potes          |\n"
                    + "|                                                |\n"
                    + "|  Açucar -------------------------- 500 gramas  |\n"
                    + "|  Margarina gelada ---------------- 300 gramas  |\n"
                    + "|  Ovos médios --------------------- 10 unidades |\n"
                    + "|  Farinha de trigo com fermento --- 300 gramas  |\n"
                    + "|  Suco de maracujá ---------------- 480 ml      |\n"
                    + "|  Amido de milho ------------------ 20  gramas  |\n"
                    + "|  Água ---------------------------- 250 ml      |\n"
                    + "|  Leite --------------------------- 200 ml      |\n"
                    + "|  Manteiga ------------------------ 50 gramas   |\n"
                    + "|  Potes --------------------------- 15 unidades |\n"
                    + "|                                                |\n"
                    + "|  OBS.: Caso informe medidas diferentes iremos  |\n"
                    + "|  calcular e informar a qtd de potes viáveis.   |\n");
            System.out.print("* ---------------------------------------------- *");
            System.out.print("\n\n");

            // entrada de medidas e custos
            int item = 0, entradas = 2;
            double custoCompra = 0;
            double[][] scRec3 = new double[entradas][itensRec3.length];
            System.out.println("INFORME AS MEDIDAS E O CUSTO (POR ITEM)");
            for (int col = 0; col < itensRec3.length; col++) {

                System.out.println("----------------------------------------"
                        + "----------");
                System.out.println(itensRec3[item]);

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Medida: ");
                        scRec3[0][col] = sc.nextDouble();

                        while (scRec3[0][col] < minExtRec3[item]) {
                            System.out.print("A Medida informada"
                                    + " está abaixo do necessário.");
                            System.out.print("\nTente novamente! ");
                            System.out.printf("Medida mínima desse item "
                                    + "= %.0f.\n", minExtRec3[item]);

                            System.out.print("Medida: ");
                            scRec3[0][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }

                valida = true;
                while (valida) {
                    try {
                        System.out.print("Custo(R$): ");
                        scRec3[1][col] = sc.nextDouble();

                        while (scRec3[1][col] < 0) {
                            System.out.println("***Entrada invalida! "
                                    + "Tente novamente!");
                            System.out.print("Custo(R$): ");
                            scRec3[1][col] = sc.nextDouble();
                        }
                        valida = false;

                    } catch (Exception e) {
                        System.out.println("***Entrada invalida! "
                                + "Tente novamente!");
                    }
                    sc.nextLine(); // resetBuffer
                }
                item++;
                custoCompra += scRec3[1][col];
            }

            // calcula qtd de potes possivel por item
            double[] qtdPOT = new double[itensRec3.length];
            for (int col = 0; col < itensRec3.length; col++) {
                qtdPOT[col] = scRec3[0][col] / minExtRec3[col] * 15;
            }

            // calcula menor qtd de potes para utilizar como referência
            double menor = qtdPOT[0];
            for (int col = 1; col < itensRec3.length; col++) {
                if (qtdPOT[col] < menor) {
                    menor = qtdPOT[col];
                }
            }

            // informa ao usuario a qtd de potes possiveis e o custo
            System.out.println("----------------------------------------"
                    + "----------");
            int menorInt = (int) menor;
            System.out.print("Essas medidas rendem " + menorInt + " potes\n");
            System.out.printf("Custo total = R$ %.2f\n", custoCompra);
            System.out.printf("Custo por pote = R$ %.2f\n", (custoCompra / menor));

            if (custoCompra / menor > 2.0) {
                System.out.println("ATENÇÃO: O custo excedeu o limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            } else {
                System.out.println("LEGAL!!! O custo está dentro do limite da regra\n"
                        + "REGRA: não ultrapassar custo de R$ 2,00 por pote");
                System.out.println("----------------------------------------"
                        + "----------");
            }

            // solicita projetado valor de venda (por pote)
            double vlrVndProj = 0;
            valida = true;
            while (valida) {
                try {
                    System.out.print("Qual o valor de venda pretendito"
                            + " (por pote)? ");
                    vlrVndProj = sc.nextDouble();
                    while (vlrVndProj < 0) {
                        System.out.println("Entrada inválida! Tente novamente");
                        System.out.print("Qual o valor de venda pretendito"
                                + " (por pote)? ");
                        vlrVndProj = sc.nextDouble();
                    }
                    valida = false;
                } catch (Exception e) {
                    System.out.println("***Entrada invalida! "
                            + "Tente novamente!");
                }
                sc.nextLine(); // resetBuffer
            }

            // saida final
            System.out.println("----------------------------------------"
                    + "----------");
            System.out.printf("Valor de venda estimado = R$ %.2f\n",
                    vlrVndProj * menorInt);

            if (vlrVndProj * menorInt - custoCompra <= 0) {
                System.out.print("Lucro inviável!");
            } else {
                System.out.printf("Lucro estimado = R$ %.2f\n",
                        vlrVndProj * menorInt - custoCompra);
                System.out.print("Lucro estimado (%) = ");
                System.out.printf("%.0f",
                        (((vlrVndProj * menorInt) - custoCompra) / custoCompra)
                        * 100);
                System.out.print("%");

            }
            System.out.println("\n----------------------------------------"
                    + "----------");
        }
    }
}
