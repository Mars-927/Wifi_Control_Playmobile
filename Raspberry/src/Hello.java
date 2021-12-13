import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class Hello extends Thread{
	Hello(){
		try {
			Thread LED;
			Thread Camera;
			LED led;
			Camera camera;
			led=new LED();
			camera=new Camera();
			LED=new Thread(led);
			Camera=new Thread(camera);
			byte[] data=new byte [100];
			DatagramSocket mail_check=new DatagramSocket(10008);
			DatagramPacket pack_check=new DatagramPacket(data,100);
			mail_check.receive(pack_check);
			mail_check.close();
			String temp=new String(data);
			System.out.println("receive IP/port/camera:"+temp);
			String []output=temp.split("-");
			if(output.length==3) {
				Camera.start();
			}
			if(temp!=null){
				LED.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			System.out.println("LED Begin");
		}
	}
}
class Camera implements Runnable{
	public void run() {
		try {
			String result=shall.run("/home/pi/jk.sh");
			System.out.println(result);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
