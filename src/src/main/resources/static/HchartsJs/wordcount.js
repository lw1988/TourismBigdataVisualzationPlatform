$(function () {
    $(document).ready(function () {
        $.ajax({
            type:"POST",
            url:'tourismIndexSearch',
            data:{
                "title":$("#title").val()
            },

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


