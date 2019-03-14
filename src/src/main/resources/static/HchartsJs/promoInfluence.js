$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getPromoSale_Cus',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('promoInfluence',{
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '促销对每月的日平均销量与客流量影响'
                    },
                    subtitle: {
                        text: '2018年代理销售及客流数据'
                    },
                    xAxis: {
                        categories: [
                            '一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'
                        ],
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '频率 '
                        }
                    },
                    tooltip: {
                        // head + 每个 point + footer 拼接成完整的 table
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            borderWidth: 0
                        }
                    },
                    series: [{
                        name: '促销活动日均客流',
                        data: data[0]
                    }, {
                        name: '无活动日均客流',
                        data: data[1]
                    }, {
                        name: '促销活动日均销量',
                        data: data[2]
                    }, {
                        name: '无活动日均销量',
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