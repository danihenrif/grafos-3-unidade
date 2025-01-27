package com.ufrn.imd.pcv;

import com.ufrn.imd.ExcelToMatrix;

import java.util.List;

public class Utils {
    public static double[][] lerEntradaKM() {
        // Caminho do arquivo XLSX
        String filePath = "pcv/src/entradas/48/km.xlsx";

        // Carregar a matriz do arquivo Excel
        ExcelToMatrix.loadMatrixFromExcel(filePath);

        // Acessar e utilizar a matriz estática
        double[][] matrix = ExcelToMatrix.matrix;

        return matrix;
    }

    public static double[][] lerEntradaMin() {
        // Caminho do arquivo XLSX
        String filePath = "pcv/src/entradas/48/km.xlsx";

        // Carregar a matriz do arquivo Excel
        ExcelToMatrix.loadMatrixFromExcel(filePath);

        // Acessar e utilizar a matriz estática
        double[][] matrix = ExcelToMatrix.matrix;

        return matrix;
    }

    public static double calcularCusto(double[][] matriz, List<Integer> caminho) {
        double custoTotal = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            custoTotal += matriz[caminho.get(i)][caminho.get(i + 1)];
        }
        return custoTotal;
    }
}
