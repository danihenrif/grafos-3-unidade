package com.ufrn.imd;

import javax.swing.*;

import static com.ufrn.imd.pcv.Guloso.rodarGuloso;
import static com.ufrn.imd.pcv.InsercaoMaisBarata.rodarInsercaoMaisBarata;
import static com.ufrn.imd.pcv.Grasp.rodarGrasp;

public class Main {
    public static void main(String[] args) {
        int entradaArquivo = 6; // 6, 7, 12, 24, 36 ou 48
        String tipo = "km"; // "km" ou "min"
        int cidadeInicial = 0; // Cidade inicial para o IMB e Guloso usar como base
        int qtdBusca = 100; // Quantidade de vezes que o Grasp vai buscar o melhor algoritmo

        double somaMelhoresCusto = 0;
        int quantidade = 30;

        for (int i = 0; i < quantidade; i++) {
            /*--------------------------------- Inserção Mais Barata  ---------------------------------*/
            somaMelhoresCusto += rodarInsercaoMaisBarata(entradaArquivo, cidadeInicial, tipo);

            /*--------------------------------- Guloso  ---------------------------------*/
            //somaMelhoresCusto += rodarGuloso(entradaArquivo, cidadeInicial, tipo);

            /*--------------------------------- Grasp  ---------------------------------*/
           // somaMelhoresCusto += rodarGrasp(entradaArquivo, qtdBusca, tipo);
        }

        System.out.println("/------------------------------------------------------------------/");
        System.out.println("Média de melhores custos: " + somaMelhoresCusto/quantidade);
    }
}
