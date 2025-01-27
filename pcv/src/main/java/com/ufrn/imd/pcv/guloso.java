package com.ufrn.imd;

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
