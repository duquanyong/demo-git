package com.example.demo.caroil.model;
 
import java.util.Date;

/**
 * 油量分析数据来源表
 * 原来可以从 xx_gps_today 表中取，但是这里面的数据量大，而且没有必要需要间隔那么小的数据
 * 这里的数据间隔是每隔五分钟一个数据点
 * @author duqy
 */
public class CarOil {
    private String ID;

    private String carNo;

    private String plateNumber;

    private String theirUnit;

    private String longitude;

    private String latitude;
    
    private String address;

    private Double oilQuantity;
 
	private Date gpsTime;

    private Date createTime;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getTheirUnit() {
        return theirUnit;
    }

    public void setTheirUnit(String theirUnit) {
        this.theirUnit = theirUnit == null ? null : theirUnit.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getOilQuantity() {
		return oilQuantity == null? 0.0d : oilQuantity;
	}

	public void setOilQuantity(Double oilQuantity) {
		this.oilQuantity = oilQuantity;
	}

    public Date getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(Date gpsTime) {
        this.gpsTime = gpsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}