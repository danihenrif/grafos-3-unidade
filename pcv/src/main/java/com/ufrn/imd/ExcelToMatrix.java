package com.ufrn.imd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelToMatrix {
    public static void main(String[] args) {
        String filePath = "src/repositorios/min.xlsx";  // Substitua pelo caminho do seu arquivo
        try {
            // Abrir o arquivo XLSX
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // Lê a primeira aba da planilha

            // Determinar o número de linhas e colunas
            int numRows = sheet.getPhysicalNumberOfRows();
            Row firstRow = sheet.getRow(0);
            int numCols = firstRow.getPhysicalNumberOfCells();

            // Criar uma matriz com o tamanho da planilha
            double[][] matrix = new double[numRows][numCols];

            // Preencher a matriz com os valores da planilha
            for (int i = 0; i < numRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                matrix[i][j] = cell.getNumericCellValue();  // Armazena como double
                                break;
                            case STRING:
                                // Caso precise de strings, você pode armazenar valores como String, ou ignorar
                                // matrix[i][j] = Double.parseDouble(cell.getStringCellValue());  // Caso queira tentar converter para double
                                break;
                            case BOOLEAN:
                                // Se você precisa de valores booleanos, trate como boolean, por exemplo:
                                // matrix[i][j] = cell.getBooleanCellValue() ? 1.0 : 0.0;  // Convertendo para 1 ou 0
                                break;
                            default:
                                matrix[i][j] = 0.0;  // Caso a célula não tenha valor, atribui 0
                                break;
                        }
                    }
                }
            }

            // Exibir a matriz
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }

            // Fechar o arquivo
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
