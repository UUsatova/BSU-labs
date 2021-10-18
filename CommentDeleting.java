import java.io.IOException;
import java.util.*;
public class Laba4 {

    private StringBuilder text;
    private String fileName;
   
    public  Laba4 (String fileName){

         text = new StringBuilder();
         this.fileName = fileName;
        
    }

    public String getText(){
        return text.toString();
    }

    public void textReading() throws IOException{
        
        FileWorker fr = new FileWorker(fileName);
        text = fr.read();

    }

    public void commentsDeleting(){
        char a = '*';

        int i = 0;
        while(i < text.length()){
            //a = text.charAt(i);

            if(text.charAt(i) == '"')  {
                i++;
                //a = text.charAt(i);
                while(text.charAt(i) != '"' ){
                    //a = text.charAt(i);
                    if( text.charAt(i) == '\\') i = i + 2;
                    else i++;
                } 

            }

            else if(text.charAt(i) == '\'')  {
                i++;
                while(text.charAt(i) != '\'' ){
                    if( text.charAt(i) == '\\') i = i + 2;
                    else i++;
                }

            }

            else if(text.charAt(i) == '/'   )  {
                

                if(i < text.length() - 1 &&  text.charAt(i + 1) == '/'){

                    int k = i;
                    while(text.charAt(i + 1) != '\n' && i < text.length() - 1  ){
                        
                        i++;
                      //  a = text.charAt(i)

                    }
                    int s = text.substring(k, i).indexOf("\\u000d");
                    if( s == -1){
                    text.delete(k,i + 1 );
                    
                    }
                    else {
                        text.delete(k, k + s + "\\u000d".length());
                    }
                    i = k;

                }

                 if(i < text.length() - 1 && text.charAt(i + 1) == '*'){
                    int k = i;
                    i = i + 2;
                    while(i < text.length() - 1 && !(text.charAt(i) == '*' && text.charAt(i + 1) == '/')){
                        i++;
                    }
                    text.delete(k,i + 2);
                    i = k;

                }


            }
             i++;
               
        }
        

    }

    public void showInFile() throws IOException{

        FileWorker fw = new FileWorker(fileName);
        fw.writer(text.toString());

    }
    
    public void showInFile(String str) throws IOException{

        FileWorker fw = new FileWorker(str);
        fw.writer(text.toString());

    }
    public static void main(String[] args){

        try{
           Laba4 k = new Laba4("//home//uliana//programming//jaVka//Univer//src//labs//Laba4//MyComments.txt");
           k.textReading();
           k.commentsDeleting();
           k.showInFile();
           System.out.println( k.getText());
        }catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
