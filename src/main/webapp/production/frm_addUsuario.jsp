<%@page import="entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>DataTables | Gentelella</title>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- Datatables -->
<link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />

<link
	href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
							<span>Dpto. Educacion</span></a>
					</div>

					<div class="clearfix"></div>

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							
							<ul class="nav side-menu">
								<li><a><i class="fa fa-shield"></i> Seguridad <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tbl_usuario.jsp">Usuario</a></li>
										<li><a href="tbl_rol.jsp">Rol</a></li>
										<li><a href="tbl_opcion.jsp">Opciones</a></li>
										<li><a href="tbl_UsuarioRol.jsp">Asignar roles a usuario</a></li>
										<li><a href="tbl_RolOpciones.jsp">Asignar opciones a los roles</a></li>
									</ul>
								</li>
								
								<li><a><i class="fa fa-institution"></i> Catalogos <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tbl_facultad.jsp">Facultad</a></li>
										<li><a href="tbl_departamento.jsp">Departamento</a></li>
										<li><a href="tbl_carrera.jsp">Carrera</a></li>
									</ul>
								</li>
									
								<li><a><i class="fa fa-book"></i>Oferta <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tbl_modalidad.jsp">Modalidad</a></li>
										<li><a href="tbl_capacitacion.jsp">Capacitacion</a></li>
										<li><a href="tbl_facilitador.jsp">Facilitador</a></li>
										<li><a href="tbl_oferta.jsp">Oferta</a></li>
									</ul>
								</li>
								
								<li><a><i class="fa fa-archive"></i> Inscripcion <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tbl_inscripcion.jsp">Gestion de Inscripciones</a></li>
										<li><a href="frm_addInscripcion.jsp">Inscripcion Docente</a></li>
									</ul>
								</li>
								<li><a><i class="fa fa-file-o"></i> Reportes Parametrizados<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="rpt_general.jsp">General</a></li>
										<li><a href="rpt_docCap.jsp">Docentes Capacitados</a></li>
										<li><a href="rpt_docEv.jsp">Docentes por Evaluacion</a></li>
										<li><a href="rpt_docCertif.jsp">Docentes Certificados</a></li>
									</ul>
								</li>
								<li><a><i class="fa fa-clone"></i>Evaluacion <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="tbl_EscalaCalificacion.jsp">Escalas de Evaluacion</a></li>
										<li><a href="tbl_evaluar.jsp">Evaluar </a></li>
									</ul>
								</li>
							</ul>
						</div>
						

					</div>
					<!-- /sidebar menu -->

					
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>
					<nav class="nav navbar-nav">
						<ul class=" navbar-right">
							<li style="padding-left: 15px;">
								<a data-toggle="tooltip" data-placement="top" title="Cerrar Sesión"
								href="login.html"> <span class="glyphicon glyphicon-off fa-2x"
								aria-hidden="true"></span>
								</a>
                            </li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Gestion de Usuarios</h3>
						</div>

						<div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								
							</div>
						</div>
					</div>


					<div class="clearfix"></div>



					<div class="col-md-12 col-sm-12 ">
						<div class="x_panel">
                                <div class="x_title">
                                    <h2>Ingrese un Nuevo Usuario </h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form class="" action="../Sl_Usuario" method="post" novalidate>
                                       <input type="hidden" value="1" name="opcion" id="opcion"/>

                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Id Uca <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="idU" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Nombre Real <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="name" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Nombre de Usuario <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="username" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Contraseña<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input type="password" class="form-control"  name="pwd" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Cargo<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="cargo" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        
                                         <%
									ArrayList<Facultad> listaFac= new ArrayList<Facultad>();
									Dt_Facultad dtf = new Dt_Facultad();
									listaFac = dtf.listaFacActivos();

											%>
                                        
                                          <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Facultad<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<select id="facultad" name="facultad" class="form-control js-example-basic-single">
													<option value="0">...Seleccione</option>
													<% for(Facultad f: listaFac){ %>
														
													<option value="<%=f.getId_facultad() %>"> <%=f.getNombre_facultad() %> </option>
													<%} %>
												</select>
											</div>
										</div>
                                         
                                        <%

									ArrayList<Departamento> listaDep= new ArrayList<Departamento>();
									Dt_Departamento dtd = new Dt_Departamento();
									listaDep = dtd.listaDepActivos();
                                               %>
                                               
                                           <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align ">Departamento<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<select id="depto" name="depto" class="form-control js-example-basic-single">
													<option value="0">...Seleccione</option>
													<% for(Departamento d: listaDep){ %>
													<option value="<%=d.getId_departamento()%>"><%=d.getNombre_departamento()%></option>
													<%} %>
												</select>
											</div>
										</div>
                                        
                                        <%

									ArrayList<Carrera> listaCar= new ArrayList<Carrera>();
									Dt_carrera dtc = new Dt_carrera();
									listaCar = dtc.listaCarActivos();
                                               %>
                                         
                                           <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Carrera<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<select id="carrera" name="carrera" class="form-control js-example-basic-single">
													<option value="0">...Seleccione</option>
													<% for(Carrera c: listaCar){ %>
														
													<option value="<%=c.getId_carrera() %>"> <%=c.getNombre_carrera() %> </option>
													<%} %>
												</select>
											</div>
										</div>
                                        
                                     
                                     	<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Correo Institucional<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="insEmail" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Correo Personal <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="persEmail" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Telefono <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="telephone" placeholder="..."  />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Sexo<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<select id="sexo" name="sexo" class="form-control js-example-basic-single">
													<option value="">...Seleccione</option>
													<option value="0">Femenino</option>
													<option value="1">Masculino</option>
												</select>
											</div>
										</div>
										
                                     <div class="ln_solid">
                                            <div class="form-group">
                                             
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Guardar</button>
                                                    <a href="tbl_usuario.jsp" class="btn btn-success">Regresar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
              
            </div>
            <!-- /page content -->

            <!-- footer content -->
            <footer>
				<div class="pull-right">
					Gestion de Capacitacion Docente - UCA
				</div>
				<div class="clearfix"></div>
			</footer>
            <!-- /footer content -->
        </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="../vendors/validator/multifield.js"></script>
    <script src="../vendors/validator/validator.js"></script>
    
    <!-- Javascript functions	-->
	<script>
	$(document).ready(function() {
        $('.js-example-basic-single').select2();
    });
		function hideshow(){
			var password = document.getElementById("password1");
			var slash = document.getElementById("slash");
			var eye = document.getElementById("eye");
			
			if(password.type === 'password'){
				password.type = "text";
				slash.style.display = "block";
				eye.style.display = "none";
			}
			else{
				password.type = "password";
				slash.style.display = "none";
				eye.style.display = "block";
			}
		}
	</script>

    <script>
        // initialize a validator instance from the "FormValidator" constructor.
        // A "<form>" element is optionally passed as an argument, but is not a must
        var validator = new FormValidator({
            "events": ['blur', 'input', 'change']
        }, document.forms[0]);
        // on form "submit" event
        document.forms[0].onsubmit = function(e) {
            var submit = true,
                validatorResult = validator.checkAll(this);
            console.log(validatorResult);
            return !!validatorResult.valid;
        };
        // on form "reset" event
        document.forms[0].onreset = function(e) {
            validator.reset();
        };
        // stuff related ONLY for this demo page:
        $('.toggleValidationTooltips').change(function() {
            validator.settings.alerts = !this.checked;
            if (this.checked)
                $('form .alert').remove();
        }).prop('checked', false);
    </script>

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- validator -->
    <!-- <script src="../vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script> -->
    
    <script type="text/javascript">
    
    </script>

</body>
</html>
