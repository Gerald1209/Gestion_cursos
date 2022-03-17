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

<title>Gestion de Cursos | Ofertas</title>

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


<link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet" />

<!-- <link href="../vendors/jAlert-master/src/jAlert.css" rel="stylesheet">
<script src="../vendors/jAlert-master/src/jAlert.js"> </script>
<script src="../vendors/jAlert-master/src/jAlert-functions.js"> </script> -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">

<%-- <% int msg = Integer.parseInt( request.getParameter("msj") );%> --%>

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
							<h3>Gestion de Ofertas</h3>
						</div>
					</div>


					<div class="clearfix"></div>
					<%
					ArrayList<Oferta_Detalle> listaOferta = new ArrayList<Oferta_Detalle>();
					Oferta oferta = new Oferta();
					
					Dt_Oferta dto = new Dt_Oferta();
					Dt_Oferta_Det dtod = new Dt_Oferta_Det();
					
					
					int x = dto.getid_oferta();

					oferta = dto.getoferta(x);
					listaOferta = dtod.listaOD_id(x);
					%>
					<div class="col-md-12 col-sm-12 ">
						<div class="x_panel">
                                <div class="x_title">
                                    <h2>Ingrese un Encabezado para su oferta </h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <form class="" action="" method="post" novalidate>
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Nombre de Oferta <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="name" placeholder="ex. Primer Semestre 2020" value="<%=oferta.getNombre() %>" readonly/>
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Inicio <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input value="<%=oferta.getFecha_inicial() %>"  class="form-control" type="date" name="finicio" id="finicio" placeholder="ex. Primer Semestre 2020" readonly/>
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Final <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input value="<%=oferta.getFecha_final() %>" class="form-control" type="date" name="ffinal" id="ffinal" placeholder="ex. Primer Semestre 2020" readonly />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Período <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input value="<%=oferta.getPeriodo() %>" class="form-control" name="periodo" id="periodo" placeholder="ex. 1S2020" readonly />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Descripción <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input value="<%=oferta.getDescripcion() %>" class="form-control"  name="descr" id="descr" placeholder="ex. ofertas dentro del periodo 1S 2020" readonly />
										
                                            </div>
                                        </div>
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                	
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
						
						<div class="x_panel">
                                <div class="x_title">
                                    <h2>Datos para los detalles de su oferta </h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                
                                
                                    <form class="" action="../Sl_OfertaDet" method="post" novalidate>
<!--                                         <p>For alternative validation library <code>parsleyJS</code> check out in the <a href="form.html">form page</a> -->
<!--                                         </p> -->
<!--                                         <span class="section">Personal Info</span> -->
									   <input type="hidden" value="<%=oferta.getFecha_inicial() %>" name="finicio" id="finicio"/>
									   <input type="hidden" value="<%=oferta.getFecha_final() %>"  name="ffinal" id="ffinal" />
									   <input type="hidden" value="1" name="opcion" id="opcion"/>
									   <input type="hidden" value="<%=oferta.getId_oferta() %>" name="id_oferta" id="id_oferta"/>
									   
									   
                                       <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Capacitacion <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<% 
													ArrayList<Vw_Capacitacion> listaCap = new ArrayList<Vw_Capacitacion>();
													Dt_capacitacion dtc = new Dt_capacitacion();
													listaCap = dtc.listaCapActivos();
													
													ArrayList<Facilitador> listaF = new ArrayList<Facilitador>();
													Dt_Facilitador dtf = new Dt_Facilitador();
													listaF = dtf.listaFaciActivos();
												%>
                                            	<select id="capacitacion" name="capacitacion" class="form-control js-example-basic-single">
													<option value="">...Seleccione</option>
													<%for(Vw_Capacitacion vc:listaCap){ %>
													<option value="<%=vc.getId_capacitacion() %>"> ( <%=vc.getModalidad() %> ) <%=vc.getNombre() %></option>
													<%} %>
												</select>
                                            </div>
                                        </div>
                                        
                                         <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Facilitador:  <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<select id="facilitador" name="facilitador" class="form-control js-example-basic-single">
													<option value="0">...Seleccione</option>
													<%for(Facilitador f: listaF){ %>
														<option value="<%=f.getId_facilitador()%>"><%=f.getNombre_completo() %></option>
													<%} %>
													<option value="2">Maria Jose</option>
												</select>
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Inicio <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" type="date" name="finiciod" id="finiciod"  required="required" />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Fecha Final <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control" type="date" name="ffinald" id="ffinald"  required="required" />
										
                                            </div>
                                        </div>

									<div class="field item form-group">
										<label class="col-form-label col-md-3 col-sm-3  label-align">Hora Inicial <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control timepick" name="hinicial"
												id="hinicial" placeholder="6:00 pm" required="required" />

										</div>
									</div>

									<div class="field item form-group">
										<label class="col-form-label col-md-3 col-sm-3  label-align">Hora
											Final <span class="required">*</span>
										</label>
										<div class="col-md-6 col-sm-6">
											<input class="form-control timepick" name="hfinal"
												id="hfinal" placeholder="8:00 pm" required="required" />

										</div>
									</div>

									<div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Dias de asistencia<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<input class="form-control"  name="dias" id="dias" placeholder="todos los lunes" required="required" />
										
                                            </div>
                                        </div>
                                        
                                        <div class="field item form-group">
                                            <label class="col-form-label col-md-3 col-sm-3  label-align">Publico <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6">
                                            	<select name="publico" id="publico" required="required" class="form-control js-example-basic-single">
												
													  <option value="0">Mantener Privado</option>
													  <option value="1">Hacer Publico</option>
												  
												 
												</select>
                                            </div>
                                        </div>  
                                        <div class="ln_solid">
                                            <div class="form-group">
                                                <div class="col-md-6 offset-md-3">
                                                    <button type='submit' class="btn btn-primary">Guardar</button>
                                                    <a href="tbl_oferta.jsp" class="btn btn-success">Regresar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                        </div>
                        
                        <div class="clearfix"></div>
						
						<div class="x_panel">
							<div class="x_title">
								<h2>Ofertas Registradas</h2>

								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<div class="row">
									<div class="col-sm-12">
										<div class="card-box table-responsive">
											<div class="text-muted font-13 col-md-12"
												style="text-align: right;">
												<a href="frm_addOfertaDet.jsp"> <i
													class="fa fa-2x fa-plus-square" title="Nueva Oferta"></i></a> <br></br>
											</div>

											<table id="datatable-buttons" class="table table-striped table-bordered dataTable facultad" style="width:100%">
												
												
												<thead>
													<tr>
														<th>Capacitacion</th>
														<th>Facilitador</th>
														<th>Duracion</th>
														<th>Horario</th>
														<th>Días de Asistencia</th>
														<th>Visibilidad</th>
														<th>Acciones</th>
													</tr>
												</thead>

												<tbody>
													
													<%
													for (Oferta_Detalle to : listaOferta) {
														String estado = "";
														if (to.getPublico() == 0) {
															estado = "Privado";
														} else {
															estado = "Publico";
														}
													%>
													<tr>
														<td><%=to.getCapacitacion()%></td>
														<td><%=to.getFacilitador()%></td>
														<td>De <%=to.getFecha_inicial()%> a <%=to.getFecha_final()%></td>
														<td><%=to.getHora_inicio()%> - <%=to.getHora_final()%></td>
														<td><%=to.getDias()%></td>
														<td><%=estado %></td>
														<td>
															<a href="frm_modOfertaDet.jsp" target="blank"><i class="fa fa-2x fa-edit" title="Editar Gastos"></i></a> 
															<a href="frm_vwOfertaDet.jsp" target="blank"><i class="fa fa-eye fa-2x" title="Visualizar gasto"></i></a> 
															<a href="frm_delOfertaDet.jsp" target="blank"><i class="fa fa-2x fa-trash" title="Eliminar Gasto"></i></a>
														</td>
													</tr>
													<%
													}
													%> 
												</tbody>

												<tfoot>
													<tr>
														<th>Capacitacion</th>
														<th>Facilitador</th>
														<th>Duracion</th>
														<th>Horario</th>
														<th>Días de Asistencia</th>
														<th>Visibilidad</th>
														<th>Acciones</th>
													</tr>
												</tfoot>
											</table>


										</div>
									</div>
								</div>
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
    

	<!-- jQuery -->
	<script src="../vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!-- FastClick -->
	<script src="../vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="../vendors/nprogress/nprogress.js"></script>
	<!-- iCheck -->
	<script src="../vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	<script src="../vendors/jszip/dist/jszip.min.js"></script>
	<script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="../vendors/pdfmake/build/vfs_fonts.js"></script>
	
	<!-- bootstrap-datetimepicker -->    
    <script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.min.js"></script>
    
	<script  type="text/javascript">
	$(document).ready(function() {
        $('.js-example-basic-single').select2();
        
    });
	
	
		/*  var mensaje = 0;
	      mensaje = 1;

	      if (mensaje == "1") {
	        javascript:successAlert('Exito', 'Los datos han sido registrado exitosamente!');
	      }
	      if (mensaje == "2") {
	        errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
	      }

	      if (mensaje == "3") {
	    	  errorAlert('Error', 'La fecha inicial ingresada no es compatible con la del periodo');
	      }

	      if (mensaje == "4") {
	    	  errorAlert('Error', 'La fecha final ingresada no es compatible con la del periodo');
	      }

	      if (mensaje == "6") {
	        errorAlert('Error', 'No se logro desactivar la categoria');
	      } */
	      
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

    
    
	<!-- Custom Theme Scripts -->
	<script src="../build/js/custom.min.js"></script>
 	

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
</body>
</html>