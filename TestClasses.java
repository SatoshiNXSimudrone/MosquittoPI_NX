import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class TestClasses{
     
     // yeah yeah I know all in main is ugly but i dont care !
     public static void main(String [] args)throws InterruptedException, IOException, ParseException{
		 //initialize mosquitto variables 
		 
		 String topic ="Raspy_1";
		 String topic2 ="Raspy_2";
		 String server_addr ="10.10.68.131";
		 // Create ArrayList of MosquittoHelper objects 
		 ArrayList<MosquittoHelper> mqtt_helper = new ArrayList<MosquittoHelper>();

     	/*
     	         "Hostname:_"+NetworkInfo.getHostname());
	            for (String ipAddretIPAddresses());
	                p= rt.exec("mosquitto_pub -h localhost -t SystemInfoPI -m  IP_Addresses:_"+ipAddress);
	            for (String fqdn :Ns())
	                p= rt.exec("mosquitto_pub -h localhost -t SystemInfoPI -m  FQDN:_"+fqdn);
	            for (String nameserver : NetworkInfo.getNameservers())
	                p= rt.exec("mosquitto_pub -h localhost -t SystemInfoPI -m   Nameserver:_" + nameserver);
	             


     	*/

     	


	// topic = CPUInfo create Arrays with topics and messages for mosquitto
	    String [] cpu_i={
	    	"CPU_Revision:_"+SystemInfo.getCpuRevision(),
	    	"CPU_Architecture:  " + SystemInfo.getCpuArchitecture(),
	    	"CPU_Part:_"+ SystemInfo.getCpuPart(),
	    	"CPU_Temperature:_" + SystemInfo.getCpuTemperature(),
	    	"CPU_Core_Voltage:_" + SystemInfo.getCpuVoltage(),
	    	"CPU_Model_Name:_" + SystemInfo.getModelName()};
	    
	    // topic = HarwareInfo create Arrays with topics and messages for mosquitto
	    String [] hardW_i={"Processor:_" + SystemInfo.getProcessor(),
		    "Hardware_Revision:_" + SystemInfo.getRevision(),
		    "Is_Hard_Float_ABI :_" + SystemInfo.isHardFloatAbi(),
		    "Board_Type:_" + SystemInfo.getBoardType().name()};

        // topic = MemInfo create Arrays with topics and messages for mosquitto
	    String [] mem_i={
	    	"Total_Memory:_" + SystemInfo.getMemoryTotal(),
	    	"Used_Memory:_" + SystemInfo.getMemoryUsed(),
	    	"Free_Memory:_" + SystemInfo.getMemoryFree(),
	    	"Shared_Memory:_" + SystemInfo.getMemoryShared(),
	    	"Memory_Buffers:_" + SystemInfo.getMemoryBuffers(),
	    	"Cached_Memory:_" + SystemInfo.getMemoryCached()};
	    
	    // topic = voltageInfo create Arrays with topics and messages for mosquitto
	    String [] volt_i={
	           "SDRAM_C_Voltage:_" + SystemInfo.getMemoryVoltageSDRam_C(),
	           "SDRAM_I_Voltage:_" + SystemInfo.getMemoryVoltageSDRam_I(),
	           "SDRAM_P_Voltage:_" + SystemInfo.getMemoryVoltageSDRam_P()}; 
        
        // topic = OS_Info create Arrays with topics and messages for mosquitto
	    String [] os_i={
	           "OS_Name:_" + SystemInfo.getOsName(),
	           "OS_Version:_" + SystemInfo.getOsVersion(),
	           "OS_Architecture:_" + SystemInfo.getOsArch(),
	           "OS_Firmware_Build:_" + SystemInfo.getOsFirmwareBuild(),
	           "SystemInfoPI -m OS_Firmware_Date:_" + SystemInfo.getOsFirmwareDate()};

	    // topic = Java Info create Arrays with topics and messages for mosquitto
	    String [] java_i={
	           "Java_Vendor:_" + SystemInfo.getJavaVendor(),
	           "Java_Vendor_URL:_" + SystemInfo.getJavaVendorUrl(),
	           "Java_Version:_" + SystemInfo.getJavaVersion(),
	           "Java_VM:_" + SystemInfo.getJavaVirtualMachine(),
	           "Runtime:_" + SystemInfo.getJavaRuntime()};
	    
	    // topic = Codecs Info create Arrays with topics and messages for mosquitto
	    String [] codecs ={         
	           "H264_Codec_Enabled:_" + SystemInfo.getCodecH264Enabled(),
	           "MPG2_Codec_Enabled:_" + SystemInfo.getCodecMPG2Enabled(),
	           "WVC1_Codec_Enabled:_" + SystemInfo.getCodecWVC1Enabled()}; 

        // topic = Freq Info create Arrays with topics and messages for mosquitto
	    String [] freqs ={
	           "ARM_Frequency:_" + SystemInfo.getClockFrequencyArm(),
	           "CORE_Frequency:_" + SystemInfo.getClockFrequencyCore(),
	           "H264_Frequency:_" + SystemInfo.getClockFrequencyH264(),
	           "ISP_Frequency:_" +SystemInfo.getClockFrequencyISP(),
	           "V3D_Frequency:_" + SystemInfo.getClockFrequencyV3D(),
	           "UART_Frequency:_" + SystemInfo.getClockFrequencyUART(),
	           "PWM_Frequency:_" + SystemInfo.getClockFrequencyPWM(),
	           "EMMC_Frequency:_" + SystemInfo.getClockFrequencyEMMC(),
	           "Pixel_Frequency:_" + SystemInfo.getClockFrequencyPixel(),
	           "VEC_Frequency:_" + SystemInfo.getClockFrequencyVEC(),
	           "HDMI_Frequency:_" + SystemInfo.getClockFrequencyHDMI(),
	           "DPI_Frequency:_" + SystemInfo.getClockFrequencyDPI()};
	    
	    //Instantiate and Initailize MossquittoHelper Object
	    MosquittoHelper class1 = new MosquittoHelper();
	    class1.setAddress(server_addr);
	    class1.setTopic(topic);
	    //load array into MosquittoHelper object
	    class1.loadMessage(cpu_i);
	    MosquittoHelper class2 = new MosquittoHelper();
	    class2.setAddress(server_addr);
	    class2.setTopic(topic);
	    class2.loadMessage(hardW_i);
	    MosquittoHelper class3 = new MosquittoHelper();
	    class3.setAddress(server_addr);
	    class3.setTopic(topic);
	    class3.loadMessage(mem_i);
	    MosquittoHelper class4 = new MosquittoHelper();
	    class4.setAddress(server_addr);
	    class4.setTopic(topic);
	    class4.loadMessage(volt_i);
	    MosquittoHelper class5 = new MosquittoHelper();
	    class5.setAddress(server_addr);
	    class5.setTopic(topic);
	    class5.loadMessage(os_i);
	    MosquittoHelper class6 = new MosquittoHelper();
	    class6.setAddress(server_addr);
	    class6.setTopic(topic);
	    class6.loadMessage(java_i);
	    MosquittoHelper class7 = new MosquittoHelper();
	    class7.setAddress(server_addr);
	    class7.setTopic(topic);
	    class7.loadMessage(codecs);
	    MosquittoHelper class8 = new MosquittoHelper();
	    class8.setAddress(server_addr);
	    class8.setTopic(topic);
	    class8.loadMessage(freqs);
	    // add initialized objects to ArrayList
	    mqtt_helper.add(class1);
	    mqtt_helper.add(class2);
	    mqtt_helper.add(class3);
	    mqtt_helper.add(class4);
	    mqtt_helper.add(class5);
	    mqtt_helper.add(class6);
	    mqtt_helper.add(class7);
	    mqtt_helper.add(class8);
	    
	    System.out.println("Going into classes to publish");
	    // method call
	    class1.publishTopic(cpu_i);
	    class2.publishTopic(hardW_i);
	    class3.publishTopic(mem_i);
	    class4.publishTopic(volt_i);
	    class5.publishTopic(os_i);
	    class6.publishTopic(java_i);
	    class7.publishTopic(codecs);
	    class8.publishTopic(freqs);
	    //create new MosquittoHelper object and pass ArrayList to constructor
	    MosquittoHelper class9 =new MosquittoHelper();
	    class9.publishTopics(mqtt_helper);
	    
    }
}
