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
    data=[{"name":"两江西湖","weight":13},{"name":"漓江","weight":8},{"name":"日月塔","weight":9},{"name":"象山景区","weight":6},{"name":"银子岩","weight":3},{"name":"芦笛岩","weight":4},{"name":"世外桃源","weight":5},{"name":"龙脊梯田","weight":3},{"name":"十里画廊","weight":7},{"name":"叠彩山","weight":5},{"name":"月亮山","weight":5},{"name":"九马画山","weight":10}]
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
