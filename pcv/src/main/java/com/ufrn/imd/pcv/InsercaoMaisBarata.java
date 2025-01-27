package com.ufrn.imd.pcv;

import com.ufrn.imd.ExcelToMatrix;
import java.util.List;

public class InsercaoMaisBarata {
    public static void main(String[] args) {
        // Caminho do arquivo XLSX
        String filePath = "src/entradas/km.xlsx";

        // Carregar a matriz do arquivo Excel
        ExcelToMatrix.loadMatrixFromExcel(filePath);

        // Acessar e utilizar a matriz estática
        double[][] matrix = ExcelToMatrix.matrix;

        // Cidade inicial (indexada por 0)
        int cidadeInicial = 0;

        // Resolver o problema do caixeiro viajante com Inserção Mais Barata
        List<Integer> caminho = PcvInsercaoMaisBarata.resolverPCVInsercaoMaisBarata(matrix, cidadeInicial);

        // Exibir o caminho percorrido e o custo total
        System.out.println("Caminho percorrido: " + caminho);
        System.out.println("Custo total: " + PcvInsercaoMaisBarata.calcularCusto(matrix, caminho));
    }
}
