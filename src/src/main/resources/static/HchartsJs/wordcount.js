$(function () {
    $(document).ready(function () {
    var text = '需求图谱';
    var lines = text.split(/[,\. ]+/g),
        data = Highcharts.reduce(lines, function (arr, word) {
            var obj = Highcharts.find(arr, function (obj) {
                return obj.name === word;
            });
            if (obj) {
                obj.weight += 1;
            } else {
                obj = {
                    name: word,
                    weight: 1
                };
                arr.push(obj);
            }
            return arr;
        }, []);
    /* alert(JSON.stringify(data)); */
    data=[{"name":"西湖","weight":13},{"name":"雷峰塔","weight":8},{"name":"浙江大学","weight":9},{"name":"灵隐寺","weight":6},{"name":"飞来峰","weight":3},{"name":"青芝坞","weight":4},{"name":"西溪国家湿地公园","weight":5},{"name":"曲院风荷","weight":3},{"name":"断桥残雪","weight":7},{"name":"白堤","weight":5},{"name":"孤山","weight":5},{"name":"钱塘江大桥","weight":10}]
    Highcharts.chart('wordcount', {
        title: {
            text: null
        },
        credits: {
            enabled:false
        },
        series: [{
            type: 'wordcloud',
            data: data,
            name: 'Occurrences'
        }]
    });

    })
})
