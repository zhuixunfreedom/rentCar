package cn.kgc.pojo;


public class Shop {

  private long sid;
  private String shopName;
  private String shopAddress;
  private String shopCity;
  private String shopTel;

  @Override
  public String toString() {
    return "Shop{" +
            "sid=" + sid +
            ", shopName='" + shopName + '\'' +
            ", shopAddress='" + shopAddress + '\'' +
            ", shopCity='" + shopCity + '\'' +
            ", shopTel='" + shopTel + '\'' +
            '}';
  }

  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }


  public String getShopAddress() {
    return shopAddress;
  }

  public void setShopAddress(String shopAddress) {
    this.shopAddress = shopAddress;
  }


  public String getShopCity() {
    return shopCity;
  }

  public void setShopCity(String shopCity) {
    this.shopCity = shopCity;
  }


  public String getShopTel() {
    return shopTel;
  }

  public void setShopTel(String shopTel) {
    this.shopTel = shopTel;
  }

}
