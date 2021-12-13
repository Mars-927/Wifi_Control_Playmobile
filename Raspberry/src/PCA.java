
import java.math.BigDecimal;
import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
public class PCA{
	static int change=15;
    static int flag_up=400;//300(up)-500(down) 
    static int flag_down=362;//150(left)-575(right)
    static PCA9685GpioProvider provider;
    static Pin pin_up;
    static Pin pin_down;
    @SuppressWarnings("resource")
    PCA(){
    	try {
    		System.out.println("<--Pi4J--> PCA9685 PWM Example ... started.");
    		BigDecimal frequency = new BigDecimal("50");
    		BigDecimal frequencyCorrectionFactor = new BigDecimal("1");
    		I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
    		final PCA9685GpioProvider provider = new PCA9685GpioProvider(bus, 0x40, frequency, frequencyCorrectionFactor);
    		GpioPinPwmOutput[] myOutputs = provisionPwmOutputs(provider);
    		provider.reset();
    		Pin pin_up = PCA9685Pin.ALL[0];
    		Pin pin_down = PCA9685Pin.ALL[15];
    		provider.setPwm(pin_up, 0, flag_up);
    		provider.setPwm(pin_down, 0, flag_down);
    		PCA.provider=provider;
    		PCA.pin_up=pin_up;
    		PCA.pin_down=pin_down;
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    void go(int a) {
    		PCA.run(a,PCA.provider,pin_up,pin_down);
    	}
    private static GpioPinPwmOutput[] provisionPwmOutputs(final PCA9685GpioProvider gpioProvider) {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput myOutputs[] = {
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "DOWN"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_06, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_07, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_08, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_09, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_10, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_11, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_12, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_13, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_14, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_15, "UP")};  //it must wiring 0-15
        return myOutputs;
    }
	static void run(int a,PCA9685GpioProvider provider,Pin pin_up,Pin pin_down) {
    	if(a==1) {//up
    		if(flag_up>=220)
    			flag_up=flag_up-change;
    		provider.setPwm(pin_up, 0, flag_up);
    	}
    	else if(a==2) {//down
    		if(flag_up<=490)
    			flag_up=flag_up+change;
    		provider.setPwm(pin_up, 0, flag_up);
    	}
    	else if(a==3) {//right
    		if(flag_down<=565)
    			flag_down=flag_down+change;
    		provider.setPwm(pin_down, 0, flag_down);
    	}
    	else if(a==4) {//left
    		if(flag_down>=160)
    			flag_down=flag_down-change;
    		provider.setPwm(pin_down, 0, flag_down);
    	}
    	else if(a==5) {
    		flag_up=400;//300(up)-500(down) 
    	    flag_down=362;//150(left)-575(right)
    	    provider.setPwm(pin_down, 0, flag_down);
    	    provider.setPwm(pin_up, 0, 300);
    	    try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    	    provider.setPwm(pin_up, 0, 500);
    	    provider.setPwm(pin_up, 0, flag_up);
    	}
    	else if(a==6) {
    		flag_up=400;//300(up)-500(down) 
    	    flag_down=575;//150(left)-575(right)
    	    provider.setPwm(pin_up, 0, flag_up);
    		provider.setPwm(pin_down, 0, flag_down);
    	}
    	else if(a==7) {
    		flag_up=400;//300(up)-500(down) 
    	    flag_down=150;//150(left)-575(right)
    	    provider.setPwm(pin_up, 0, flag_up);
    		provider.setPwm(pin_down, 0, flag_down);
    	}
    }
}
