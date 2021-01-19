$(window).ready(function(){
	var loginTab = $("#main-side .tab-wrap > div");
	var loginBox = $("#main-side .tab-item-wrap > div");
	loginTab.click(function(){
		var _this = $(this);
		var _ind = _this.index();
		loginTab.removeClass("on");
		_this.addClass("on");
		loginBox.hide();
		loginBox.eq(_ind).show();
	})
})