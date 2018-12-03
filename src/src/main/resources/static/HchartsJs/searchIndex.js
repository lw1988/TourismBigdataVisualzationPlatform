$.getJSON('/Json/aap.json', function (data) {

        // Create the chart
        Highcharts.stockChart('searchIndex', {


            rangeSelector: {
                selected: 4
            },

            title : {
                text : '搜索指数'
            },
            credits: {
                enabled:false
            },

            series: [{
                name: '搜索指数',
                data: data,
                type: 'areaspline',
                threshold: null,
                tooltip: {
                    valueDecimals: 2
                },
                fillColor: {
                    linearGradient: {
                        x1: 0,
                        y1: 0,
                        x2: 0,
                        y2: 1
                    },
                    stops: [
                        [0, Highcharts.getOptions().colors[0]],
                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                    ]
                }
            }]
        });
    });