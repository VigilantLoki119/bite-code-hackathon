<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create TestCase</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
<script src="/js/home.js"></script>
<script src="/js/createTestCase.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
<div class="row">
    <div class="col-sm-8">
      <h2>Create TestCase</h2>
    </div>
   
    <div class="col-sm-4">
      <a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Row</a>
    </div>
    <hr>
  </div>
  <div class="row">
    <h1 id="msg"></h1>
    <h1 id="bannedMsg"></h1>
  </div>
<div class="row">  
    <div class="col-sm-12">
<table class="table" id="tbl_posts">
  <thead>
    <tr>
      <th scope="col">SL No</th>
      <th scope="col">Node Name</th>
      <th scope="col">Xpath</th>
      <th scope="col">Operation</th>
      <th scope="col">Test Data</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody id="tbl_posts_body">
    <tr id="rec-1">
      <th scope="row" class="sn">1</th>
      <td><input type="text" name="nodeName" id="nodeName1"/></td>
      <td><input type="text" name="xpathStr" id="xpathStr1" /></td>
      <td><input type="text" name="operaionName" id="operationName1" /></td>
      <td><input type="text" name="testData1"  id="testData1"/></td>
      <td><a class="btn btn-xs delete-record" data-id="1"><i class="glyphicon glyphicon-trash"></i></a></td>
    </tr>
 
  </tbody>
</table>
<button class="btn btn-primary" id="submitTestCase">Submit</button>


</div>
</div>
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