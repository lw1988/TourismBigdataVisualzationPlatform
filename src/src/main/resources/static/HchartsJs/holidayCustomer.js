$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getHolidayCustomers',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('holidayCustomer', {
                    chart: {
                        type: 'scatter',
                        zoomType: 'xy'
                    },
                    title: {
                        text: ' '
                    },
                    subtitle: {
                        text: '2018年数据'
                    },
                    xAxis: {
                        title: {
                            enabled: true,
                            text: '代理商ID'
                        },
                        startOnTick: true,
                        endOnTick: true,
                        showLastLabel: true
                    },
                    yAxis: {
                        title: {
                            text: '平均日销量'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'left',
                        verticalAlign: 'top',
                        x: 70,
                        y: 70,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
                        borderWidth: 1
                    },
                    plotOptions: {
                        scatter: {
                            marker: {
                                radius: 5,
                                states: {
                                    hover: {
                                        enabled: true,
                                        lineColor: 'rgb(100,100,100)'
                                    }
                                }
                            },
                            states: {
                                hover: {
                                    marker: {
                                        enabled: false
                                    }
                                }
                            },
                            tooltip: {
                                headerFormat: '<b>{series.name}</b><br>',
                                pointFormat: '{point.x} ID, {point.y} 件'
                            }
                        }
                    },
                    series: [{
                        name: '节假日',
                        color: 'rgba(223, 83, 83, .5)',
                        data: data[0]
                    }, {
                        name: '非节假日',
                        color: 'rgba(119, 152, 191, .5)',
                        data: data[1]
                    }]
                });
            },
            error:function(e){
                // alert(e);
            }
        });
    })
})