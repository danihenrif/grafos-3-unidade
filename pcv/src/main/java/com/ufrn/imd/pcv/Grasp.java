package com.ufrn.imd.pcv;

import com.ufrn.imd.ExcelToMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ufrn.imd.pcv.BuscaLocal.Swap.trocaDeVizinhos;
import static com.ufrn.imd.pcv.Utils.calcularCusto;
import static com.ufrn.imd.pcv.Utils.lerEntradaKM;

public class Grasp {
    public static void main(String[] args) {
        double[][] matrix = lerEntradaKM();

        //Quantas vezes o grasp vai buscar a melhor solução
        int qtdBusca = 100;

        Grasp(matrix, qtdBusca);

    }

    public static void Grasp(double[][] distancia, int qtdBuscarMelhorSolução) {
        List<Integer> melhorSolucao = new ArrayList<>();
        double melhorCusto = Double.MAX_VALUE;

        for (int i = 0; i < qtdBuscarMelhorSolução; i++) {
            List<Integer> solucao = solucaoAleatoria(distancia);

            solucao = trocaDeVizinhos(solucao, distancia);

            double custo = calcularCusto(distancia, solucao);

            if (custo < melhorCusto) {
                melhorCusto = custo;
                melhorSolucao = new ArrayList<>(solucao);
            }
        }

        System.out.println("Solução: " + melhorSolucao.toString());
        System.out.println("Melhor custo: " + melhorCusto);
    }

    private static List<Integer> solucaoAleatoria(double[][] distancia) {
        int tam = distancia.length;
        List<Integer> naoVisitados = new ArrayList<Integer>();
        for (int i = 0; i < tam; i++) {
            naoVisitados.add(i);
        }

        List<Integer> solucao = new ArrayList<>();
        Random random = new Random();

        int cidadeAtual = random.nextInt(tam);
        solucao.add(cidadeAtual);
        naoVisitados.remove(Integer.valueOf(cidadeAtual));

        while (!naoVisitados.isEmpty()) {
            List<Integer> listaCandidatos = new ArrayList<>();
            double custoMin = Double.MAX_VALUE;
            double custoMax = Double.MIN_VALUE;

            for(int cidade : naoVisitados) {
                double custo = distancia[cidadeAtual][cidade];
                if(custo < custoMin) custoMin = custo;
                if(custo > custoMax) custoMax = custo;
            }

            for (int cidade : naoVisitados) {
                double custo = distancia[cidadeAtual][cidade];
                if (custo <= custoMin + 0.3 * (custoMax - custoMin)) {
                    listaCandidatos.add(cidade);
                }
            }

            int proximaCidade = listaCandidatos.get(random.nextInt(listaCandidatos.size()));
            solucao.add(proximaCidade);
            naoVisitados.remove(Integer.valueOf(proximaCidade));
            cidadeAtual = proximaCidade;
        }

        return solucao;
    }
}
