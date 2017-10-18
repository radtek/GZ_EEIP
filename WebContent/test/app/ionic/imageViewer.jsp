<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %><%@ page import="java.io.*" %><%
File image = new File(request.getParameter("path"));
if ( image.exists() && image.canRead() ) {
	FileInputStream inputStream = new FileInputStream(image);
    byte[] data = new byte[(int)image.length()];
    inputStream.read(data);
    inputStream.close();
    response.setContentType("image/jpeg");
    OutputStream stream = response.getOutputStream();
    stream.write(data);
    stream.flush();
    stream.close();
}
%>