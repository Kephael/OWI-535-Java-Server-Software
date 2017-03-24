package sensor;

import java.io.Serializable;

public class ProximitySensorData implements Serializable{
	private int cData;
	private int red;
	private int green;
	private int blue;
	private int proximity;

	/**
	 * @return the cData
	 */
	public int getcData() {
		return cData;
	}

	/**
	 * @param cData
	 *            the cData to set
	 */
	public void setcData(int cData) {
		this.cData = cData;
	}

	/**
	 * @return the red
	 */
	public int getRed() {
		return red;
	}

	/**
	 * @param red
	 *            the red to set
	 */
	public void setRed(int red) {
		this.red = red;
	}

	/**
	 * @return the green
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * @param cData
	 * @param red
	 * @param green
	 * @param blue
	 * @param proximity
	 */
	public ProximitySensorData(int cData, int red, int green, int blue, int proximity) {
		super();
		this.cData = cData;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.proximity = proximity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProximitySensorData [cData=" + cData + ", red=" + red + ", green=" + green + ", blue=" + blue
				+ ", proximity=" + proximity + "]";
	}

	/**
	 * @param green
	 *            the green to set
	 */
	public void setGreen(int green) {
		this.green = green;
	}

	/**
	 * @return the blue
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * @param blue
	 *            the blue to set
	 */
	public void setBlue(int blue) {
		this.blue = blue;
	}

	/**
	 * @return the proximity
	 */
	public int getProximity() {
		return proximity;
	}

	/**
	 * @param proximity
	 *            the proximity to set
	 */
	public void setProximity(int proximity) {
		this.proximity = proximity;
	}
}
