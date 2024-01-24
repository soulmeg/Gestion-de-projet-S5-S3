<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Acceuil</title>
    <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="assets/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="assets/vendor/chart.js/Chart.min.js"></script>

    <script src="assets/js/demo/chart-area-demo.js"></script>
    <script src="assets/js/demo/chart-pie-demo.js"></script>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">ANTSIKA</div>
            </a>

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>MEUBLE</span></a>
            </li>

            <!-- Heading -->
            <div class="sidebar-heading">
                GESTION MATERIEL
            </div>


            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target=".meuble-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>MEUBLES</span>
                </a>
                <div class="collapse meuble-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Insertions</h6>
                        <a class="collapse-item" href="InsertionCategorie.jsp"> Catégorie</a>
                        <a class="collapse-item" href="InsertionVolume.jsp"> Volume</a>
                        <a class="collapse-item" href="InsertionQuantitemateriel"> Quantité Matériel</a>
                        <a class="collapse-item" href="/Baovola/InsertionMeuble"> Insertion Meuble</a>
                        <h6 class="collapse-header">Listes</h6>
                        <a class="collapse-item" href="/Baovola/ListeMeubleMateriel">Liste Meuble par Matériel</a>
                        
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target=".fabrication-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>FABRICATION MEUBLE</span>
                </a>
                <div class="collapse fabrication-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Filtre</h6>
                        <a class="collapse-item" href="/Baovola/FiltrePrix">Prix Meuble</a>
                        <a class="collapse-item" href="/Baovola/FiltreBenefice">Benefice</a>
                        
                        <h6 class="collapse-header">Insertions</h6>
                        <a class="collapse-item" href="InsertionFabricationMeuble">FABRICATION MEUBLE</a>
                        <a class="collapse-item" href="InsertionDureeFabricationMeuble">DUREE FABRICATION</a>
                        <a class="collapse-item" href="InsertionPrixDeVente">PRIX DE VENTE</a>
                      
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target=".achat-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>STYLE</span>
                </a>
                <div class="collapse achat-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Insertions</h6>
                        <a class="collapse-item" href="InsertionStyle.jsp"> Style</a>
                        <a class="collapse-item" href="/Baovola/InsertionStyleMateriel"> Style Matériel</a>
                        <h6 class="collapse-header">Listes</h6>
                        <a class="collapse-item" href="/Baovola/ListeSMServlet">Liste Matériel par style</a>
                    </div>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                    <!-- <i class="fas fa-fw fa-chart-area"></i> -->
                    <i class="fas fa-fw fa-folder"></i>
                    <span>MATERIEL</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Insertions</h6>
                        <a class="collapse-item" href="InsertionMateriel.jsp"> Matériel</a>
                        <a class="collapse-item" href="InsertionPrixMateriel"> Prix Matériel</a>
                        <h6 class="collapse-header">Listes</h6>
                        <a class="collapse-item" href="/Baovola/ListeSMServlet">Liste Matériel par style</a>
                        
                        <h6 class="collapse-header">Stockage</h6>
                        <a class="collapse-item" href="/Baovola/StockMateriel">Stock</a>
                        <a class="collapse-item" href="StockEntrer"> Insertion stock</a>
                    </div>
                </div>
            </li>
            
            

            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target=".employe-collapse" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>PERSONNEL</span>
                </a>
                <div class="collapse employe-collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">                    
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Insertions</h6>
                        <a class="collapse-item" href="/Baovola/InsertionPersonne.jsp">Individu</a>
                        <a class="collapse-item" href="/Baovola/InsertionEmploye">Insertion Employe </a>
                        <a class="collapse-item" href="/Baovola/InsertionEmployeFabrication">Employe-Fabrication</a>
                        <a class="collapse-item" href="/Baovola/InsertionExperience">Grade</a>
                        <h6 class="collapse-header">Liste</h6>
                        <a class="collapse-item" href="/Baovola/PosteActuel">Poste Actuel</a>
                    
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            <!-- <li class="nav-item">
                <a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li> -->

            <!-- Nav Item - Tables -->
            <!-- <li class="nav-item">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li> -->

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
    

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Profil
                             
                            </span>
                                <img class="img-profile rounded-circle"
                                    src="assets/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#" >
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>