var api = (function () {
    var url="https://ec2-3-84-24-31.compute-1.amazonaws.com:5000"

    function load(){
        axios.get(url+"/auth/user").then(res=>{
            $("#user").text(res.data);
        })

        axios.get(url+"/auth/servicio").then(res=>{
            console.log(res.data);
            $("#service").text(res.data);
        })

    }
    function login(){
        var user={email:document.getElementById("email").value,password:document.getElementById("password").value}
        axios.post(url+"/login",user).then(res=>{
            if(res.data!=""){
                alert(res.data)
            }
            else {
                window.location.href="auth/index.html";
            }

        })
    }



    return {
        load:load,
        login:login
    };
})();