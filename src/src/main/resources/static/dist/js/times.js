var slidint;
var temperature;
var light;
var humidity;
function newTimer() {
    // stopit();
    var today;
    today = new Date();
    var str = today.toLocaleDateString();
    str += "  " + week();
    str += "  " + today.toLocaleTimeString();
    //str += "  " + "温度："+'25'+"℃" + "  光照："+'330'+"LX";
    var o = document.getElementById("DateTime");
    o.innerHTML = str;
   // o.innerHTML = str+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+'<a href="video1"><img src= "images/camera2.jpg" height="30" width="40"></a>';
    // slidint = setTimeout(newTimer, 1000);
}

function stopit() {
    clearTimeout(slidint);
}

function week() {
    var d, day, x, s = " ";
    var x = new Array("星期日", "星期一", "星期二");
    var x = x.concat("星期三", "星期四", "星期五");
    var x = x.concat("星期六");
    d = new Date();
    day = d.getDay();
    return (s += x[day]);
}

window.onload = function() {
    newTimer();
    newTimer1();
}
function newTimer1(){
    $.post('getUbibotData/getDataByMinutes', function(data) {
        temperature = data["温度"];
        light = data["光照"];
        humidity=data["湿度"];
    });
}