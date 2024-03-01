package utilities;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCSV {


    public String toCSV(String data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public List<String> openCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/jose/workspace/acelera-zg/todo-list/src/repositories/TarefasRepository.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\n");
                records.add(Arrays.asList(values));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }


    public void givenDataArray_whenConvertToCSV_thenOutputCreated(List<String> dataLines) throws IOException {
        File csvOutputFile = new File("/home/jose/workspace/acelera-zg/todo-list/src/repositories/TarefasRepository.csv");;
        try (PrintWriter pw = new PrintWriter(String.valueOf(csvOutputFile))) {
            dataLines.stream()
                    .map(this::toCSV)
                    .forEach(pw::println);
        }

    }

}
