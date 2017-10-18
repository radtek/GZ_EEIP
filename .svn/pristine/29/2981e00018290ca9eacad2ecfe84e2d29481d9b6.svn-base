package org.pangolin.eeip.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.pangolin.eeip.common.Const;
import org.pangolin.eeip.service.MessagePushService;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

@Service("messagePushService")
@SuppressWarnings("all")
public class MessagePushServiceImpl implements MessagePushService {
	
	public void pushMessage(String alert) {
		JPushClient jpushClient = new JPushClient(Const.MASTER_SECRET, Const.APP_KEY);
        PushPayload payload = buildDefaultPayLoad(alert);
        try {
            jpushClient.sendPush(payload);
        } catch (APIConnectionException ex) {
        	ex.printStackTrace();
        } catch (APIRequestException ex) {
        	ex.printStackTrace();
        }
	}

	public void pushMessage(String alias, String alert) {
		JPushClient jpushClient = new JPushClient(Const.MASTER_SECRET, Const.APP_KEY);
        PushPayload payload = buildPayLoad(alias, alert);
        try {
            jpushClient.sendPush(payload);
        } catch (APIConnectionException ex) {
        	ex.printStackTrace();
        } catch (APIRequestException ex) {
        	ex.printStackTrace();
        }
	}
	
	public void pushMessage(String[] tags, String alert) {
		JPushClient jpushClient = new JPushClient(Const.MASTER_SECRET, Const.APP_KEY);
        PushPayload payload = buildPayLoad(Arrays.asList(tags), alert);
        try {
            jpushClient.sendPush(payload);
        } catch (APIConnectionException ex) {
        	ex.printStackTrace();
        } catch (APIRequestException ex) {
        	ex.printStackTrace();
        }
	}
	
	/**
	 * 构建默认推送对象（针对所有平台，所有设备）
	 * @param alert 消息内容
	 * */
	private PushPayload buildDefaultPayLoad(String alert) {
		return PushPayload.alertAll(alert);
	}
	
	/**
	 * 构建默认推送对象（针对所有平台，指定别名）
	 * @param alias 别名（为安装了应用程序的用户，取个别名来标识。以后给该用户 Push 消息时，就可以用此别名来指定）
	 * @param alert 消息内容
	 * */
	private PushPayload buildPayLoad(String alias, String alert) {
		return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
	}
	
	/**
	 * 构建默认推送对象（针对所有平台，指定标签）
	 * @param tags 标签集合（安装了应用程序的用户，打上标签。其目的主要是方便开发者根据标签，来批量下发 Push 消息）
	 * @param alert 消息内容
	 * */
	private PushPayload buildPayLoad(Collection<String> tags, String alert) {
		return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.alert(alert))
                .build();
	}
	
	/*public static void main(String args[]) {
		new MessagePushServiceImpl().pushMessage("oscarmok", "Test Msg");
		new MessagePushServiceImpl().pushMessage(new String[] { "admin", "mr_admin" }, "Test Msg");
	}*/
}