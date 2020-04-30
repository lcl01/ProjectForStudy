package com.lcl.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SMSUtils {
    public static final String VAlIDATE_CODE="SMS_175060831";
    public static final String ORDER_NOTICE = "SMS_175051009";

    public static void sendShortMessage(String templateCode,String phoneNumbers,String param) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";
        final String accessKeyId = "LTAI4FsJgjEfBPD5KNMuTpw3";//LTAI4FsJgjEfBPD5KNMuTpw3\LTAI4FkzekeGY36jboV4wwZy
        final String accessKeySecret = "bospTd2No1SJAdS8pqvCbs5LWVuTdM";//bospTd2No1SJAdS8pqvCbs5LWVuTdM\Ok2IHSMy11M0UwEc5n6TyaH24e9Teh
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phoneNumbers);
        request.setSignName("lcl温馨提示");
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\""+param+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            // 请求成功
            System.out.println("请求成功");}
    }

//    public static void main(String[] args) throws ClientException {
//        Integer code = ValidateCodeUtils.generateValidateCode(4);
//        System.out.println(code);
//        sendShortMessage(VAlIDATE_CODE,"19926584284",code+"");
//    }
}
