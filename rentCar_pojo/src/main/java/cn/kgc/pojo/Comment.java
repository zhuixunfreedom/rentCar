package cn.kgc.pojo;


public class Comment {

  private long id;
  private double carPoint;
  private double qualityPoint;
  private double attitudePoint;
  private String comment;
  private String commentImg;


  public Comment() {
  }

  public Comment(long id, double carPoint, double qualityPoint, double attitudePoint, String comment, String commentImg) {

    this.id = id;
    this.carPoint = carPoint;
    this.qualityPoint = qualityPoint;
    this.attitudePoint = attitudePoint;
    this.comment = comment;
    this.commentImg = commentImg;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "id=" + id +
            ", carPoint=" + carPoint +
            ", qualityPoint=" + qualityPoint +
            ", attitudePoint=" + attitudePoint +
            ", comment='" + comment + '\'' +
            ", commentImg='" + commentImg + '\'' +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getCarPoint() {
    return carPoint;
  }

  public void setCarPoint(double carPoint) {
    this.carPoint = carPoint;
  }


  public double getQualityPoint() {
    return qualityPoint;
  }

  public void setQualityPoint(double qualityPoint) {
    this.qualityPoint = qualityPoint;
  }


  public double getAttitudePoint() {
    return attitudePoint;
  }

  public void setAttitudePoint(double attitudePoint) {
    this.attitudePoint = attitudePoint;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getCommentImg() {
    return commentImg;
  }

  public void setCommentImg(String commentImg) {
    this.commentImg = commentImg;
  }

}
