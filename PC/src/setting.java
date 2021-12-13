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
	public static int port;//端口
	public static boolean switch_camera;//摄像头开关判定
	public static int win_x=600,win_y=350;//窗体大小
	public static String windows_title="Raspberry Control";//窗体标题
	public static String in_title="Raspberry";//窗体内部标题
	public static int background[]={255,246,220};//窗口背景颜色设置
	public static Font font = new Font("宋体",Font.BOLD,30);//标题字体
	public static Font font_input = new Font("宋体",Font.BOLD,24);//输入文本字体
	public static String tip="Camera";
	JTextField text1;
	JTextField text2;
	Checkbox camera;
	setting(){
		int width=(Toolkit.getDefaultToolkit().getScreenSize().width-win_x)/2;
		int height=(Toolkit.getDefaultToolkit().getScreenSize().height-win_y)/2;
		

		setBounds(width,height,win_x,win_y);//居中显示		
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
		//设计背景 标题
		JLabel InTitle=new JLabel(in_title,JLabel.CENTER);
		InTitle.setBackground(new Color(background[0],background[1],background[2]));
		InTitle.setFont(font);
		this.add(InTitle);
		InTitle.setBounds(0,0,win_x,win_y/8);
		//设计 中间IP输入 端口输入 按钮
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
		//摄像头开关
		camera=new Checkbox(tip);
		camera.setBackground(new Color(background[0],background[1],background[2]));
		this.add(camera);
		camera.setBounds(win_x/4,win_y*3/5,23*tip.length(),win_y/8);
		//添加监控
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
			JOptionPane.showMessageDialog(null, "输入格式错误","警告", JOptionPane.WARNING_MESSAGE);
		}
		finally {
			System.out.println("IP输入:"+IP);
			System.out.println("端口输入:"+port);
			System.out.println("摄像头状态:"+switch_camera);
		}
	}

}
