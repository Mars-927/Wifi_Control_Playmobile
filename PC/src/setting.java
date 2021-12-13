/**
 * @author Master
 * function: 
 * Raspberry car 
 * input Ip  port camera
 */
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
public class setting extends JFrame implements ActionListener {
	public static String IP;//IP
	public static int port;//�˿�
	public static boolean switch_camera;//����ͷ�����ж�
	public static int win_x=600,win_y=350;//�����С
	public static String windows_title="Raspberry Control";//�������
	public static String in_title="Raspberry";//�����ڲ�����
	public static int background[]={255,246,220};//���ڱ�����ɫ����
	public static Font font = new Font("����",Font.BOLD,30);//��������
	public static Font font_input = new Font("����",Font.BOLD,24);//�����ı�����
	public static String tip="Camera";
	JTextField text1;
	JTextField text2;
	Checkbox camera;
	setting(){
		int width=(Toolkit.getDefaultToolkit().getScreenSize().width-win_x)/2;
		int height=(Toolkit.getDefaultToolkit().getScreenSize().height-win_y)/2;
		

		setBounds(width,height,win_x,win_y);//������ʾ		
		this.getContentPane().setBackground(new Color(background[0],background[1],background[2]));
		setTitle(windows_title);
		setResizable(false);
		setVisible(true);
		this.Components();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	void Components() {
		JPanel inputIP_Port=new JPanel();
		this.setLayout(null);
		inputIP_Port.setLayout(null);
		//��Ʊ��� ����
		JLabel InTitle=new JLabel(in_title,JLabel.CENTER);
		InTitle.setBackground(new Color(background[0],background[1],background[2]));
		InTitle.setFont(font);
		this.add(InTitle);
		InTitle.setBounds(0,0,win_x,win_y/8);
		//��� �м�IP���� �˿����� ��ť
		inputIP_Port.setBackground(new Color(background[0],background[1],background[2]));
		JLabel tip1=new JLabel("IP");
		JLabel tip2=new JLabel("Port");
		text1=new JTextField();
		text2=new JTextField();	
		ImageIcon image = new ImageIcon("icon.png");
		JButton OK=new JButton();
		OK.setBounds(win_x/4+280, win_y/16, 67, 78);
		Image temp = image.getImage().getScaledInstance(OK.getWidth(), OK.getHeight(), Image.SCALE_DEFAULT);
		image= new ImageIcon(temp);
		OK.setIcon(image);
		OK.setBorderPainted(false);
		OK.setBackground(new Color(background[0],background[1],background[2]));	
		tip1.setFont(font_input);
		tip2.setFont(font_input);
		text1.setFont(font);
		text2.setFont(font);	
		inputIP_Port.add(OK);
		inputIP_Port.add(tip1);
		inputIP_Port.add(tip2);
		inputIP_Port.add(text1);
		inputIP_Port.add(text2);
		tip1.setBounds(win_x/4-90,win_y/16,60,win_y/8);
		tip2.setBounds(win_x/4-90,win_y/8+win_y/16,60,win_y/8);
		text1.setBounds(win_x/4-30,win_y/16,279,win_y/8);
		text2.setBounds(win_x/4-30,win_y/8+win_y/16,279,win_y/8);
		this.add(inputIP_Port);
		inputIP_Port.setBounds(0,win_y/4,win_x,win_y/3);
		//����ͷ����
		camera=new Checkbox(tip);
		camera.setBackground(new Color(background[0],background[1],background[2]));
		this.add(camera);
		camera.setBounds(win_x/4,win_y*3/5,23*tip.length(),win_y/8);
		//��Ӽ��
		OK.addActionListener(this);		
	}
	int getx() {
		return getX();
	}
	int gety() {
		return getY();
	}
	void close() {
		this.dispose();
	}
	public void actionPerformed(ActionEvent arg0) {
		try {
		IP=text1.getText();
		port=Integer.parseInt(text2.getText());
		switch_camera=camera.getState();
		new connections();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "�����ʽ����","����", JOptionPane.WARNING_MESSAGE);
		}
		finally {
			System.out.println("IP����:"+IP);
			System.out.println("�˿�����:"+port);
			System.out.println("����ͷ״̬:"+switch_camera);
		}
	}

}
