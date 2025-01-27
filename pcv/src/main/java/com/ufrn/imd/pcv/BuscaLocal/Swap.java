package com.ufrn.imd.pcv.BuscaLocal;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.ufrn.imd.pcv.Utils.calcularCusto;

public class Swap {
    public static List<Integer> trocaDeVizinhos(List<Integer> solucao, double[][] distancia) {
        Random rand = new Random();
        List<Integer> solucaoNova = new java.util.ArrayList<>(solucao);
        int n = solucao.size();

        int i = rand.nextInt(n);
        int j = rand.nextInt(n);

        while (i == j) {
            j = rand.nextInt(n);
        }

        Collections.swap(solucaoNova, i, j);

        double custoAtual = calcularCusto(distancia, solucao);
        double custoNovo = calcularCusto(distancia, solucaoNova);

        if (custoNovo < custoAtual) return solucaoNova;

        return solucao;
    }

}
