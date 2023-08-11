<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body onload="sample3_execDaumPostcode()">
<div id="wrap" style="display:none;border:1px solid;width:100%;height:100%;margin:0px 0;position:relative">
<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:0px;z-index:1" onclick="foldDaumPostcode()" alt="닫기버튼">
</div>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    //닫기버튼 (x) 클릭
    function foldDaumPostcode() {
    	
    	//선택된 값 없이 nexacro platform 으로 전달 - close
    	setContent();
    }

    function sample3_execDaumPostcode() {
       
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수'
                var addrjibun = ''; //지번주소
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               
                if (data.userSelectedType === 'R') 
                { // 사용자가 도로명 주소를 선택했을 경우 - 지번주소 return 되지 않음
                    addr = data.roadAddress;
                	
                 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                 // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }   
                }
                else
                { // 사용자가 지번 주소를 선택했을 경우(J)
                	addr = data.jibunAddress;
                	addrjibun = data.roadAddress;
                }           
                
                // 우편번호와 주소 정보를 해당 필드에 nexacro platform으로 전달
              	setContent(data.zonecode,addr,addrjibun,extraAddr);
               
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
            	element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
    
  	//================================필수==============================================
    if (! window.NEXACROHTML)
    {
		window.NEXACROHTML = {};
	}
	  
  	window.NEXACROHTML.FireUserNotify = function(userdata)
  	{
  		
		if (window.NEXACROWEBBROWSER)
		{
			// web runtime environment, iOS/iPadOS NRE
			window.NEXACROWEBBROWSER.on_fire_onusernotify(window.NEXACROWEBBROWSER, userdata);
			element_wrap.style.display = 'none';
		}
		else if (typeof nexacro == "undefined")
	 	{
			// nexacro runtime environment 
			window.document.title = userdata;
			element_wrap.style.display = 'none';
		}
		else if (nexacro)
		{
	    	// Android NRE, macOS NRE
			nexacro.fireUserNotify(userdata)
			element_wrap.style.display = 'none';
	   }	
	}
	
  	
	//nexacro platform으로 선택된 주소 data넘겨주기
    function setContent(zipcode,addr,addrjibun,extraAddr)
    {
		var str = zipcode +"," + addr + "," + addrjibun + ","+ extraAddr;
		
    	window.NEXACROHTML.FireUserNotify(str);
    	
    	// iframe을 넣은 element를 안보이게 한다.
        // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
    	element_wrap.style.display = 'none';
    }
  	
	//==============================================================================
		
</script>
</body>
</html>