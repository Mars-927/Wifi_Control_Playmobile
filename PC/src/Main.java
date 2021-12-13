public class Main {
	static Thread contor;
	static setting one;
	static int flag_first=0;
	public static void main(String arge[]) {	
			first temp=new first();
			contor=new Thread(temp);
			contor.start();
	}
	static void close_first_windows() {
		one.close();
	}
}
class first implements Runnable{
	public void run() {
		Main.one=new setting();
	}
}

