var chart = null;
$.getJSON('HchartsJs/data/range.json', function (data) {
    chart = Highcharts.chart('TimeUsed', {
        chart: {
            type: 'arearange',
            zoomType: 'x' // 水平缩放
        },
        title: {
            text: '用户使用时间段'
        },
        xAxis: {
            type: 'datetime',
            crosshair: true // 启用 x 轴准星线
        },
        yAxis: {
            title: {
                text: null
            }
        },
        tooltip: {
            shared: true,
            valueSuffix: 'min'
        },
        legend: {
            enabled: false // 关闭图例
        },
        series: [{
            name: '时间',
            data: data
        }]
    });
});