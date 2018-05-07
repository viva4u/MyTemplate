window.onload=function () {
    // $('#navigate').load(getPath()+"/templates/users.html");
    // $('#test').load(getPath()+"/templates/test.html");
    // $('#about').load(getPath()+"/templates/about.html");
    // $('#mainnav').scrollspy();
}
function  getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}