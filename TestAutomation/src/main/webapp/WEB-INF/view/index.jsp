<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="home.css">
</head>

<!------Home Html ------->

<body>
<div class="container pt-10x register-form">
            <div class="form">
                <div class="note">
                    <p><h1>Home Page for Automated testing.</h1></p>
                </div>
                <form id=Home-form> 
                  <nav class="navbar navbar-expand-sm bg-light navbar-light">
                          <ul class="navbar-nav">
                            <li class="nav-item">
                              <a class="navbar-brand" href="#">
                                    <img src="https://image.freepik.com/free-icon/todo-list_318-10185.jpg" alt="logo" style="width:40px;">
                              </a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="#">RUN</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="#">ADD CONFIG</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="#">TEST CASE CONFIG</a>
                            </li>
                          </ul>
                    </nav>   
                    <div class="form-content">
                        <div class="row">
                            <div class="col-md-6">
                                <br>
                                <label class="label-name"> OLD SITE </label>
                                <br>
                                <div class="form-group" id="Application1">
                                    <input type="text" class="form-control" placeholder="Application" name="Application1" value=""/>
                                </div>
                                 <div class="form-group" id="Functionality1">
                                    <input type="text" class="form-control" placeholder="Functionality" name="Functionality1" value=""/>
                                </div>
                                 <div class="form-group" id="Environment1">
                                    <input type="text" class="form-control" placeholder="Environment" name="Environment1" value=""/>
                                </div>
                                <div class="form-group" id="URL1">
                                    <input type="text" class="form-control" placeholder="URL" name="URL1" value=""/>
                                </div>
                                 <div class="form-group" id="login1">
                                    <form>
                                        <label class="label-name" for="userId">Login Credentials:</label>
                                        <input type="checkbox" onclick="loginDetails()" id="loginCheck1" ></button>
                                        <div id="login-disp1" style="display: none">
                                            <input type="text" class="form-control" id="userId" placeholder="User ID" name="userId1"value=""/>
                                            <br>
                                            <input type="Password" class="form-control" id="Pass" placeholder="Password" name="pass1" value=""/>
                                        </div>
                                    </form> 
                                </div>
                            </div>
                            <div class="col-md-6">
                                <br>
                                <label class="label-name"> NEW SITE </label>
                                <br>
                                <div class="form-group" id="Application2">
                                    <input type="text" class="form-control" placeholder="Application" name="Application2" value=""/>
                                </div>
                                 <div class="form-group" id="Functionality2">
                                    <input type="text" class="form-control" placeholder="Functionality" name="Functionality2" value=""/>
                                </div>
                                 <div class="form-group" id="Environment2">
                                    <input type="text" class="form-control" placeholder="Environment" name="Environment2" value=""/>
                                </div>
                                <div class="form-group" id="URL1">
                                    <input type="text" class="form-control" placeholder="URL" name="URL2" value=""/>
                                </div>
                                 <div class="form-group" id="login2">
                                    <form>   
                                        <label class="label-name" for="userId">Login Credentials:</label>
                                        <input type="checkbox" onclick="loginDetails2()" id="loginCheck2" ></button>
                                        <div id="login-disp2" style="display: none">
                                            <input type="text" class="form-control" id="userId" placeholder="User ID" name="userId2"value=""/>
                                            <br>
                                            <input type="Password" class="form-control" id="Pass" placeholder="Password" name="pass2" value=""/>
                                        </div>
                                    </form> 
                                </div>
                            </div>
                        <button type="Submit" class="btnSubmit" onclick="formDetails()">Submit</button>
                    </div>
                </form>
            </div>
        </div>
<script src="home.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
