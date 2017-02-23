import java.io.*;

import java.util.*;

/**
 * Created by luyao on 2/22/2017.
 */
public class Question1 {


    public static List<String> parseFile(String filename)
            throws FileNotFoundException, IOException {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines);
    }


    public static List<String> parseLines(List<String> allLines) {

        String start_point = null;
        String dest_point = null;

        HashMap<String, List<String>> graph  = new HashMap<>();

        for (String line: allLines) {
            if (!line.contains(":")) {
                start_point = line.split(" ")[0];
                dest_point = line.split(" ")[1];
            }
            else{
                String start = line.split(":")[0].trim();
                String[] dest_s = line.split(":")[1].trim().split(" ");

                List<String> dest_list = Arrays.asList(dest_s);
                graph.put(start, dest_list);
            }
        }

        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        if (start_point != null && dest_point != null) {
            findAllPaths(start_point, dest_point, graph, visited, result, sb);
        }
        return result;

    }

    public static void findAllPaths (String curr_point, String end_point, HashMap<String, List<String>> graph, Set<String> visited, List<String> result, StringBuilder path){
        StringBuilder currentPath = new StringBuilder(path);

        currentPath.append(curr_point);
        visited.add(curr_point);

        if (curr_point.equals(end_point)) {
           result.add(currentPath.toString());
        } else {
            List<String> neighbors = graph.get(curr_point);

            if (neighbors != null) {
               for (String v : neighbors) {
                   if (!visited.contains(v)) {
                       findAllPaths(v, end_point, graph, visited, result, currentPath);
                   }
               }
            }
        }
        visited.remove(curr_point);
    }
}
