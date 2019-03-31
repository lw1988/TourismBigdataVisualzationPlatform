var chart = Highcharts.chart('look_count', {
    chart: {
        type: 'bar'
    },
    title: {
        text: '商品浏览统计（前五）'
    },
    subtitle: {
    },
    xAxis: {
        categories: ['永福天坑景区', '夜游四湖', '三娘湾景区', '锦龙国际赛车场', '象山公园'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '人口总量 (/人)',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' 人'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    },
    series: [{
        name: '2018年10月统计情况',
        data: [1752, 1678, 1258, 1211, 1054]
    }]
});


var chart = Highcharts.chart('save_count', {
    chart: {
        type: 'bar'
    },
    title: {
        text: '商品收藏统计（前五）'
    },
    subtitle: {
    },
    xAxis: {
        categories: ['独秀峰王城', '永福天坑景区', '三娘湾景区', '夜游四湖', '象山公园'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '人口总量 (/人)',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' 人'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    },

    series: [{
        name: '2018年10月统计情况',
        data: [77, 54, 51, 48, 46]
    }]
});


var chart = Highcharts.chart('readybuy_count', {
    chart: {
        type: 'bar'
    },
    title: {
        text: '商品加购统计（前五）'
    },
    subtitle: {
    },
    xAxis: {
        categories: ['夜游四湖', '独秀峰王城', '象山公园', '永福天坑景区', '锦龙国际赛车场'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '人口总量 (/人)',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' 人'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    },

    series: [{
        name: '2018年10月统计情况',
        data: [102, 90, 85, 77, 73]
    }]
});


var chart = Highcharts.chart('buy_count', {
    chart: {
        type: 'bar'
    },
    title: {
        text: '商品购买统计（前五）'
    },
    subtitle: {
    },
    xAxis: {
        categories: ['夜游四湖', '独秀峰王城', '象山公园', '永福天坑景区', '锦龙国际赛车场'],
        title: {
            text: null
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '人口总量 (/人)',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' 人'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    },

    series: [{
        name: '2018年10月统计情况',
        data: [83, 46, 42, 34, 34]
    }]
});

var chart = Highcharts.chart('proportion_1', {
    chart: {
        type: 'area'
    },
    title: {
        text: '每月产品销售比例'
    },
    subtitle: {
        text: '各类商品每月销售的比例没有明显的变化'
    },
    xAxis: {
        categories: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月', '9月', '10月', '11月', '12月'],
        tickmarkPlacement: 'on',
        title: {
            enabled: false
        }
    },
    yAxis: {
        title: {
            text: '百分比'
        }
    },
    tooltip: {
        pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.0f} 人)<br/>',
        shared: true
    },
    plotOptions: {
        area: {
            stacking: 'percent',
            lineColor: '#ffffff',
            lineWidth: 1,
            marker: {
                lineWidth: 1,
                lineColor: '#ffffff'
            }
        }
    },
    series: [{
        name: '自然风光类',
        data: [302, 335, 309, 347, 442, 334, 368,302, 335, 309, 307, 302]
    }, {
        name: '风景名胜类',
        data: [246, 257, 281, 333, 391, 267, 266,206, 207, 211, 233, 231]
    }, {
        name: '文化古迹类',
        data: [173, 193, 176, 208, 247, 229, 228,213, 203, 176, 168, 177]
    }, {
        name: '红色旅游类',
        data: [120, 120, 140, 216, 219, 218, 201,208, 201, 174, 156, 119]
    }, {
        name: '其它',
        data: [20, 20, 20, 26, 33, 30, 36,20, 20, 20, 16, 13]
    }]
});


// Make monochrome colors and set them as default for all pies
Highcharts.getOptions().plotOptions.pie.colors = (function () {
    var colors = [],
        base = Highcharts.getOptions().colors[0],
        i;
    for (i = 0; i < 10; i += 1) {
        // Start out with a darkened base color (negative brighten), and end
        // up with a much brighter color
        colors.push(Highcharts.Color(base).brighten((i - 3) / 7).get());
    }
    return colors;
}());
// 初始化图表
var chart = Highcharts.chart('proportion_2', {
    title: {
        text: '产品类型销量占比'
    },
    subtitle: {
        text: '自然风光类景区产品的销售量最高（占46.0%），红色旅游类景区产品的销售量最低（占6.2%）'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        type: 'pie',
        name: '',
        data: [
            ['自然风光类',   46.0],
            ['风景名胜类',       26.8],
            {
                name: '文化古迹类',
                y: 12.8,
                sliced: true,
                selected: true
            },
            ['其它',    8.2],
            ['红色旅游类',     6.2]
        ]
    }]
});

