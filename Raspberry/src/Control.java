/*
 * input port 10008
 * using this port to control the car move
 * 
 */
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Control {
	Control(){
		int port=10008;
		System.out.println("Begin connection---run Control!");
		GPIO ne=new GPIO();
			try {
				DatagramSocket mail_in=new DatagramSocket(port);
				byte data[]=new byte[1024];
				int length=1024;
				DatagramPacket pack=new DatagramPacket(data,length);
				while(true) {
					mail_in.receive(pack);
					byte[]data2=pack.getData();
					System.out.println("length:"+data2.length+"contain:"+data2[0]);
					ne.now(data2[0]);
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}
}