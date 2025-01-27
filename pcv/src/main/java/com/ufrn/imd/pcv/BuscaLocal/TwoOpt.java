package com.ufrn.imd.pcv.BuscaLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ufrn.imd.pcv.Utils.calcularCusto;

public class TwoOpt {
    public static List<Integer> reversaodeSubcaminho(List<Integer> solucao, double[][] distancia) {
        double melhorCusto = calcularCusto(distancia, solucao);
        int n = solucao.size();
        Random rand = new Random();

        // Escolhe dois índices aleatórios diferentes
        int i = rand.nextInt(n);
        int j = rand.nextInt(n);

        while (i == j || Math.abs(i - j) == 1 || Math.abs(i - j) == n - 1) {
            j = rand.nextInt(n);
        }

        // Garante que i seja menor que j
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        // Cria uma nova solução invertendo o subcaminho entre i e j
        List<Integer> novaSolucao = new ArrayList<>(solucao);
        int left = i;
        int right = j;

        while (left < right) {
            int temp = novaSolucao.get(left);
            novaSolucao.set(left, novaSolucao.get(right));
            novaSolucao.set(right, temp);
            left++;
            right--;
        }

        // Calcula o custo da nova solução
        double novoCusto = calcularCusto(distancia, novaSolucao);

        if (novoCusto < melhorCusto) {
            return novaSolucao;
        }

        return solucao;
    }
}
