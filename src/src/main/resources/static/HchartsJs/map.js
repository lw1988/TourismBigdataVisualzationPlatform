$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'userJson/getProvince',
            dataType:'json',
            success:function (data) {
                var map = new Highcharts.Map('map', {
                    title: {
                    text: '全国客源地热力图'
                    },
                    colorAxis: {
                        stops: [
                            [0, '#3060cf'],
                            [0.1, '#fffbbc'],
                            [0.2, '#c46732'],
                            [0.3, '#c4463a']
                                            ],
                        min: 0,
                        max: 100000,
                        // minColor: 'rgb(255,255,255)',
                        // maxColor: '#d94e5d'
                                },
                    series: [{
                        data: data,
                        name: '游客人数',
                        mapData: Highcharts.maps['cn/china'],
                        joinBy: 'name' // 根据 name 属性进行关联
                        }],
                credits: {
                enabled:false
        }
        });
            },
            error:function(e){
                alert(e);
            }
        });
    })
})