$( document ).ready(function() {
	$('.inputDisabled').attr('readOnly', true);
});

//잘못되면 true, 정상이면 false

//<input>을 넣어주면 거기에 글자가 없는지 체크해줄 함수
//없으면 true, 있으면 false리턴
function isEmpty(field) {
	return (!field.value);
}

//<input>, 최소 글자수를 넣어주면 체크해줄 함수
//최소글자수보다 짧으면 true, 길면 false리턴
function lessThan(field, min) {
	return (field.value.length < min);
}

//<input>넣어주면 거기에 한글/특수문자 있는지 체크해줄 함수
//한글/특수문자가 들어있으면 true, 없으면 false리턴
function containsHS(field) {
	var str = "@_.123456890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	for (var i = 0; i < field.value.length; i++) {
		if (str.indexOf(field.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

//<input>2개 넣어서, 그 2개 값 다른지 체크할 함수
//다르면 true, 같으면 false
function notEquals(field1, field2){
	return (field1.value != field2.value);
}


//<input>, 허용할 문자열세트를 넣었을때
//그게 들어있지 않으면 true, 들어있으면 false
function notContains(field, set){
	for (var i = 0; i < set.length; i++) {
		if (field.value.indexOf(set[i]) != -1){
			return false;
		}
	}
	return true;
}

//<input>을 넣어주면 숫자만 있는지
//불순물이 있으면 true, 아니면 false
function isNotNumber(field){
	return isNaN(field.value);
}

//<input>, 파일확장자(png)를 넣어주면
//value가 확장자로 안끝나면 true, 끝나면 false
function isNotType(field, type){
	return (field.value.toLowerCase().indexOf("." + type) == -1);
	//return (!field.value.toLowerCase().endsWith("." + type));
}




//엔터실행
function excuteEnter(excuteFunc)
{
	if(event.keyCode == 13){
		excuteFunc();
		return;
	}
}

function excuteEnter_param(excuteFunc, param1, param2)
{
	if(event.keyCode == 13){
		excuteFunc(param1, param2);
		return;
	}
}


//만 나이 계산
function calcAge(birth) {                 

    var date = new Date();
    var year = date.getFullYear();
    var month = (date.getMonth() + 1);
    var day = date.getDate();       
    if (month < 10) month = '0' + month;
    if (day < 10) day = '0' + day;
    var monthDay = month + day;
    birth = birth.replace('-', '').replace('-', '');
    var birthdayy = birth.substr(0, 4);
    var birthdaymd = birth.substr(4, 4);
    var age = monthDay < birthdaymd ? year - birthdayy - 1 : year - birthdayy;

    return age;
}


//일별 날짜 소환
function getInputDayLabel(dd) {
    
    var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
    
    var today = new Date(dd).getDay();
    var todayLabel = week[today];
    
    return todayLabel;
}

//날짜 데이트 포맷
function cutDate(dd)
{
	if(dd != '' && dd != null)
	{
		if(dd.length == 8)
		{
			var year = dd.substring(0,4);
			var month = dd.substring(4,6);
			var day = dd.substring(6,8);
			return year+"-"+month+"-"+day;
		}
		else if(dd.length == 14)
		{
			var year = dd.substring(0,4);
			var month = dd.substring(4,6);
			var day = dd.substring(6,8);
			var hour = dd.substring(8,10);
			var min = dd.substring(10,12);
			var sec = dd.substring(12,14);
			return year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
		}
	}
}

//널체크
function nullChk(d)
{
	if(d == "" || d == null || d == 'null' || d == undefined)
	{
		return "";
	}
	else
	{
		return d;
	}
}

//콤마 기입
function comma(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}


var setCookie = function(name, value, exp) 
{
	var date = new Date();
	date.setTime(date.getTime() + exp*24*60*60*1000);
	document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
};


var getCookie = function(name) 
{
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
	return value? value[2] : null;
};


//현재시각 
function getNow()
{
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = new String(date.getMonth()+1); 
	var day = new String(date.getDate()); 

	// 한자리수일 경우 0을 채워준다. 
	if(month.length == 1){ 
	  month = "0" + month; 
	} 
	if(day.length == 1){ 
	  day = "0" + day; 
	} 
	return year + "" + month + "" + day;
}


function getTime()
{
	var date = new Date(); 
	var h = date.getHours();
	var m = date.getMinutes();
	var s = date.getSeconds();
	// 한자리수일 경우 0을 채워준다. 
	if(h.length == 1){ 
	  h = "0" + h.toString(); 
	} 
	if(m.length == 1){ 
	  m = "0" + m.toString(); 
	} 
	if(s.length == 1){ 
		s = "0" + s.toString(); 
	} 
	return h + "" + m + "" + s;
}

function trim(stringToTrim) {
    return nullChk(stringToTrim).toString().replace(/^\s+|\s+$/g,"");
}

function ck_age(age) { 
  var year=parseInt(new Date().getFullYear()); 
  var ck=parseInt(age.substring(0,4)); 
  return (year-ck)+1; // 우리나라 나이 표시 +1 더함 
}

function show_address(post, addr) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById(post).value = data.zonecode;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
	            document.getElementById(addr).value = roadAddr;
               // document.getElementById("extraAddress").value = extraRoadAddr;
            } else {
	            document.getElementById(addr).value = data.jibunAddress;
               // document.getElementById("extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
            	
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                //guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
               // guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
            	
                var expJibunAddr = data.autoJibunAddress;
               //guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
               // guideTextBox.style.display = 'block';
            } else {
            	
               // guideTextBox.innerHTML = '';
               // guideTextBox.style.display = 'none';
            }
        }
    }).open();
}


function repWord(dd)
{
	dd = dd.replace(/&amt;/gi, "&");
	dd = dd.replace(/&lt;/gi, "<");
	dd = dd.replace(/&gt;/gi, ">");
	dd = dd.replace(/&quot;/gi, "\"");
	dd = dd.replace(/&#039;/gi, "\'");
	dd = dd.replace(/<br>/gi, "\n");
	
	return dd;
	
}

//파일크기 제한
function checkSize(input) 
{
    if (input.files && input.files[0].size > (20 * 1024 * 1024))
    {
        alert("파일 사이즈가 20mb 를 넘습니다.");
        input.value = null;
    }
}


function convChmod(useridx) 
{
	var chmod="";
	$.ajax({
		type : "POST", 
		url : "/dosign/getChmod",
		dataType : "text",
		async : false,
		data : 
		{
			useridx : useridx
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			chmod = result.chmod;
		}
	});
	return chmod;
}