package app.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {

    // files are expected to be located in resources directory
    public static List<String[]> getListFromFile(String filename){
        try{
            InputStream file = getFile(filename);
            return readFile(file);
        } catch (Exception e){
            System.out.println("Error in processing the file!\n");
            e.printStackTrace();
            return null;
        }
    }

    private static List<String[]> readFile(InputStream file) throws IOException {
        List<String[]> values = new ArrayList<>();
        String line;

        // src: https://www.baeldung.com/java-csv-file-array
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file))){
            // skip first line
            br.readLine();
            while((line = br.readLine()) != null){
                String[] arr = line.split(",");
                values.add(arr);
            }
        }

        return values;
    }

    // src: https://mkyong.com/java/java-read-a-file-from-resources-folder/
    private static InputStream getFile(String filename) throws URISyntaxException {
        return CSVReader.class.getClassLoader().getResourceAsStream(filename);
    }
}
