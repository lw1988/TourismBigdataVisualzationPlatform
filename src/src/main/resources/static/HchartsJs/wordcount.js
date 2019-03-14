$(function () {
    $(document).ready(function () {
        //异步请求数据
        $.ajax({
            type: "POST",
            url: 'tourismIndexSearch',
            contentType: "application/json",
            dataType: 'json',
            data:{
                title:$("#title").val()
            },
            traditional:true,
            success: function (data) {
                Highcharts.chart('wordcount', {
                    title: {
                        text: ''
                    },
                    credits: {
                        enabled: false
                    },
                    series: [{
                        type: 'wordcloud',
                        data: data,
                        name: 'Occurrences'
                    }]
                });
            },
            error: function (e) {
                // alert(e);
            }
        });
    })
})
$(function () {
$("#startSearch").click(function () {
    var title=$("#title").val();
    if(title==''){
        alert("请输入关键词");
        return false;
    }
    //异步请求数据
    $.ajax({
        type:"POST",
        url:'tourismIndexSearch',
        data:{
            title:title
        },
        contentType: "application/json",
        dataType:'json',
        traditional:true,
        success:function (data) {
            Highcharts.chart('wordcount', {
                title: {
                    text: ''
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
        },
        error:function(e){
            // alert(e);
        }
    });
})
})

