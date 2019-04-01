$(function () {
    $(document).ready(function () {
       var map=new AMap.Map('guangximap',{resizeEnable: true,zoom:13});
        $.ajax({
            type:"GET",
            url:'getALLTourismAndPeopleCount',
            dataType:'json',
            traditional:true,
            success:function (data) {
              for(var i=1;i<produces.length;i=i+1){
                  var marker;
                  var icon;
                  if(produces[i].count>50){
                      icon=new AMap.Icon({
                          image:'https://webapi.amap.com/theme/v1.3/markers/n/mark_r.png',
                          size: new AMap.Size(24, 24)
                      });
                  }else{
                      icon=new AMap.Icon({
                          image:'https://webapi.amap.com/theme/v1.3/markers/n/mark_b.png',
                          size: new AMap.Size(24, 24)
                      });
                  }
                  marker = new AMap.Marker({
                      icon: icon,
                      position:getPosition(produces[i].title),
                      offset: new AMap.Pixel(-12,-12),
                      zIndex: 101,
                      title:produces[i].title+"已有"+produces[i].count+"人旅游过"
                  });
              }
            },
            error:function(e){

            }
        });

    })
})

//获取经纬度
function getPosition( address) {
    var lng;
    var lat;
    geocoder.getLocation(address, function(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            lng = result.geocodes[0].location.lng;
            lat=result.geocodes[0].location.lat;
        }
    });
    return [lng,lat]
}