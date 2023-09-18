var article_id = $(".article-id").val();

$(window).on('load', function() {
	if ($("#contactInfo #parent-Info").val()) {
		var jsonText = JSON.parse($("#contactInfo #parent-Info").val());
	}
});

$(document).ready(function() {	//지도
	if ($(".invitation .location .init-map").length != 0) {
		$("#map").addClass("active");
		naver.maps.Service.geocode({
			address : document.getElementById('map-address1').value
		}, function(status, response) {
			if (status !== naver.maps.Service.Status.OK) {
				return "";
			}
			var result = response.result;
			var o = result.items[0];
			var p = new naver.maps.LatLng(o.point.y, o.point.x);

			var mapDiv = document.getElementById('map');
			var mapOptions = {
				center : p,
				useStyleMap : true,
				zoom : 15,
				scrollWheel : false,
				draggable : false,
				mapDataControl: false,
			    scaleControl: true,
			    scaleControlOptions: {
			        position: naver.maps.Position.BOTTOM_RIGHT
			    }
			    
			};

			var map = new naver.maps.Map(mapDiv, mapOptions);
			marker = new naver.maps.Marker({
				map : map,
				position : mapOptions.center,
				icon: {
					url: '/img/marker.png'
				}
			});
		});
	}
	
	$(".reallyclose").click(function (e) {
		$(".pswp__button--close").click();
		$(".reallyclose").hide();
	});
	
	var pswpElement = document.querySelectorAll('.pswp')[0];
	var gallery, items = [];

	$(".hide-image>img").each(function (k, v) {
		$(v).attr("data-page", k);
		items.push({ src: $(v).attr("data-src"), w: 0, h: 0 });
	});

	$(".galleries-align .galleries-content").click(function (e) {
		gallery = new PhotoSwipe( pswpElement, PhotoSwipeUI_Default, items, { index: parseInt($(this).attr("data-page")) });
		gallery.listen('gettingData', function(index, item) {
			if (item.w <= 100 || item.h <= 100) { // unknown size
				var img = new Image(); 
				img.onload = function() { // will get size after load
					item.w = img.width; // set image width
					item.h = img.height; // set image height
					gallery.invalidateCurrItems(); // reinit Items
					gallery.updateSize(true); // reinit Items
				}
				img.src = item.src; // let's download image
			}
		});
		console.log(gallery);
		gallery.init();
		$(".reallyclose").show();
		e.preventDefault();
		return false;
	});

	var startX,startY, endX,endY;
	$(".owl-galleries").on('touchstart',function(event){
	    startX = event.originalEvent.changedTouches[0].screenX;
	    startY = event.originalEvent.changedTouches[0].screenY;
	});
	$(".owl-galleries").on('touchmove',function(event){
	    endX=event.originalEvent.changedTouches[0].screenX;
	    endY=event.originalEvent.changedTouches[0].screenY;
    	
	    if(startX-endX>70 || endX-startX>70){
	    }else {
	    	if(startY-endY>30 || endY-startY>30){
	        	$(".owl-galleries").css("top",endY-startY);
		    	if(startY-endY>30) {
		    		$(".galleries-bg").css("opacity",1-(((endY-startY) * -1)/500));
		    	}else if(endY-startY>30) {
		    		$(".galleries-bg").css("opacity",1-((endY-startY)/500));
		    	}
		    	
		        return false;  
		    }	
	    }
	    
	});
	
	$(".owl-galleries").on('touchend',function(event){
		
		if($(".galleries-bg").css("opacity") < 0.9) $("body").removeClass("galleries-open");
		var comback = setInterval(function(e) {
			var _t = $(".owl-galleries").css("top");
			_t = parseInt(_t.substring(0,_t.length - 2));
			if(_t > 0) {
				$(".owl-galleries").css("top",_t - 1);
			}else {
				$(".owl-galleries").css("top",_t + 1);
			}
			if(_t == 0) {
				clearInterval(comback);
				$(".owl-galleries").css("top",0);
			}
		}, 1);
		var comback2 = setInterval(function(e) {
			var _o = parseFloat($(".galleries-bg").css("opacity"));
			if(parseInt(_o) != 1) {
				$(".galleries-bg").css("opacity",_o + 0.001);
			}else {
				clearInterval(comback2);
			}
		}, 1);
	});
	
	var regChinese = new RegExp('([\u2e80-\u2eff\u31c0-\u31ef\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fbf\uf900-\ufaff])+', 'g');
	var parentData = document.getElementById('parentchinese').value;
	var jsonParent = JSON.parse(parentData);
	

	$.each(jsonParent, function(k, v){

		var $el = $(".p-info[data-type='" + k + "']");

		var parentText = $('.p-info').text();
		
		if(regChinese.test(v)){
			if($(".p-info").hasClass("other-theme")){
				var v = v.replace(regChinese, '<span style="font-family:serif; margin-left:0;">$&</span>');
			}else{				
				var v = v.replace(regChinese, '<span style="font-family:serif; margin-left:auto;">$&</span>');
			}
			$(".p-info[data-type='" + k + "]'").text(v);
			$($el, ".p-info[data-type='" + k + "]'").html(v);
		}else{
			$(".p-info[data-type='" + k + "]'").text(v);
			$($el, ".p-info[data-type='" + k + "]'").html(v);
		}

	});
		
	var textChinese = $('.invitation.content.pre-tag').text();
	
	if(regChinese.test(textChinese) == true){
		var content = textChinese.replace(regChinese, '<span style="font-family:serif; margin-left:auto;">$&</span>');
		$('.invitation.content.pre-tag').text(content);
		$('.invitation.content.pre-tag').html(content);
	}

	if(article_id == "9419"){
		var mName = $("#mName").val();	//신랑 이름 가져오기
		var fName = $("#fName").val();	//신부 이름 가져오기
		var m_name_split = mName.split(""); // 신랑 ((이름))을 각 문자로 자르기
		var f_name_split = fName.split(""); // 신부 ((이름))을 각 문자로 자르기

		var check = "교뇨됴료묘뵤쇼요죠쵸쿄툐표효"; //단어 리스트 만들기
		var check_arr = check.split("");	// ((교~효)) 각 문자로 자르기
		
		for(i=0; i < check_arr.length; i++){
			for(j=0; j < m_name_split.length; j++){
				if(m_name_split[j] == check_arr[i]){
					m_name_split[j] = "<span class='temporary-name'>" + m_name_split[j] + "</span>";
				}
			}
			for(j=0; j < f_name_split.length; j++){
				if(f_name_split[j] == check_arr[i]){
					f_name_split[j] = "<span class='temporary-name'>" + f_name_split[j] + "</span>";
				}
			}
		}
		
		var mName_plus = m_name_split.join("");
		var fName_plus = f_name_split.join("");
		
		$('.invitation .cover-mname').text(mName_plus);
		$('.invitation .cover-mname').html(mName_plus);
		$('.invitation .cover-fname').text(fName_plus);
		$('.invitation .cover-fname').html(fName_plus);
		
	}
	
})




//달력
var today = new Date();// 오늘 날짜//내 컴퓨터 로컬을 기준으로 today에 Date 객체를 넣어줌
var date = new Date();// today의 Date를 세어주는 역할

/*
 * function prevCalendar() {//이전 달 // 이전 달을 today에 값을 저장하고 달력에 today를 넣어줌
 * //today.getFullYear() 현재 년도//today.getMonth() 월 //today.getDate() 일
 * //getMonth()는 현재 달을 받아 오므로 이전달을 출력하려면 -1을 해줘야함 today = new
 * Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
 * buildCalendar(); //달력 cell 만들어 출력 }
 * 
 * function nextCalendar() {//다음 달 // 다음 달을 today에 값을 저장하고 달력에 today 넣어줌
 * //today.getFullYear() 현재 년도//today.getMonth() 월 //today.getDate() 일
 * //getMonth()는 현재 달을 받아 오므로 다음달을 출력하려면 +1을 해줘야함 today = new
 * Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
 * buildCalendar();//달력 cell 만들어 출력 }
 */

if(article_id == "9410" || article_id == "9377" || article_id == "9375"){
	$(window).on('load',function buildCalendar() { // 달력 만들기
	
		var yaml_date = document.getElementById('marryHidden').value;
	
		var arr = yaml_date.split('-');
		var countDownDate = new Date(arr[0] + '/' + arr[1] + '/' + arr[2])
				.getTime();
		var D_DAY = new Date(arr[0] + '/' + arr[1] + '/' + arr[2]);
	
		var now = new Date().getTime();
	
		var distance = countDownDate - now;
	
		var d = Math.floor(distance / (1000 * 60 * 60 * 24));
		var h = Math.floor((distance % (1000 * 60 * 60 * 24))
				/ (1000 * 60 * 60));
		var m = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		var s = Math.floor((distance % (1000 * 60)) / 1000);
	
		if (d == 0) {
			d = 'day';
		}
	
		/*
		 * if (d < 0) { d = d * -1;
		 * document.getElementById('D-DAY').innerHTML = 'D+' + d; } else {
		 * document.getElementById('D-DAY').innerHTML = 'D-' + d; }
		 */
	
		/* var cover_date = document.getElementById('cover_date'); */
		var yyyy = D_DAY.getFullYear();
		var mm = D_DAY.getMonth() + 1;
		var dd = D_DAY.getDate();
		var ho = D_DAY.getHours();
		var mi = D_DAY.getMinutes();
		var ap = 'AM';
		if (mm < 10) {
			mm = '0' + mm;
		}
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (ho >= 12) {
			if (ho == 12) {
				ho = '12';
			} else {
				ho = '0' + (ho - 12);
			}
	
			ap = 'PM';
		}
		if (mi == '0') {
			mi = '00';
		}
	
		/*
		 * cover_date.textContent = yyyy + '.' + mm + '.' + dd + ' ' + ap + ' ' +
		 * ho + ':' + mi;
		 */
	
		var doMonth = new Date(D_DAY.getFullYear(), D_DAY.getMonth(), 1);
		// 이번 달의 첫째 날,
		// new를 쓰는 이유 : new를 쓰면 이번달의 로컬 월을 정확하게 받아온다.
		// new를 쓰지 않았을때 이번달을 받아오려면 +1을 해줘야한다.
		// 왜냐면 getMonth()는 0~11을 반환하기 때문
		var lastDate = new Date(D_DAY.getFullYear(), D_DAY.getMonth() + 1,
				0);
		// 이번 달의 마지막 날
		// new를 써주면 정확한 월을 가져옴, getMonth()+1을 해주면 다음달로 넘어가는데
		// day를 1부터 시작하는게 아니라 0부터 시작하기 때문에
		// 대로 된 다음달 시작일(1일)은 못가져오고 1 전인 0, 즉 전달 마지막일 을 가져오게 된다
		var tbCalendar = document.getElementById("calendar");
		// 날짜를 찍을 테이블 변수 만듬, 일 까지 다 찍힘
		var tbCalendarYM = document.getElementById("tbCalendarYM");
		var tbCalendarYM2 = document.getElementById("tbCalendarYM2");
		// 테이블에 정확한 날짜 찍는 변수
		// innerHTML : js 언어를 HTML의 권장 표준 언어로 바꾼다
		// new를 찍지 않아서 month는 +1을 더해줘야 한다.
		tbCalendarYM.innerHTML = (D_DAY.getMonth() + 1) + "월";
		/* while은 이번달이 끝나면 다음달로 넘겨주는 역할 */
		while (tbCalendar.rows.length > 2) {
			// 열을 지워줌
			// 기본 열 크기는 body 부분에서 2로 고정되어 있다.
			tbCalendar.deleteRow(tbCalendar.rows.length - 1);
			// 테이블의 tr 갯수 만큼의 열 묶음은 -1칸 해줘야지
			// 30일 이후로 담을달에 순서대로 열이 계속 이어진다.
		}
		var row = null;
		row = tbCalendar.insertRow();
		// 테이블에 새로운 열 삽입//즉, 초기화
		var cnt = 0;// count, 셀의 갯수를 세어주는 역할
		// 1일이 시작되는 칸을 맞추어 줌
		for (i = 0; i < doMonth.getDay(); i++) {
			/* 이번달의 day만큼 돌림 */
			cell = row.insertCell();// 열 한칸한칸 계속 만들어주는 역할
			cnt = cnt + 1;// 열의 갯수를 계속 다음으로 위치하게 해주는 역할
		}
		/* 달력 출력 */
		for (i = 1; i <= lastDate.getDate(); i++) {
			// 1일부터 마지막 일까지 돌림
			cell = row.insertCell();// 열 한칸한칸 계속 만들어주는 역할
			cell.innerHTML = i;// 셀을 1부터 마지막 day까지 HTML 문법에 넣어줌
			cnt = cnt + 1;// 열의 갯수를 계속 다음으로 위치하게 해주는 역할
			if (cnt % 7 == 1) {/* 일요일 계산 */
				// 1주일이 7일 이므로 일요일 구하기
				// 월화수목금토일을 7로 나눴을때 나머지가 1이면 cnt가 1번째에 위치함을 의미한다
				cell.innerHTML = "<font color=#f00>" + i
				// 1번째의 cell에만 색칠
			}
			if (cnt % 7 == 0) {/* 1주일이 7일 이므로 토요일 구하기 */
				// 월화수목금토일을 7로 나눴을때 나머지가 0이면 cnt가 7번째에 위치함을 의미한다
				cell.innerHTML = i
				// 7번째의 cell에만 색칠
				row = calendar.insertRow();
				// 토요일 다음에 올 셀을 추가
			}
			/* 오늘의 날짜에 노란색 칠하기 */
			if (D_DAY.getFullYear() == D_DAY.getFullYear()
					&& D_DAY.getMonth() == D_DAY.getMonth()
					&& i == D_DAY.getDate()) {
				// 달력에 있는 년,달과 내 컴퓨터의 로컬 년,달이 같고, 일이 오늘의 일과 같으면
				//cell.bgColor = "#FAF58C";	// 셀의 배경색을 노랑으로
				cell.style.fontSize = "5vmin";
				cell.style.fontWeight = "bold";
				//cell.style.paddingTop = "0.001vw";
	
			}
		}
	});
};

var weekDate = document.getElementById('marryHidden2').value;
var arr = weekDate.split('-');
var D_DAY = new Date(arr[0] + '/' + arr[1] + '/' + arr[2]);

function getDate(weekDate){//날짜문자열
	
	var week = [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일' ];
	
	var dayOfWeek = week[D_DAY.getDay()];
	return dayOfWeek;
}	
getDate(weekDate);
$('#weekDate').html(getDate(weekDate));

var ap = "오후";
if (D_DAY.getHours() <= 11) {
	var ap = "오전";
}
$('#ap').html(ap);

$(document).on(		//축하메시지 쓰기
		'submit',
		'#message-form',
		function(e) {
			$btn = $(this).find("button");
			$btn.hide();
			$.ajax({
				url : "/messageinput/input.ajax",
				data : $("#message-form").serialize(),
				type : "POST",
				success : function(data) {
					var html = "<div class='message-details'>"
							+ "<div class='message-info'>"
							+ "<span class='message-name'>" + data.name
							+ "</span>"
							+ "<span class='message-date'>" + data.created
							+ "</span></div>" 
							+ "<div class='message-message'>"
							+ "<p>" + data.content + "</p>"
							+ "</div>"
							+ "<div class='check-pw' id='check-pw' style='display:none;'>"
							+ "<input type='password' name='messagePassword' placeholder='비밀번호를 입력하세요.' autocomplete='off'>"
							+ "<button class='deleteSubmit' type='submit' name='deleteSubmit' data-id='" + data.id 
							+ "'>삭제</button>"
							+ "</div>"
							+ "<a class='delete-message' id='delete-message' data-id='" + data.id
							+ "'>x</a>" + "</div>";
					$('.message-output').prepend(html);
					$("#message-form input[type!='hidden']").val("");
					alert("등록되었습니다.");
					$btn.show();
				}
			});

			e.preventDefault();
			return false;
		});

$(document).on('click', '.deleteSubmit', function() {		//축하메시지 삭제
	$btn = $(this);
	$.ajax({
		url : "/messagedelete/delete.ajax",
		dataType : "json",
		type : "POST",
		data : {
			id : $btn.attr("data-id"),
			password : $(this).siblings("input[name='messagePassword']").val()	
		},
		success : function(data) {
			if(!data.success){
				this.error();
			}else{
				$btn.parent().parent().remove();
				alert("삭제되었습니다.");
			}
		},
		error: function(){
			alert("비밀번호를 다시 확인해 주세요.");
		}
	});
});

$(document).on('click', '.delete-message', function() {		//비밀번호 입력 폼 활성화
	$(this).parent().find('.check-pw').show();
});


if($("#order_form").length == 1) {
	$("body>footer.all-footer").css("padding-bottom",$("#order_form").height() + 10);
}

if($("[data-last]").length != 0) {
	var idx = parseInt($("[data-last]").attr("data-last"));
	if(!isNaN(idx)) {
		if(idx <= 9) idx = "0" + idx;
		$("[data-last]").text(idx);
	}
}

$("[data-src]").each(function (k, v) {
	$(v).css("background-image", "url(" + $(v).attr("data-src") + ")");
});


var message = $(".message-details");	//축하메시지 출력

if (message.length > 2) {
	message.slice(2, message.length).hide();
}

$(document).on('click', '#add-message', function() {
	$(".message-details:hidden").slice(0, 3).show();
	if ($(".message-details:hidden").length == 0) {
		$(this).remove();
	}
});


Kakao.init('3e89670d5127d5b105a43cebc95bdee2');	//공유하기
if($("#kakao").length != 0) {
	Kakao.Link.createDefaultButton({
	    container: '#kakao',
	    objectType: 'feed',
	    content: {
	      title: $("[property='og:title']").attr("content"),
	      description: $("[property='og:description']").attr("content"),
	      imageUrl:
	    	  $("[property='og:image']").attr("content"),
	      link: {
	        mobileWebUrl: location.href,
	        webUrl: location.href,
	      },
	    },
	    buttons: [
	      {
	        title: '초대장 방문하기',
	        link: {
	          mobileWebUrl: location.href,
	          webUrl: location.href,
	        },
	      },
	    ],
	});	
}

$(document).on("click","#kakao_story",function(e){
	Kakao.Story.open({
	      url: location.href,
	      text: $("[property='og:description']").attr("content"),
	})		
});

$(document).on("click","#facebook",function(e){
	link = encodeURIComponent(location.href);
	title = encodeURIComponent($("[property='og:title']").attr("content"));
	var uri = 'http://www.facebook.com/sharer.php?u=' + link + '&t=' + title;
	window.open(uri,'','width=400,height=400,left=600');	
});

$(document).on("click","#band",function(e){
	link = encodeURIComponent(location.href);
	title = encodeURIComponent($("[property='og:title']").attr("content"));
	var uri = "https://band.us/plugin/share?body="+title+"&route="+link;
	window.open(uri,'','width=400,height=400,left=600');	
});



