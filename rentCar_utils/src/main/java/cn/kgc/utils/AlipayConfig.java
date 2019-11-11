package cn.kgc.utils;


public class AlipayConfig {


	// 商家的appId
	public static String app_id = "2016101300679500";
	
	// 商家私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCMh5z0lBVDfGafq0PpV8cdvTLt/Q1vdyLShRvA4cPTxlUmbZCP7RRfPXkRwIMfHN/FQIqYz6Dm5SktkAie/IoVoXBV7UILxhe4aBD4glYwnL8bv0PkYXmKhk7yZfzdjIAiDKK4mKtDBGP5imBvhzZj1lwqKG9/TNGDI8gFYVOZlG2lyKgw8ebYFF4y6vYWo1dDHJZ1/LieYP8TxAECvx8eAWjiDxvtFTPyFqP6f7KfYp49KhOiwU15+LcHjUixsXW6TxwOhZYxvkbBRtwKnDssbXb2JqUZg9d6HdReIn9uSbuw2uRYJw4Of0Ppta9JliYCO9IbFUFdLLLjOe1XfcwhAgMBAAECggEAKXj4NCHjqJf0/Vgg4aNbCwbEGgIdTfD94N0RlLnL/hrBFGcvS5pu8bCFo1yKFcuCqobioDheRuYIYf7o3GqxIbMUIPe1Dx5176EeqQhmAVCxAbJPif3OTbhXYigBGS0Wv3W1K/86Q7vu+T0COsfPoGUpq/Nk/E+iYS5VIGlZr6/ypF2Gb4feFrOUxNEi1sUF6gV8Vv6DxOpYTghVU8G/zSUIOXNEca6n6pdUbPyn8JWzrxaf9pu8H5hUoHDI0+u/BC12BlJvv2Vp8aDSRg1L8i9GK/il/hL1SdCDKKOOcjtbe4yPgKbVBH4UjtPgmOzsN4wvMboIz1jVgsU5Ar1ZdQKBgQDSOnycAJVcbDQWN3cVnA3uXG7qEo8nphaBJuhKH6Uk9qYxuOFMptivuz3nMUvD2zVD7QAOpwhx4pej4FCvu1C8gPNgfyIXE65ueeotZx2k29dkY4bdn5NQBrFun5rJ5T7auEdRg2Zr8uBBFihx1C3YmzDgK+VT+6kNtAtA2yTcfwKBgQCrIFNNu8YNCo4hq+5lIfFueRCRqIXD22vloBSLq4I7FA9rpiJ+gha+8I88q1Ps5ZcDZO1zQ34NnpmhPwQ/bIQT/DbeCwjUAMFFSn0m1m7L5slzU1uZsjvFjsxi3rliGPmLEdtdmxQGdb6hqUGrXF77c48O7DFc50vo59RyKveHXwKBgBYH8w8WMJDi9gJuBZjKJduY7DazgzUQfsNCJI3ACzp4bqo/Sb0SrxqbcL1NuTbpPgfESoE+l+/3YxTVaR9BbhCTIu415Iiuk1UYiaYAbGbecxAeLgADvRhh2y5Qo5QM5i1dqnusXYtqhH3NqKdlKPjOKq0TbJEEio7ZE2TUkmRZAoGBAJFuF12ohtfucHwNMbyg7B2GpZ4kKgoZH8k2Ej/gsfyjP7esqQP6ano61oAo2lopg/1OeL3MTgQlFUsD0whToKubXMW3evkw6w+IDnRDKEYBDJMF9ILaBhIPGYOs5L+JmgmmU1dpw8r5pdidj0GibtYjjyCPeiQKLWjyHIoqGdLhAoGAPXhBOutCLrmSQDX5vbZJUc87Y6iZLK2mVJUpOmQd7JmfjC/NhEQenrmYLz2rRGkxMbGNUjXpQnpts8LbEwFQ5VnOyzsSahD+im1ofzLgeVOYf+gynQbJsDDOy4MzC7cAF5t1FZXF6b2FXWdF7AhcOusXqeBFKozeTHhabCSFRe8=";
	
	// 支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsN8yCCE3YGFhVKn+YI6BlTAwmzAkfRDTGsFN+D7Ch2ClNdgMNFJAQzh2+bt5fw9bAopzjFaJISwuu9ZKQo+V2q9GW9LzxWgEJZoetrDYZY2cN/LNHFUGFHhzxG45oTNgPzjv9rYrp1g7/l//vIoRfM09lGkhbV9n0+vW9M6/2TgdNZ2d6hPf40p5x2QDOZtMkaKHto5GScIn8q0lji5DfBqpgXy3IGudm3od25Df9+duw7Nx7P5z2HknuXrSPrGwLy70lSbH0diynX0zOQCJ4ZIecKNgZokY1w9GCjUQ25UbwODqzxhLvBtx2atWeqWKJHawAf5gACmY7w3MGH28ZQIDAQAB";

	// 异步返回路径
	public static String notify_url = "http://n262658x42.qicp.vip/notify_url.jsp";

	// 同步返回路径
	public static String return_url = "http://n262658x42.qicp.vip/index.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码
	public static String charset = "utf-8";

//	支付宝网关
//  正式环境https://openapi.alipay.com/gateway.do
//  沙箱环境https://openapi.alipaydev.com/gateway.do
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志路径
//	public static String log_path = "C:\\";


//	输出日志
//    public static void logResult(String sWord) {
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
//            writer.write(sWord);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}

