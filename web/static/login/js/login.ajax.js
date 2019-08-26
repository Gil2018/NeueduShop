//服务器校验
function login(){
	location.href="index.html";
	if(login_validate()){
		
		var url = 'userControl/newLogin';

		var loginname = $("#loginname").val();
		var password = $("#password").val();
		var info = {
			userName:loginname,
			password:password,
			code:$('#code').val()
		}
		
		console.log(info);
		
		$.ajax({
			type: "POST",
			url: url,
	    	data: JSON.stringify(info),
			dataType:'json',
			contentType: 'application/json',
			cache: false,
			success: function(data){
				if("200" == data.code){
					saveCookie();
					window.location.href=data.msg;
				}else if("400" == data.code){
					$("#loginname").tips({
						side : 1,
						msg : data.msg,
						bg : '#FF5080',
						time : 15
					});
					$("#loginname").focus();
					$("#codeImg").click();
				}else if("500" == data.code){
					$("#loginname").tips({
						side : 1,
						msg : data.msg,
						bg : '#FF5080',
						time : 15
					});
					$("#code").focus();
					$("#codeImg").click();
				}else{
					$("#loginname").tips({
						side : 1,
						msg : "缺少参数",
						bg : '#FF5080',
						time : 15
					});
					$("#loginname").focus();
					$("#codeImg").click();
				}
			}
		});
	}
}

//客户端校验
function login_validate() {

	if ($("#loginname").val() == "") {

		$("#loginname").tips({
			side : 2,
			msg : '用户名不得为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#loginname").focus();
		return false;
	} else {
		$("#loginname").val(jQuery.trim($('#loginname').val()));
	}

	if ($("#password").val() == "") {

		$("#password").tips({
			side : 2,
			msg : '密码不得为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#password").focus();
		return false;
	}
	if ($("#code").val() == "") {

		$("#code").tips({
			side : 1,
			msg : '验证码不得为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#code").focus();
		return false;
	}

	return true;
}

function register() {
	if(register_validate()) {
		
		var url = 'userControl/userRegister';

		var username = $("#registerUsername").val();
		var password = $("#registerPassword").val();
		var register_name = $("#registerName").val();
		var register_email = $("#registerEmail").val();
		var register_phone = $("#registerPhone").val();
		var register_role = $("#registerRole").val();
		var register_skin = $("#registerSkin").val();

		info = {
			userName:username, 
			password:password, 
			name:register_name,
			email:register_email,
			phone:register_phone, 
			skin:register_skin, 
			roleID:register_role
		};

		console.log(info);

		$.ajax({
			type: "POST",
			url: url,
	    	data: JSON.stringify(info),
			dataType:'json',
			contentType: 'application/json',
			cache: false,
			success: function(data){
				if("200" == data.code){
					toggle('#login-form');
					$("#loginname").val($("#registerUsername").val());
					$("#loginname").tips({
						side : 2,
						msg : '注册成功！',
						bg : '#AE81FF',
						time : 3
					});
					$("#password").focus();
				}else{
					$("#registerUsername").tips({
						side : 1,
						msg : "注册失败",
						bg : '#FF5080',
						time : 15
					});
					$("#registerUsername").focus();

					var msg = data.message;
					if(msg.password != '')
					{
						$("#registerPassword").tips({
							side : 2,
							msg : '密码格式不正确',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.name != '')
					{
						$("#registerName").tips({
							side : 2,
							msg : '昵称格式不正确',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.email != '')
					{
						$("#registerEmail").tips({
							side : 2,
							msg : 'Email格式不正确',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.phone != '')
					{
						$("#registerPhone").tips({
							side : 2,
							msg : '电话格式不正确',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.userName != '')
					{
						$("#registerUsername").tips({
							side : 2,
							msg : '账号已被注册',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.skin != '')
					{
						$("#registerSkin").tips({
							side : 2,
							msg : '非法的skin',
							bg : '#AE81FF',
							time : 3
						});
					}
					if(msg.roleID != '')
					{
						$("#registerRole").tips({
							side : 2,
							msg : '非法的roleID',
							bg : '#AE81FF',
							time : 3
						});
					}
				}
			}
		});
	}
}

function register_validate() {
	if ($("#registerUsername").val() == "") {
		$("#registerUsername").tips({
			side : 2,
			msg : '用户名不得为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerUsername").focus();
		return false;
	} else {
		$("#registerUsername").val(jQuery.trim($('#registerUsername').val()));
	}

	if ($("#registerPassword").val() == "") {

		$("#registerPassword").tips({
			side : 2,
			msg : '密码不得为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerPassword").focus();
		return false;
	}

	if ($("#registerPassword2").val() != $("#registerPassword").val()) {

		$("#registerPassword2").tips({
			side : 2,
			msg : '两次密码不一致',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerPassword2").focus();
		return false;
	}

	if ($("#registerName").val() == "") {

		$("#registerName").tips({
			side : 2,
			msg : '昵称不能为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerName").focus();
		return false;
	}

	if ($("#registerEmail").val() == "") {

		$("#registerEmail").tips({
			side : 2,
			msg : 'Email不能为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerEmail").focus();
		return false;
	} else {
		var email = $("#registerEmail").val();
	  	if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
	  		$("#registerEmail").tips({
				side : 2,
				msg : 'Email格式不正确',
				bg : '#AE81FF',
				time : 3
			});
			$("#registerEmail").focus();
	  		return false;
	  	}
	}

	if ($("#registerPhone").val() == "") {

		$("#registerPhone").tips({
			side : 2,
			msg : '电话不能为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#registerPassword2").focus();
		return false;
	} else {
		var phone = $("#registerPhone").val();
		if (!phone.match(/^(1)\d{10}$/)) {
			$("#registerPhone").tips({
				side : 2,
				msg : '电话格式不正确',
				bg : '#AE81FF',
				time : 3
			});
			$("#registerPhone").focus();
	  		return false;
		}
	}

	return true;
}

function send_email() {
	var email = $("#validate-email").val();
	if (email == "") {

		$("#validate-email").tips({
			side : 2,
			msg : 'Email不能为空',
			bg : '#AE81FF',
			time : 3
		});

		$("#validate-email").focus();
		return false;
	} else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
		$("#validate-email").tips({
			side : 2,
			msg : 'Email格式不正确',
			bg : '#AE81FF',
			time : 3
		});
		$("#validate-email").focus();
		return false;
	} else {
		$.ajax({
			type: "POST",
			url: 'http://earlhwong.cn/testing/a.php',
	    	data: {EMAIL:email},
			dataType:'json',
			cache: false,
			success: function(data){
				if(data.code == '400') {
					show_reset_pwd();
				}
				else{
					$("#validate-email").tips({
						side : 2,
						msg : data.msg.PASSWORD,
						bg : '#AE81FF',
						time : 3
					});
					$("#validate-email").focus();
				}
			}
		});
	}
}

function send_reset_info(){
	var email_code = $("#validate-email-code").val();
	var password = $("#reset-pwd").val();
	var password2 = $("#reset-pwd2").val();

	if(password2 != password){
		$("#reset-pwd").tips({
			side : 2,
			msg : '两次密码不一致',
			bg : '#AE81FF',
			time : 3
		});
		return false;
	}

	$.ajax({
		type: "POST",
		url: 'http://earlhwong.cn/testing/a.php',
    	data: {CODE:email_code, PASSWORD:password},
		dataType:'json',
		cache: false,
		success: function(data){
			if(data.code == '400') {
				show_reset_pwd();
			}
			else{
				$("#validate-email").tips({
					side : 2,
					msg : data.msg.PASSWORD,
					bg : '#AE81FF',
					time : 3
				});
				$("#validate-email").focus();
			}
		}
	});
}

$(document).ready(function() {
	changeCode();
	$("#codeImg").bind("click", changeCode);
});

function genTimestamp() {
	var time = new Date();
	return time.getTime();
}

function changeCode() {
	$("#codeImg").attr("src", "code.do?t=" + genTimestamp());
}

function savePaw() {
	if (!$("#saveid").attr("checked")) {
		$.cookie('loginname', '', {
			expires : -1
		});
		$.cookie('password', '', {
			expires : -1
		});
	}
}

function saveCookie() {
	if ($("#saveid").attr("checked")) {
		$.cookie('loginname', $("#loginname").val(), {
			expires : 7
		});
		$.cookie('password', $("#password").val(), {
			expires : 7
		});
	}
}
function reset() {
	$("#loginname").val('');
	$("#password").val('');
}

jQuery(function() {
	var loginname = $.cookie('loginname');
	var password = $.cookie('password');
	if (typeof(loginname) != "undefined"
			&& typeof(password) != "undefined") {
		$("#loginname").val(loginname);
		$("#password").val(password);
		$("#saveid").attr("checked", true);
		$("#code").focus();
	}
});

function toggle(span) {

	var li_1 = $("#li-1");
	var li_2 = $("#li-2");    
	var li_3 = $("#li-3");
	if(span == '#register-form'){
		$(li_2).insertBefore(li_1);
		$(li_1).after(li_3);
	}
	if(span == '#login-form'){
		$(li_1).insertBefore(li_2);
		$(li_2).after(li_3);
	}
		if(span == '#find-pwd-form'){
		$(li_3).insertBefore(li_1);
		$(li_1).after(li_2);
	}

	switch(span) {
		case '#login-form':
			$('#login-form').animate({
				'height':'178px',
			});
			$('#register-form').animate({
				'height':'178px',
			});
			$('#find-pwd-form').animate({
				'height':'178px',
			});
			$('.page-wrapper').removeClass('form-div--show-register');
			$('.page-wrapper').removeClass('form-div--show-forget');

			$('.li-active').removeClass('li-active');
			$('.navigation-link').addClass(function(n){
			if(n == 0)
				return 'li-active';
			});
			break;
		case '#register-form':

			$('#login-form').animate({
				'height':'735px',
			});
			$('#register-form').animate({
				'height':'735px',
			});
			$('#find-pwd-form').animate({
				'height':'735px',
			});
			$('.page-wrapper').removeClass('form-div--show-forget');
			$('.page-wrapper').addClass('form-div--show-register');

			$('.li-active').removeClass('li-active');
			$('.navigation-link').addClass(function(n){
			if(n == 0)
				return 'li-active';
			});
			break;
		case '#find-pwd-form':

			if($('#send-email-form').attr('class').match('form-div-email')){
				$('#login-form').animate({
					'height':'279px',
				});
				$('#register-form').animate({
					'height':'279px',
				});
				$('#find-pwd-form').animate({
				'height':'279px',
				});
			}
			else{
				$('#login-form').animate({
					'height':'194px',
				});
				$('#register-form').animate({
					'height':'194px',
				});
				$('#find-pwd-form').animate({
					'height':'194px',
				});
			}

			$('.page-wrapper').removeClass('form-div--show-register');
			$('.page-wrapper').addClass('form-div--show-forget');

			$('.li-active').removeClass('li-active');
			$('.navigation-link').addClass(function(n){
			if(n == 0)
				return 'li-active';
			});

			break;
	}



}

function show_reset_pwd(){
	$('#find-pwd-form').animate({height:'279px'},"slow");
	$('#send-email-form').addClass('form-div-email');
	$('#reset-pwd-form').addClass('form-div-email');
}

function resend_email(){
	$('#find-pwd-form').animate({height:'194px'},"slow");
	$('.form-div-email').removeClass('form-div-email');
}


//TOCMAT重启之后 点击左侧列表跳转登录首页 
if (window != top) {
	top.location.href = location.href;
}


