package sensor;

import java.io.Serializable;

public class EnvironmentSensorData implements Serializable{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EnvironmentSensorData [humidity=" + humidity + ", pressure=" + pressure + ", temperature=" + temperature
				+ "]";
	}
	private static final long serialVersionUID = -2487008775123171169L;
	private double humidity; // relative humidity percentage
	private double pressure; // pressure in hectopascals
	private double temperature; // temperature in Fahrenheit
	
	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}
	/**
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 */
	public EnvironmentSensorData(double temperature, double pressure, double humidity) {
		super();
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	
}
