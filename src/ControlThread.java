import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import arm.ArmControl;
import sensor.BME280;
import sensor.TMG39931;

public class ControlThread implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		ArmControl arm = new ArmControl();
		BME280 bme280 = new BME280();
		TMG39931 tmg39931 = new TMG39931();
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				Object request = in.readObject();
				if (request instanceof String) {
					String msg = (String) request;
					switch (msg) { // perform action based on message content
					case "rotateLeft":
						arm.rotateLeft();
						break;
					case "rotateRight":
						arm.rotateRight();
						break;
					case "shoulderDown":
						arm.shoulderDown();
						break;
					case "shoulderUp":
						arm.shoulderUp();
						break;
					case "elbowDown":
						arm.elbowDown();
						break;
					case "elbowUp":
						arm.elbowUp();
						break;
					case "wristDown":
						arm.wristDown();
						break;
					case "wristUp":
						arm.wristUp();
						break;
					case "gripClose":
						arm.gripClose();
						break;
					case "gripOpen":
						arm.gripOpen();
						break;
					case "lightToggle":
						arm.lightToggle();
						break;
					case "sendEnvironmentData": 
						out.writeObject(bme280.pollEnvironmentSensor());
						break;
					case "sendProximitySensorData":
						out.writeObject(tmg39931.pollProximitySensor());
						break;
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ControlThread(Socket socket) {
		super();
		this.socket = socket;
	}

}
