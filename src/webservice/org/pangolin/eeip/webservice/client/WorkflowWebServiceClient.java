package org.pangolin.eeip.webservice.client;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WorkflowWebServiceClient extends BaseWebServiceClient {
	
	/**
	 * 根据流程模板标识初始化流程实例
	 * @author Oscar Mok
	 * @param processDefinitionKey 流程模板标识
	 * @return 流程实例ID
	 * */
	public String initProcessInstanceByKey(String processDefinitionKey) {
		String procInstId = null;
		try {
			if ( processDefinitionKey != null 
					&& !processDefinitionKey.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { processDefinitionKey };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "initProcessInstanceByKey");
			    
			    procInstId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return procInstId;
	}
	
	/**
	 * 启动工作项
	 * @author Oscar Mok
	 * @param sender 发送者帐号
	 * @param receiver 接收者帐号
	 * @param receiptDate 接收时间毫秒数（单位：毫秒）
	 * @param procInstId 流程实例ID
	 * @param procActInstId 流程环节实例ID
	 * @return 新工作项ID
	 * */
	public String startTask(String sender, String receiver, long receiptDate, String procInstId, String procActInstId) {
		String taskId = null;
		try {
			if ( sender != null && !sender.trim().equals("") 
					&& receiver != null && !receiver.trim().equals("")
					&& procInstId != null && !procInstId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { sender, receiver, receiptDate, procInstId, procActInstId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "startTask");
			    
			    taskId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return taskId;
	}
	
	/**
	 * 获取当前运作中的工作项
	 * @author Oscar Mok
	 * @param receiver 接收者帐号
	 * @param procInstId 流程实例ID
	 * @return 当前运作中的工作项ID
	 * */
	public String getProcessingTask(String receiver, String procInstId) {
		String taskId = null;
		try {
			if ( receiver != null && !receiver.trim().equals("")
					&& procInstId != null && !procInstId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { receiver, procInstId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "getProcessingTask");
			    
			    taskId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return taskId;
	}
	
	/**
	 * 完成工作项
	 * @author Oscar Mok
	 * @param workItemId 工作项ID
	 * @return 完成后的工作项ID
	 * */
	public String completeTask(String workItemId) {
		String taskId = null;
		try {
			if ( workItemId != null && !workItemId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { workItemId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "completeTask");
			    
			    taskId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return taskId;
	}
	
	/**
	 * 根据当前流程步骤实例ID获取下一环节实例ID
	 * @author Oscar Mok
	 * @param procActId 当前流程步骤实例ID
	 * @return 流程步骤实例ID
	 * */
	public String getNextProcAct(String procActId) {
		String nextProcActId = null;
		try {
			if ( procActId != null && !procActId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { procActId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "getNextProcAct");
			    
			    nextProcActId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return nextProcActId;
	}
	
	/**
	 * 根据工作项获取流程步骤实例ID
	 * @author Oscar Mok
	 * @param workItemId 工作项ID
	 * @return 流程步骤实例ID
	 * */
	public String getProcActInstByTask(String workItemId) {
		String procActInstId = null;
		try {
			if ( workItemId != null && !workItemId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { workItemId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "getProcActInstIdByTask");
			    
			    procActInstId = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return procActInstId;
	}
	
	/**
	 * 根据工作项获取发送者帐号
	 * @author Oscar Mok
	 * @param workItemId 工作项ID
	 * @return 发送者帐号
	 * */
	public String getSenderByTask(String workItemId) {
		String userName = null;
		try {
			if ( workItemId != null && !workItemId.trim().equals("") ) {
				RPCServiceClient serviceClient = new RPCServiceClient();
			    Options options = serviceClient.getOptions();
			    
			    EndpointReference targetEPR = new EndpointReference(getWebServiceURL("WORKFLOW_MGT_WS"));
			    options.setTo(targetEPR);
			    options.setTimeOutInMilliSeconds(WS_TIMEOUT);
			    
			    Object[] opAddEntryArgs = new Object[] { workItemId };
			    Class[] classes = new Class[] { String.class };
			    QName opAddEntry = new QName("http://www.pangolin.org/xsd", "getSenderByTask");
			    
			    userName = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0].toString();
			}
		} catch(Exception ex) { ex.printStackTrace(); }
		return userName;
	}
	
	public static void main(String args[]) {
		WorkflowWebServiceClient client = new WorkflowWebServiceClient();
		//System.out.println(client.initProcessInstanceByKey("EEIP"));
		//System.out.println(client.startTask("test1", "test2", new Date().getTime(), "297e6ace5b805b74015b806150bc0001", ""));
		//System.out.println(client.getProcessingTask("test2", "297e6ace5b805b74015b806150bc0001"));
		//System.out.println(client.completeTask("297e6ace5b80d0e3015b80d141a70000"));
		//System.out.println(client.getProcActInstByTask("297e6ace5b80d0e3015b80d141a70000"));
		//System.out.println(client.getSenderByTask("297e6ace5b80d0e3015b80d141a70000"));
		//System.out.println(client.getNextProcAct("4028813d5bebdd2f015bebdf82350017"));
	}
}