// window.onload=function () {
//     login();
// }
function checkName() {

    var user = {};
    user['name']=$('#username').val();
    user['password']=$('#password').val();
    $.ajax({
        type:"GET",
        url:getPath()+'/login/',
        data:{"name":$('#username').val()},
        dataType:"json",
        success:function (data) {

            if(data.flag==true){
                $('#msg').val("is true");
                $('#msg').css('style','border:none');
                // $('#msgmodal').modal('show');
                return true;

            }else {
                $('#msg').val("is false");
                $('#msg').css('style','border:none');
                $('#msgmodal').modal('show');
                return false;
            }
        }
    });
}
function  getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
function login() {
    var oMethod = document.getElementById("loginForm");
    var oUser = oMethod.serialize();
    // oUser["username"]=document.getElementById("username").val();
    // oUser["password"]=document.getElementById("password").val();
    // oMethod.method="POST";
    // oMethod.action="login";
    // oMethod.setAttribute("method","post");
    // oMethod.setAttribute("action",getPath()+"/login");
    oMethod.submit(oUser);
    // $.post(getPath()+"/login",{'user':oUser});
}