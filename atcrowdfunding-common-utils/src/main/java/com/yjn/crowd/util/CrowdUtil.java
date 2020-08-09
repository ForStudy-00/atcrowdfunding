package com.yjn.crowd.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;
import com.yjn.crowd.constant.CrowdConstant;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Lenovo
 */
public class CrowdUtil {

    public static ResultEntity<String> sendMessage(String phoneNum, ArrayList<String> messageList) {
        String host = "https://edisim.market.alicloudapi.com";
        String path = "/comms/sms/sendmsg";
        String method = "POST";
        String appcode = "01e6b0ed5c4f496a9b910a5a9bde0511";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("callbackUrl", "http://test.dev.esandcloud.com");
        bodys.put("channel", "0");
        bodys.put("mobile", phoneNum);
        bodys.put("templateID", "0000000");
        bodys.put("templateParamSet", messageList.toString());


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultEntity.successWithData(phoneNum);
    }


    /**
     * * 判断当前请求是否是ajax请求  true:是    false :不是
     *
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request) {
        //获取请求的消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestheader = request.getHeader("X-Requested-With");
        //判断
        return ((acceptHeader != null && acceptHeader.contains("application/json")) ||
                ("XMLHttpRequest".equals(xRequestheader)));

    }

    public static String md5(String source) {
        // 判断resource是否有效
        if (source == null || source.length() == 0) {
            // 无效
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        } else {
            // 获取MessageDigest对象
            String algorithm = "md5";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
                // 获取明文字符串对应的字节数组
                byte[] input = source.getBytes();
                // 执行加密操作
                byte[] output = messageDigest.digest(input);
                // 创建BigInteger对象
                int signum = 1;
                BigInteger bigInteger = new BigInteger(signum, output);
                // 将bigInteger转换为16进制的字符
                int radix = 16;
                String encoded = bigInteger.toString(radix);
                // 将加密后的密码返回
                return encoded;

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 专门负责上传文件到 OSS 服务器的工具方法
     * @param endpoint OSS 参数
     * @param accessKeyId OSS 参数
     * @param accessKeySecret OSS 参数
     * @param inputStream 要上传的文件的输入流
     * @param bucketName OSS 参数
     * @param bucketDomain OSS 参数
     * @param originalName 要上传的文件的原始文件名
     * @return 包含上传结果以及上传的文件在 OSS 上的访问路径
     */
    public static ResultEntity<String> uploadFileToOss(
            String endpoint,
            String accessKeyId,
            String accessKeySecret, InputStream inputStream,
            String bucketName,
            String bucketDomain,
            String originalName) {
        // 创建 OSSClient 实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 生成上传文件的目录
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 生成上传文件在 OSS 服务器上保存时的文件名
        // 原始文件名： beautfulgirl.jpg
        // 生成文件名： wer234234efwer235346457dfswet346235.jpg
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("-", "");
        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));
        // 使用目录、 文件主体名称、 文件扩展名称拼接得到对象名称
        String objectName = folderName + "/" + fileMainName + extensionName;
        try {
        // 调用 OSS 客户端对象的方法上传文件并获取响应结果数据
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, inputStream);
        // 从响应结果中获取具体响应消息
            ResponseMessage responseMessage = putObjectResult.getResponse();
        // 根据响应状态码判断请求是否成功
            if (responseMessage == null) {
        // 拼接访问刚刚上传的文件的路径
                String ossFileAccessPath = bucketDomain + "/" + objectName;
        // 当前方法返回成功
                return ResultEntity.successWithData(ossFileAccessPath);
            } else {
        // 获取响应状态码
                int statusCode = responseMessage.getStatusCode();
        // 如果请求没有成功， 获取错误消息
                String errorMessage = responseMessage.getErrorResponseAsString();
        // 当前方法返回失败
                return ResultEntity.failed(" 当 前 响 应 状 态 码 =" + statusCode + " 错 误 消 息 =" + errorMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        // 当前方法返回失败
            return ResultEntity.failed(e.getMessage());
        } finally {
            if (ossClient != null) {
        // 关闭 OSSClient。
                ossClient.shutdown();
            }
        }
    }
}
