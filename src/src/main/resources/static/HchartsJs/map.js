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
                                [0.2, '#fffbbc'],
                                [0.4, '#ffcc65'],
                                [0.6, '#c4705b'],
                                [0.8, '#c4463a']
                                            ],
                        min: 0,
                        max: 100,
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