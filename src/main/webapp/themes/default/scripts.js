
var sections;
var xhr;

$(window).scroll(function () {
	var _st = $(this).scrollTop();
	var _t1 = $("#contents").offset().top - _st;
	(_t1 <= 80) ? $("#contents .page-header").addClass("fixed") : $("#contents .page-header").removeClass("fixed");
	
	if ($("#contents section").size() > 0) {
		var _t2 = $("#contents section:eq(0)").offset().top - _st + 80;
		(_t2 <= 170) ? $(".side-i").addClass("fixed") : $(".side-i").removeClass("fixed");

		if (sections) {
			$("#gnb li").removeClass("active");
			var _el = "/";
			sections.each(function () {
				var $t = $(this);
				var _n = $t.offset().top - _st;
				if (_n + $t.outerHeight() < 0 || _n > $(window).outerHeight()) return;
				if (_n - $(window).outerHeight() < -130) {
					_el = "/" + $t.attr("id");
				}
			});
			$("#gnb li:has(a[href='" + _el + "'])").addClass("active");
			if (history.replaceState) history.replaceState({}, "", "/");
		}		
	}
	

});

$(window).resize(function () {
	$(".side-i").css("width", "auto");
	$(".side-i").css("width", $(".side-i").width() + "px");
	
	if ($(this).width() > 768) {
		$("#main-owl img[data-src]").attr("src", "/img/t.png");
	}
	else {
		$("#main-owl img[data-src]").each(function () {
			$(this).attr("src", $(this).attr("data-src"));
		});
	}
});

$(document).on("click", ".calc-container [data-id]", function (e){
	var p = $(this).parents("li[data-type]");
	$("input.index", p).val($(this).attr("data-id"));
	calculator_reload();
	e.preventDefault();
	return false;
});

$(document).on("click", ".calc-container .btn-delete", function (e){
	var p = $(this).parents("li[data-type]");
	$("input.index", p).val("");
	calculator_reload();
	e.preventDefault();
	return false;
});



function hidemsg() {
	clearInterval($("#beauty-alert").data("iv"));
	$("#beauty-alert").clearQueue().fadeOut(300);
}

function calculator_reload() {
	if(xhr) xhr.abort();
	xhr = $.ajax({
		url : "/calculator/data.ajax",
		data : $("#calc-form").serialize(),
		type : "POST",
		success: function (data) {
			
			var _tpl1 = $("#tpl_calculator_item").text();
			Mustache.parse(_tpl1);

			var _tpl2 = $("#tpl_calculator_selected").text();
			Mustache.parse(_tpl2);
			
			$.each(data, function (k, v) {
				var $el = $(".calc-container>ul>li[data-type='" + k + "']");
				
				if (v.selected) {
					$el.addClass("selected");
					var rendered = Mustache.render(_tpl2, v.selected);
					$(".choice_item", $el).html(rendered);
					$("input[type='text']", $el).val(v.selected.title);
				}
				else {
					$el.removeClass("selected");
					$("input[type='text']", $el).val("");
				}
				
				$(".recommand>ul", $el).html("");
				$.each(v.recomm, function (k, v) {
					  var rendered = Mustache.render(_tpl1, v);
					  $(".recommand>ul", $el).append(rendered);
				});
			});
			
			if (data.price && data.price > 0) {
				$(".result-info").addClass("has-price");
				$(".result-info .company-desc b").text(data.selects);
				$(".result-info .company-desc b.price").text($.number(data.price, 0));
			}
			else {
				$(".result-info").removeClass("has-price");
			}
			
		}
	});
}

$(document).ready(function() {
	$(window).resize();
	
	if ($(".side-i").size() > 1) $(".side-i:not(:eq(0))").remove();
	$(".side-i").css("width", $(".side-i").width() + "px");
	
	$(".dateinput").attr("readonly", "readonly").datepicker({
		dateFormat: "yy-mm-dd",
		changeMonth: true,
		changeYear: true,
		monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
		monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
		dayNames: [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ],
		dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ], 
		dayNamesShort: [ "일", "월", "화", "수", "목", "금", "토" ]
	});

	$("#main-owl").owlCarousel({ 	
		items:1,
		nav: true,
		loop: true,
		center: true, 
		dots: false,
		autoHeight: true,
		navText: [ '<i class="fal fa-angle-left"></i>', '<i class="fal fa-angle-right"></i>' ],
		responsiveClass:true,
		responsive: { 0:{ autoHeight: true }, 768:{ autoHeight: false} }
	}).on('changed.owl.carousel', function(e) {
		var t = this;
		$(".thumbs .thumb[data-idx]").removeClass("active");
		setTimeout(function () {
			var idx = $(".owl-item.active [data-idx]", t).attr("data-idx");
			$(".thumbs .thumb[data-idx='" + idx + "']").addClass("active");
		}, 200);
	});
	
	$("#main-owl img").one("load", function() {
		$('.main-div .owl-carousel').trigger('refresh.owl.carousel');
	}).each(function() {
		if(this.complete) $(this).load();
	});
	
	$(".thumbs .thumb[data-idx='0']").addClass("active");
	$(".thumbs .thumb[data-idx]").click(function () {
		var ix = parseInt($(this).attr("data-idx"));
		$('.main-div .owl-carousel').trigger('to.owl.carousel', ix);
		e.preventDefault();
		return false;
	});
	
	var base_w = $(".thumb-box .thumbs>section").width() - $(".thumb-box .thumbs").width();
	$(".thumb-box .carousel").on("mousemove", function (e) {
		var ox = e.pageX - $(this).offset().left;
		var r = 1.2 * (ox / $(this).width()) - 0.1;
		if (r < 0) r = 0;
		if (r > 1) r = 1;
		$(".thumb-box .thumbs>section").css("left", (0 - base_w * r) + "px");
	});
	
	$('[data-src]').each(function () {
		$(this).css("background-image", "url(" + $(this).attr("data-src") + ")");
	});
	
	$('#option-owl').owlCarousel({ 	
		items:2,
		nav: true,
		navText: [ '<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>' ],
		responsiveClass:true,
		responsive: { 0:{ items:1.5, nav: false, center: true, loop: true }, 768:{ items:2 } }
	});

	var _y = $("#contents").prev().outerHeight();
	$("#contents").css("top", _y + "px");
	
	$("#gnb li").removeClass("active");
	sections = $("#contents>section");
	if (sections.size() == 1) {
		var href = "/" + sections.attr("id");
		$("#gnb li:has(a[href='" + href + "'])").addClass("active");
		sections = undefined;
	}
	
	$(window).scroll();
	
	$(document).on("click", "#gnb li>a", function (e) {
		var href = $(this).attr("href").substring(1);
		if ($("section#" + href).size() > 0) {
			if (history.replaceState) history.replaceState({}, href, "/");
			$("body").removeClass("m-open");
			var x = 80;
			if ($(window).width() < 768) x = 0;
			var t = $("section#" + href).position().top + $("#background").height() - x;
			$("html,body").animate({ scrollTop : t }, 500);
			e.preventDefault();
		}
	});
	
	$(document).on("click", ".pagemore a", function (e) {
		
		var $btn = $(this);
		if ($btn.hasClass("loading")) return;
		
		$btn.addClass("loading");
		
		$.ajax({
			url : $(this).attr("href"),
			success: function (html) {
				var $el = $(html).find("#reviews");
				if ($el.size() > 0) {
					$("#reviews .pagemore").remove();
					$("#reviews").append($el.html());
					$(window).scroll();
				}
				else {
					this.error();
				}
			},
			error: function () {
				alert("서버와 연결이 올바르지 않습니다.");
				$btn.removeClass("loading");
			}
		});
		
		e.preventDefault();
		return false;
	});
	
	$("[data-autocomplete]").each(function (k, v) {
		$(v).autocomplete({
			source : $(v).attr("data-autocomplete"),
		    minLength: 0,
		    focus : function(event, ui) {
				$(v).val(ui.item.label);
				return false;
			},
			select : function(event, ui) {
				var $el = $(this).parents("li[data-type]");
				$("input.index", $el).val(ui.item.id);
				calculator_reload();
			}
		}).keydown(function(e){
			if(e.keyCode == 13){
				e.preventDefault();
				return false;
			}
		});
	});
	
	calculator_reload();

	$(".all-check").click(function(){
		if($(this).prop("checked")) {
			$("input[type=checkbox]").prop("checked",true);
		}
		else {
			$("input[type=checkbox]").prop("checked",false);
		}
	});


	$(document).on("click", ".contact-area>button", function (e) {
		var article = "";
		$(".price-area>.company-desc>b").each( function(k,v) {
			if(k > 0) {
				article += ", " + $(this).text();
			}else {
				article += $(this).text(); 
			}
		});
		
		$("textarea[name='content']").val(article);
		
		var offset = $("textarea[name='content']").offset();
		 $('html, body').animate({scrollTop : offset.top - 120}, 400);
		
		e.preventDefault();
		return false;
	});
	
	$("#contacts_form").submit(function (e) {
		e.preventDefault();
		if (!$(this).parsley().validate()) return false;
			
		var $form = $(this);
		$("button", this).hide();
		$.ajax({
			url : context_path + "/contacts",
			data : $(this).serialize(),
			type : "POST",
			success: function (data) {
				if (!data.success) {
					this.error();
					return;
				}
				
				clearInterval($("#beauty-alert").data("iv"));
				$("#beauty-alert h3").html(data.title);
				$("#beauty-alert p").html(data.message);
				$("#beauty-alert i").attr("class", "far fa-heart");
				$("#beauty-alert").clearQueue().show();
				$("#beauty-alert").data("iv", setInterval(hidemsg, 2000));
				
				$("input , textarea", $form).val("");
				$("input[type='checkbox']", $form).prop("checked", false);
				$("button", $form).show();
				
			},
			error: function () {
				alert("서버와 연결할 수 없습니다.");
				$("button", $form).show();
			}
		});
		
		return false;
	});
});



