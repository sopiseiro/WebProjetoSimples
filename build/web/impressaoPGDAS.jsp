<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<jsp:useBean id="pgdas" class="br.jonatas.Simples.Bean.PGDAS"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dependencias/header.html" %>
<body> 
    <!-- Start: page-top-outer -->
    <div id="page-top-outer">    

        <!-- Start: page-top -->
        <div id="page-top">

            <!-- start logo -->
            <div id="logo">
                <a href=""><img src="images/shared/logo.png" width="206" height="60" alt="" /> 
                    Sistema de Monitoramento Fiscal do Simples Nacional - Modulo Municipal
                </a>
            </div>
            <!-- end logo -->


            <div class="clear"></div>

        </div>
        <!-- End: page-top -->

    </div>
    <!-- End: page-top-outer -->

    <div class="clear">&nbsp;</div>

    <!--  start nav-outer-repeat................................................................................................. START -->
    <div class="nav-outer-repeat"> 
        <!--  start nav-outer -->
        <div class="nav-outer"> 

            <!-- start nav-right -->
            <div id="nav-right">

                <div class="nav-divider">&nbsp;</div>
                <div class="showhide-account"><img src="images/shared/nav/nav_myaccount.gif" width="93" height="14" alt="" /></div>
                <div class="nav-divider">&nbsp;</div>
                <a href="" id="logout"><img src="images/shared/nav/nav_logout.gif" width="64" height="14" alt="" /></a>
                <div class="clear">&nbsp;</div>

                <!--  start account-content -->	
                <div class="account-content">
                    <div class="account-drop-inner">
                        <a href="" id="acc-settings">Configuracoes</a>
                        <div class="clear">&nbsp;</div>
                        <div class="acc-line">&nbsp;</div>
                        <a href="" id="acc-details">Cadastro </a>

                    </div>
                </div>
                <!--  end account-content -->

            </div>
            <!-- end nav-right -->


            <!--  start nav -->
            <%@include file="dependencias/menu.html" %>
            <!--  start nav -->

        </div>
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
                <h1>PGDAS Consultas</h1>
                <h3 style="width: 90%">Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, 
                    e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou
                    uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.
                    Lorem Ipsum sobreviveu não só a cinco séculos, como também 
                    ao salto para a editoração eletrônica, permanecendo essencialmente 
                    inalterado. Se popularizou na década de 60, quando a Letraset lançou 
                    decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser 
                    integrado a softwares de editoração eletrônica como Aldus PageMaker.</h3>
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

                                <!--  start message-yellow -->
                                <div id="message-yellow">

                                </div>
                                <!--  end message-green -->


                                <!--  start product-table ..................................................................................... -->
                                <form id="mainform" action="pgdasControleImpressao" method="POST">
                                    <!--  start step-holder -->
                                    <div id="step-holder">
                                        <div class="step-no">1</div>
                                        <div class="step-dark-left">
                                            <a href=""  style="margin-right: 300px" >Filtro  </a>
                                        </div>
                                    </div>
                                    <!--  end step-holder -->

                                    <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                                        <tr>
                                            <th valign="top">CNPJ:</th>
                                            <td><input type="text" value="" name="cnpj" class="inp-form" /></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th valign="top">Competência:</th>
                                            <td><input type="text" name="pa" value="" class="inp-form" /></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <th valign="top"></th>
                                            <td><input type="submit" value="Enviar" name="botao" /></td>
                                            <td></td>
                                        </tr>
                                    </table>

                                    <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                        <tr>
                                            <th class="table-header-check"><a id="toggle-all" ></a> </th>
                                            <th class="table-header-repeat line-left"><a href="">P.A.</a>	</th>
                                            <th class="table-header-repeat line-left"><a href="">CNPJ</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Razão</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Devido</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Retido</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Aliquota</a></th>
                                            <th class="table-header-options line-left"><a href="">Operação</a></th>
                                        </tr>
                                        <c:forEach  items="${listaPgdas}" var="pgdas">
                                            <tr>
                                                <td><input  type="checkbox"/></td>
                                                <td>${pgdas.pa}</td>
                                                <td>${pgdas.cnpj}</td>
                                                <td>${pgdas.razao}</td>
                                                <td>R$ <fmt:formatNumber value="${pgdas.valdecsemretencao}" minFractionDigits="2"/></td>
                                                <td>R$ <fmt:formatNumber value="${pgdas.valdeccomretencao}" minFractionDigits="2"/></td>
                                                <td><fmt:formatNumber value="${pgdas.aliquota}" minFractionDigits="2"/>%</td>
                                                <td>${pgdas.operacao}</td>
                                                
                                            </tr>
                                        </c:forEach>

                                    </table>
                                    <!--  end product-table................................... --> 
                                </form>
                            </div>
                            <!--  end content-table  -->

                            <!--  start actions-box ............................................... -->
                            <div id="actions-box">
                                <a href="" class="action-slider"></a>
                                <div id="actions-box-slider">
                                    <a href="" class="action-edit">Imprimir</a>
                                </div>
                                <div class="clear"></div>
                            </div>
                            <!-- end actions-box........... -->

                            <!--  start paging..................................................... -->
                            <table border="0" cellpadding="0" cellspacing="0" id="paging-table">
                                <tr>
                                    <td>
                                        <a href="" class="page-far-left"></a>
                                        <a href="" class="page-left"></a>
                                        <div id="page-info">Página <strong>1</strong> / 15</div>
                                        <a href="" class="page-right"></a>
                                        <a href="" class="page-far-right"></a>
                                    </td>
                                    <td>
                                        <select  class="styledselect_pages">
                                            <option value="">Linhas</option>
                                            <option value="">10</option>
                                            <option value="">20</option>
                                            <option value="">50</option>
                                            <option value="">100</option>

                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <!--  end paging................ -->

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