if($(window).width() > 991) {
    var total = window.innerHeight;
    document.getElementById("title").style.height = total * 0.1 + "px";
    document.getElementById("main").style.height = total * 0.95 + "px"
    main = document.getElementById("main");

    box02 = document.getElementById("box02");;
    title = document.getElementById("title");
    box03 = document.getElementById("box03");
    title_h = title.offsetHeight;
    main_h = main.offsetHeight;

    box02_h = box02.offsetHeight;
    box03_h = box03.offsetHeight;
    document.getElementById("box01").style.height = main_h * 0.65 + "px";
   // document.getElementById("box8-box").style.height = main_h * 0.3 + "px";
    box02.style.height = main_h * 0.62 + "px";
    // document.getElementById("box9-box").style.height = main_h * 0.3 + "px";
    box03.style.height = main_h * 0.475 + "px";
    box01 = document.getElementById("box01");
    box01_h = box01.offsetHeight;
    document.getElementById("total-mn1").style.height = box01_h * 0.02 + "px";
    //document.getElementById("ym-menu").style.height = box03_h * 0.1 + "px";
};
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http({
        method: 'get',
        url: 'data/da.json'
    }).then(function(res) {
        /*$scope.listHead = res.data.listHead; //数据列表-头
        $scope.listContent = res.data.listContent; //数据列表
        $scope.listData1 = res.data.listData1; //数据列表*/


        //  本省游客/千人
        var worldMapContainer2 = document.getElementById('box2');
        var box01 = document.getElementById("box01");
        var box01_h = box01.offsetHeight;
        var box01_w = box01.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        var resizeWorldMapContainer2 = function() {
            worldMapContainer2.style.width = box01_w * 0.96 + 'px';
            worldMapContainer2.style.height = box01_h * 0.38 + 'px';
        };
        //设置容器高宽
        resizeWorldMapContainer2();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer2);
        var titleList5 = ["南宁", "桂林", "柳州", "百色", "钦州", "玉林", "北海", "贵港"];
        var legendList5 = ["团队", "散客"];
        var dataList5 = [["33.0", "9.9", "7.0", "13.2", "25.6", "16.7", "15.6", "6.8"],["12.6", "5.9", "9.0", "6.4", "8.7", "7.7", "5.6", "3.3"]];
        var option = {

            olor: ['#38b5f4', '#ff7d4e'],
            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: res.data.legendList5,
                textStyle: {
                    color: '#ccc'
                }
            },
            grid: {
                top: '15%',
                left: '3%',
                right: '3%',
                bottom: '6%',
                containLabel: true
            },
            calculable: true,
            textStyle: {
                color: '#ccc'
            },
            xAxis: [{
                type: 'category',
                data: res.data.titleList5,
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#fff', fontSize:'12'
                    },
                    interval: 0,
                }
            }],
            yAxis: [{
                type: 'value'
            }],
            series: function() {
                var serie = [];
                for(var i = 0; i < res.data.legendList5.length; i++) {
                    var item = {
                        name: res.data.legendList5[i],
                        type: 'bar',
                        data: res.data.dataList5[i]
                    };
                    markPoint : {
                        serie.push(item);
                    }
                }

                return serie;
            }()

        };
        myChart.setOption(option);


        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer2();
            myChart.resize();
        };
        $(function () {
            $(document).ready(function () {
                        var worldMapContainer4 = document.getElementById('box4');
                        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
                        var resizeWorldMapContainer4 = function() {
                            worldMapContainer4.style.width = box01_w * 0.96 + 'px';
                            worldMapContainer4.style.height = box01_h * 0.45 + 'px';
                        };
                        //设置容器高宽
                        resizeWorldMapContainer4();
                        // 基于准备好的dom，初始化echarts实例
                        var myChart = echarts.init(worldMapContainer4);
                        var option = {
                                title : {
                                    text: '游客职业占比',
                                    x:'center',
                                    textStyle: {
                                        fontWeight:'normal',              //标题颜色' +
                                         color:'#83c7e3'
                                    }
                                },

                                tooltip : {
                                    trigger: 'item',
                                    formatter: "{b} : {c} ({d}%)"
                                },
                                legend: {
                                    show:false,
                                    orient: 'vertical',
                                    left: 'left',
                                    data: ['医生','学生','职员','教师','程序员','其他']
                                },
                                series : [
                                    {
                                        type: 'pie',
                                        radius : '55%',
                                        center: ['50%', '60%'],
                                        data:[
                                            {value:450, name:'医生'},
                                            {value:266, name:'学生'},
                                            {value:128, name:'职员'},
                                            {value:62, name:'教师'},
                                            {value:7, name:'其他'}
                                        ],
                                        itemStyle: {
                                            emphasis: {
                                                shadowBlur: 10,
                                                shadowOffsetX: 0,
                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                            }
                                        }
                                    }
                                ]
                            };
                        myChart.setOption(option);
            })
        })
        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer4();
            myChart.resize();
        };
        //	景区天气状况
     //   var worldMapContainer8 = document.getElementById('box8');
       // box8_box = document.getElementById("box8-box");
       // box8_box_h = box8_box.offsetHeight;
       // box8_box_w = box8_box.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        /*var resizeWorldMapContainer8 = function() {
            worldMapContainer8.style.width = box8_box_w * 0.96 + 'px';
            worldMapContainer8.style.height = box8_box_h * 0.87 + 'px';
        };*/
        //设置容器高宽
       // resizeWorldMapContainer8();
        // 基于准备好的dom，初始化echarts实例
       // var myChart = echarts.init(worldMapContainer8);
        // 指定图表的配置项和数据
        /*var colors = ['#5793f3', '#d14a61', '#675bba'];
        option = {
            color: colors,
            grid:{
                x:35,
                y:55,
                x2:30,
                y2:30,
                borderWidth:1
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },

            legend: {
                data:['湿度','光照','平均温度'],
                textStyle: {
                    color: '#ffffff'
                }
            },
            xAxis: [
                {
                    axisLine:{
                        lineStyle:{
                            color:'#FFF',
                        }},
                    type: 'category',
                    data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    axisPointer: {
                        type: 'shadow'
                    },
                    axisLabel: {
                        show: true,
                        interval: 0,
                    }
                }
            ],
            yAxis: [
                {
                    axisLine:{
                        lineStyle:{
                            color:'#FFF',
                        }},
                    type: 'value',
                    name: '光照/千LUX',
                    min: 0,
                    max: 350,
                    interval: 70,
                    axisLabel: {
                        formatter: '{value}'
                    }
                },
                {
                    axisLine:{
                        lineStyle:{
                            color:'#FFF',
                        }},
                    type: 'value',
                    name: '温度/°C',
                    min: 5,
                    max: 30,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value}'
                    }
                }
            ],
            series: [
                {
                    name:'湿度',
                    type:'bar',
                    data:[20, 39, 40, 52, 56, 66.7, 75.6, 82.2, 32.6, 20.0, 30, 35]
                },
                {
                    name:'光照',
                    type:'bar',
                    data:[56, 70, 90, 204, 227, 267, 300, 182.2, 87, 88, 75, 45]
                },
                {
                    name:'平均温度',
                    type:'line',
                    yAxisIndex: 1,
                    data:[14.2, 16.5, 18.0, 23.5, 26.3, 27.0, 29.2, 29.0, 26.0, 24.5, 19.4, 15.1]
                }
            ]
        };*/


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
         //   resizeWorldMapContainer8();
            myChart.resize();
        };
        //	游客情况
        var worldMapContainer = document.getElementById('box3');
        box03 = document.getElementById("box03");
        box03_h = box03.offsetHeight;
        box03_w = box04.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        var resizeWorldMapContainer = function() {
            worldMapContainer.style.width = box03_w * 1 + 'px';
            worldMapContainer.style.height = box03_h * 0.7 + 'px';
        };
        //设置容器高宽
        resizeWorldMapContainer();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer);

        // 指定图表的配置项和数据
        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            grid: {
                height: '40%',
                y: '5%',
                x: '14%'
            },
            legend: {
                x: 'center',
                y: 'bottom',
                textStyle: {
                    color: '#ccc'
                },
                data: ["男性","女性","00后","90后","80后","70后","60后","其他"]
            },
            series: [{
                color: ['#7627cb', '#2551bb', '#e26021', '#c7353a', '#f5b91e','#da70d6'],
                name: '年龄结构',
                type: 'pie',
                selectedMode: 'single',
                radius: '40%',
                center: ['50%', '40%'],

                label: {
                    normal: {
                        position: 'inner'
                    }
                },
                labelLine: {
                    normal: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        label: {
                            textStyle: {
                                fontSize: 12,

                            }
                        }
                    }
                },
                data: function() {
                    var serie = [];
                    for(var i = 0; i < res.data.titleList4.length; i++) {
                        var item = {
                            name: res.data.titleList4[i],
                            value: res.data.dataList4[i]
                        };
                        serie.push(item);
                    }
                    return serie;
                }()

            },
                {
                    name: '男女比例',
                    type: 'pie',
                    center: ['50%', '40%'],
                    radius: ['50%', '65%'],
                    color: ['#259fd2','#ffc0cb'],
                    data: function() {
                        var serie = [];
                        for(var i = 0; i < res.data.titleList3.length; i++) {
                            var item = {
                                name: res.data.titleList3[i],
                                value: res.data.dataList3[i]
                            };
                            serie.push(item);
                        }
                        return serie;
                    }()

                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer();
            myChart.resize();
        };
        //	购票方式
        var worldMapContainer = document.getElementById('boxes3');
        box03 = document.getElementById("box03");
        box03_h = box03.offsetHeight;
        box03_w = box04.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        var resizeWorldMapContainer = function() {
            worldMapContainer.style.width = box03_w * 1.0 + 'px';
            worldMapContainer.style.height = box03_h * 0.7 + 'px';
        };
        //设置容器高宽
        resizeWorldMapContainer();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer);

        // 指定图表的配置项和数据
        var colors = ['#e26021', '#259fd2', '#f5b91e','#da70d6']
        // 指定图表的配置项和数据
        option = {

            color: colors,
            title : {
                text: '',
                subtext: '',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                x : 'center',
                y : 'bottom',
                textStyle: {
                    color: '#ccc'
                },
                data:res.data.titleList6
            },
            calculable : true,
            series : [
                {
                    name:'面积模式',
                    type:'pie',
                    radius : [20, 60],
                    center : ['50%', '40%'],
                    labelLine:{
                        normal:{
                            length:10
                        }
                    },
                    roseType : 'area',
                    label: {
                        normal: {
                            show: true,
                            formatter: '{d}%'
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    itemStyle: {
                        normal: {
                            label: {
                                textStyle: {
                                    fontSize: 14,
                                    fontWeight:'bolder'
                                }
                            }
                        }
                    },
                    data: function() {
                        var serie = [];
                        for(var i = 0; i < res.data.titleList6.length; i++) {
                            var item = {
                                name: res.data.titleList6[i],
                                value: res.data.dataList6[i]
                            };
                            serie.push(item);
                        }
                        return serie;
                    }()
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer();
            myChart.resize();
        };


        //         景区消费情况
        var worldMapContainer5 = document.getElementById('box5');
        box04 = document.getElementById("box04");
        box04_h = box04.offsetHeight;
        box04_w = box04.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        var resizeWorldMapContainer5 = function() {
            worldMapContainer5.style.width = box04_w * 0.96 + 'px';
            worldMapContainer5.style.height = box04_h * 0.96 + 'px';
        };
        //设置容器高宽
        resizeWorldMapContainer5();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer5);

        // 指定图表的配置项和数据

        var legendData = [];


        legendData.push('trend');


        function renderItem(params, api) {
            var xValue = api.value(0);
            var currentSeriesIndices = api.currentSeriesIndices();
            var barLayout = api.barLayout({
                barGap: '30%', barCategoryGap: '20%', count: currentSeriesIndices.length - 1
            });

            var points = [];
            for (var i = 0; i < currentSeriesIndices.length; i++) {
                var seriesIndex = currentSeriesIndices[i];
                if (seriesIndex !== params.seriesIndex) {
                    var point = api.coord([xValue, api.value(seriesIndex)]);
                    point[0] += barLayout[i - 1].offsetCenter;
                    point[1] -= 20;
                    points.push(point);
                }
            }
            var style = api.style({
                stroke: api.visual('color'),
                fill: null
            });

            return {
                type: 'polyline',
                shape: {
                    points: points
                },
                style: style
            };
        }




        option = ({
            title : {

                subtext: '人数'
            },
            grid:{
                x:40,
                y:70,
                x2:20,
                y2:40,
                borderWidth:1
            },
            legend: {
                data:['0-200元','200-400元',"400-600元"],
                textStyle:{//图例文字的样式
                    color:'#fff',
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff', fontSize:'12'
                        },
                        interval: 0,
                    },
                    //设置轴线的属性
                    axisLine:{
                        lineStyle:{
                            color:'#FFF',

                        }
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    //设置轴线的属性
                    axisLine:{
                        lineStyle:{
                            color:'#FFF',

                        }
                    }
                }
            ],
            series : [
                {
                    name:'0-200元',
                    type:'bar',
                    data:[388,839, 426, 533, 794, 567, 1116, 1023, 601, 1211, 1521, 1755]
                },
                {
                    name:'200-400元',
                    type:'bar',
                    data:[463, 924, 347, 487, 602, 149, 975, 879, 507, 877, 896, 1352]
                },
                {
                    name:'400-600元',
                    type:'bar',
                    data:[521, 341, 278, 337, 159, 241, 666,529 , 422, 346, 661, 771]
                }
            ]
        });




        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer5();
            myChart.resize();
        };


        //       游客来源
        var worldMapContainer1 = document.getElementById('box1');
        box02 = document.getElementById("box02");
        box02_h = box02.offsetHeight;
        box02_w = box02.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        var resizeWorldMapContainer1 = function() {
            worldMapContainer1.style.width = box02_w * 0.9 + 'px';
            worldMapContainer1.style.height = box02_h * 0.82 + 'px';
        };
        //设置容器高宽
        resizeWorldMapContainer1();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer1);
        // 指定图表的配置项和数据
        function randomData() {
            return Math.round(10000+Math.random() * 300000);
        }

        var mydata1 = [
            {name: '北京',value: '550000' },{name: '天津',value: randomData() },
            {name: '上海',value: '488000' },{name: '重庆',value: '698' },
            {name: '河北',value: randomData() },{name: '河南',value: randomData() },
            {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
            {name: '黑龙江',value: randomData() },{name: '湖南',value: '333000' },
            {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
            {name: '新疆',value: '10000'},{name: '江苏',value: randomData() },
            {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
            {name: '湖北',value: randomData() },{name: '广西',value: '688000' },
            {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
            {name: '内蒙古',value:'6500' },{name: '陕西',value: randomData() },
            {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
            {name: '贵州',value:'298000'},{name: '广东',value:'509000' },
            {name: '青海',value: randomData() },{name: '西藏',value:'15000'},
            {name: '四川',value: '360000' },{name: '宁夏',value: randomData() },
            {name: '海南',value: randomData() },{name: '台湾',value:'13300'},
            {name: '香港',value: randomData() },{name: '澳门',value: '11200'}
        ];
        var mydata2 = [
            {name: '北京',value: '680000' },{name: '天津',value: randomData() },
            {name: '上海',value: '569000' },{name: '重庆',value: '555'},
            {name: '河北',value: randomData() },{name: '河南',value: randomData() },
            {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
            {name: '黑龙江',value: randomData() },{name: '湖南',value: '298000'},
            {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
            {name: '新疆',value: '5000'},{name: '江苏',value: randomData() },
            {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
            {name: '湖北',value: randomData() },{name: '广西',value: '831000' },
            {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
            {name: '内蒙古',value: '9000' },{name: '陕西',value: randomData() },
            {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
            {name: '贵州',value: '346000' },{name: '广东',value:'530000' },
            {name: '青海',value: randomData() },{name: '西藏',value: '80000' },
            {name: '四川',value: '126000' },{name: '宁夏',value: randomData() },
            {name: '海南',value: randomData() },{name: '台湾',value: '59000' },
            {name: '香港',value: randomData() },{name: '澳门',value: '33000' }
        ];
        var mydata3 = [
            {name: '北京',value: '639000' },{name: '天津',value: randomData() },
            {name: '上海',value: '912000' },{name: '重庆',value: '398000' },
            {name: '河北',value: randomData() },{name: '河南',value: randomData() },
            {name: '云南',value: randomData() },{name: '辽宁',value: randomData() },
            {name: '黑龙江',value: randomData() },{name: '湖南',value:'50000' },
            {name: '安徽',value: randomData() },{name: '山东',value: randomData() },
            {name: '新疆',value: '39000'},{name: '江苏',value: randomData() },
            {name: '浙江',value: randomData() },{name: '江西',value: randomData() },
            {name: '湖北',value: randomData() },{name: '广西',value: '95000' },
            {name: '甘肃',value: randomData() },{name: '山西',value: randomData() },
            {name: '内蒙古',value:'55000' },{name: '陕西',value: randomData() },
            {name: '吉林',value: randomData() },{name: '福建',value: randomData() },
            {name: '贵州',value: '220000' },{name: '广东',value: '88000' },
            {name: '青海',value: randomData() },{name: '西藏',value: '52000' },
            {name: '四川',value: '260000' },{name: '宁夏',value: randomData() },
            {name: '海南',value: randomData() },{name: '台湾',value: '29000'},
            {name: '香港',value: randomData() },{name: '澳门',value: '44000' }
        ];

        var option = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                y: 'bottom',
                data: [
                    '跟团游',
                    '自驾游',
                    '其它'
                ],
                textStyle: {
                    color: '#ccc'
                }
            },
            visualMap: {
                min: 10000,
                max: 1500000,
                left: 'right',
                top: 'bottom',
                text: ['高', '低'], // 文本，默认为数值文本
                calculable: true,
                //		color: ['#26cfe4', '#f2b600', '#ec5845'],
                textStyle: {
                    color: '#fff'
                }
            },
            series: [{
                name: '跟团游',
                type: 'map',
                aspectScale: 0.75,
                zoom: 1.2,
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:mydata1

            },
                {
                    name: '自驾游',
                    type: 'map',
                    mapType: 'china',
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: mydata2

                },
                {
                    name: '其它',
                    type: 'map',
                    mapType: 'china',
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data: mydata3

                }
            ]



        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        //用于使chart自适应高度和宽度
        window.onresize = function() {
            //重置容器高宽
            resizeWorldMapContainer1();
            myChart.resize();
        };

        //     游客实时统计
        // var worldMapContainer5 = document.getElementById('box6');
        box04 = document.getElementById("box04");
        box04_h = box04.offsetHeight;
        box04_w = box04.offsetWidth;
        //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        // var resizeWorldMapContainer5 = function() {
        //     worldMapContainer5.style.width = box04_w * 2.0 + 'px';
        //     worldMapContainer5.style.height = box04_h * 0.65 + 'px';
        // };
        //设置容器高宽
        // resizeWorldMapContainer5();
        // 基于准备好的dom，初始化echarts实例
        // var myChart = echarts.init(worldMapContainer5);
        // 指定图表的配置项和数据
        // option = {
        //     title : {
        //         text: '',
        //         subtext: ''
        //     },
        //     grid:{
        //         x:40,
        //         y:20,
        //         x2:20,
        //         y2:70,
        //         borderWidth:1
        //     },
        //
        //     tooltip : {
        //         trigger: 'axis'
        //     },
        //     legend: {
        //         data:['客流量']
        //     },
        //     toolbox: {
        //         show : true,
        //         feature : {
        //             mark : {show: true},
        //             dataView : {show: true, readOnly: false},
        //             // magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
        //             restore : {show: true},
        //             saveAsImage : {show: true}
        //         }
        //     },
        //     calculable : true,
        //     xAxis : [
        //         {	axisLine:{
        //                 lineStyle:{
        //                     color:'#FFF',
        //                 }},
        //             type : 'category',
        //             boundaryGap : false,
        //             data: (function () {
        //                 // 加载10项时间数据，每项相隔20秒
        //                 var now = new Date();
        //                 var res = [];
        //                 var len = 5;
        //                 while (len--) {
        //                     // 格式化时间
        //                     res.unshift(now.toLocaleTimeString('chinese', { hour12: false }).replace(/^\D*/, ''));
        //                     now = new Date(now - 60*60*1000);
        //                 }
        //                 return res;
        //             })()
        //         }
        //     ],
        //     yAxis : [
        //         {	axisLine:{
        //                 lineStyle:{
        //                     color:'#FFF',
        //                 }},
        //             type : 'value',
        //             scale: true
        //         }
        //     ],
        //     series : [
        //         {
        //             name:'客流量',
        //             type:'line',
        //             smooth:true,
        //             itemStyle: {normal: {areaStyle: {type: 'default'}}},
        //             data:[]
        //         }
        //     ]
        // };
        // myChart.setOption(option);
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
                    myChart.setOption({        //加载数据图表
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


    });
});