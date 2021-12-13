import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
public class Stream extends JPanel  {
	static int stream_x=320;
	static int stream_y=180;
	static int where_X;
	static int where_Y;
	public static int background[]={255,246,220};//窗口背景颜色设置
    JPanel webBrowserPanel;//窗口初始化
    JWebBrowser webBrowser;//网站
    public Stream(String url) {
        super(new BorderLayout());
        webBrowserPanel = new JPanel(new BorderLayout());
        webBrowser = new JWebBrowser();
        webBrowser.navigate(url);
        webBrowser.setButtonBarVisible(false);
        webBrowser.setMenuBarVisible(false);
        webBrowser.setBarsVisible(false);
        webBrowser.setStatusBarVisible(false);
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        add(webBrowserPanel, BorderLayout.CENTER);
    }
    public  static void  openForm(String url,String title){
        UIUtils.setPreferredLookAndFeel();
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(title);
                frame.setAlwaysOnTop(true); 
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new Stream(url));
                frame.setUndecorated(true);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(true);
                frame.setBounds(where_X,where_Y,stream_x+16, stream_y+16);
                frame.setLocationRelativeTo(frame.getOwner());
                
            }
        });
        NativeInterface.runEventPump();
    }
}