package com.ufrn.imd.pcv;

import java.util.ArrayList;
import java.util.List;

import static com.ufrn.imd.pcv.Utils.lerEntrada;

public class InsercaoMaisBarata {
    public static void main(String[] args) {
        double[][] matriz = lerEntrada(48, "km");

        // Cidade inicial (indexada por 0)
        int cidadeInicial = 0;

        // Resolver o problema do caixeiro viajante com Inserção Mais Barata
        List<Integer> caminho = resolverPCVInsercaoMaisBarata(matriz, cidadeInicial);

        // Exibir o caminho percorrido e o custo total
        System.out.println("Caminho percorrido: " + caminho);
        System.out.println("Custo total: " + calcularCusto(matriz, caminho));
    }

    public static List<Integer> resolverPCVInsercaoMaisBarata(double[][] matriz, int cidadeInicial) {
        int n = matriz.length;
        List<Integer> caminho = new ArrayList<>();
        List<Integer> naoVisitadas = new ArrayList<>();

        // Inicializar as cidades não visitadas
        for (int i = 0; i < n; i++) {
            if (i != cidadeInicial) {
                naoVisitadas.add(i);
            }
        }

        // Começar com uma rota inicial contendo apenas a cidade inicial
        caminho.add(cidadeInicial);
        caminho.add(cidadeInicial); // Fechar o ciclo de volta à cidade inicial

        while (!naoVisitadas.isEmpty()) {
            int melhorCidade = -1;
            int melhorPosicao = -1;
            double menorCustoAdicional = Double.MAX_VALUE;

            // Para cada cidade não visitada
            for (int cidade : naoVisitadas) {
                // Testar todas as posições possíveis para inserção
                for (int pos = 0; pos < caminho.size() - 1; pos++) {
                    int cidadeA = caminho.get(pos);
                    int cidadeB = caminho.get(pos + 1);

                    // Calcular o custo adicional de inserir a cidade
                    double custoAdicional = matriz[cidadeA][cidade] + matriz[cidade][cidadeB] - matriz[cidadeA][cidadeB];

                    // Verificar se é a melhor inserção até agora
                    if (custoAdicional < menorCustoAdicional) {
                        menorCustoAdicional = custoAdicional;
                        melhorCidade = cidade;
                        melhorPosicao = pos;
                    }
                }
            }

            // Inserir a melhor cidade na melhor posição
            caminho.add(melhorPosicao + 1, melhorCidade);
            naoVisitadas.remove((Integer) melhorCidade);
        }

        return caminho;
    }

    // Método para calcular o custo total do caminho
    public static double calcularCusto(double[][] matriz, List<Integer> caminho) {
        double custoTotal = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            custoTotal += matriz[caminho.get(i)][caminho.get(i + 1)];
        }
        return custoTotal;
    }

    public static double rodarInsercaoMaisBarata(int entradaArquivo, int cidadeInicial, String tipo) {

        double[][] matriz = lerEntrada(entradaArquivo, tipo);

        // Resolver o problema do caixeiro viajante com Inserção Mais Barata
        List<Integer> caminho = resolverPCVInsercaoMaisBarata(matriz, cidadeInicial);

        // Exibir o caminho percorrido e o custo total
        System.out.println("Caminho percorrido: " + caminho);
        System.out.println("Custo total: " + calcularCusto(matriz, caminho));

        return  calcularCusto(matriz, caminho);
    }
}
