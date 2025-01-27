package com.ufrn.imd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelToMatrix {

    // Matriz estática que pode ser acessada globalmente
    public static double[][] matrix;

    // Método para carregar a matriz a partir do arquivo XLSX
    public static void loadMatrixFromExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            // Determinar o número de linhas e colunas
            int numRows = sheet.getPhysicalNumberOfRows();
            Row firstRow = sheet.getRow(0);
            int numCols = firstRow.getPhysicalNumberOfCells();

            // Inicializar a matriz estática
            matrix = new double[numRows][numCols];

            // Preencher a matriz com os valores da planilha
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                matrix[i][j] = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                matrix[i][j] = cell.getBooleanCellValue() ? 1.0 : 0.0;
                                break;
                            default:
                                matrix[i][j] = 0.0; // Preencher com 0.0 se a célula for vazia ou incompatível
                                break;
                        }
                    }
                }
            }

            // Fechar recursos
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }
}
