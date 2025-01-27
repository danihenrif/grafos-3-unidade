package com.ufrn.imd.pcv;

import com.ufrn.imd.ExcelToMatrix;

public class guloso {
    public static void main(String[] args) {
        // Caminho do arquivo XLSX
        String filePath = "src/entradas/km.xlsx";

        // Carregar a matriz do arquivo Excel
        ExcelToMatrix.loadMatrixFromExcel(filePath);

        // Acessar e utilizar a matriz estática
        double[][] matrix = ExcelToMatrix.matrix;


    }
}
