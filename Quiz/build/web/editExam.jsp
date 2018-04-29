<%@page import="Model.Exam.DAOExam"%>
<%@page import="java.util.List"%>
<%@page import="Model.Exam.Exam"%>
<%@page import="Model.Exam.ImpDAOExam"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Modifier Examne</title>
  <meta charset="utf-8">
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
    <link href="css/coming-soon.min.css" rel="stylesheet">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Custom styles for this template -->
</head>
<body>
    <%@include file="navbar.jsp" %>

<div class="container">
        <% 
         Long ide = Long.parseLong(request.getParameter("ide"));
         Exam e = (Exam)new ImpDAOExam().getExam(ide);
        %>
  <h2>Modifier les Questions de l'examen <%=e.getLibelle() %></h2>
  <center> 
      <a  href='#myModal' class="modal-link" rel="<%=e.getIdExam() %>"role='button' data-toggle='modal'>
        <button class="btn btn-default"><i class='fa fa-trash-o'>Supprimer cet Examens?</i></button>
    </a><br><br>
    <script>
       $(".modal-link").click(function(){
       $("#submit-link").attr('href','DeleteExam?ide='+$(this).attr('rel'));
         $($(this).attr('href')).modal('show');
          });
    </script>
       
       
      <c:set var="q" value="<%=e.getQuestions()%>"/>
       <c:set var="i" value="0"/>
  <form class="form-horizontal" method="POST" action="EditExam">
<input type="hidden" value="<%= request.getParameter("ide")%>" name="ide">
        
  <c:forEach items= '${q}' var='e' >
      <c:set var="i" value="${i+1}"/>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Question N° ${i}</label>
      <div class="col-sm-10">
        <input type="text" value="${e.getLibelle()}" class="form-control" required  placeholder="entrez votre question" name="libelle${i}">
        <br>
        <c:set var="value1" value="${e.getChoix().get(0).getValue()}"/>
        <c:set var="value2" value="${e.getChoix().get(1).getValue()}"/>
        <c:set var="value3" value="${e.getChoix().get(2).getValue()}"/>
        <ul>
            <li class="list-group-item">
                réponse vrai? 
                 <c:choose>
                        <c:when test="${value1=='True'}">
                            <input type="radio" name="optradio${i}" value="1" checked>                       
                        </c:when>
                        <c:otherwise>
                              <input type="radio" name="optradio${i}" value="1"> 
                        </c:otherwise>
                </c:choose>
                <input value="${e.getChoix().get(0).getLibelle()}" type="text" class="form-control" required  placeholder="premier choix" name="choix1-${i}">       
            </li>
            <li class="list-group-item">
                réponse vrai?  
                <c:choose>
                        <c:when test="${value2=='True'}">
                            <input type="radio" name="optradio${i}" value="2" checked>                       
                        </c:when>
                        <c:otherwise>
                              <input type="radio" name="optradio${i}" value="2"> 
                        </c:otherwise>
                </c:choose>
                <input value="${e.getChoix().get(1).getLibelle()}" type="text" class="form-control" required placeholder="deuxiéme choix" name="choix2-${i}">
        
            </li>
            <li class="list-group-item">
                réponse vrai?   
               <c:choose>
                        <c:when test="${value3=='true'}">
                            <input type="radio" name="optradio${i}" value="3" checked>                       
                        </c:when>
                        <c:otherwise>
                              <input type="radio" name="optradio${i}" value="3"> 
                        </c:otherwise>
                </c:choose>
                <input value="${e.getChoix().get(2).getLibelle()}" type="text" class="form-control" required  placeholder="troisiéme choix" name="choix3-${i}">
        
            </li>
        </ul>
      </div>
      
    </div>
      
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
        </div>
      </div>
    </div>
   
  </c:forEach>
       <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Modifier</button>
      </div>
    </div>
  </form>
</div>
 <div class='modal small fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>
                 <div class='modal-dialog'>
                  <div class='modal-content'>
                      <div class='modal-header'>
                          <button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>
                          <h3 id='myModalLabel'>Confirmation de Suppression</h3>
                      </div>
                    <div class='modal-body'>
                         <p class='error-text'><i class='fa fa-warning modal-icon'></i>Etes-Vous sûr de vouloir supprimer cet Examen ?</p>
                      </div>
                       <div class='modal-footer'>
                          <button class='btn btn-default' data-dismiss='modal' aria-hidden='true'>Annuler</button>
                          <a href="#" id="submit-link"><button class='btn btn-danger'>Supprimer</button></a>
                     </div>
                 </div>
              </div>
          </div>
</body>
</html>
