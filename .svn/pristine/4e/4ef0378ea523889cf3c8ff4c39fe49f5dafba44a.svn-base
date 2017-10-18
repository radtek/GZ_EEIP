package org.pangolin.eeip.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class ServiceTicketServlet extends HttpServlet {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceTicketServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServiceTicket(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServiceTicket(request, response);
	}
	
	private void getServiceTicket(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String protocol = request.getParameter("protocol");
			String serviceAddress = request.getParameter("serviceAddress");
			String serverPort = request.getParameter("serverPort");
			String serviceName = request.getParameter("serviceName");
			
			if ( session.getAttribute("service_ticket") != null ) {
				String ticketId = (String)session.getAttribute("service_ticket");
				if ( ticketId != null && !ticketId.trim().equals("") ) {
					String url = "";
					if ( Integer.valueOf(serverPort) == 80 ) 
						url = protocol + "://"+ serviceAddress + "/" + serviceName + "/proxy?service_ticket=" + ticketId;
		        	else 
		        		url = protocol + "://"+ serviceAddress + ":" + Integer.valueOf(serverPort) + "/" + serviceName + "/proxy?service_ticket=" + ticketId;
					
					response.sendRedirect(url);
				}
			}
		}  catch(Exception ex) { log.error(ex.getMessage()); }
	}
}