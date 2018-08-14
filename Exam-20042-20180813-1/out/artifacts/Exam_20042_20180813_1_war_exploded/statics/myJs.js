$(document).ready(function(){
        $("#login").click(
            function () {
                if($("#name").val()==""){
                    alert("用户名为空！")
                    return false;
                }else {
                    return true;
                }
            }
        );
})