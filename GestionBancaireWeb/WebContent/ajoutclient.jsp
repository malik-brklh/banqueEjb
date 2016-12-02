<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
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

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Ajouter un client</title>

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

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" >Menu</a>
            </div>
 
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li >
                        <a href="accueil.jsp"> Accueil</a>
                    </li>
                    <li class="active">
                        <a href="javascript:;" data-toggle="collapse" data-target="#clientele"> Gestion des clients <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="clientele" class="collapse">
                            <li class="active">
                                <a href="ajoutclient.jsp">Ajouter un client</a>
                            </li>
                            <li>
                                <a href="chercherclient.jsp">Chercher un client</a>
                            </li>
                            <li>
                                <a href="modifierclient.jsp">Modifié les données d'un client</a>
                            </li>
                            <li>
                                <a href="supprimerclient.jsp">Supprimer un client</a>
                            </li>
                            <li>
                                <a href="listerclient.jsp">Lister les clients</a>
                            </li>
                        </ul>
                    </li>  
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#Compte"> Gestion des comptes <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="Compte" class="collapse">
                            <li>
                                <a href="ajoutcomptebancaire.jsp">Ouvrir un compte</a>
                            </li>
                          
                            <li>
                                <a href="supprimercompte.jsp">Fermer un compte</a>
                            </li>
                        	<li>
                                <a href="listercompte.jsp">Lister les comptes</a>
                            </li>
                        </ul>
                    </li>
                        <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#monetique"> Services monétaires <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="monetique" class="collapse">
                             <li>
                                <a href="depotargent.jsp">Déposer de l'argent sur un compte</a>
                            </li>
                            <li>
                                <a href="retraitargent.jsp"> Retirer de l'argent d'un compte</a>
                            </li>
                            
		                    <li>
		                        <a href="transfertargent.jsp">Transfert d'argent</a>
		                    </li>
                        </ul>
                    </li>

                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Ajouter un client<br>
                            <%Boolean clientCreer = (Boolean)session.getAttribute("clientCreer");
                            if (clientCreer!=null){
                            	if(clientCreer.booleanValue()==false){
                            		%>
                            		
                            		<small>Un compte avec le même CIN existe déja</small>
                            		<%
                            	
                            	}
                            	else{%>
                            		<small>Compte ajouté avec succès</small>
                            	<%}
                            	
                            }
                            %>
                            
                        </h1>
                        <p/>
                <%if (clientCreer==null || clientCreer.booleanValue()==false){ %>        
                        <h3>Veuillez remplir tous les champs :</h3>
                        
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="AjoutClientServlet" method="post">
                           <div class="form-group">
                                <input class="form-control" placeholder="Prenom" name="prenom"  required="required">
                                <input class="form-control" placeholder="Nom de famille" name="nom"  required="required">
                                <input class="form-control" placeholder="Adresse" name="adresse"  required="required">
                                <input class="form-control" placeholder="numéro de Catre d'identité nationale" name="cin" type="number" required="required">
                                <button type="submit" class="btn btn-default">Ajouter</button>
                            </div>
                        </form>
                    </div>
                </div>
                            
                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
<%}session.setAttribute("clientCreer", null);%>
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
