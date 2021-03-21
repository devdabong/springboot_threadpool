package com.wideshot.alimtalk.model;

public class WeatherVO {
	
	private String tempNo;
	private String tempLon;
	private String tempLat;
	private String curWeather;
	private String description;
	private String curTemp;
	private String feelTemp;
	private String curHumidity;
	private String country;
	private String city;
	private String tempDate;
	private String etcCode;
	
	public String getTempNo() {
		return tempNo;
	}
	public void setTempNo(String tempNo) {
		this.tempNo = tempNo;
	}
	public String getTempLon() {
		return tempLon;
	}
	public void setTempLon(String tempLon) {
		this.tempLon = tempLon;
	}
	public String getTempLat() {
		return tempLat;
	}
	public void setTempLat(String tempLat) {
		this.tempLat = tempLat;
	}
	public String getCurWeather() {
		return curWeather;
	}
	public void setCurWeather(String curWeather) {
		this.curWeather = curWeather;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCurTemp() {
		return curTemp;
	}
	public void setCurTemp(String curTemp) {
		this.curTemp = curTemp;
	}
	public String getFeelTemp() {
		return feelTemp;
	}
	public void setFeelTemp(String feelTemp) {
		this.feelTemp = feelTemp;
	}
	public String getCurHumidity() {
		return curHumidity;
	}
	public void setCurHumidity(String curHumidity) {
		this.curHumidity = curHumidity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTempDate() {
		return tempDate;
	}
	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
	}
	public String getEtcCode() {
		return etcCode;
	}
	public void setEtcCode(String etcCode) {
		this.etcCode = etcCode;
	}
	
	@Override
	public String toString() {
		return "WeatherVO [tempNo=" + tempNo + ", tempLon=" + tempLon + ", tempLat=" + tempLat + ", curWeather="
				+ curWeather + ", description=" + description + ", curTemp=" + curTemp + ", feelTemp=" + feelTemp
				+ ", curHumidity=" + curHumidity + ", country=" + country + ", city=" + city + ", tempDate=" + tempDate
				+ ", etcCode=" + etcCode + "]";
	}
	
}
