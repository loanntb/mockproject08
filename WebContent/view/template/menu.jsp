<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 try{
      int quyen = (int) session.getAttribute("Quyen");
    if(quyen==0){ %>  
   <%@ include file="/view/template/menuAdmin.jsp"%>
   <%} 
    else {if(quyen ==1 ){ %>
         <%@ include file="/view/template/menuNV.jsp"%>
        <%}}}
    catch (Exception e){%>
               <%@ include file="/view/template/menuNV.jsp"%>
             <%}%>