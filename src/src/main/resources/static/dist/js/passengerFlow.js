//游客实时统计
var worldMapContainer5 = document.getElementById('passengerFlow');
box04 = document.getElementById("box04");
box04_h = box04.offsetHeight;
box04_w = box04.offsetWidth;
//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
var resizeWorldMapContainer5 = function() {
    worldMapContainer5.style.width = box04_w * 2.0 + 'px';
    worldMapContainer5.style.height = box04_h * 0.65 + 'px';
};
//设置容器高宽
resizeWorldMapContainer5();
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(worldMapContainer5);
// 指定图表的配置项和数据
option = {
    title : {
        text: '',
        subtext: ''
    },
    grid:{
        x:40,
        y:20,
        x2:20,
        y2:70,
        borderWidth:1
    },

    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['客流量'],
        textStyle: {
            color: '#fffdfe'
        }
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {	axisLine:{
                lineStyle:{
                    color:'#FFF',
                }},
            type : 'category',
            boundaryGap : false,
            data: (function () {
                // 加载10项时间数据，每项相隔20秒
                var now = new Date();
                var res = [];
                var len = 5;
                while (len--) {
                    // 格式化时间
                    res.unshift(now.toLocaleTimeString('chinese', { hour12: false }).replace(/^\D*/, ''));
                    now = new Date(now - 60*60*1000);
                }
                return res;
            })()
        }
    ],
    yAxis : [
        {	axisLine:{
                lineStyle:{
                    color:'#FFF',
                }},
            type : 'value',
            scale: true
        }
    ],
    series : [
        {
            name:'客流量',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[]
        }
    ]
};
myChart.setOption(option);
$.ajax({
    type:'GET',
    url:'getTouristsData/getFirstData',
    dateType:'json',
    success:function (data) {
        myChart.setOption({        //加载数据图表
            series: [{
                data: data
            }]
        });
    }
});
// 定时生成新数据
setInterval(function () {
    var data = 100;
    var date = new Date();
    var m = date.getMonth()+1;
    var d = date.getDate();
    if(m==10){
        if(d==1||2||3||4||5||6||7){
            data = data*10;
        }
    }
    // 格式化时间
    var axisData = (new Date()).toLocaleTimeString().replace(/^\D*/, '');
    $.ajax({
        type:'GET',
        url:'getTouristsData/getFirstData',
        dateType:'json',
        success:function (data) {
            myChart.setOption({        //加载数据图表we
                series: [{
                    data: data
                }]
            });
        }
    });
    option.xAxis[0].data.shift();
    option.xAxis[0].data.push(axisData);
    // 应用配置
    myChart.setOption(option);
}, 1000*60*60);

//用于使chart自适应高度和宽度
window.onresize = function() {
    //重置容器高宽
    resizeWorldMapContainer5();
    myChart.resize();
};