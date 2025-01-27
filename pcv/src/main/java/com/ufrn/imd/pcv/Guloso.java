package com.ufrn.imd.pcv;

import java.util.ArrayList;
import java.util.List;

import static com.ufrn.imd.pcv.Utils.calcularCusto;
import static com.ufrn.imd.pcv.Utils.lerEntradaKM;

public class Guloso {
    public static void main(String[] args) {
        int cidadeInicial = 0; // Cidade de início (indexada por 0)
        double[][] matrix = lerEntradaKM();

        List<Integer> caminho = resolverPCV(matrix, cidadeInicial);

        // Exibir o caminho percorrido
        System.out.println("Caminho percorrido: " + caminho);
        System.out.println("Custo total: " + calcularCusto(matrix, caminho));
    }

    public static List<Integer> resolverPCV(double[][] matriz, int cidadeInicial) {
        int n = matriz.length;
        boolean[] visitadas = new boolean[n]; // Marca as cidades já visitadas
        List<Integer> caminho = new ArrayList<>();

        int cidadeAtual = cidadeInicial;
        caminho.add(cidadeAtual);
        visitadas[cidadeAtual] = true;

        for (int i = 0; i < n - 1; i++) {
            int proximaCidade = -1;
            double menorDistancia = Double.MAX_VALUE;

            // Encontrar a cidade mais próxima que ainda não foi visitada
            for (int j = 0; j < n; j++) {
                if (!visitadas[j] && matriz[cidadeAtual][j] < menorDistancia) {
                    menorDistancia = matriz[cidadeAtual][j];
                    proximaCidade = j;
                }
            }

            cidadeAtual = proximaCidade;
            caminho.add(cidadeAtual);
            visitadas[cidadeAtual] = true;
        }

        caminho.add(cidadeInicial);
        return caminho;
    }
}
