package gerenciadordememoria;

import java.util.Scanner;

/**
 *
 * @author Ícaro
 */
public class GerenciadorDeMemoria {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //ENDEREÇO INICIAL DA MEMÓRIA LIVRE & QUANTIDADE DE MEMÓRIA LIVRE
        listaLigada livre = new listaLigada();

        listaLigada alocada = new listaLigada();

        System.out.println("Digite a quantidade de memória desejada: ");
        int tamanho = ler.nextInt();
        livre.adicionaInicio(tamanho);

        int operacao;
        int id = 0;

        boolean executando = true;

        while (executando) {

            System.out.println("\n1 - Alocar memória");
            System.out.println("2 - Finalizar processo");
            System.out.println("3 - Situação atual da memória");
            System.out.println("4 - Encerrar simulação\n");

            System.out.println("Digite o número da operação: ");
            operacao = ler.nextInt();
            System.out.println("");

            switch (operacao) {
                case 1:
                    System.out.println("Digite a quantidade de memória necessária: ");
                    int memoria = ler.nextInt();
                    alocada.adicionaInicio(memoria);

                    System.out.println("O ID do processo é: " + id++);

                    if (tamanho - memoria >= 0) {
                        alocada.adicionaFim(id, memoria);
                        livre.getInicio().setElemento(tamanho - memoria);
                        tamanho = tamanho - memoria;
                    } else {
                        System.out.println("NÃO HÁ MEMÓRIA SUFICIENTE\nMemória disponível: " + tamanho);
                    }

                    break;

                case 2:
                    //Finaliza processo, libera memoria
                    if (!alocada.estaVazio()) {
                        System.out.println("Digite o ID do processo: ");
                        System.out.println(alocada.buscaRecursiva(id));
                        while (!alocada.buscaRecursiva(id)) {
                            System.out.println("Id inválido, tente novamente");
                            id = ler.nextInt();
                            System.out.println(alocada.buscaRecursiva(id));
                        }

                    } else {
                        System.out.println("Não há processos rodando!");
                    }
                    break;

                case 3:
                    System.out.println("Memória livre:");
                    System.out.println(livre.toString() + "\n");
                    System.out.println("Memória alocada e seus ID's:");
                    System.out.println(alocada.toString() + "\n");
                    System.out.print("Processos rodando: " + id++ + "\n");

                    break;

                case 4:
                    System.out.println("Simulação Finalizada!");
                    executando = false;
                    break;
            }
        }
    }
}
