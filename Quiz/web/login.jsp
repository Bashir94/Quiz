<!DOCTYPE html>
<html lang="en" >
<% if(session.getAttribute("Session")!=null) 
             response.sendRedirect("index.jsp");
    %>
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up</h1>
          
          <form action="addUser" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                Nom<span class="req">*</span>
              </label>
              <input type="text" name="nom" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Prenom<span class="req">*</span>
              </label>
              <input type="text"required name="prenom"  autocomplete="off"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              login<span class="req">*</span>
            </label>
            <input type="text"required name="login"  autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required name="password"  autocomplete="off"/>
          </div>
              
             
          <div class="field-wrap">
            
              <select name="type">
                  <option value="Prof">Prof</option>
                  <option value="Etudiant">Etudiant</option>
              </select>
          </div> 
          
          <button type="submit" class="button button-block"/>Register</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Welcome !</h1>
          
          <form action="Authentifier" method="post">
          
            <div class="field-wrap">
            <label>
             Login<span class="req">*</span>
            </label>
            <input type="text" name="login" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="password" required autocomplete="off"/>
          </div>
          <button type="submit" class="button button-block"/>Log In</button>
          
          </form>

        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>




</body>

</html>
