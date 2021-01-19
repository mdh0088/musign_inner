

function show_comment(way)
{	
	$('.conmment_div').hide();
	$('.return_div').hide();
	
	if (way=="approve") {	
		$('.conmment_div').show();
		if ($('.conmment_div').hasClass('on')) {
			$('.conmment_div').removeClass('on');
		}else{
	    	$('.conmment_div').addClass('on');
			$('.conmment_div').hide();
		}
	}else{
		$('.return_div').show();
		if ($('.return_div').hasClass('on')) {
			$('.return_div').removeClass('on');
		}else{
	    	$('.return_div').addClass('on');
			$('.return_div').hide();
		}
	}
	
}


function commemt_chk(index,useridx,way)
{	
	$.ajax({
		type : "POST", 
		url : "/dosign/getApprovalLine",
		dataType : "text",
		async : false,
		data : 
		{
			idx : index,
		},
		error : function() 
		{
			console.log("AJAX ERROR");
		},
		success : function(data) 
		{
			console.log(data);
			var result = JSON.parse(data);
			if (result.isSuc =="fail") {
				alert(result.msg);
				location.href="/main";
			}
			if (way=="approve")
			{
				var approval_line = result.data.approval_line.split('|');
				var approval_cont = result.data.approval_content.split('|');
				
				for (var i = 0; i < approval_line.length; i++) {
					if (approval_line[i] == useridx) {
						alert(approval_cont[i]);
						break;
					}
				}
			}
			else
			{
				alert(result.data.return_why);
			}
		}
	});
}