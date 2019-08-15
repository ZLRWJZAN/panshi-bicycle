package com.panshi.userservice.service.impl;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.panshi.userservice.service.SendVerifyService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class SendVerfiyServiceImpl implements SendVerifyService {

    /**
     * 生成验证码
     * @return
     */
    @Override
    public String generateVerifynCode() {
        //生成随机数
        Random random = new Random();

        //保存随机生成的验证码
        String str = "";
        for (int i = 0; i < 6 ; i++){
            str+=(int)(Math.random()*9);
        }
        return  str;
    }

    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    @Override
    public int sendPhoneVerifyCode(String code,String phone)throws HttpProcessException {

        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String url = "http://v.juhe.cn/sms/send";

        Map map = new HashMap(6);
        //接受短信的用户手机号码
        map.put("mobile",phone);
        //您申请的短信模板ID，根据实际情况修改
        map.put("tpl_id","168920");
        //您设置的模板变量，根据实际情况修改
        map.put("tpl_value","%23code%23%3d"+code);
        //应用APPKEY(应用详细页查询)
        map.put("key","ca3e339f005c92e9358233def1759bcc");
        map.put("dtype","");

        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .url(url)	          //设置请求的url
                .map(map)          //设置请求参数，没有则无需设置
                .client(httpClient);
        String r =  HttpClientUtil.post(config);
        System.out.println(r);

        return 0;
    }

    /**
     * 发送邮箱验证码
     * @return
     */
    @Override
    public String sendMailboxVerifynCode(String code,String mailbox) {

        // 属性
        Properties properties = new Properties();
        // 设置认证属性
        properties.setProperty( "mail.smtp.auth", "true" );
        // 设置通信协议
        properties.setProperty( "mail.transport.protocol", "smtp" );
        // 邮件环境信息
        Session session = Session.getInstance( properties );
        // 调试,打印信息
        session.setDebug( false );

        // 邮件
        Message message = new MimeMessage( session );

        try {
            // 主题
            message.setSubject( "验证码信息：" );
            // 发送人
            message.setFrom( new InternetAddress( "1094856904@qq.com" ) );
            // 内容
            message.setText( "验证码为："+code);

            // 邮件传输对象
            Transport transport = session.getTransport();
            // 传输连接：host，port，user，pass/主机，端口，用户名，密码
            transport.connect( "smtp.qq.com", 25, "1094856904@qq.com", "ughfmwotobeobaai" );
            // 发送邮件
            transport.sendMessage( message, new Address[]{new InternetAddress(mailbox)} );
        } catch (MessagingException e) {
        }
        return code;
    }
}
