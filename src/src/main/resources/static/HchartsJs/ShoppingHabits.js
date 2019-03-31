Highcharts.data({
    csv: document.getElementById('tsv').innerHTML,
    itemDelimiter: '\t',
    parsed: function (columns) {
        var brands = {},
            brandsData = [],
            versions = {},
            drilldownSeries = [];
        // 解析百分比字符串
        columns[1] = Highcharts.map(columns[1], function (value) {
            if (value.indexOf('%') === value.length - 1) {
                value = parseFloat(value);
            }
            return value;
        });
        $.each(columns[0], function (i, name) {
            var brand,
                version;
            if (i > 0) {
                // Remove special edition notes
                name = name.split(' -')[0];
                // 拆分
                version = name.match(/([0-9]+[\.0-9x]*)/);
                if (version) {
                    version = version[0];
                }
                brand = name.replace(version, '');
                //创建主数据
                if (!brands[brand]) {
                    brands[brand] = columns[1][i];
                } else {
                    brands[brand] += columns[1][i];
                }
                // 创建版本数据
                if (version !== null) {
                    if (!versions[brand]) {
                        versions[brand] = [];
                    }
                    versions[brand].push(['v' + version, columns[1][i]]);
                }
            }
        });
        $.each(brands, function (name, y) {
            brandsData.push({
                name: name,
                y: y,
                drilldown: versions[name] ? name : null
            });
        });
        $.each(versions, function (key, value) {
            drilldownSeries.push({
                name: key,
                id: key,
                data: value
            });
        });
        // 创建图例
        var chart = Highcharts.chart('ShoppingHabits',{
            chart: {
                type: 'pie'
            },
            title: {
                text: '用户购物习惯'
            },
            subtitle: {
                text: '用户的购买方式以浏览时直接购买与添加购物车后购买为主'
            },
            plotOptions: {
                series: {
                    dataLabels: {
                        enabled: true,
                        format: '{point.name}: {point.y:.1f}%'
                    }
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
            },
            series: [{
                name: '习惯',
                colorByPoint: true,
                data: brandsData,
                size: '60%',
                //innerSize: '80%'
            }],
            drilldown: {
                series: drilldownSeries
            }
        });
    }
});