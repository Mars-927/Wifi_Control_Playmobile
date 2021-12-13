import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class control extends JFrame implements KeyListener{
	static String input=setting.IP;
	public static JTextArea now1=new JTextArea();
	public static int win_x=600,win_y=800;//窗体大小
	public static Font font = new Font("宋体",Font.BOLD,30);//标题字体设置
	public static Font font2 = new Font("宋体",Font.BOLD,20);//标题字体设置
	public static int background[]={255,246,220};//窗口背景颜色设置
	public static JLabel PWM=new JLabel("当前速度:50%");
	public static byte []A1=new byte[] {1};
	public static byte []A2=new byte[] {2};
	public static byte []A3=new byte[] {3};
	public static byte []A4=new byte[] {4};
	public static byte []A5=new byte[] {5};
	public static byte []A6=new byte[] {6};
	public static byte []A7=new byte[] {7};
	public static byte []A8=new byte[] {8};
	public static byte []A9=new byte[] {9};
	public static byte []A10=new byte[] {10};
	public static byte []A11=new byte[] {11};
	public static byte []A12=new byte[] {12};
	public static byte []A13=new byte[] {13};
	public static byte []A14=new byte[] {14};
	public static byte []A15=new byte[] {15};
	public static byte []A16=new byte[] {16};
	control(String input_ip){
		setLayout(null);
		this.getContentPane().setBackground(new Color(background[0],background[1],background[2]));
		setTitle("树莓派远程遥控车");
		JLabel wel=new JLabel("树莓派远程操控");//标题
		JLabel IP=new JLabel("IP:"+input);
		JLabel state=new JLabel("连接成功");
		now1.addKeyListener(this);
		now1.setText("开始\n");
		
		int width=(Toolkit.getDefaultToolkit().getScreenSize().width-win_x)/2;
		int height=(Toolkit.getDefaultToolkit().getScreenSize().height-win_y)/2;
		Stream.where_X=width;
		Stream.where_Y=height/2;
		if(setting.switch_camera==true)
			Stream.openForm("http://192.168.0.107:8070/javascript_simple.html","hello swing");
		this.add(wel);
		wel.setFont(font);
		wel.setBounds(win_x/2-115, 0, 230, 40);
		
		this.add(IP);
		IP.setFont(font2);
		IP.setBounds(win_x/2-200,win_y/4-105,200,20);
		
		this.add(state);
		state.setFont(font2);
		state.setBounds(win_x/2-200,win_y/4-65,200,20);
		
		this.add(PWM);
		PWM.setFont(font2);
		PWM.setBounds(win_x/2-200, win_y/4-25,200, 20);
		
		
		this.add(now1);
		now1.setBounds(win_x/2, 50, win_x/2-50, win_y/2-200);
		
		setBounds(width,height-100,win_x,win_y);//居中显示
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	public void keyPressed(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
			case KeyEvent.VK_A:now1.setText("按下A ↙左后\n");Network.run(A1);break;
			case KeyEvent.VK_D:now1.setText("按下D ↘右后\n");Network.run(A2);break;
			case KeyEvent.VK_W:now1.setText("按下W ↑前\n");Network.run(A4);break;
			case KeyEvent.VK_S:now1.setText("按下S ↓后\n");Network.run(A3);break;
			
			case KeyEvent.VK_NUMPAD7:now1.setText("按下7 ↑后\n");PWM.setText("当前速度:80%");Network.run(A5);break;
			case KeyEvent.VK_NUMPAD6:now1.setText("按下6 ↑后\n");PWM.setText("当前速度:70%");Network.run(A6);break;
			case KeyEvent.VK_NUMPAD5:now1.setText("按下5 ↑后\n");PWM.setText("当前速度:60%");Network.run(A7);break;
			case KeyEvent.VK_NUMPAD4:now1.setText("按下4 ↑后\n");PWM.setText("当前速度:50%");Network.run(A8);break;
			case KeyEvent.VK_NUMPAD3:now1.setText("按下3 ↑后\n");PWM.setText("当前速度:35%");Network.run(A10);break;
			case KeyEvent.VK_NUMPAD2:now1.setText("按下2 ↑后\n");PWM.setText("当前速度:35%");Network.run(A11);break;
			case KeyEvent.VK_NUMPAD1:now1.setText("按下1 ↑后\n");PWM.setText("当前速度:25%");Network.run(A12);break;
			
			case KeyEvent.VK_UP:now1.setText("按下↑  舵机上移\n");NetworkServo.run(A1);break;
			case KeyEvent.VK_DOWN:now1.setText("按下↓  舵机下移\n");NetworkServo.run(A2);break;
			case KeyEvent.VK_LEFT:now1.setText("按下←  舵机左移\n");NetworkServo.run(A3);break;
			case KeyEvent.VK_RIGHT:now1.setText("按下→  舵机右移\n");NetworkServo.run(A4);break;
			case KeyEvent.VK_NUMPAD0:now1.setText("按下0  舵机复位\n");NetworkServo.run(A5);break;
			case KeyEvent.VK_OPEN_BRACKET:now1.setText("按下[  舵机左最大\n");NetworkServo.run(A6);break;
			case KeyEvent.VK_CLOSE_BRACKET:now1.setText("按下]  舵机右最大\n");NetworkServo.run(A7);break;
		}
		
	}
	public void keyReleased(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
		case KeyEvent.VK_A:now1.setText("释放A ↙左后\n");Network.run(A13);break;
		case KeyEvent.VK_D:now1.setText("释放D ↘右后\n");Network.run(A14);break;
		case KeyEvent.VK_W:now1.setText("释放W ↑前\n");Network.run(A15);break;
		case KeyEvent.VK_S:now1.setText("释放S ↓后\n");Network.run(A16);break;
		}
	}
	public void keyTyped(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
		case KeyEvent.VK_A:now1.setText("敲击A ↙左后\n");Network.run(A9);break;
		case KeyEvent.VK_D:now1.setText("敲击D ↘右后\n");Network.run(A9);break;
		case KeyEvent.VK_W:now1.setText("敲击W ↑前\n");Network.run(A9);break;
		case KeyEvent.VK_S:now1.setText("敲击S ↓后\n");Network.run(A9);break;
		}
	}
}