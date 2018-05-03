function  getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}
function postNewUser(URL,params) {
    // alert(123);
    // alert(params['name']);
    // alert(params['deptment']);
    // alert(params['password']);
    var form = document.createElement('form');
    form.action=URL;
    form.method='post';
    form.style.display='none';
    document.body.appendChild(form);
    for(var obj in params){
        var oText = document.createElement('textarea');
        oText.name=obj;
        oText.value=params[obj];
        form.appendChild(oText);
    }
    form.submit(params);
    document.body.removeChild(form);
}
window.onload=function () {
    $('#table').bootstrapTable({
        method:'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url:getPath()+'/users',
        dataType: "json",
        pagination: true, //分页
        data_local: "zh-US",
        pageIndex:1,
        pageNumber: 1,
        pageSize:5,
        queryParamsType:'',
        queryParams:function (params) {
            return {
                pageNumber:params.pageNumber,
                pageSize:params.pageSize,
                username:$('#username').val(),
                deptment:$('#deptment').val()
            };
        },

        sidePagination: "server", //服务端处理分页,
        columns: [
            {
                title: 'ID',
                field: 'id',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '姓名',
                field: 'name',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '部门',
                field: 'deptment',
                align: 'center'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter:function(value,row,index){
                    var e = '<a href="#" mce_href="#" onclick="edit(\''+ row.id + '\')">编辑</a> ';
                    var d = '<a href="#" mce_href="#" onclick="del(\''+ row.id +'\')">删除</a> ';
                    return e+d;
                }
            }]
    });
    $('#search_btn').click(function () {
        $('#table').bootstrapTable('refresh',{url:getPath()+'/users'})
    });
    $('#newUser').click(function () {
        // window.location.href=getPath()+'/newUser';
        $('#newusermodal').modal('show');
    });
    $('#postNewUser').click(function () {

        var params = {};
        params['name']=$('#newname').val();
        params['deptment']=$('#newdept').val();
        params['password']='123';
        params['User.id']=0;
        params['Category.id']=6;
        params['cateName']=$('#newcate').val();
        alert(params['cateName']);
        var url = getPath()+'/register';
        // var oJson = JSON.parse(user);
        // alert(oJson);
        postNewUser(url,params);
    });
    testNav();
}
function testNav() {
    $('#testNav').click(function () {
        alert(2);
        window.location.href=getPath()+'/testNav';
    });
}