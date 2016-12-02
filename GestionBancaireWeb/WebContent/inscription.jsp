<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
Boolean authentified=(Boolean) session.getAttribute("authentified");
if (authentified==null){
	authentified=new Boolean(false);
}

if(authentified.booleanValue()==false){
	response.sendRedirect("index.jsp");
	return;
}

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Se connecter</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                
                    <div class="col-lg-3"></div>
                <%String notifCompte=(String)session.getAttribute("notifCompte"); 
                if (notifCompte==null) notifCompte="";
                %>
                        
                    <div class="col-lg-6">
                        <h1 class="page-header">
                            Inscriver un nouvel administrateur :
                            <small><%=notifCompte %></small>
                        </h1>
                        <p/>
                        
                        <form role="form" action="SignUpServlet" method="post">
                           <div class="form-group">
                                <input class="form-control" placeholder="Nom d'utilisateur" name="userName"  required="required">
                                <input class="form-control" placeholder="Mot de passe" name="passwd" type="password" required="required">
            				    <button type="reset" class="btn btn-default">Vider</button> 
            				    <button type="submit" class="btn btn-default">S'incrire</button> 
                           </div>
                        </form>
                        
                    </div>
                      <div class="col-lg-3"></div>
                </div>
                
                            
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

  
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>


    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>

</body>

</html>
