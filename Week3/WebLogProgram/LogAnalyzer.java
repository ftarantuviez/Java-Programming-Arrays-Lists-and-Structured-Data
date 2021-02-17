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
             WebLogParser parser = new WebLogParser();     
             LogEntry log = parser.parseEntry(line);
             records.add(log);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(uniqueIPs.contains(ip)) continue;
            uniqueIPs.add(ip);
         }
         
         return uniqueIPs.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(num<le.getStatusCode()) System.out.println(le);
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String day){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        
        for(LogEntry le : records){
            String date = le.getAccessTime().toString();
            String ip = le.getIpAddress();
            if(date.contains(day) && !uniqueIPs.contains(ip)) {
                uniqueIPs.add(ip);
            }
         }
         
         return uniqueIPs;
     }
     
     public int countUniqueIPsInRange(int low, int high){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for(LogEntry le : records){
            int status = le.getStatusCode();
            String ip = le.getIpAddress();
            if(status>=low && status<=high && !uniqueIPs.contains(ip)){
                uniqueIPs.add(ip);
            }
         }
         
         return uniqueIPs.size();
     }
     
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> visitPerIP = new HashMap<String,Integer>();
         
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             int count = 0;
             if(visitPerIP.containsKey(ip)) {
                 count = visitPerIP.get(ip);
             }
             
             visitPerIP.put(ip, count+1);
         }
         
         return visitPerIP;
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> ips){
         int maxVal = 0;
         for(String k : ips.keySet()){
             int val = ips.get(k);
             if(maxVal<val) maxVal = val;
         }
         
         return maxVal;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> ips){
         ArrayList<String> ans = new ArrayList<String>();
         int maxVisits = mostNumberVisitsByIP(ips);
         for(String k : ips.keySet()){
             int sizeIps = ips.get(k);
             if(sizeIps == maxVisits) ans.add(k);
         }
         
         return ans;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays (){
     HashMap<String, ArrayList<String>> DateIP = new HashMap<String, ArrayList<String>>();
     
     for (LogEntry le: records){
             String date = le.getAccessTime().toString();
             date = date.substring(4, 10);
             if (DateIP.containsKey(date)){
             ArrayList<String> temp = DateIP.get(date);
             temp.add(le.getIpAddress());
             DateIP.put(date, temp );
            }
             else{
                 ArrayList<String> temp = new ArrayList<String>();
                 temp.add(le.getIpAddress());
                 DateIP.put(date, temp);
            }
             
        }
        return DateIP;
    }
        
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> days){
         String mostD = "";
         int mostS = 0;
         for( String current: days.keySet()){
             int size = days.get(current).size();
             if (size > mostS){
                 mostS = size;
                 mostD = current;
                }
            }
         return mostD;
       }
        
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> days, String someday){
         ArrayList<String> superstars = new ArrayList<String>();
         
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         
         ArrayList<String> wholeDay = new ArrayList<String>();
         wholeDay = days.get(someday);
         
         for (String s: wholeDay){
             
             if (counts.containsKey(s)){
                 counts.put(s, counts.get(s) +1);
                }
             else{
                 counts.put(s, 1);
                }
            
            }
         
         superstars = iPsMostVisits(counts);
         
         
         return superstars;
        }
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
