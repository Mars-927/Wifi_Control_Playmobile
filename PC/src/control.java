import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class control extends JFrame implements KeyListener{
	static String input=setting.IP;
	public static JTextArea now1=new JTextArea();
	public static int win_x=600,win_y=800;//�����С
	public static Font font = new Font("����",Font.BOLD,30);//������������
	public static Font font2 = new Font("����",Font.BOLD,20);//������������
	public static int background[]={255,246,220};//���ڱ�����ɫ����
	public static JLabel PWM=new JLabel("��ǰ�ٶ�:50%");
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
		setTitle("��ݮ��Զ��ң�س�");
		JLabel wel=new JLabel("��ݮ��Զ�̲ٿ�");//����
		JLabel IP=new JLabel("IP:"+input);
		JLabel state=new JLabel("���ӳɹ�");
		now1.addKeyListener(this);
		now1.setText("��ʼ\n");
		
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
		
		setBounds(width,height-100,win_x,win_y);//������ʾ
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	public void keyPressed(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
			case KeyEvent.VK_A:now1.setText("����A �L���\n");Network.run(A1);break;
			case KeyEvent.VK_D:now1.setText("����D �K�Һ�\n");Network.run(A2);break;
			case KeyEvent.VK_W:now1.setText("����W ��ǰ\n");Network.run(A4);break;
			case KeyEvent.VK_S:now1.setText("����S ����\n");Network.run(A3);break;
			
			case KeyEvent.VK_NUMPAD7:now1.setText("����7 ����\n");PWM.setText("��ǰ�ٶ�:80%");Network.run(A5);break;
			case KeyEvent.VK_NUMPAD6:now1.setText("����6 ����\n");PWM.setText("��ǰ�ٶ�:70%");Network.run(A6);break;
			case KeyEvent.VK_NUMPAD5:now1.setText("����5 ����\n");PWM.setText("��ǰ�ٶ�:60%");Network.run(A7);break;
			case KeyEvent.VK_NUMPAD4:now1.setText("����4 ����\n");PWM.setText("��ǰ�ٶ�:50%");Network.run(A8);break;
			case KeyEvent.VK_NUMPAD3:now1.setText("����3 ����\n");PWM.setText("��ǰ�ٶ�:35%");Network.run(A10);break;
			case KeyEvent.VK_NUMPAD2:now1.setText("����2 ����\n");PWM.setText("��ǰ�ٶ�:35%");Network.run(A11);break;
			case KeyEvent.VK_NUMPAD1:now1.setText("����1 ����\n");PWM.setText("��ǰ�ٶ�:25%");Network.run(A12);break;
			
			case KeyEvent.VK_UP:now1.setText("���¡�  �������\n");NetworkServo.run(A1);break;
			case KeyEvent.VK_DOWN:now1.setText("���¡�  �������\n");NetworkServo.run(A2);break;
			case KeyEvent.VK_LEFT:now1.setText("���¡�  �������\n");NetworkServo.run(A3);break;
			case KeyEvent.VK_RIGHT:now1.setText("���¡�  �������\n");NetworkServo.run(A4);break;
			case KeyEvent.VK_NUMPAD0:now1.setText("����0  �����λ\n");NetworkServo.run(A5);break;
			case KeyEvent.VK_OPEN_BRACKET:now1.setText("����[  ��������\n");NetworkServo.run(A6);break;
			case KeyEvent.VK_CLOSE_BRACKET:now1.setText("����]  ��������\n");NetworkServo.run(A7);break;
		}
		
	}
	public void keyReleased(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
		case KeyEvent.VK_A:now1.setText("�ͷ�A �L���\n");Network.run(A13);break;
		case KeyEvent.VK_D:now1.setText("�ͷ�D �K�Һ�\n");Network.run(A14);break;
		case KeyEvent.VK_W:now1.setText("�ͷ�W ��ǰ\n");Network.run(A15);break;
		case KeyEvent.VK_S:now1.setText("�ͷ�S ����\n");Network.run(A16);break;
		}
	}
	public void keyTyped(KeyEvent arg0) {
		int temp;
		temp=arg0.getKeyCode();
		switch(temp) {
		case KeyEvent.VK_A:now1.setText("�û�A �L���\n");Network.run(A9);break;
		case KeyEvent.VK_D:now1.setText("�û�D �K�Һ�\n");Network.run(A9);break;
		case KeyEvent.VK_W:now1.setText("�û�W ��ǰ\n");Network.run(A9);break;
		case KeyEvent.VK_S:now1.setText("�û�S ����\n");Network.run(A9);break;
		}
	}
}