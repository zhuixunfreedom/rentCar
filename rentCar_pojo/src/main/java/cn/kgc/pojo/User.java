package cn.kgc.pojo;


public class User {

  private long uid;
  private String telNo;
  private String password;
  private String name;
  private String personId;
  private String driverId;
  private long driverTickets;
  private long points;
  private double rechargeMoney;
  private String rentCity;
  private String sex;
  private String email;
  private long verifyStatus;
  private long userStatus;

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", telNo='" + telNo + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", personId='" + personId + '\'' +
            ", driverId='" + driverId + '\'' +
            ", driverTickets=" + driverTickets +
            ", points=" + points +
            ", rechargeMoney=" + rechargeMoney +
            ", rentCity='" + rentCity + '\'' +
            ", sex='" + sex + '\'' +
            ", email='" + email + '\'' +
            ", verifyStatus=" + verifyStatus +
            ", userStatus=" + userStatus +
            '}';
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }


  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }


  public long getDriverTickets() {
    return driverTickets;
  }

  public void setDriverTickets(long driverTickets) {
    this.driverTickets = driverTickets;
  }


  public long getPoints() {
    return points;
  }

  public void setPoints(long points) {
    this.points = points;
  }


  public double getRechargeMoney() {
    return rechargeMoney;
  }

  public void setRechargeMoney(double rechargeMoney) {
    this.rechargeMoney = rechargeMoney;
  }


  public String getRentCity() {
    return rentCity;
  }

  public void setRentCity(String rentCity) {
    this.rentCity = rentCity;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getVerifyStatus() {
    return verifyStatus;
  }

  public void setVerifyStatus(long verifyStatus) {
    this.verifyStatus = verifyStatus;
  }


  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }

}
