$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getPromoSale_Cus',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('sold_price', {
                    chart: {
                        type: 'bubble',
                        plotBorderWidth: 1,
                        zoomType: 'xy'
                    },
                    legend: {
                        enabled: false
                    },
                    title: {
                        text: '18年月平均售价对销量的影响'
                    },
                    subtitle: {
                        text: '圆圈面积表示销量，可以看到3月份价格最低时，此时售量越高'
                    },
                    xAxis: {
                        gridLineWidth: 1,
                        title: {
                            text: ''
                        },
                        categories: [
                            '一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'
                        ],
                        crosshair: true
                    },
                    yAxis: {
                        startOnTick: false,
                        endOnTick: false,
                        title: {
                            text: '价格'
                        },
                        labels: {
                            format: '{value}'
                        },
                        maxPadding: 0.2,
                    },
                    tooltip: {
                        useHTML: true,
                        headerFormat: '<table>',
                        pointFormat:
                            '<tr><th>销售量:</th><td>{point.z}</td></tr>' +
                            '<tr><th>价格:</th><td>{point.y}</td></tr>' ,
                        footerFormat: '</table>',
                        followPointer: true
                    },
                    plotOptions: {
                        series: {
                            dataLabels: {
                                enabled: true,
                                format: '{point.name}'
                            }
                        }
                    },
                    series: [{
                        data: [
                            {  z: 2195, y: 195 },
                            {  z: 3102.9, y: 186.5 },
                            {  z: 3191.5, y: 180.8},
                            { z: 2102.5, y: 280.4},
                            { z: 2321.1, y: 280.3 },
                            { z: 2170.1, y:178.4},
                            {  z: 2102.9, y: 186.5 },
                            {  z: 2391.5, y: 182.8},
                            { z: 2202.5, y: 180.4},
                            { z: 1721.1, y: 270.3 },
                            { z: 2170.1, y:198.4},
                            { z: 2070.1, y:178.4}
                        ]
                    }]
                });
            },
            error:function(e){
                // alert(e);
            }
        });
    })
})