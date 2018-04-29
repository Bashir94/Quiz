<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Passer l'examen</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
    <%@include file="navbar.jsp" %>
 <c:set var="ide" value="<%=request.getParameter("ide")%>"/>
  <c:set var="idq" value="<%=request.getParameter("idq")%>"/>
  <c:set var="rep" value="<%=request.getParameter("rep")%>"/>
<center>
    <h2>Time Left: <div id="worked"><%=request.getParameter("t")%></div>
</h2>
    <br><br><br><br>
    <script>
$(document).ready(function (e) {
    var $worked = $("#worked");
    
    function update() {
        var myTime = $worked.html();
        var ss = myTime.split(":");
        var dt = new Date();
        dt.setHours(0);
        dt.setMinutes(ss[0]);
        dt.setSeconds(ss[1]);

        var dt2 = new Date(dt.valueOf() - 1000);
        var temp = dt2.toTimeString().split(" ");
        var ts = temp[0].split(":");

        $worked.html(ts[1]+":"+ts[2]);
        if(ts[1]==0 && ts[2]==0)
                window.location = "CheckResult?ide=${ide}&rep=${rep}";
        setTimeout(update, 1000);
         $(".list-group-item").click(function(){
            $("#link1").prop('href','passExam?ide=${ide}&idq=${idq+1}&rep=${rep}1&t='+ts[1]+":"+ts[2]);
            $("#link2").prop('href','passExam?ide=${ide}&idq=${idq+1}&rep=${rep}2&t='+ts[1]+":"+ts[2]);
            $("#link3").prop('href','passExam?ide=${ide}&idq=${idq+1}&rep=${rep}3&t='+ts[1]+":"+ts[2]);
        });
    }

    setTimeout(update, 1000);
    
   
});
</script>
<div class="container">
  <h2>Question N°<%=request.getParameter("idq")%> : ${question}</h2>
  <div class="list-group">
      
    <a href="passExam?ide=${ide}&idq=${idq+1}&rep=${rep}1&t=<%=request.getParameter("t")%>" id="link1" class="list-group-item active">${ch1}</a>
    <a href="passExam?ide=${ide}&idq=${idq+1}&rep=${rep}2&t=<%=request.getParameter("t")%>" id="link2"  class="list-group-item ">${ch2}</a>
    <a href="passExam?ide=${ide}&idq=${idq+1}&rep=${rep}3&t=<%=request.getParameter("t")%>"  id="link3" class="list-group-item active">${ch3}</a>
  </div>
</div>
</center>
</body>
</html>
