package Week3.WebLogProgram;




import  java.util.*;
public class LogEntry
{
     private String ipAddress;
     private String accessTime;
     private String request;
     private int statusCode;
     private int bytesReturned;
     
   public LogEntry(String ip, String time, String req, int status, int bytes) {
       ipAddress = ip;
       accessTime = time;
       request = req;
       statusCode = status;
       bytesReturned = bytes;
       
   }
   
   public String getIpAddress() {
         return ipAddress;
    }
    public String getAccessTime() {
         return accessTime;
   }   
   public String getRequest() {
         return request;
   }
   public int getStatusCode() {
         return statusCode;
   }
   public int getBytesReturned() {
         return bytesReturned;
   }
   
   public String toString() {
       return ipAddress + " " + accessTime + " " + request 
           + " " + statusCode + " " + bytesReturned;
    }
}
