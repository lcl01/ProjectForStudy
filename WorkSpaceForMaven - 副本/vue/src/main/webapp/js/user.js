var app = new Vue({
    el:"#app",
    data:{
        list:[],
        user:[],//初始化空值
    },
    methods:{
        findAll:function () {
            axios.get('user/findAll').then(
                function (response) {// {data:{}}
                    app.list=response.data;
                }).catch(function (error) {

            })
        },
        //方法 在点击编辑的时候调用 根据ID 查询用户的数据 返回一个JSON 赋值给变量user
        findOne:function (id) {
            axios.get('user/findOne?id='+id).then(
                function (response) {// {data:{}}
                    app.user=response.data;//{id,name}
                }
            )
        },
        //当点击修改的时候调用  发请求 将表单的对象绑定的user传递过去
        update:function () {
            axios.post('user/update',this.user).then(
                function (response) {//int
                    if(response .data>0){
                        //刷新页面
                        app.findAll();
                    }else{
                        alert("你错了");
                    }
                }
            )
        }
    },
    //钩子函数
    created:function () {
        //发送请求 获取List<User>:[{},{}]  将其赋值给变量,页面绑定变量 循环遍历即可
        this.findAll();
    }

});