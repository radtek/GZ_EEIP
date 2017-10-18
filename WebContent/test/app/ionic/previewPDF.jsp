<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ include file = "/common/taglibs.jsp"%>
<%@ page import="java.io.File" %>
<%@ page import="org.pangolin.eeip.common.Const" %>
<%@ page import="org.pangolin.eeip.util.SpringUtil" %>
<%@ page import="org.pangolin.eeip.entity.Document" %>
<%@ page import="org.pangolin.eeip.service.DocumentService" %>
<%@ page import="org.pangolin.eeip.util.PDFUtil" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>PDF VIEWER</title>
  </head>
  <body>
    <center>
    <%
    SpringUtil springUtil = new SpringUtil();
    DocumentService documentService = (DocumentService) springUtil.getBean("documentService");
    Document document = documentService.getDocumentById(request.getParameter("id"));
    if ( document != null ) {
    	File dir = new File(Const.BP_DOCUMENT_PATH+"/preview/"+document.getId());
    	if ( dir.exists() ) {
    		String[] imageNames = dir.list();
    		for ( int i = 0; i < imageNames.length; i ++ ) {
    			String path = Const.BP_DOCUMENT_PATH+"/preview/"+document.getId()+"/"+"pdf-img-capture-"+i+".jpg";
    			%>
    			<img style="width: 100%;" src="${pageContext.request.contextPath}/test/app/ionic/imageViewer.jsp?path=<%=path %>"/><br/>
    			<%
    		}
    	} else {
    		String[] imagePath = PDFUtil.generateImages(document.getPath(), Const.BP_DOCUMENT_PATH+"/preview/"+document.getId());
    		for ( String path : imagePath ) {
    			%>
    			<img style="width: 100%;" src="${pageContext.request.contextPath}/test/app/ionic/imageViewer.jsp?path=<%=path %>"/><br/>
    			<%
    		}
    	}
    }
    %>
    </center>
  </body>
</html>