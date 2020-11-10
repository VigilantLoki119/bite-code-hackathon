/* Home JS */

function loginDetails() {

  var checkBox = document.getElementById("loginCheck1");
  var login1 = document.getElementById("login-disp1");

console.log(checkBox);
console.log(login1);

  if (checkBox.checked == true){
    login1.style.display = "block";
  } else {
    login1.style.display = "none";
  }
}

function loginDetails2() {
  
  var checkBox = document.getElementById("loginCheck2");
  var login2 = document.getElementById("login-disp2");

  console.log(login2);

  if (checkBox.checked == true){
    login2.style.display = "block";
  } else {
    login2.style.display = "none";
  }
}