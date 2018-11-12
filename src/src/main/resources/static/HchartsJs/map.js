$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type:"GET",
            url:'userJson/getProvince',
            dataType:'json',
            success:function (data) {
                var dafaultMenuItem = Highcharts.getOptions().exporting.buttons.contextButton.menuItems;
                var map = new Highcharts.Map('map', {
                    title: {
                        text: '全国客源地热力图'
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
                                            window.location.href= '/exportProvince';
                                        }
                                    },

                                ]
                            }
                        }
                    },
                    colorAxis: {
                        stops: [
                            [0, '#3060cf'],
                            [0.1, '#fffbbc'],
                            [0.3, '#c46732'],
                            [0.5, '#c4463a']
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
                    navigation: {
                        buttonOptions: {
                            align: 'right'
                        }
                    },
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