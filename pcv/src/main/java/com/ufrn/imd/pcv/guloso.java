package com.ufrn.imd;

public class guloso {
    public static void main(String[] args) {
        // Caminho do arquivo XLSX
        String filePath = "src/entradas/km.xlsx";

        // Carregar a matriz do arquivo Excel
        ExcelToMatrix.loadMatrixFromExcel(filePath);

        // Acessar e utilizar a matriz estática
        double[][] matrix = ExcelToMatrix.matrix;

        // Exibir a matriz (exemplo de uso)
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("A matriz não foi carregada.");
        }
    }
}
