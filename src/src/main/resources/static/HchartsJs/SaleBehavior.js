$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getPromoSale_Cus',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('SaleBehavior', {
                    chart: {
                        zoomType: 'xy'
                    },plotOptions :{
                        column: {
                            dataLabels: {
                                enabled: true //设置显示对应y的值
                            }
                        }
                    },
                    title: {
                        text: '销售波动情况'
                    },subtitle: {
                        text: '销售下降最快为11月27日（5.63%），上升最快为12月2日（27.7%），11月25日~ 12月1日的销售环比增长率波动范围为-5.63%~3.43%'
                    },
                    xAxis: [{
                        categories: ['11月25日','11月26日',  '11月27日', '11月28日', '11月29日', '11月30日', '12月1日', '12月2日', '12月3日']
                    }],
                    yAxis: [{ // Primary yAxis
                        labels: {
                            format: '{value} %',
                            style: {
                                color: Highcharts.getOptions().colors[1]
                            }
                        },
                        title: {
                            text: '环比增长率',
                            style: {
                                color: Highcharts.getOptions().colors[1]
                            }
                        }
                    }, { // Secondary yAxis
                        title: {
                            text: '销售数量',
                            style: {
                                color: Highcharts.getOptions().colors[0]
                            }
                        },
                        labels: {
                            format: '{value} 百万',
                            style: {
                                color: Highcharts.getOptions().colors[0]
                            }
                        },
                        opposite: true
                    }],
                    tooltip: {
                        shared: true
                    },
                    series: [{
                        name: '销售数量',
                        type: 'column',
                        yAxis: 1,
                        data: [0.61, 0.68, 0.59, 0.58, 0.60, 0.62, 0.67,0.81,0.80],
                        tooltip: {
                            pointFormat: '<span style="font-weight: bold; color: {series.color}">{series.name}</span>: <b>{point.y:.1f} mm</b> '
                        }
                    }, {
                        name: '环比增长率',
                        type: 'spline',
                        data: [0.0, 2.67,1.49, 2.41, 3.43, 2.25, 3.60, 7.7, 1.26],
                        tooltip: {
                            pointFormat: '<span style="font-weight: bold; color: {series.color}">{series.name}</span>: <b>{point.y:.1f}°C</b> '
                        }
                    }]
                });
            },
            error:function(e){
                // alert(e);
            }
        });
    })
})