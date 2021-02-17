package Week3.WebLogProgram;


import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    private void testLogAnalyzerOne(LogAnalyzer logAnalyzer){ 
      int uniqueIPs = logAnalyzer.countUniqueIPs();
      int statusCode = 400;
      System.out.println("Logs with status code > " + statusCode + ": ");
      logAnalyzer.printAllHigherThanNum(statusCode);
      System.out.println("Number of unique IPs: " + uniqueIPs);
      String day = "Sep 24";
      System.out.println("Unique logs in the day = " + day);
      System.out.println(logAnalyzer.uniqueIPVisitsOnDay(day).size());
      int lowRange = 200;
      int highRange = 299;
      System.out.println("Unique logs with status between " + lowRange +" and " + highRange);
      System.out.println(logAnalyzer.countUniqueIPsInRange(lowRange, highRange));
    }
    
    private void testLogAnalyzerTwo(LogAnalyzer logAnalyzer){
        HashMap<String,Integer> visitsPerIP = logAnalyzer.countVisitsPerIP();
        System.out.println("Max visits per IP: ");
        System.out.println(logAnalyzer.mostNumberVisitsByIP(visitsPerIP));
        System.out.println("IP with most visits: ");
        ArrayList<String> ipsMostVisited = logAnalyzer.iPsMostVisits(visitsPerIP);
        for(String k : ipsMostVisited){
            System.out.println(k);
        }
        HashMap<String,ArrayList<String>> ipsPerDay = logAnalyzer.iPsForDays();
        System.out.println("Day with most IP visits: " + logAnalyzer.dayWithMostIPVisits(ipsPerDay));
        String day = "Sep 29";
        ArrayList<String> ipsOnDay = logAnalyzer.iPsWithMostVisitsOnDay(ipsPerDay, day);
        System.out.println("IPs with most visits on " + day);
        for(String ip : ipsOnDay){
            System.out.println(ip);
        }
        
    }
    
    public void testLogAnalyzer() {
      LogAnalyzer logAnalyzer = new LogAnalyzer();
      logAnalyzer.readFile("Week3/WebLogProgram/weblog2_log");
      System.out.println("All the logs");
      logAnalyzer.printAll();
      //testLogAnalyzerOne(logAnalyzer);
      testLogAnalyzerTwo(logAnalyzer);
    }
}
