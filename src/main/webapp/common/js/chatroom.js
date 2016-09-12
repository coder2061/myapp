$(function(){
    refresh();
}) ;

function refresh(){
    $.ajax({
        type:'POST',
        url:getPath()+'/ws/loadMessage',
        success:function(data){
            if (data.result ==1){
                var contents = data.data.contents ;
                for (var i=0 ;i<contents.length ;i++){
                    var content = contents[i];
                    var msg = content.content;
                    $("#msg").append(msg+"<br/>")
                }
            }else {

            }
        }
    });
}

//获取java路径
function getPath() {
	return $('body').attr('data');
}

//404情况下的图片或头像
function imgError(img,type){
	img.src=getPath()+'/images/default/'+type+'.jpg';
	if(type=='default_coach_list_img'){
		window.setTimeout(function(){
			$('#coachPic img').css('height',''+$('.content_bg:eq(1) img').height()+'px');									
		},50);
	}
}
//获取请求URL参数
function getURLParams(name){
     var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null){
    	 return unescape(r[2]);
     } 
     return null;
}
//获取cookies参数
function getCookie(name){  
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));  
    if(arr != null){  
     return unescape(arr[2]);   
    }else{  
     return null;  
    }  
}

//倒计时小于两位数，补0
var zero = function(num){
	return num < 10 ? ("0" + num) : num;
};
