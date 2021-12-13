import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
public class LED implements Runnable {
	public void run(){
		try{
			GpioController gpio = GpioFactory.getInstance();
			GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_26, "MyLED", 50);
			pin.setShutdownOptions(true, PinState.LOW);
			while(true) {	
				for(int i=0; i<=50; i++) {
					pin.setPwm(50-i);           
					Thread.sleep(50);
				}
				for (int i=0; i<=50; i++) {
					pin.setPwm(i);           
					Thread.sleep(50);
					}
				}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}