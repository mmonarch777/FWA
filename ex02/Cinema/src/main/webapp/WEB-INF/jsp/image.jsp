<%@ page import="java.io.File" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="sun.misc.IOUtils" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%
    String uniqName = request.getPathInfo().substring(1);
    InputStream in = Files.newInputStream(Paths.get(request.getSession().getAttribute("path") + File.separator + uniqName));
    String type = uniqName.substring(uniqName.indexOf('.') + 1);
    if ("jpeg".equals(type))
        response.setContentType("image/jpeg");
    else
        response.setContentType("image/png");
    ServletOutputStream outputStream = response.getOutputStream();
    outputStream.write(IOUtils.readAllBytes(in));
    outputStream.close();
    in.close();
%>
