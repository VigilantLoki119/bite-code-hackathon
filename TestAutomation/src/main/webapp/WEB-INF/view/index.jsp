<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>

<!------Home Html ------->

<body>
<jsp:include page="header.jsp"/>
<div class="container">
<div class="row">
    <div class="col-sm-12">
      <h2>Run Test Case</h2>
    </div>

    <br>
	<br>
  </div>
<div class="form-content"> 
<div class="row"> 

    <div class="col-sm-12">


                      
							
                             
								<form:form action="/result" modelAttribute="testCaseRunRequest" method="post"> 
								<!-- section-1-->
									<div class="col-sm-6">
										<div class="form-group">
										  <label for="selectedApp">Application:</label>
										  <form:select class="form-control" id="selectedApp" path="selectedApp">
										   <option value="">Select Application Name</option>
											<c:forEach var="appValue" items="${appDetails}">
											<option value="${appValue.appId}"><c:out value="${appValue.appName}"/></option>
											</c:forEach>
										  </form:select>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
										  <label for="">Functionlity:</label>
										  <form:select class="form-control" id="selectedPage" path="selectedPage">
											
										  </form:select>
										</div>
									</div>
									<!-- section-1-->
									<!-- section-2-->
									<div class="col-sm-12">
									
										<div class="col-sm-6">
										<label>Site 1:</label>
										<div class="form-content">
										<div class="form-group">
										  <label for="selectedTestCaseSite1">Available Configured TestCases:</label>
										  <form:select class="form-control" id="selectedTestCaseSite1" path="selectedTestCaseSite1">
											
										  </form:select>
										</div>
										<div class="form-group">
										  <label for="selectedEnvSite1">Environment:</label>
										  <form:select class="form-control" id="selectedEnvSite1" path="selectedEnvSite1" onChange="getUrlValue('1')">
										  <option value=''>Select Environment</option>
											<c:forEach var="envValue" items="${envDetails}">
											<option value="${envValue.envId}"><c:out value="${envValue.envName}"/></option>
											</c:forEach>
										  </form:select>
										</div>
										<div class="form-group">
										  <label for="selectedUrlSite1">URL:</label>
										  <form:input type="text" class="form-control" id="selectedUrlSite1" placeholder="URL" path="selectedUrlSite1" />
										</div>
										</div>
										</div>
								
										<div class="col-sm-6">
										<label>Site 2:</label>
										<div class="form-content">
										<div class="form-group">
										  <label for="selectedTestCaseSite2">Available Configured TestCases:</label>
										  <form:select class="form-control" id="selectedTestCaseSite2" path="selectedTestCaseSite2">
											
										  </form:select>
										</div>
											<div class="form-group">
											  <label for="selectedEnvSite2">Environment:</label>
											  <form:select class="form-control" id="selectedEnvSite2" path="selectedEnvSite2" onChange="getUrlValue('2')">
											  <option value=''>Select Environment</option>
												<c:forEach var="envValue" items="${envDetails}">
												<option value="${envValue.envId}"><c:out value="${envValue.envName}"/></option>
												</c:forEach>
											  </form:select>
											</div>
											<div class="form-group">
											  <label for="selectedUrlSite2">URL:</label>
											  <form:input type="text" class="form-control" id="selectedUrlSite2" placeholder="URL" path="selectedUrlSite2" />
											</div>
										</div>
										</div>
									</div>
									<!-- section-2-->
									<!-- section-3-->
								<div class="col-sm-6">
                                 <div class="form-group" id="login1">
                                        <label class="label-name" for="userId">Login Credentials:</label>
                                        <form:checkbox path="loginCredRequired" id="loginCredRequired" />
                                        <div id="loginCred" style="display: none">
                                            <form:input type="text" class="form-control" id="username" placeholder="Username" path="username" />
                                            <br>
                                            <form:input type="Password" class="form-control" id="password" placeholder="Password" path="password" />
                                        </div>
                                   
                                </div>
								<button type="Submit" class="btnSubmit" >Run</button>
								</div>
								<!-- section--->
							</form:form>
               
         
		 
</div>	 

</div>
</div>
</div>
</body>
 <script> 
        $(document).ready(function () { 
                $('ul.navbar-nav > li') .removeClass('active'); 
                $("#index").addClass('active'); 
        }); 
    </script>
</html>
