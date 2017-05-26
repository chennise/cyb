// JavaScript Document
//支持Enter键登录
//		document.onkeydown = function(e){
//			if($(".bac").length==0)
//			{
//				if(!e) e = window.event;
//				if((e.keyCode || e.which) == 13){
//					var obtnLogin=document.getElementById("submit_btn");
//					obtnLogin.focus();
//				}
//			}
//		};
 //获取cookie代码
  //获取cookie代码

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				var l_index = layer.load('登录中...');
				if($('#account').val() == ''){
					layer.msg('请输入账号！',1);	
					$('#account').focus();
				}else if($('#password').val() == ''){
					layer.msg('请输入密码！',1);
					$('#password').focus();
				}else if($('#verifyDiv').css('display') != 'none' && $('#j_captcha').val() == ''){
					layer.msg('请输入验证码！',1);
					$('#j_captcha').focus();
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					$.ajax({
						// url:'http://222.200.98.147/login!doLogin.action',
						url:'login/',
						type:"post",
						data:{
							account:$("#account").val(),
							pwd:$("#password").val(),
							verifycode:$("#j_captcha").val()
						},
						dataType:"json",
						complete:function(){
							layer.close(l_index);
						},
						success:function(chard){
							if(chard == 'y'){//登录成功
								layer.msg('登录成功  正在为您跳转...',3,10);
								window.location.href = 'http://222.200.98.147/login!welcome.action';
							}else{//登录失败
								changeVerifyCode();
								layer.alert('您的帐号或密码不正确');
								isNeedVerify();
							}
						},
						error:function(){
							layer.alert("登录超时，请稍后重试！");
						}
					});
					
				}
			});
			
			
			//全屏图
		 	$.supersized({

			        // Functionality
			        slide_interval     : 4000,    // Length between transitions
			        transition         : 3,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
			        transition_speed   : 1000,    // Speed of transition
			        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
			        
			        // Size & Position
			        min_width          : 0,    // Min width allowed (in pixels)
			        min_height         : 0,    // Min height allowed (in pixels)
			        vertical_center    : 0,    // Vertically center background
			        horizontal_center  : 1,    // Horizontally center background
			        fit_always         : 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
			        fit_portrait       : 1,    // Portrait images will not exceed browser height
			        fit_landscape      : 0,    // Landscape images will not exceed browser width

			        // Components
			        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
			        slides             : [    // Slideshow Images
											 {image : 'static/1.jpg'}
			                       ]

			    });   			
			
			
		});
    	
    	
