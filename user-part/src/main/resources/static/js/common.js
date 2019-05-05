/**
 * @author yf
 * @date 2019/4/18 10:57:02
 *
 * 用户模块公用JS
 */

/**
 * 判断用户是否登录
 * @returns {boolean} (true/false):(已登录/ 未登录)
 */
function isSignin(){
    let user = layui.sessionData('userStore').user;
    return !!user;
}

/**
 * 记录当前uri，跳转到登录页面
 */
function toLogin() {
    let uri = window.location.pathname;
    layui.sessionData('urls',{
        key: 'uri'
        ,value: uri
    });
    layer.alert("您还没登录，请先登录",function () {
        window.location.href = '/login/login.html'
    });
}


/**
 * 获得登录的用户id
 * @returns {*}  userId
 */
function getUserId(){
    return layui.sessionData('userStore').user.id;
}

/**
 * 获得登录的用户名
 * @returns {Document.username|string}
 */
function getUserName() {
    return layui.sessionData('userStore').user.username;
}

/**
 * 商品搜索
 */
function searchGoods(){
    let keyWork = $('#search-input').val();
    if(!keyWork){
        layer.msg("请输入关键字");
        return false;
    }
    // 保存关键字
    layui.sessionData('goods',{
        key: "keyWord",
        value: keyWork
    });

    window.location.href = "/goods/search.html";
}

/**
 * 获得商品搜索关键字
 */
function getKeyWord(){
    return layui.sessionData('goods').keyWord;
}