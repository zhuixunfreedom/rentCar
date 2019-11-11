package cn.kgc.pojo;


public class Car {

  private long cid;
  private String carName;
  private String carDesc;
  private String carType;
  private long carPrice;
  private long rentCount;
  private String carImg;
  private String carNum;
  private long primeCost;
  private long rentStatus;
  private String carCity;
  private String engineNum;
  private long takeNum;
  private String registeTime;
  private String certifyTime;
  private String carOwner;
  private long shopid;

  public Car() {
  }

  public Car(long cid, String carName, String carDesc, String carType, long carPrice, long rentCount, String carImg, String carNum, long primeCost, long rentStatus, String carCity, String engineNum, long takeNum, String registeTime, String certifyTime, String carOwner, long shopid) {
    this.cid = cid;
    this.carName = carName;
    this.carDesc = carDesc;
    this.carType = carType;
    this.carPrice = carPrice;
    this.rentCount = rentCount;
    this.carImg = carImg;
    this.carNum = carNum;
    this.primeCost = primeCost;
    this.rentStatus = rentStatus;
    this.carCity = carCity;
    this.engineNum = engineNum;
    this.takeNum = takeNum;
    this.registeTime = registeTime;
    this.certifyTime = certifyTime;
    this.carOwner = carOwner;
    this.shopid = shopid;
  }

  @Override
  public String toString() {
    return "Car{" +
            "cid=" + cid +
            ", carName='" + carName + '\'' +
            ", carDesc='" + carDesc + '\'' +
            ", carType='" + carType + '\'' +
            ", carPrice=" + carPrice +
            ", rentCount=" + rentCount +
            ", carImg='" + carImg + '\'' +
            ", carNum='" + carNum + '\'' +
            ", primeCost=" + primeCost +
            ", rentStatus=" + rentStatus +
            ", carCity='" + carCity + '\'' +
            ", engineNum='" + engineNum + '\'' +
            ", takeNum=" + takeNum +
            ", registeTime='" + registeTime + '\'' +
            ", certifyTime='" + certifyTime + '\'' +
            ", carOwner='" + carOwner + '\'' +
            ", shopid=" + shopid +
            '}';
  }

  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }


  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }


  public String getCarDesc() {
    return carDesc;
  }

  public void setCarDesc(String carDesc) {
    this.carDesc = carDesc;
  }


  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
  }


  public long getCarPrice() {
    return carPrice;
  }

  public void setCarPrice(long carPrice) {
    this.carPrice = carPrice;
  }


  public long getRentCount() {
    return rentCount;
  }

  public void setRentCount(long rentCount) {
    this.rentCount = rentCount;
  }


  public String getCarImg() {
    return carImg;
  }

  public void setCarImg(String carImg) {
    this.carImg = carImg;
  }


  public String getCarNum() {
    return carNum;
  }

  public void setCarNum(String carNum) {
    this.carNum = carNum;
  }


  public long getPrimeCost() {
    return primeCost;
  }

  public void setPrimeCost(long primeCost) {
    this.primeCost = primeCost;
  }


  public long getRentStatus() {
    return rentStatus;
  }

  public void setRentStatus(long rentStatus) {
    this.rentStatus = rentStatus;
  }


  public String getCarCity() {
    return carCity;
  }

  public void setCarCity(String carCity) {
    this.carCity = carCity;
  }


  public String getEngineNum() {
    return engineNum;
  }

  public void setEngineNum(String engineNum) {
    this.engineNum = engineNum;
  }


  public long getTakeNum() {
    return takeNum;
  }

  public void setTakeNum(long takeNum) {
    this.takeNum = takeNum;
  }


  public String getRegisteTime() {
    return registeTime;
  }

  public void setRegisteTime(String registeTime) {
    this.registeTime = registeTime;
  }


  public String getCertifyTime() {
    return certifyTime;
  }

  public void setCertifyTime(String certifyTime) {
    this.certifyTime = certifyTime;
  }


  public String getCarOwner() {
    return carOwner;
  }

  public void setCarOwner(String carOwner) {
    this.carOwner = carOwner;
  }


  public long getShopid() {
    return shopid;
  }

  public void setShopid(long shopid) {
    this.shopid = shopid;
  }

}
