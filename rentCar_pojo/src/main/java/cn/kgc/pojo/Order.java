package cn.kgc.pojo;


public class Order {

  private long oid;
  private String getCarAddress;
  private String returnCarAddress;
  private String getCarTime;
  private String returnCarTime;
  private long rentTime;
  private String rentType;
  private String rentCarName;
  private String rentCarNum;
  private long rentMoney;
  private long serviceMoney;
  private long totalMoney;
  private String orderNum;
  private String rentCity;
  private double driveLong;
  private long orderStatus;
  private long payStatus;
  private long userid;
  private long carid;

  @Override
  public String toString() {
    return "Order{" +
            "oid=" + oid +
            ", getCarAddress='" + getCarAddress + '\'' +
            ", returnCarAddress='" + returnCarAddress + '\'' +
            ", getCarTime='" + getCarTime + '\'' +
            ", returnCarTime='" + returnCarTime + '\'' +
            ", rentTime=" + rentTime +
            ", rentType='" + rentType + '\'' +
            ", rentCarName='" + rentCarName + '\'' +
            ", rentCarNum='" + rentCarNum + '\'' +
            ", rentMoney=" + rentMoney +
            ", serviceMoney=" + serviceMoney +
            ", totalMoney=" + totalMoney +
            ", orderNum='" + orderNum + '\'' +
            ", rentCity='" + rentCity + '\'' +
            ", driveLong=" + driveLong +
            ", orderStatus=" + orderStatus +
            ", payStatus=" + payStatus +
            ", userid=" + userid +
            ", carid=" + carid +
            '}';
  }

  public long getOid() {
    return oid;
  }

  public void setOid(long oid) {
    this.oid = oid;
  }


  public String getGetCarAddress() {
    return getCarAddress;
  }

  public void setGetCarAddress(String getCarAddress) {
    this.getCarAddress = getCarAddress;
  }


  public String getReturnCarAddress() {
    return returnCarAddress;
  }

  public void setReturnCarAddress(String returnCarAddress) {
    this.returnCarAddress = returnCarAddress;
  }


  public String getGetCarTime() {
    return getCarTime;
  }

  public void setGetCarTime(String getCarTime) {
    this.getCarTime = getCarTime;
  }


  public String getReturnCarTime() {
    return returnCarTime;
  }

  public void setReturnCarTime(String returnCarTime) {
    this.returnCarTime = returnCarTime;
  }


  public long getRentTime() {
    return rentTime;
  }

  public void setRentTime(long rentTime) {
    this.rentTime = rentTime;
  }


  public String getRentType() {
    return rentType;
  }

  public void setRentType(String rentType) {
    this.rentType = rentType;
  }


  public String getRentCarName() {
    return rentCarName;
  }

  public void setRentCarName(String rentCarName) {
    this.rentCarName = rentCarName;
  }


  public String getRentCarNum() {
    return rentCarNum;
  }

  public void setRentCarNum(String rentCarNum) {
    this.rentCarNum = rentCarNum;
  }


  public long getRentMoney() {
    return rentMoney;
  }

  public void setRentMoney(long rentMoney) {
    this.rentMoney = rentMoney;
  }


  public long getServiceMoney() {
    return serviceMoney;
  }

  public void setServiceMoney(long serviceMoney) {
    this.serviceMoney = serviceMoney;
  }


  public long getTotalMoney() {
    return totalMoney;
  }

  public void setTotalMoney(long totalMoney) {
    this.totalMoney = totalMoney;
  }


  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }


  public String getRentCity() {
    return rentCity;
  }

  public void setRentCity(String rentCity) {
    this.rentCity = rentCity;
  }


  public double getDriveLong() {
    return driveLong;
  }

  public void setDriveLong(double driveLong) {
    this.driveLong = driveLong;
  }


  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }

  public long getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(long payStatus) {
    this.payStatus = payStatus;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public long getCarid() {
    return carid;
  }

  public void setCarid(long carid) {
    this.carid = carid;
  }

}
