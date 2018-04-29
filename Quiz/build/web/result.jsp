<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Resultat</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="navbar.jsp" %>
<center><h1>Your Score is ${score}/30 !!</h1></center>
    <c:choose>
        <c:when test="${score<=15}">
        <center>
            <h2>You failed! You have to work harder !</h2>
            <img src="img/D.jpg" alt="fail" width="420" height="420">
        </center>                                 
        </c:when>
        <c:when test="${score>15 and score<21}">
            <center>
                <h2>You can do better! You have to work harder ! </h2>
                <img src="img/C.png" alt="mhm" width="420" height="420">
            </center>                               
        </c:when>
        <c:when test="${score>20 and score<26}">
            <center>
                <h2>Good Job! You Succeded!</h2>
                <img src="img/B.jpg" alt="good" width="420" height="420">
            </center>                                   
        </c:when>
        <c:when test="${score>25}">
            <center>
                <h2>Excellent !! </h2>
                <img src="img/A.jpg" alt="Excellent" width="420" height="420">
            </center>                          
        </c:when>
    </c:choose>
<center><h3><a href='correction.jsp?ide=<%=request.getParameter("ide")%>&rep=<%=request.getParameter("rep")%>'>Voir Correction</a></h3></center>
</body>
</html>
