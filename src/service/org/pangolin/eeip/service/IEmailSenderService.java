package org.pangolin.eeip.service;

public interface IEmailSenderService {

	public void sendMail(String title,String text,String mailAdress);
}
