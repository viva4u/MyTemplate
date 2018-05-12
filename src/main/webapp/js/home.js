$(document).ready(function () {
    $('#navigate').click(function () {
        $.ajax({
            url:getPath()+'/navigate',
            type:'GET',
            success:function (html) {
                $('#main').html(html);
            }
        });
    });
})

function  getPath(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
