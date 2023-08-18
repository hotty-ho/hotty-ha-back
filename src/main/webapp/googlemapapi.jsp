<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        #map {
            height: 100%;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>

</head>
<body>
<%--<iframe--%>
<%--        width="450"--%>
<%--        height="250"--%>
<%--        frameborder="0" style="border:0"--%>
<%--        referrerpolicy="no-referrer-when-downgrade"--%>
<%--        src="https://www.google.com/maps/embed/v1/view?key=YOUR_API_KEY&center=35.159755,128.1062387"--%>
<%--        allowfullscreen>--%>
<%--</iframe>--%>
<div id="map"></div>
<script async
        src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
</script>
<script type="text/javascript">

    function initMap() {
        var Y_point = 35.159755;        // Y 좌표
        var X_point = 128.1062387;        // X 좌표
        var zoomLevel = 18;                // 지도의 확대 레벨 : 숫자가 클수록 확대정도가 큼
        var markerTitle = "서울IT교육센터";        // 현재 위치 마커에 마우스를 오버을때 나타나는 정보
        var markerMaxWidth = 300;                // 마커를 클릭했을때 나타나는 말풍선의 최대 크기
        var contentString    = '<div style="color:black;">' +		// 말풍선 내용
            '<h2>오시는 길</h2>'+
            '<p>주소 : 경상남도 진주시 가좌동 가좌길74번길 8 KR 혜람빌딩 5층</p>' +
            '<p>영업 시간 : 평일 오전 9:00 ~ 오후 10:00, 토요일 오전 9:00 ~ 오후 1:00</p>'+
            '<p>보건 및 안전 : 예약 필수 · 마스크 필수 · 체온 확인 필수 · 직원 마스크 착용함 · 직원 체온 확인함 </p>' +
            '<p>연락처 : 055-753-3677</p>'
        '</div>';
        var myLatlng = new google.maps.LatLng(Y_point, X_point);
        var mapOptions =
            {
                zoom: zoomLevel,
                center: myLatlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
        var map = new google.maps.Map(document.getElementById('map'), mapOptions);
        var marker = new google.maps.Marker
        ({
            position: myLatlng,
            map: map,
            title: markerTitle
        });
        var infowindow = new google.maps.InfoWindow
        ({
            content: contentString,
            maxWizzzdth: markerMaxWidth
        });
        google.maps.event.addListener(marker, 'click', function()
        {
            infowindow.open(map, marker);
        });
    }

    window.initMap = initMap;

</script>
</body>
</html>
