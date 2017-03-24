import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import arm.ArmControl;

public class ControlServer {
	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("Server must be launched with the port specified as an argument.");
			System.exit(-1);
		}
		System.out.println("Server is listening on port " + args[0]);
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(Integer.parseInt(args[0]));
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}

		while (true){
			try {
				Socket clientSocket = serverSocket.accept();
				Thread controlThread = new Thread(new ControlThread(clientSocket));
				controlThread.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
