package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReader {

	public static Object[][] readCsvData(String filePath) {
        List<String[]> dataList = new ArrayList<>();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // Split elements by commas
                String[] row = line.split(",");
                dataList.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read targets within target CSV file path: " + filePath);
        }

        Object[][] dataMatrix = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            dataMatrix[i] = dataList.get(i);
        }
        return dataMatrix;
    }
}
