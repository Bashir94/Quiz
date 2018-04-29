<%@page import="Model.Categorie.Categorie"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="SousCategorie.SousCategorie"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<% if(session.getAttribute("Session")==null) 
             response.sendRedirect("login.jsp");
    %>
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Page d'acceuil</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/coming-soon.min.css" rel="stylesheet">

  </head>

  <body>
<%@include file="navbar.jsp" %>
    <div class="overlay"></div>
<c:set var="con" value="<%=session.getAttribute("Session")%>"/>
<c:set var="type" value="<%=session.getAttribute("Session_type")%>"/>
    <div class="masthead">
      <div class="masthead-bg"></div>
      <div class="container h-100">
        <div class="row h-100">
          <div class="col-12 my-auto">
              <c:choose>
                      <c:when test="${con=='true'}">
                          <div class="masthead-content text-white py-5 py-md-0">
                            <h2 class="mb-3">Bienvenue <%=session.getAttribute("Session_nomUser")%>!</h2>
                          </div>
                            <c:choose>
                                  <c:when test="${type=='Prof'}">
                                      <a href="addExam.jsp"> 
                                        <button class="btn btn-secondary" type="button">Ajouter Examen</button>
                                     </a>
                                      <a href="ListeExam?idProf=<%=session.getAttribute("Session_idUser")%>"> 
                                        <button class="btn btn-secondary" type="button">Consulter mes Examens</button>
                                     </a>
                                  </c:when>
                                <c:otherwise><div class="masthead-content text-white py-5 py-md-0">
                                    <p class="mb-5">choisissez un examen pour le passer !</p>
                                        <%
                                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("QuizPU");
                                        EntityManager em = emf.createEntityManager();    
                                        String req1 ="select m from Categorie m";
                                        Query q1 = em.createQuery(req1);
                                        List<Categorie> liste;
                                        liste= q1.getResultList();
                                        %>
                                         <c:set var="listeC" value="<%=liste%>"/>
                                         <c:forEach items= '${listeC}' var='p' >
                                             <h3 class="mb-3">${p.getLibelle()}</h3>
                                             <c:set var="idc" value="${p.getIdCategorie()}"/>
                                            
                                            <% Long idC = (Long) pageContext.getAttribute("idc");;
                                             String req ="select m from SousCategorie m where m.categorie.idCategorie = ?1";
                                                Query q = em.createQuery(req);
                                                q.setParameter(1, idC);
                                                List<SousCategorie> listeSC = q.getResultList();

                                             %>
                                            <c:set var="listesc" value="<%=listeSC%>"/>
                                             <ul>
                                                <c:forEach items= '${listesc}' var='sc' >
                                                    <a href="ListeExam?idsc=${sc.getIdSC()}" style="color:White">  <li>${sc.getLibelle()}</li> </a>
                                                </c:forEach>
                                            </ul>
                                         </c:forEach>    
                                </div>
                                </c:otherwise>
                            </c:choose>
                       
                     </c:when> 
                        <c:otherwise>
                             <div class="masthead-content text-white py-5 py-md-0">
                                <h1 class="mb-3">Bienvenue!</h1>
                                <p class="mb-5">Bienvenue dans notre plateforme de certification en ligne, Veuillez vous connecter pour accéder à nos services
                                <div class="input-group input-group-newsletter">
                                  <div class="input-group-append">
                                    <a href="login.jsp"> 
                                        <button class="btn btn-secondary" type="button">Connectez vous</button>
                                    </a>
                                  </div>
                                </div>
                              </div> 
                     </c:otherwise>
                </c:choose>
            
          </div>
        </div>
      </div>
    </div>

   

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/vide/jquery.vide.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/coming-soon.min.js"></script>

  </body>

</html>
