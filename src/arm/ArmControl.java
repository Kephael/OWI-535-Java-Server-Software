package arm;

/*
 * Byte format courtesy of http://notbrainsurgery.livejournal.com/38622.html (Vadim Zaliva)
 */
import java.io.IOException;

public class ArmControl {
	private boolean light = false;
	private final int SLEEPTIME = 200 ; // length of time movement commands are performed for, this must match what is set on the Android Control Client
	public void lightToggle() {
		try {
			if (light) { // light is currently on
				ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", "00");
				pb.start();
				light = false;
			} else { // light is currently off
				ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", "01");
				pb.start();
				light = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * Opens grip for SLEEPTIME ms
	 */
	public void gripOpen(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "02", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Closes grip for SLEEPTIME ms
	 */
	public void gripClose(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "01", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Moves wrist up for SLEEPTIME ms
	 */
	public void wristUp(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "04", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Moves wrist down for SLEEPTIME ms
	 */
	public void wristDown(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "08", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Moves elbow up for SLEEPTIME ms
	 */
	public void elbowUp(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "10", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Moves elbow down for SLEEPTIME ms
	 */
	public void elbowDown(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "20", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Moves shoulder up for SLEEPTIME ms
	 */
	public void shoulderUp(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "40", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Moves shoulder down for SLEEPTIME ms
	 */
	public void shoulderDown(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "80", "00", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * rotates frame left for SLEEPTIME ms
	 */
	public void rotateLeft(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "00", "02", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * rotates frame right for SLEEPTIME ms
	 */
	public void rotateRight(){
		ProcessBuilder pb = new ProcessBuilder("/home/pi/arm_driver", "00", "01", light ? "01" : "00"); 
		try {
			pb.start();
			Thread.sleep(SLEEPTIME); 
			pb = new ProcessBuilder("/home/pi/arm_driver", "00", "00", light ? "01" : "00");
			pb.start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public ArmControl() {


	}
}
