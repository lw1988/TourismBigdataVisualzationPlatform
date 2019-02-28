$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'/products/getSale',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var chart = Highcharts.chart('monthlyVisits', {
                    chart: {
                        type: 'line'
                    },
                    title: {
                        // text: '每月访问量'
                    },
                    exporting: {
                        buttons: {
                            contextButton: {
                                // 自定义导出菜单项目及顺序
                                menuItems: [
                                    dafaultMenuItem[0],
                                    dafaultMenuItem[1],
                                    dafaultMenuItem[3],
                                    dafaultMenuItem[5],
                                    {
                                        text: '下载 PDF 文件',
                                        onclick: function() {
                                            this.exportChart({
                                                type: 'application/pdf'
                                            });
                                        }
                                    },
                                    {
                                        text: '导出excel',
                                        onclick: function() {
                                            window.location.href= '/exportAccessRecord';
                                        }
                                    },

                                ]
                            }
                        }
                    },
                    subtitle: {
                        // text: '数据来源: gxu.edu.cn'
                    },
                    xAxis: {
                        categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
                    },
                    yAxis: {
                        title: {
                            text: '访问人数 (千人)'
                        },
                        plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                    },
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom',
                        // borderWidth: 0
                    },
                    plotOptions: {
                        series: {
                            allowPointSelect: true,
                            // color:'red',
                            // lineWidth:4,
                        }
                    },
                    tooltip: {
                        xDateFormat: '%Y-%m-%d',
                        shared: true,
                        valuePrefix: '',
                        valueSuffix: ' 千人次',
                        // useHTML: true,
                        // headerFormat: '<small>{point.key}</small><table>',
                        // pointFormat: '<tr><td style="color: {series.color}">{series.name}: </td>' +
                        // '<td style="text-align: right"><b>{point.y} 千人次</b></td></tr>',
                        // footerFormat: '</table>',
                        style: {                      // 文字内容相关样式
                            // color: "#ff0000",
                            fontSize: "15px",
                            fontWeight: "blod",
                            fontFamily: "Courir new"
                        }
                    },
                    series: [
                        {
                            name: '2018年',
                            data: data[2]
                        },
                        {
                            name: '2017年',
                            data: data[1]
                        },
                        {
                            name: '2016年',
                            data: data[0]
                        }
                    ],
                    credits: {
                        enabled:false
                    }
                });
            },
            error:function(e){
                // alert(e);
            }
        });
    })
})