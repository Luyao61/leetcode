import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> result = Question1.parseFile("file1.txt");

        for(String s : result){
            System.out.println(s);
        }

        String ans = Question2.parseFile("log2.txt");
        System.out.println(ans);


        /*
        Date start_time = new Date();
        String str = "(11/12/2015-02:34:56)";

        DateFormat df = new SimpleDateFormat("(MM/dd/yyyy-hh:mm:ss)");


        try {
            start_time = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        str = "(11/13/2015-02:34:56)";
        Date end_time = new Date();
        try {
            end_time = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long time_elapse = end_time.getTime();
        System.out.println(time_elapse);
        */

        //String str = "(01/01/2000-01:00:00) :: START";
        //String[] ans = str.split(" :: ");


    }
}
