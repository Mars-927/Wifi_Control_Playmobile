import java.net.*;
public class Network
{
	static String IP=setting.IP;
	static int port=setting.port;
	public static void run(byte a[]){
		try{
			System.out.println("·¢ËÍ×Ö·û´®"+(int)a[0]);
			InetAddress address=InetAddress.getByName(IP);
			DatagramPacket data_pack=new DatagramPacket(a,a.length,address,port);
			DatagramSocket mail_out=new DatagramSocket();
			mail_out.send(data_pack);
			mail_out.close();
		}
		catch(Exception e) {
		}
	}
}