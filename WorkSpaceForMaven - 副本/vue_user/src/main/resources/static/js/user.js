var vue = new Vue({
    el:"#app",
    data:{
        userList:[],
        user:{}
    },
    methods:{
        findAll:function(){
            var _this=this; //this代表是vue对象
            console.log("hello");
            axios.get("./user/findAll").then(function (response) {
                console.log(response),
                _this.userList=response.data;
            }).catch(function (err) {
                alert("失败");
            })
        },
        // init: function(){
        //     axios.get("./data/user.json").then(function(response){
        //         // alert(response);
        //         console.log(response);
        //         alert(JSON.stringify(response))
        //         alert(response.data[0].username);
        //     })
        // },
        findOne:function (id) {
            var _this=this; //this代表是vue对象
            axios.get("./user/findOne/"+id).then(function(response){
//          this变成了window，使用_this
                _this.user = response.data.data;
            }).catch(function (err) {
                alert("修改失败");
            });
        },
        update:function () {
            var _this=this;
            axios.post("./user/update",this.user).then(function (response) {
                _this.findAll();
            }).catch(function (err) {
                alert("修改失败");
            })

        }
    },
    created:function(){
        alert("lllll");
        this.findAll();
        // this.init();
    }


});