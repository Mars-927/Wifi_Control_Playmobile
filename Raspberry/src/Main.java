public class Main {
	public static void main(String[] args) {
		net1 one=new net1();
		net2 two=new net2();
		new Hello();
		System.out.println("check succeed! ");
		Thread th1=new Thread(one);	
		Thread th2=new Thread(two);	
		th1.start();
		th2.start();
	}
}
class net1 implements Runnable {
	public void run() {
		new Control();
	}
}
class net2 implements Runnable {
	public void run() {
		new ControlMot();
	}
}


