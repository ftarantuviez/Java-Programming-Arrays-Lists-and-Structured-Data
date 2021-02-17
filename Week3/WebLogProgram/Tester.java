package Week3.WebLogProgram;


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date().toString(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date().toString(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
      LogAnalyzer logAnalyzer = new LogAnalyzer();
      logAnalyzer.readFile("Week3/WebLogProgram/short-test_log");
      logAnalyzer.printAll();
    }
}
