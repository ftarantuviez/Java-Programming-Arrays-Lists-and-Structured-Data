package Week3.WebLogProgram;


import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         records.clear();
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
             String[] arrOfStr = line.split(" "); 
             String ip = arrOfStr[0];
             String date = arrOfStr[3].substring(1) ;
             int indexOfQuote = line.indexOf("\"")+1;
             int indexOfSecondQuote = line.indexOf("\"", indexOfQuote);
             int indexOfFinishStatus = indexOfSecondQuote+5;
             String request = line.substring(indexOfQuote, indexOfSecondQuote);
             int status = Integer.parseInt(line.substring(indexOfSecondQuote+2, indexOfFinishStatus));
             int bytes = Integer.parseInt(line.substring(indexOfFinishStatus+1));
             
             LogEntry log = new LogEntry(ip,date,request,status,bytes);
             records.add(log);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
