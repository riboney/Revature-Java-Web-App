package app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {

    // files are expected to be located in resources directory
    public static List<String[]> getListFromFile(String filename){
        try{
            File file = getFile(filename);
            return readFile(file);
        } catch (Exception e){
            System.out.println("Error in processing the file!\n");
            e.printStackTrace();
            return null;
        }
    }

    private static List<String[]> readFile(File file) throws IOException {
        List<String[]> values = new ArrayList<>();
        String line;

        // src: https://www.baeldung.com/java-csv-file-array
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
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
    private static File getFile(String filename) throws URISyntaxException {
        URL fileURL = CSVReader.class.getClassLoader().getResource(filename);
        return new File(fileURL.toURI());
    }
}
