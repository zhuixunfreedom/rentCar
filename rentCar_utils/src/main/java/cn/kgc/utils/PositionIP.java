package cn.kgc.utils;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 基本方法
 * 通过ip     获取城市名getAddresses("ip=" + ip, "utf-8")参数为ip
 * 通过城市名 获取经纬度getCoordinate(address)参数为address
 * 通过经纬度 获取两地距离getDistance(double lng1, double lat1,double lng2, double lat2)参数为两地的经纬度
 */

//测试北京ip：123.125.71.38
//测试郑州ip：123.160.228.162
//测试上海ip：116.234.222.36
//    此方法有一定误差，且需联网
public class PositionIP {
    public static void main(String[] args) {
//        通过ip获取距离
        System.out.println(byIPgetDistance("123.125.71.38","116.234.222.36")+"公里");
//        通过城市名获取距离
        System.out.println(byAddressgetDistance("北京","上海")+"公里");
    }

    private static String byIPgetDistance(String ip1,String ip2){
        String address1 = "";
        String address2 = "";
        Object[] address1Coordinate = new Object[2];
        Object[] address2Coordinate = new Object[2];
        try {
            address1 = getAddresses("ip=" + ip1, "utf-8");
            address2 = getAddresses("ip=" + ip2, "utf-8");
            address1Coordinate = getCoordinate(address1);
            address2Coordinate = getCoordinate(address2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double distance = getDistance(Double.parseDouble(address1Coordinate[0].toString()), Double.parseDouble(address1Coordinate[1].toString()), Double.parseDouble(address2Coordinate[0].toString()), Double.parseDouble(address2Coordinate[1].toString()));
        return String.valueOf(distance);
    }

    private static String byAddressgetDistance(String address1,String address2){
        Object[] address1Coordinate = new Object[2];
        Object[] address2Coordinate = new Object[2];
        try {
            address1Coordinate = getCoordinate(address1);
            address2Coordinate = getCoordinate(address2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double distance = getDistance(Double.parseDouble(address1Coordinate[0].toString()), Double.parseDouble(address1Coordinate[1].toString()), Double.parseDouble(address2Coordinate[0].toString()), Double.parseDouble(address2Coordinate[1].toString()));
        return String.valueOf(distance);
    }

    /**
     * 3 * @param content 请求的参数 格式为：name=xxx&pwd=xxx
     *
     * encoding 服务器端请求编码。如GBK,UTF-8等
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getAddresses(String content, String encodingString) throws UnsupportedEncodingException {
        // 这里调用pconline的接口
        String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
        // 从http://whois.pconline.com.cn取得IP所在的省市区信息
        String returnStr = getResult(urlStr, content, encodingString);
        if (returnStr != null) {
            // 处理返回的省市区信息
//            System.out.println("IP=====" + returnStr);
            String[] temp = returnStr.split(",");
            if (temp.length < 3) {
                return "0"; // 无效IP，局域网测试
            }
            String region = (temp[5].split(":"))[1].replaceAll("\"", "");
            region = decodeUnicode(region); // 省
//            System.out.println("region = " + region);

            String country = "";
            String area = "";
            // String region = "";
            String city = "";
            String county = "";
            String isp = "";
//            System.out.println("temp的长度=" + temp.length);
            for (int i = 0; i < temp.length; i++) {
                switch (i) {
                    // 如果使用的是新浪的接口，那这里的需要修改，case:3 4 5分别对应国家，省，市区
                    case 1:
                        country = (temp[i].split(":"))[2].replaceAll("\"", "");
                        country = decodeUnicode(country); // 国家
                        break;
                    case 3:
                        area = (temp[i].split(":"))[1].replaceAll("\"", "");
                        area = decodeUnicode(area); // 地区
                        break;
                    case 5:
                        region = (temp[i].split(":"))[1].replaceAll("\"", "");
                        region = decodeUnicode(region); // 省份
                        break;
                    case 7:
                        city = (temp[i].split(":"))[1].replaceAll("\"", "");
                        city = decodeUnicode(city); // 市区
                        break;
                    case 9:
                        county = (temp[i].split(":"))[1].replaceAll("\"", "");
                        county = decodeUnicode(county); // 地区
                        break;
                    case 11:
                        isp = (temp[i].split(":"))[1].replaceAll("\"", "");
                        isp = decodeUnicode(isp); // ISP公司
                        break;
                }
            }
//            System.out.println(country + "=" + area + "=" + region + "=" + city + "=" + county + "=" + isp);
            return region;
        }
        return null;
    }

    /**
     * @param urlStr   请求的地址
     * @param content  请求的参数 格式为：name=xxx&pwd=xxx
     * @param encoding 服务器端请求编码。如GBK,UTF-8等
     * @return
     */
    private static String getResult(String urlStr, String content, String encoding) {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection(); // 新建连接实例
            connection.setConnectTimeout(2000); // 设置连接超时时间，单位毫秒
            connection.setReadTimeout(2000); // 设置读取数据超时时间，单位毫秒
            connection.setDoOutput(true); // 是否打开输出流 true|false
            connection.setDoInput(true); // 是否打开输入流true|false
            connection.setRequestMethod("POST"); // 提交方法POST|GET
            connection.setUseCaches(false); // 是否缓存true|false
            connection.connect(); // 打开连接端口
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
            out.writeBytes(content); // 写数据,也就是提交你的表单 name=xxx&pwd=xxx
            out.flush(); // 刷新
            out.close(); // 关闭输出流
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
            // ,以BufferedReader流来读取
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect(); // 关闭连接
            }
        }
        return null;
    }

    /**
     * unicode 转换成 中文
     *
     * @author fanhui 2007-3-15
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed  encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }

    /**
     * @param addr
     * 根据地址查询经纬度
     * @return
     * @throws IOException
     */
    public static Object[] getCoordinate(String addr) throws IOException {
        String lng = null;//经度
        String lat = null;//纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String key = "f247cdb592eb43ebac6ccd27f796e2d2";
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                int count = 1;
                while((data= br.readLine())!=null){
                    if(count==5){
                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                        count++;
                    }else if(count==6){
                        lat = data.substring(data.indexOf(":")+1);//纬度
                        count++;
                    }else{
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(insr!=null){
                insr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat};
    }

    /**
     * 计算两个地点的距离
     *
     * @param lng1 第一个经度
     * @param lat1 第一个纬度
     * @param lng2 第二个经度
     * @param lat2 第二个纬度
     * @return 两个经纬度的距离
     */
    public static double getDistance(double lng1, double lat1,double lng2, double lat2) {
        double radLat1 = rad(lat1);//纬度
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;//两点纬度之差
        double b = rad(lng1) - rad(lng2);//经度之差

        //计算两点之间距离的公式
        double s = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        //弧长乘地球半径（半径）（km）
        s = s * 6378.137;
        //精确距离的数值（单位千米）
        s = (s * 10000) / 10000;
        //保留一位小数
        s = Double.parseDouble(String.format("%.1f",s));
        return s;
    }
    private static double rad(double d) {
        //角度转换成弧度
        return d * Math.PI / 180.0;
    }



}
