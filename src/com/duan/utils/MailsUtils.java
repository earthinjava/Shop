package com.duan.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailsUtils {
	/**
	 * 
	 * @param myEmailAccount ������������
	 * @param myEmailPassword ��������������
	 * @param myEmailSMTPHost ����������SMTPhost
	 * @param receiveMailAccount	�ռ���������
	 * @param subject	������
	 * @param content 	��������
	 */
	public static void sendMail(String myEmailAccount, String myEmailPassword, String myEmailSMTPHost,
			String receiveMailAccount, String subject, String content) {
		 // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
        
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        
        
        
        // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getDefaultInstance(props);
        // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        session.setDebug(true);                       
        // 3. ����һ���ʼ�
        MimeMessage message;
		try {
			message = createMimeMessage(session, myEmailAccount, receiveMailAccount,subject,content);
        // 4. ���� Session ��ȡ�ʼ��������
        Transport transport = session.getTransport();

        // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
        // 
        //    PS_01: �ɰܵ��жϹؼ��ڴ�һ��, ������ӷ�����ʧ��, �����ڿ���̨�����Ӧʧ��ԭ��� log,
        //           ��ϸ�鿴ʧ��ԭ��, ��Щ����������᷵�ش������鿴�������͵�����, ���ݸ����Ĵ���
        //           ���͵���Ӧ�ʼ��������İ�����վ�ϲ鿴����ʧ��ԭ��
        //
        //    PS_02: ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
        //           (1) ����û�п��� SMTP ����;
        //           (2) �����������, ����ĳЩ���俪���˶�������;
        //           (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
        //           (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
        //           (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
        //
        //    PS_03: ��ϸ��log, ���濴log, ����log, ����ԭ����log��˵����
        transport.connect(myEmailAccount, myEmailPassword);
        // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());
        // 7. �ر�����
        transport.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	 private static MimeMessage createMimeMessage(Session session, String sendMail, 
			 String receiveMail,String subject,String content
			 ) throws Exception {
	        // 1. ����һ���ʼ�
	        MimeMessage message = new MimeMessage(session);	        
	        // 2. From: ������
	        message.setFrom(new InternetAddress(sendMail,"UTF-8"));
	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,"UTF-8"));

	        // 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
	        message.setSubject(subject, "UTF-8");

	        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
	        message.setContent(content, "text/html;charset=UTF-8");

	        // 6. ���÷���ʱ��
	        message.setSentDate(new Date());

	        // 7. ��������
	        message.saveChanges();

	        return message;
	    }
}
