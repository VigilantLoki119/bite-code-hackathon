<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/js/home.js"></script>
<script src="/js/result.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>


  
<div class="container">
<div class="row">
    <div class="col-sm-12">
      <h2>Test Case Execution Result</h2>
    </div>
</div>
    <br>
	<br>
  <div class="row">
    <div class="col-sm-12">
      <table  class="table table-bordered" style="border-collapse:collapse;">
           <c:choose>
               <c:when test="${not empty runningTestCaseList}">
                 <thead>
                    <tr>
                    	<th scope="col">Application</td>
                        <th scope="col">Functionality</td>
                        <th scope="col">TestCaseName</td>
                        <th scope="col">Execution Date&Time</td>
                        <th scope="col">Status</td>
                        
                    </tr>
                </thead>
                <tbody>
              		<c:forEach var="runningTestCase" items="${runningTestCaseList}" varStatus="loopCounter">
                    <tr>
                    	<td>
                            <p class="text-left font-weight-bold"><c:out value="${runningTestCase.testCaseRunRequest.selectedApp}"/></p>
                        </td>
                        <td>
							<p class="text-left font-weight-bold"><c:out value="${runningTestCase.testCaseRunRequest.selectedPage}"/></p>   
                        </td>
                         <td>
                            <p class="text-left font-weight-bold"><c:out value="${runningTestCase.testCaseRunRequest.selectedTestCaseName}"/></p>
                        </td>
                         <td>
                         	<p class="text-left font-weight-bold"><c:out value="${runningTestCase.testCaseRunRequest.testExecutionDate}"/></p>
                        </td>
                         <td>
                         	<p class="text-left font-weight-bold"><c:out value="${runningTestCase.testCaseRunResponse.status}"/></p>
                         	<c:if test="${runningTestCase.testCaseRunResponse.status == 'success'}">
                          	<p class="text-left font-weight-bold"><button type="button" class="btn btn-success" onClick="viewResult('${runningTestCase.testCaseRunResponse.testCaseSessionKey}')">Show Details</button></p>
                          	</c:if>
                        </td>
                   </tr>
                </c:forEach>
             
                </tbody>
               </c:when>
               <c:otherwise>
               <tbody>
               		<tr>
               			<td>No Test Cases has been executed.</td>
               		</tr>
               </tbody>
               </c:otherwise>
            </c:choose>
           
       </table>
    </div>
</div>
    <br>
	<br>    
 
<div class="row" id="resultGridView"> 
  <!--  Start of Grid View -->
      <%--   <div id="table-border" class="col-md-12">
            <table  class="table table-bordered" style="border-collapse:collapse;">
                <thead>
                    <tr>
                        <th scope="col">Expected Data(Old Site)</td>
                        <th scope="col">Actual Data(New Site)</td>
                        <th scope="col">Result</td>
                        
                    </tr>
                </thead>

                <tbody>
              		
            		<c:forEach var="testResultWithStatus" items="${testResultDetails.testResultWithStatusList}" varStatus="loopCounter">
                    <tr>
                        <td>
                          <p><span class="btn btn-primary"><c:out value="${testResultWithStatus.testItemExpected.itemName}"/></span></p>
                             <div class="accordian-body collapse  row${loopCounter.index}">
                             <c:forEach var="expectedValue" items="${testResultWithStatus.testItemExpected.values}">
                            	<ul>
                            		<li><p class="text-left font-weight-bold"><c:out value="${expectedValue}"/></p></li>
                               </ul>
                              </c:forEach>
                            </div>
                        </td>
                        
                         <td>
                          <p><span class="btn btn-primary"><c:out value="${testResultWithStatus.testItemActual.itemName}"/></span></p>
                             <div class="accordian-body collapse  row${loopCounter.index}">
                              <c:forEach var="actualValue" items="${testResultWithStatus.testItemActual.values}">
                            	<ul>
                            		<li><p class="text-left font-weight-bold"><c:out value="${actualValue}"/></p></li>
                               </ul>
                              </c:forEach>
                            </div>
                        </td>
                      
                          
                     
                         <td>
                         
                          	<button type="button" class="btn btn-success" id="btn-show-${loopCounter.index}"><c:out value="${testResultWithStatus.status}"/></span> &nbsp;&nbsp;<i class="glyphicon glyphicon-plus" onClick="showItemData(${loopCounter.index})"></i></button>
                            <button type="button" class="btn btn-success hidden" id="btn-hide-${loopCounter.index}"><c:out value="${testResultWithStatus.status}"/></span> &nbsp;&nbsp;<i class="glyphicon glyphicon-minus" onClick="hideItemData(${loopCounter.index})"></i></button>
                            <div class="accordian-body collapse row${loopCounter.index}">
                               
                            </div>
                        </td>
                       
                   </tr>
                  </c:forEach>
                   </tbody>
            </table>
        </div> --%>
        <!--  End of Grid View -->
        
        
        </div>
        
</div>      

</body>
 <script> 
 $(document).ready(function () { 
                $('ul.navbar-nav > li') .removeClass('active'); 
                $("#result").addClass('active'); 
        }); 
 </script> 
</html>