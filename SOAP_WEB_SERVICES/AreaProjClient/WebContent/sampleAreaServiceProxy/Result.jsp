<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAreaServiceProxyid" scope="session" class="org.tempuri.AreaService.AreaServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAreaServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAreaServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAreaServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        org.tempuri.AreaService.AreaService_PortType getAreaService_PortType10mtemp = sampleAreaServiceProxyid.getAreaService_PortType();
if(getAreaService_PortType10mtemp == null){
%>
<%=getAreaService_PortType10mtemp %>
<%
}else{
        if(getAreaService_PortType10mtemp!= null){
        String tempreturnp11 = getAreaService_PortType10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String height_2id=  request.getParameter("height18");
        float height_2idTemp  = Float.parseFloat(height_2id);
        String width_3id=  request.getParameter("width20");
        float width_3idTemp  = Float.parseFloat(width_3id);
        %>
        <jsp:useBean id="org1tempuri1AreaService1Dimensions_1id" scope="session" class="org.tempuri.AreaService.Dimensions" />
        <%
        org1tempuri1AreaService1Dimensions_1id.setHeight(height_2idTemp);
        org1tempuri1AreaService1Dimensions_1id.setWidth(width_3idTemp);
        float calculateRectArea13mtemp = sampleAreaServiceProxyid.calculateRectArea(org1tempuri1AreaService1Dimensions_1id);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(calculateRectArea13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>