<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
</head>
<body>
<div class="container">
<div class="row">
    <div class="col-sm-12">
      <h2>Configure Application </h2>
    </div>
   
   
    <hr>
  </div>
<div class="row">  
    <div class="col-sm-4">
    <form action="/upload" method="post">
	  <div class="form-group">
	    <label for="appConfFilePath">Upload File</label>
	    <input type="text" class="form-control" id="appConfFilePath" name="appConfFilePath" placeholder="Enter File Path"/>
	 
	  </div>
	  <button class="btn btn-primary" id="appConfFilePathBtn" type="submit">Upload</button>
	 </form>


</div>
</div>
</div>
</body>
</body>
</html>