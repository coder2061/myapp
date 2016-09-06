
/**
 * 特殊字符检测
 * @param str
 * @returns {Boolean}
 */
function IsSpecialChar(str){
    var reg_exp = /^[^`#+=?|\\\'"%;<>]{1,}$/;
    if (reg_exp.test(str)) {
        return false;
    } else {
        return true;
    }
}

/**
 * 前进
 */
function back(){
    history.go(-1);
}
/**
 * 后退
 */
function forward(){
    history.go(1);
}
/**
 * 刷新
 */
function refresh(){
    history.go(0);
}




