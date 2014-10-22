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
</div>
<!--  start nav-outer-repeat................................................... END -->

<div class="clear"></div>

<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
    <!-- start content -->
    <div id="content">

        <!--  start page-heading -->
        <div id="page-heading">
            <h1>Pagamentos</h1>
            <h3 style="width: 90%">Verificação de contribuintes inadimplentes.</h3>
        </div>
        <!-- end page-heading -->


        <form id="mainform" action="pgdasControleImpressao" method="POST">   
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
                                    <tr>
                                        <th valign="top">Regime:</th>
                                        <td><input type="radio" id="tipo" value="MEI" name="cnpj" checked="checked"  /> SIMPLES</td>
                                        <td><input type="radio" id="tipo" value="MEI" name="cnpj"  /> SIMEI </td>
                                    </tr>
                                    <tr>
                                        <th valign="top">Opções:</th>
                                        <td><input type="checkbox" id="tipo" value="1" name="cnpj"  /> Somente sem recolhimento. <br>

                                    </tr>
                                    <input type="hidden" name="retorno" value="submit"/>

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
                                        <th class="table-header-repeat line-left"><a href="">Devido</a></th>
                                        <th class="table-header-repeat line-left"><a href="">Retido</a></th>
                                        <th class="table-header-repeat line-left"><a href="">Aliquota</a></th>
                                        <th class="table-header-repeat line-left"><a href="">Operação</a></th>
                                        <th class="table-header-repeat line-left"><a href="">DAF607</a></th>
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
                                            <td>${pgdas.pa}</td>
                                            <td>${pgdas.cnpj}</td>
                                            <td>${pgdas.razao}</td>
                                            <td>R$ <fmt:formatNumber value="${pgdas.valdecsemretencao}" maxFractionDigits="2" minFractionDigits="2"/></td>
                                            <td>R$ <fmt:formatNumber value="${pgdas.valdeccomretencao}" maxFractionDigits="2" minFractionDigits="2"/></td>
                                            <td><fmt:formatNumber value="${pgdas.aliquota}" maxFractionDigits="2" minFractionDigits="2"/>%</td>
                                            <td>${pgdas.operacao}</td>
                                            <td>R$ <fmt:formatNumber value="${pgdas.valorrecoiss}" maxFractionDigits="2" minFractionDigits="2"/></td>

                                        </tr>
                                        <c:if test="${loop.last}">
                                            <tr>
                                                <td colspan="8" style="text-align: center;"><b>Total de registros: ${loop.count}</b></td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>

                                </table>
                                <!--  end product-table................................... --> 
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
                                        <select name="registro"  class="styledselect_pages">
                                            <option value="">Registros</option>
                                            <option value="">10</option>
                                            <option value="">20</option>
                                            <option value="">50</option>
                                            <option value="">100</option>

                                        </select>
                                    </td>
                                </tr>
                            </table>
                            <!--  end paging................ -->
                            </form>

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