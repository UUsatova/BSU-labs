
import java.io.*;
import java.util.Scanner;
public class FileWorker {
        private String fileName;

        public FileWorker(String fileName){

            this.fileName = fileName;

        }

        public StringBuilder read() throws IOException{

            StringBuilder text = new StringBuilder();

            try (Scanner scanner = new Scanner(new File(fileName))) {
            
                while (scanner.hasNextLine()){
                text.append( scanner.nextLine());
                text.append("\n");
                }
            
            } 
            return text;

        }

        public void writer(String str) throws IOException{
                try(FileWriter writer = new FileWriter(fileName, false))
            {
                writer.write(str);
            }
            

        }

        public static void main(String args[]) {}
     
}
