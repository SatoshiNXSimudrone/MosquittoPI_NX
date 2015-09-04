
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class MosquittoHelper {
    //instantiate private data fields
    private String topic;
    private String address; 
    private String [] msgs;
    public MosquittoHelper(){

    }
     // method to test that mosquitto publishes data
     public void testRun(String message) throws InterruptedException, IOException, ParseException {
		 System.out.println("I am in testRun");
		  // get runtimeenv
          Runtime rt = Runtime.getRuntime();
          int i =1;
          // spawn publish process 
          Process p= rt.exec("mosquitto_pub -h "+this.address+" -t "+this.topic+" -m message:"+"_"+getTime());
          
          while(1 < 10){
              p= rt.exec("mosquitto_pub -h "+this.address+" -t "+this.topic+" -m message:"+"_"+getTime());
              
 	        try{
	            Thread.sleep(3000);
	           } 
	           catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	            }
	            i++;
			}
	 }
	 // method load Array of required data to publish
     public void loadMessage(String[] message){
		 
         this.msgs = message;
     }
     // Return array call back
     public String[] getMessages(){
         return this.msgs;
     }
     // method to publish content of arrays 
     public void publishTopic(String[] message)throws InterruptedException, IOException, ParseException {
		 System.out.println("I am in publishTopic");
          Runtime rt = Runtime.getRuntime();
          int i =0;
          int len = message.length;
          Process p= rt.exec("clear");
          while ( i< len){
              p= rt.exec("mosquitto_pub -h "+this.address+" -t "+this.topic+" -m issued:"+getTime()+"_&"+message[i]);
              System.out.println("mosquitto_pub -h "+this.address+" -t "+this.topic+" -m issued:"+getTime()+"_&"+message[i]);
        
	        try {
				// 3 seconds interval between each publish
	            Thread.sleep(3000);
	           } 
	           catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	           }
	           i++;
	      }
     }
     // method to publish all Contents of all Mosquitto helper classes stored in ArrayList 
     public void publishTopics(ArrayList<MosquittoHelper> helper)throws InterruptedException, IOException, ParseException {
          Runtime rt = Runtime.getRuntime();
          int i =0;
          int len = helper.size();
          Process p= rt.exec("clear");
          while ( i< len){
              helper.get(i).publishTopic(getMessages());
	        i++;
	      }
     }
     // set topic
     public void setTopic(String topic){
         this.topic = topic;
     }
     // set address
     public void setAddress(String addr){
         this.address = addr;
     } 
     // get toppic
     public String getTopic(){
         return this.topic;
     }
     // get address
     public String getAddress(){
         return this.address;
     } 
     // get current time
     public static String getTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
    }
}
