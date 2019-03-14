$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getSaleWay',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('SaleWay', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: ' '
                    },
                    xAxis: {
                        categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '产品总销售量'
                        },
                        stackLabels: {  // 堆叠数据标签
                            enabled: true,
                            style: {
                                fontWeight: 'bold',
                                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        align: 'right',
                        x: -30,
                        verticalAlign: 'top',
                        y: 25,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                        borderColor: '#CCC',
                        borderWidth: 1,
                        shadow: false
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>' + this.x + '</b><br/>' +
                                this.series.name + ': ' + this.y + '<br/>' +
                                '总量: ' + this.point.stackTotal;
                        }
                    },
                    plotOptions: {
                        column: {
                            stacking: 'normal',
                            dataLabels: {
                                enabled: true,
                                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                style: {
                                    // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                    textOutline: '1px 1px black'
                                }
                            }
                        }
                    },
                    series: [{
                        name: '携程',
                        data: data[0]
                    }, {
                        name: '美团',
                        data: data[1]
                    },{
                            name: '微信小程序',
                            data:data[2]
                    },{
                        name: '官网',
                        data: data[3]
                    }]
                });
            },
            error:function(e){
                // alert(e);
            }
        });
    })
})