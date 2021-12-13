import java.net.*;
import javax.swing.JOptionPane;
public class connections {
	String IP=setting.IP;
	int port=setting.port;
	int camera=0;
	connections(){
		try {String check;
			if(setting.switch_camera==true)
				check=(InetAddress.getLocalHost()).getHostAddress()+"-"+port+"-"+camera;
			else
				check=(InetAddress.getLocalHost()).getHostAddress()+"-"+port;
			byte []date=check.getBytes();
			InetAddress address=InetAddress.getByName(IP);
			DatagramPacket dataPack=new DatagramPacket(date,date.length,address,port);
			DatagramSocket out=new DatagramSocket();
			out.send(dataPack);
			out.close();	
			Main.close_first_windows();
			new control(setting.IP);
		} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "无法连接移动端,请检查网络","警告", JOptionPane.WARNING_MESSAGE);
		}
	}
}
