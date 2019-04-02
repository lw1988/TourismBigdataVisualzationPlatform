function randomData() {
    return Math.round(Math.random()*5000);
}

var optionMap = {
    title: {
        text: '',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },

    //左侧小导航图标
    visualMap: {
        show : true,
        x: 'left',
        y: 'center',
        splitList: [
            {start: 70000, end: 100000},{start: 50000, end: 70000},
            {start: 40000, end: 50000},{start: 30000, end: 40000},
            {start: 20000, end: 30000},{start: 0, end: 20000},
        ],
        color: ['red', '#9feaa5', '#85daef','#74e2ca', '#e6ac53', '#9fb5ea'],
        textStyle: {
            color: 'white'       // 图例文字颜色
        }
    },

    //配置属性
    series: [{
        name: '数据',
        type: 'map',
        mapType: '广西',
        roam: true,
        label: {
            normal: {
                show: true,  //省份名称
                textStyle: {
                    fontSize: 15,
                    // fontWeight: 'bold',
                    color: 'white'
                }
            },
            emphasis: {
                show: false
            }
        },
        data:[{"name":"南宁市","value":98201},{"name":"柳州市","value":50021},{"name":"桂林市","value":51102},{"name":"梧州市","value":42000},
            {"name":"北海市","value":9998},{"name":"防城港市","value":12003},{"name":"钦州市","value":45000},{"name":"贵港市","value":38952},
            {"name":"玉林市","value":49852},{"name":"百色市","value":40024},{"name":"贺州市","value":28547},{"name":"河池市","value":42154},
            {"name":"来宾市","value":35471},{"name":"崇左市","value":29532}] //数据
    }]
};

//初始化echarts实例
var myChart = echarts.init(document.getElementById('guangximap'));

//使用制定的配置项和数据显示图表
myChart.setOption(optionMap);