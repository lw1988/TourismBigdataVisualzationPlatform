var data = [{"name":"南宁","value":95},{"name":"柳州","value":2},{"name":"桂林","value":76},{"name":"梧州","value":45},{"name":"北海","value":83},{"name":"防城港","value":63},{"name":"钦州","value":58},{"name":"贵港","value":53},{"name":"玉林","value":78},{"name":"百色","value":83},{"name":"贺州","value":28},{"name":"河池","value":73},{"name":"来宾","value":61},{"name":"崇左","value":52}];
// 初始化图表
var map = new Highcharts.Map('guangximap', {
    title: {
        text: '广西客源地热力图'
    },
    colorAxis: {
        min: 0,
        minColor: 'rgb(255,255,255)',
        maxColor: '#006cee'
    },
    series: [{
        data: data,
        name: '游客人数/万人',
        mapData: Highcharts.maps['cn/guangxi'],
        joinBy: 'name' // 根据 name 属性进行关联
    }]
});

var map = new Highcharts.Map('guangxitourmap', {
    title: {
        text: ''
    },
    colorAxis: {
        min: 0,
        minColor: 'rgb(255,255,255)',
        maxColor: '#006cee'
    },
    series: [{
        data: data,
        name: '游客人数/万人',
        mapData: Highcharts.maps['cn/guangxi'],
        joinBy: 'name' // 根据 name 属性进行关联
    }]
});