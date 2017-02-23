import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by luyao on 2/23/2017.
 */
public class Question2 {

    public static String parseFile(String filename)
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

        return connectedTime(allLines.toArray(new String[allLines.size()]));
    }

    public static String connectedTime(String[] file) {
        Set<String> actions = new HashSet<String>(Arrays.asList("START", "CONNECTED", "DISCONNECTED", "SHUTDOWN"));

        long total_time = 0;
        long start_time = 0;
        long connected_time = 0;
        long current_connection_start_time = 0;
        boolean isConnected = false;

        for (String line : file) {
            String[] time_event = line.split(" :: ");

            String time_str = time_event[0];
            String action = time_event[1];

            DateFormat df = new SimpleDateFormat("(MM/dd/yyyy-hh:mm:ss)");
            Date time = new Date();
            try {
                time = df.parse(time_str);
            } catch (ParseException e) {
                e.printStackTrace();
            }


            if(actions.contains(action)){
                switch (action) {
                    case "START":
                        start_time = time.getTime();
                        break;
                    case "CONNECTED":
                        isConnected = true;
                        current_connection_start_time = time.getTime();
                        break;
                    case "DISCONNECTED":
                        if (isConnected) {
                            connected_time += time.getTime() - current_connection_start_time;
                        }
                        isConnected = false;
                        break;
                    case "SHUTDOWN":
                        total_time += time.getTime() - start_time;
                        if (isConnected) {
                            connected_time += time.getTime() - current_connection_start_time;
                        }
                        isConnected = false;
                        break;
                }
            }
        }
        double ratio = (double)connected_time/total_time * 100;

        String ans = Integer.toString((int)ratio) + "%";

        return ans;
    }
}
