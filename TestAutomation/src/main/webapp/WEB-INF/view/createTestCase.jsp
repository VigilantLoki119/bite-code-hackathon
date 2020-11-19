<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create TestCase</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/js/home.js"></script>
<script src="/js/index.js"></script>
<script src="/js/createTestCase.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<div class="row">
    <div class="col-sm-8">
      <h2>Create TestCase</h2>
    </div>
  </div>
  <div class="row" id="row-msg" style="display:none;">
    <div class="col-sm-12">
      <h2 class="text-success" id="msg"></h2>
    </div>
  </div>
   <br><br>
 <div class="form-content"> 
  <div class="row">

<div class="col-sm-12">
			<div class="col-sm-3">
				<div class="form-group">
				  <label for="selectedApp">Application:</label>
				  <select class="form-control" id="selectedApp">
				   	<option value="">Select Application Name</option>
						<c:forEach var="appValue" items="${appDetails}">
							<option value="${appValue.appId}___${appValue.appName}"><c:out value="${appValue.appName}"/></option>
						</c:forEach>
	  			</select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
				  <label for="">Functionlity:</label>
				  <select class="form-control" id="selectedPage">
					
				  </select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
				  <label for="selectedEnvSite1">Site1 Environment:</label>
				  <select class="form-control" id="selectedEnvSite1" >
				  <option value=''>Select Environment</option>
					<c:forEach var="envValue" items="${envDetails}">
					<option value="${envValue.envId}"><c:out value="${envValue.envName}"/></option>
					</c:forEach>
				  </select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
				  <label for="selectedEnvSite1">Site2 Environment:</label>
				  <select class="form-control" id="selectedEnvSite2" >
				  <option value=''>Select Environment</option>
					<c:forEach var="envValue" items="${envDetails}">
					<option value="${envValue.envId}"><c:out value="${envValue.envName}"/></option>
					</c:forEach>
				  </select>
				</div>
			</div>
			
</div>
 </div>
  <div class="row">
<div class="col-sm-12">
<div class="col-sm-6">
<div class="form-group">
	  <label for="testCaseName">TestCase Name:</label>
	  <input type="text" class="form-control" id="testCaseName" placeholder="Provide TestCase Name" name="testCaseName"/>
	</div>
</div>
</div>
</div>

 
  </div>

 <div class="form-content"> 
	<div class="row">			
  <div class="panel-group" id="accordion">
  
    <!--  TestStep1 starts-->
	<div class="main-record" id="record0">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a class="collapse-record" data-toggle="collapse" data-parent="#accordion"  onclick="collapseTestStep(0)">
          <span>Step1</span> <b>:</b> 
          <input class="teststepName" type="text" placeholder="Provide TestCase Step Name" name="name_teststep0" id="name_teststep0" value=""/>
          <span class="spanName_teststep" id="spanName_teststep0" style="display:none;"></span>
          </a>
          &nbsp;&nbsp;
          <i class="glyphicon glyphicon-ok" onclick="saveTestStepName(0)"></i>
          <i class='glyphicon glyphicon-pencil' onclick="editTestStepName(0)" style="display:none;"></i>
              <span class="pull-right">
          	 <a class="btn btn-xs  delete-record"  onclick="deleteTestStep(0)">
				      	<i class="glyphicon glyphicon-trash"></i>
				       </a>
				      
      				  <a class="btn btn-primary  add-record"  onclick="addTestStep(0)">
      				  	<i class="glyphicon glyphicon-plus"></i> 
      				  </a>
          </span>
        </h4>
     
       
      		
      </div>
      <div id="clspTestStep0" class="panel-collapse collapse in collapse-teststep" style="display:none">
        <div class="panel-body">
     
				<table class="table table-record">
					<thead>
					    <tr>
					      <th scope="col">Site Name</th>
					      <th scope="col">Xpath</th>
					      <th scope="col">Operation</th>
					      <th scope="col">Test Data</th>
					    </tr>
				  </thead>
				  <tbody class="body">
				  <tr>
				  	  <td> Site1</td>
				      <td><input type="text" class="xpathSite1" placeholder="Xpath for old site1" name="xpathSite1_teststep0" id="xpathSite1_teststep0" value=""/></td>
				      <td>  <select class="operationSite1" name="operationSite1_teststep0" id="operationSite1_teststep0">
										   <option value="">Select Operation for site1</option>
										   <c:forEach var="operationValue" items="${operationCatagory}">
												<option value="${operationValue}"><c:out value="${operationValue}"/></option>
											</c:forEach>
										  </select>
					 </td>
				      <td><input class="testDataSite1" type="text" placeholder="text data for site1" name="testDataSite1_teststep0"  id="testDataSite1_teststep0" value=""/></td>
				      
				     </tr>
				    <tr>
				  	  <td> Site2</td>
				      <td><input type="text" class="xpathSite2" placeholder="Xpath for old site2" name="xpathSite2_teststep0" id="xpathSite2_teststep0"  value=""/></td>
				      <td>  <select class="operationSite2" name="operationSite2_teststep0" id="operationSite2_teststep0">
										   <option value="">Select Operation for site2</option>
										   <c:forEach var="operationValue" items="${operationCatagory}">
												<option value="${operationValue}"><c:out value="${operationValue}"/></option>
											</c:forEach>
										  </select>
					 </td>
				      <td><input class="testDataSite2" type="text" placeholder="text data for site2" name="testDataSite2_teststep0"  id="testDataSite2_teststep0" value=""/></td>
				      
				     </tr>
				 
				  </tbody>
			</table>
				        
        </div>
      </div>
      
    </div>
    </div>
    <!--  TestStep1 ends-->
 
  </div> 
	</div>	
	
	<button type="Submit" class="btnSubmit" id="submitTestCase">Save</button>    
	</div>
	
	 <!-- TemplateTestStep Code starts -->
	<div id="templateRecord" style="display:none">
	
		<div class="panel panel-default" style="margin-top:10px">
      <div class="panel-heading">
        <h4 class="panel-title">
           <a class="collapse-record" data-toggle="collapse" data-parent="#accordion" >
          <span>Step</span> <b>:</b> 
          <input class="teststepName" type="text" placeholder="Provide TestCase Step Name" value=""/>
          <span class="spanName_teststep" style="display:none;"></span>
          </a>
          &nbsp;&nbsp;
          <i class="glyphicon glyphicon-ok" ></i>
          <i class='glyphicon glyphicon-pencil' style="display:none;"></i>
              <span class="pull-right">
          	 <a class="btn btn-xs  delete-record"  >
				      	<i class="glyphicon glyphicon-trash"></i>
				       </a>
				      
      				  <a class="btn btn-primary  add-record"  >
      				  	<i class="glyphicon glyphicon-plus"></i> 
      				  </a>
          </span>
        </h4>
     
       
      		
      </div>
      <div class="panel-collapse collapse in collapse-teststep" style="display:none;">
        <div class="panel-body">
     
				<table class="table table-record">
					<thead>
					    <tr>
					      <th scope="col">Site Name</th>
					      <th scope="col">Xpath</th>
					      <th scope="col">Operation</th>
					      <th scope="col">Test Data</th>
					    </tr>
				  </thead>
				  <tbody class="tbody-record">
				  <tr>
				  	  <td> Site1</td>
				      <td><input type="text" class="xpathSite1" placeholder="Xpath for old site1"  value=""/></td>
				      <td>  <select class="operationSite1">
										   <option value="">Select Operation for site1</option>
										   <c:forEach var="operationValue" items="${operationCatagory}">
												<option value="${operationValue}"><c:out value="${operationValue}"/></option>
											</c:forEach>
										  </select>
						</td>
				      <td><input class="testDataSite1" type="text" placeholder="text data for site1" value=""/></td>
				      
				     </tr>
				    <tr>
				  	  <td> Site2</td>
				      <td><input type="text" class="xpathSite2" placeholder="Xpath for old site2" value="" /></td>
				      <td>  <select class="operationSite2">
										   <option value="">Select Operation for site2</option>
										   <c:forEach var="operationValue" items="${operationCatagory}">
												<option value="${operationValue}"><c:out value="${operationValue}"/></option>
											</c:forEach>
										  </select>
						</td>
				      <td><input class="testDataSite2" type="text" placeholder="text data for site2" value=""/></td>
				      
				     </tr>
				 
				  </tbody>
			</table>
				        
        </div>
      </div>
      
    </div>

    </div>
    <!-- TemplateTestStep Code ends -->
    
	
	
</div>
</body>
 <script> 
 $(document).ready(function () { 
                $('ul.navbar-nav > li') .removeClass('active'); 
                $("#createTestCase").addClass('active'); 
        }); 
 </script> 

</body>
</html>