import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;
public class GPIO {
	static int flag=0;
	static GpioController gpio=null;
	static GpioPinPwmOutput GPIO_01=null;//ENA
	static GpioPinPwmOutput GPIO_23=null;//ENB
	static GpioPinDigitalOutput GPIO_00=null;//in_1
	static GpioPinDigitalOutput GPIO_02=null;//in_2
	static GpioPinDigitalOutput GPIO_03=null;//in_3
	static GpioPinDigitalOutput GPIO_04=null;//in_4
	static int flag_f=0,flag_r=0;
	public void now(byte a) {
		if(flag==0){
			gpio = GpioFactory.getInstance();
		 	Gpio.wiringPiSetup();
		 	SoftPwm.softPwmCreate(1, 50,100);
		 	SoftPwm.softPwmCreate(23,50,100);
		 	SoftPwm.softPwmWrite(1, 30);
		 	SoftPwm.softPwmWrite(23, 30);
			//GPIO_01= gpio.provisionPwmOutputPin(RaspiPin.GPIO_01, "ENA", 50);
			GPIO_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "IN_1", PinState.LOW);
			GPIO_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "IN_2", PinState.LOW);
			GPIO_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "IN_3", PinState.LOW);
			GPIO_04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "IN_4", PinState.LOW);
			//GPIO_23 = gpio.provisionPwmOutputPin(RaspiPin.GPIO_23, "ENB", 50);
			flag=1;
		}
		switch(a) {
		//case 1:GPIO_00.setState(PinState.HIGH);GPIO_02.setState(PinState.LOW);GPIO_03.setState(PinState.LOW);GPIO_04.setState(PinState.HIGH);break;
		//case 2:GPIO_00.setState(PinState.LOW);GPIO_02.setState(PinState.HIGH);GPIO_03.setState(PinState.HIGH);GPIO_04.setState(PinState.LOW);break;
		//case 3:GPIO_00.setState(PinState.HIGH);GPIO_02.setState(PinState.LOW);GPIO_03.setState(PinState.HIGH);GPIO_04.setState(PinState.LOW);break;
		//case 4:GPIO_00.setState(PinState.LOW);GPIO_02.setState(PinState.HIGH);GPIO_03.setState(PinState.LOW);GPIO_04.setState(PinState.HIGH);break;
		case 1:flag_r=1;GPIO.fun_rig();break;//right
		case 2:flag_r=-1;GPIO.fun_lef();break;//left
		case 3:flag_f=-1;GPIO.fun_bac();break;//beck
		case 4:flag_f=1;GPIO.fun_for();break;//forward
		case 5:SoftPwm.softPwmWrite(1, 85);SoftPwm.softPwmWrite(23, 85);break;
		case 6:SoftPwm.softPwmWrite(1, 70);SoftPwm.softPwmWrite(23, 70);break;
		case 7:SoftPwm.softPwmWrite(1, 60);SoftPwm.softPwmWrite(23, 60);break;
		case 8:SoftPwm.softPwmWrite(1, 50);SoftPwm.softPwmWrite(23, 50);break;
		case 10:SoftPwm.softPwmWrite(1, 45);SoftPwm.softPwmWrite(23, 45);break;
		case 11:SoftPwm.softPwmWrite(1, 35);SoftPwm.softPwmWrite(23, 35);break;
		case 12:SoftPwm.softPwmWrite(1, 25);SoftPwm.softPwmWrite(23, 25);break;
		case 13:case 14:
			flag_r=0;
			if(flag_f==0)
				GPIO.stop();
			else {
				if(flag_f==-1) {
					GPIO.fun_bac();
				}
				else {
					GPIO.fun_for();
				}
			}
			break;
		case 15:case 16:
			flag_f=0;
			if(flag_r==0)
				GPIO.stop();
			else {
				if(flag_r==-1) {
					GPIO.fun_lef();
				}
				else {
					GPIO.fun_rig();
				}
			}
			break;
			}
	}
	static void fun_for() {
		GPIO_00.setState(PinState.LOW);GPIO_02.setState(PinState.HIGH);GPIO_03.setState(PinState.LOW);GPIO_04.setState(PinState.HIGH);
		return ;
	}
	static void fun_bac() {
		GPIO_00.setState(PinState.HIGH);GPIO_02.setState(PinState.LOW);GPIO_03.setState(PinState.HIGH);GPIO_04.setState(PinState.LOW);
		return ;
	}
	static void fun_rig() {
		GPIO_00.setState(PinState.HIGH);GPIO_02.setState(PinState.LOW);GPIO_03.setState(PinState.LOW);GPIO_04.setState(PinState.HIGH);
		return ;
	}
	static void fun_lef() {
		GPIO_00.setState(PinState.LOW);GPIO_02.setState(PinState.HIGH);GPIO_03.setState(PinState.HIGH);GPIO_04.setState(PinState.LOW);
		return ;
	}
	static void stop(){
		GPIO_00.setState(PinState.LOW);GPIO_02.setState(PinState.LOW);GPIO_03.setState(PinState.LOW);GPIO_04.setState(PinState.LOW);
		return ;
	}
}
