package tarleton.lab7;
import edu.tarleton.caesarcipher.Caesar;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 *
 * @author Joe Meier
 * //<decrypt 3>
 */
public class Main {
        public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Command and shift size expected.");
            return;
        }    
        try {
            Path pc = Paths.get("input.txt");
            Charset cs = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(pc,cs);
            Caesar cc = new Caesar(Integer.parseInt(args[1]));
            try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                    new FileOutputStream("output.txt"),"UTF-8"))) {
                    for (String line : lines) {
                        if("encrypt".equals(args[0])){
                            out.printf("%s ",cc.encrypt(line));
                        }
                        else if("decrypt".equals(args[0])){
                            out.printf("%s ",cc.decrypt(line));
                        }
                        else{
                            System.out.println("encrypt or decrypt expected.");
                            return;
                        }  
                        out.println(); 
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
