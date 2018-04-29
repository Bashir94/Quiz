<%-- 
    Document   : correction
    Created on : 25 avr. 2018, 20:54:35
    Author     : USER
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Exam.DAOExam"%>
<%@page import="java.util.List"%>
<%@page import="Model.Exam.Exam"%>
<%@page import="Model.Exam.ImpDAOExam"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Correction</title>
          <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <style>
            #div  {
    border: 1px solid black;
    margin-top: 5%;
    margin-right: 10%;
    margin-left: 10%;
}
        </style>
    </head>
    <body>
          <% 
         Long ide = Long.parseLong(request.getParameter("ide"));
         Exam e = (Exam)new ImpDAOExam().getExam(ide);
        %>
         <%@include file="navbar.jsp" %>
    <c:set var="ide" value="<%=request.getParameter("ide")%>"/>
     <c:set var="idq" value="<%=request.getParameter("idq")%>"/>
     <c:set var="rep" value="<%=request.getParameter("rep")%>"/>
      <c:set var="q" value="<%=e.getQuestions()%>"/>
       <c:set var="i" value="0"/>
       <c:forEach items= '${q}' var='e' >
      <c:set var="i" value="${i+1}"/>
      <div id='div'>
      <label class="control-label col-sm-2" for="email">Question N° ${i}</label>
      <div class="col-sm-10">
       ${e.getLibelle()}
        <br>
        <c:set var="value1" value="${e.getChoix().get(0).getValue()}"/>
        <c:set var="value2" value="${e.getChoix().get(1).getValue()}"/>
        <c:set var="value3" value="${e.getChoix().get(2).getValue()}"/>
        <c:set var="str" value="${fn:substring(rep, i, i+1)}"/>
        <ul>
            <li class="list-group-item">
                 <c:choose>
                        <c:when test="${value1=='True'}">
                            ${e.getChoix().get(0).getLibelle()}&#9989                       
                        </c:when>
                        <c:when test="${str=='1' and value1!='True'}">
                            ${e.getChoix().get(0).getLibelle()}&#10060                       
                        </c:when>
                        <c:when test="${str!='1' and value1!='True'}">
                            ${e.getChoix().get(0).getLibelle()}                       
                        </c:when>
                </c:choose>
            </li>
            <li class="list-group-item">
                <c:choose>
                        <c:when test="${value2=='True'}">
                           ${e.getChoix().get(1).getLibelle()}&#9989                        
                        </c:when>
                        <c:when test="${str=='2' and value2!='True'}">
                            ${e.getChoix().get(1).getLibelle()}&#10060                       
                        </c:when>
                        <c:when test="${str!='2' and value2!='True'}">
                            ${e.getChoix().get(1).getLibelle()}                       
                        </c:when>
                </c:choose>
        
            </li>
            <li class="list-group-item">
               <c:choose>
                        <c:when test="${value3=='true'}">
                            ${e.getChoix().get(2).getLibelle()}&#9989                      
                        </c:when>
                        <c:when test="${str=='3' and value3!='True'}">
                            ${e.getChoix().get(2).getLibelle()}&#10060                   
                        </c:when>
                            <c:when test="${str!='3' and value3!='True'}">
                            ${e.getChoix().get(2).getLibelle()}                       
                        </c:when>
                </c:choose>        
            </li>
        </ul>
      </div>
      
</div>

  </c:forEach>
    </body>
</html>
