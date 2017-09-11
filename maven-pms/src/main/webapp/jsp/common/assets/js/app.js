function showLoading() {
    $("#my-modal-loading").css("display","block");
}

function hideLoading() {
    $("#my-modal-loading").css("display","none");
}


function login(loginUrl , skipUrl) {
    var userName = $("#userName").val();
    var password = $("#password").val();
    console.info("username=" + userName + " password=" + password);
    showLoading();
    $.ajax({
        url : loginUrl,
        type : "post",
        data : {
            userName: userName,
            password:password
        },
        dataType : "json",
        success : function(result) {
            hideLoading();
            if (result.resultCode == 1) {
                window.location.href = skipUrl;
            } else {
                alert(result.message);
            }
        },
        error : function () {
            hideLoading();
            alert("系统异常请稍后再试！");
        }
    });
}

