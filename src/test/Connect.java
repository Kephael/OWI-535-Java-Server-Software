package test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import sensor.EnvironmentSensorData;
import sensor.ProximitySensorData;

public class Connect {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the ip: ");
		String val0 = in.next();
		System.out.print("Enter the port: ");
		String val1 = in.next();
		try {
			Socket socket = new Socket(val0, Integer.parseInt(val1));
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			while (true){
				System.out.print("Enter String to send to server: ");
				String msg = in.next();
				out.writeObject(msg);
				if (msg.equals("sendEnvironmentData") || msg.equals("sendProximitySensorData")){ // client sent message requesting environment data
					Object data = inStream.readObject();
					if (data instanceof EnvironmentSensorData){
						EnvironmentSensorData sensorData = (EnvironmentSensorData) data;
						System.out.println(sensorData.getTemperature());
						System.out.println(sensorData.getPressure());
						System.out.println(sensorData.getHumidity());
					} else if (data instanceof ProximitySensorData){
						ProximitySensorData sensorData = (ProximitySensorData) data;
						System.out.println(sensorData);
					}
				}
				out.flush();
			}
		} catch (NumberFormatException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
