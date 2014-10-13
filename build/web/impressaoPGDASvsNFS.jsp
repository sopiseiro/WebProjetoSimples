<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<jsp:useBean id="pgdas" class="br.jonatas.Simples.Bean.PgdasNFSeBean"/>
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
                <h1>PGDAS vs NFS-e</h1>
                <h3 style="width: 90%">Nesta seção, são apresentados os valores declarados do PGDAS e confrontados com os valores de serviços prestados.
                    Para utilização desta função o usuário deverá fazer a importação dos dados fiscais municipais. </h3>
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
                                <form id="mainform" action="PgdasNFSEimpressaoControle" method="POST">
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
                                            <th valign="top">Competência:</th>
                                            <td><input type="text" id="pa" name="pa" value="${pa}" class="inp-form" /></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th valign="top">CNPJ:</th>
                                            <td><input type="text" id="cnpj" value="${cnpj}" name="cnpj" class="inp-form" /></td>
                                            <td></td>
                                        </tr>
                                        <input type="hidden" name="retorno" value="submit"/>

                                        <tr>
                                            <th valign="top"></th>
                                            <td>
                                                <input  type="checkbox" name="inconsistencia" 
                                                        <c:if test="${not empty inco}"> 
                                                            checked="1"
                                                        </c:if>    
                                                        />
                                                        Somente inconsistências.
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th valign="top"></th>
                                            <td><input type="submit" value="Enviar" name="botao" /></td>
                                            <td></td>
                                        </tr>
                                    </table>

                                    <c:if test="${not empty listaPgdas}">
                                        <!--  start message-green -->
                                        <div id="message-green">
                                            <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                                <tr>
                                                    <td class="green-left">Sucesso.</a></td>
                                                    <td class="green-right"><a class="close-green"><img src="images/table/icon_close_green.gif"   alt="" /></a></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <!--  end message-green -->
                                    </c:if>

                                    <c:if test="${empty listaPgdas}">
                                        <c:if test="${not empty retorno}">
                                            <!--  start message-red -->
                                            <div id="message-red">
                                                <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td class="red-left">Não foram localizados registros.</td>
                                                        <td class="red-right"><a class="close-red"><img src="images/table/icon_close_red.gif"   alt="" /></a></td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <!--  end message-red -->
                                        </c:if>
                                    </c:if>

                                    <table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
                                        <tr>
                                            <th class="table-header-check"><a id="toggle-all" ></a> </th>
                                            <th class="table-header-repeat line-left"><a href="">P.A.</a>	</th>
                                            <th class="table-header-repeat line-left"><a href="">CNPJ</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Razão</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Info</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Devido</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Retido</a></th>
                                            <th class="table-header-repeat line-left"><a href="">Total</a></th>

                                        </tr>
                                        <c:forEach  items="${listaPgdas}" var="pgdas" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${loop.count % 2 eq 0}">
                                                    <tr >
                                                </c:when>
                                                <c:otherwise>
                                                <tr class="alternate-row">
                                                </c:otherwise>
                                            </c:choose>
                                            
                                                <td><input  type="checkbox"/></td>
                                                <td>${pgdas.pgdas.pa}</td>
                                                <td>${pgdas.pgdas.cnpj}</td>
                                                <td>${pgdas.pgdas.razao}</td>
                                                <td>
                                                    PGDAS<br>
                                                    NFS-e<br>
                                                    Diferença
                                                </td>
                                                <td>
                                                    R$ <fmt:formatNumber value="${pgdas.pgdas.valdecsemretencao}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${pgdas.dc.valorsemretencao}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${pgdas.pgdas.valdecsemretencao - pgdas.dc.valorsemretencao}" minFractionDigits="2" maxFractionDigits="2"/>
                                                </td>
                                                <td>
                                                    R$ <fmt:formatNumber value="${pgdas.pgdas.valdeccomretencao}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${pgdas.dc.valorretido}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${pgdas.pgdas.valdeccomretencao - pgdas.dc.valorretido}" minFractionDigits="2" maxFractionDigits="2"/>
                                                </td>
                                                <td>
                                                    R$ <fmt:formatNumber value="${pgdas.pgdas.valdecsemretencao + pgdas.pgdas.valdeccomretencao}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${pgdas.dc.valorretido + pgdas.dc.valorsemretencao}" minFractionDigits="2" maxFractionDigits="2"/><br>
                                                    R$ <fmt:formatNumber value="${(pgdas.pgdas.valdecsemretencao + pgdas.pgdas.valdeccomretencao) - (pgdas.dc.valorretido + pgdas.dc.valorsemretencao)}" minFractionDigits="2" maxFractionDigits="2"/>
                                                </td>
                                                

                                            </tr>
                                            <c:if test="${loop.last}">
                                                <tr>
                                                    <td colspan="8" style="text-align: center;"><b>Total de registros: ${loop.count}</b></td>
                                                </tr>
                                            </c:if>
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