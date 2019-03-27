var chart = new Highcharts.Chart({
    chart: {
        renderTo: 'PassengerListAnalysis',
        type: 'column',
        options3d: {
            enabled: true,
            alpha: 15,
            beta: 15,
            depth: 50,
            viewDistance: 25
        }
    },
    title: {
        text: '客单分析'
    },
    subtitle: {
        text: '数据截止 2017-03'
    },
    plotOptions: {
        column: {
            depth: 25
        }
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45  // 设置轴标签旋转角度
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '客单数 (千)'
        }
    },
    /*legend: {
        enabled: false
    },*/
    tooltip: {
        pointFormat: '客单量: <b>{point.y:.1f} 千</b>'
    },
    series: [{
        name: '总客单',
        data: [
            ['12-01', 13.4],
            ['12-02', 12.50],
            ['12-03', 11.51],
            ['12-04', 10.78],
            ['12-05', 9.06],
            ['12-06', 6.20],
            ['12-07', 4.16],
            ['12-08', 2.51],
            ['12-09', 1.08],
            ['12-10', 0.44],
        ]
        /*dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // :.1f 为保留 1 位小数
            y: 10
        }*/
    }]
});
// 将当前角度信息同步到 DOM 中
var alphaValue = document.getElementById('alpha-value'),
    betaValue = document.getElementById('beta-value'),
    depthValue = document.getElementById('depth-value');
function showValues() {
    alphaValue.innerHTML = chart.options.chart.options3d.alpha;
    betaValue.innerHTML = chart.options.chart.options3d.beta;
    depthValue.innerHTML = chart.options.chart.options3d.depth;
}
// 监听 sliders 的变化并更新图表
$('#sliders input').on('input change', function () {
    chart.options.chart.options3d[this.id] = this.value;
    showValues();
    chart.redraw(false);
});
showValues();