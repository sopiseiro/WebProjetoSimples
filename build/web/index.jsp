<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<jsp:useBean id="pgdas" class="br.jonatas.Simples.Bean.PGDASBean"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dependencias/header.html" %>
<body> 
            <!--  start nav -->
            <%@include file="dependencias/menu.html" %>
            <!--  start nav -->
        <div class="clear"></div>
        <!--  start nav-outer -->
<div class="clear"></div>
<!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->

  <div class="clear"></div>
 
<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
<!-- start content -->
<div id="content">

	<!--  start page-heading -->
	<div id="page-heading">
		<h1>Apresentação</h1>
	</div>
	<!-- end page-heading -->

	<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
	<tr>
		<th rowspan="3" class="sized"><img src="images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
		<th class="topleft"></th>
		<td id="tbl-border-top">&nbsp;</td>
		<th class="topright"></th>
		<th rowspan="3" class="sized"><img src="images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
	</tr>
	<tr>
		<td id="tbl-border-left"></td>
		<td>
		<!--  start content-table-inner ...................................................................... START -->
		<div id="content-table-inner">
		
			<!--  start table-content  -->
			<div id="table-content">
			<h2>O que e o SIMOF?</h2>
			<h3>Sistema de Monitoramento Fiscal do Simples Nacional - Módulo Municipal</h3>
			
			Com a origem do Simples Nacional, o trabalho de fiscalização 
                        municipal ficou prejudicado devido a falta de mecanismos que ajudassem o 
                        Fiscal Tributário Municipal a desenvolver suas atividades e também por 
                        ferramentas serem muito caras para municípios com receitas pequenas. 
			<br />
			<br />
			Assim, o Fiscal Jônatas Cardoso – Licenciado em Computação pela 
                        Universidade do Estado de Mato Grosso, Campus de Colíder, através de estudos, 
                        obter informações junto a Receita Federal e documentos junto ao sitio do Simples Nacional, 
                        trabalhou nesta ferramenta, para agilizar o processo fiscalizatório. 
			<br />
			<br />
			Os resultados obtidos por ele foram tão satisfatórios que resolveu apresentar 
                        seu trabalho a outros municípios. Que agora podem fazer uso 
                        da ferramenta que estará em constante evolução, sempre para melhorar o trabalho dos fiscais municipais.
			
			
			</div>
			<!--  end table-content  -->
	
			<div class="clear"></div>
		 
		</div>
		<!--  end content-table-inner ............................................END  -->
		</td>
		<td id="tbl-border-right"></td>
	</tr>
	<tr>
		<th class="sized bottomleft"></th>
		<td id="tbl-border-bottom">&nbsp;</td>
		<th class="sized bottomright"></th>
	</tr>
	</table>
	<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer........................................................END -->

    <div class="clear">&nbsp;</div>
    <%@include file="dependencias/footer.html" %>