package sensor;
//Distributed with a free-will license.

//Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
//TMG39931
//This code is designed to work with the TMG39931_I2CS I2C Mini Module available from ControlEverything.com.
//https://www.controleverything.com/content/Color?sku=TMG39931_I2CS#tabs-0-product_tabset-2

import java.io.IOException;

//Distributed with a free-will license.
//Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
//TMG39931
//This code is designed to work with the TMG39931_I2CS I2C Mini Module available from ControlEverything.com.
//https://www.controleverything.com/content/Color?sku=TMG39931_I2CS#tabs-0-product_tabset-2

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public class TMG39931 {

	I2CBus bus;
	I2CDevice device;

	public TMG39931() {
		try {
			bus = I2CFactory.getInstance(I2CBus.BUS_1); // Create I2C bus
			device = bus.getDevice(0x39);
			// Set Wait Time register
			// Wtime = 2.78 ms, 
			device.write(0x83, (byte) 0xFF);
			// Set Atime register
			// ATIME : 712ms, Max count = 65535 cycles
			device.write(0x81, (byte) 0x00);
			// Select enable register
			// Power ON, ALS enable, Proximity enable, Wait enable
			device.write(0x80, (byte) 0x0F);
			Thread.sleep(800);
		} catch (UnsupportedBusNumberException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ProximitySensorData pollProximitySensor() throws IOException {


		// Read 9 Bytes of Data
		// cData lsb, cData msb, red lsb, red msb, green lsb, green msb, blue lsb, blue msb, proximity
		byte[] data = new byte[9];
		device.read(0x94, data, 0, 9);

		// Convert the data 
		int cData = (((data[1] & 0xFF) * 256) + (data[0] * 0xFF));
		int red = (((data[3] & 0xFF) * 256) + (data[2] & 0xFF));
		int green = (((data[5] & 0xFF) * 256) + (data[4] & 0xFF));
		int blue = (((data[7] & 0xFF) * 256) + (data[6] & 0xFF));
		int proximity = data[8] & 0xFF;

		// return data
		return new ProximitySensorData(cData, red, green, blue, proximity);
	}
}