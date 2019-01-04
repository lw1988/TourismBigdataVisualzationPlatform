// Give the points a 3D feel by adding a radial gradient
Highcharts.getOptions().colors = $.map(Highcharts.getOptions().colors, function (color) {
    return {
        radialGradient: {
            cx: 0.4,
            cy: 0.3,
            r: 0.5
        },
        stops: [
            [0, color],
            [1, Highcharts.Color(color).brighten(-0.2).get('rgb')]
        ]
    };
});
// Set up the chart
var chart = new Highcharts.Chart({
    chart: {
        renderTo: 'container',
        margin: 100,
        type: 'scatter',
        options3d: {
            enabled: true,
            alpha: 10,
            beta: 30,
            depth: 250,
            viewDistance: 5,
            frame: {
                bottom: { size: 1, color: 'rgba(0,0,0,0.02)' },
                back: { size: 1, color: 'rgba(0,0,0,0.04)' },
                side: { size: 1, color: 'rgba(0,0,0,0.06)' }
            }
        }
    },
    title: {
        text: 'ALS模型评估-散点图'
    },
    subtitle: {
        text: '单击并拖动鼠标可旋转绘图区'
    },
    plotOptions: {
        scatter: {
            width: 10,
            height: 10,
            depth: 10
        }
    },
    yAxis: {
        min: 0.001,
        max: 0.1,
        title: null
    },
    xAxis: {
        min: 0.05,
        max: 0.6,
        gridLineWidth: 1
    },
    zAxis: {
        min: 10,
        max: 25
    },
    legend: {
        enabled: false
    },
    series: [{
        name: '随机数据',
        colorByPoint: true,
        data: [[0.546,0.1,10],[0.491,0.1,15],[0.445,0.1,20],[0.459,0.1,25],[0.159,0.01,25],[0.068,0.01,22],[0.586,0.1,18],[0.121,0.01,18],[0.230,0.01,20],
            [0.513,0.05,10],[0.229,0.01,10],[0.415,0.03,10],[0.391,0.07,10],[0.118,0.001,10],[0.099,0.005,10],[0.238,0.007,10],[0.342,0.003,10],
            [0.130,0.005,20],[0.211,0.005,22],[0.114,0.005,15],[0.112,0.001,20],[0.234,0.01,24],[0.181,0.01,23],[0.183,0.001,22],[0.148,0.007,22]
        ]
    }]
});
// Add mouse events for rotation
$(chart.container).bind('mousedown.hc touchstart.hc', function (e) {
    e = chart.pointer.normalize(e);
    var posX = e.pageX,
        posY = e.pageY,
        alpha = chart.options.chart.options3d.alpha,
        beta = chart.options.chart.options3d.beta,
        newAlpha,
        newBeta,
        sensitivity = 5; // lower is more sensitive
    $(document).bind({
        'mousemove.hc touchdrag.hc': function (e) {
            // Run beta
            newBeta = beta + (posX - e.pageX) / sensitivity;
            newBeta = Math.min(100, Math.max(-100, newBeta));
            chart.options.chart.options3d.beta = newBeta;
            // Run alpha
            newAlpha = alpha + (e.pageY - posY) / sensitivity;
            newAlpha = Math.min(100, Math.max(-100, newAlpha));
            chart.options.chart.options3d.alpha = newAlpha;
            chart.redraw(false);
        },
        'mouseup touchend': function () {
            $(document).unbind('.hc');
        }
    });
});