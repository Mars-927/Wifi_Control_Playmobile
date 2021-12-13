/*
 * input port 10009
 * using this port to control the car Servo
 * 
 */
import java.net.*;
public class ControlMot {
	ControlMot(){
		int port=10009;
		System.out.println("Begin connection---ControlServo!");
		PCA pca = new PCA();
			try {
				DatagramSocket mail_in=new DatagramSocket(port);
				byte data[]=new byte[1024];
				int length=1024;
				DatagramPacket pack=new DatagramPacket(data,length);
				while(true) {
					mail_in.receive(pack);
					byte[]data2=pack.getData();
					System.out.println("Servo--->length:"+data2.length+"contain:"+data2[0]);
					pca.go(data2[0]);
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}
}