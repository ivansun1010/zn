<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
	<meta content="yes" name="apple-mobile-web-app-capable"/>
	<meta content="black" name="apple-mobile-web-app-status-bar-style"/>
	<meta content="telephone=no" name="format-detection"/>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta name="renderer" content="webkit"/> 
    <title>商家</title>
    <link rel="stylesheet" href="/resources/static/css/base.css">
    <link rel="stylesheet" href="/resources/static/css/dialog.css">
	<link rel="stylesheet" href="/resources/static/css/public.css">
    <script src="/resources/static/js/lib/jquery/jquery-1.8.0.js"></script>
	<script src="/resources/static/js/seajs/2.2.1/sea.js"></script>
    <script src="/resources/static/js/config.js"></script>
</head>
<body class="bDiv">
<section>
	<div class="Head_ Head_2">

		<h1>${bestbuyBusiInfo.name}</h1>
	</div>
</section>
<section class="main PAD">
    <div class="Info_TIEM"><p><img src="/resources/images/ui-loading2.gif">加载数据...</p></div>
	<input type="hidden" id="cup" value="${pageView.currentPage}">
    <input type="hidden" id="prp" value="${pageView.previousPage?c}">
    <input type="hidden" id="nep" value="${pageView.nextPage?c}">
	<#list page.content as result>
	<div class="ItemInfo">
		<h1>客户：${result.name}</h1>
		<ul>
			<li>商品：${result.productName}</li>
			<li>商品总价：￥${result.productPrice} </li>
			<li>申请分期金额：￥${result.periodPrice}</li>
			<li>客户电话：${result.phone}</li>
		</ul>
		<h3>
			<span class="Time_">${result.applyTime?datetime}</span>

			<#switch result.orderStates>
				<#case 1>
                    <span class="Status_">审核中</span>
					<#break>
				<#case 2>
                	<span class="Status_">批核</span>
					<#break>
				<#case 3>
                	<span class="Status_">用户确认</span>
					<#break>
				<#case 4>
                	<span class="Status_ BLUE_">已成交</span>
					<#break>
				<#case 91>
                	<span class="Status_ RED_">审核不通过</span>
					<#break>
				<#case 92>
                <span class="Status_">客户放弃</span>
					<#break>
			</#switch>
		</h3>
	</div>
	</#list>

</section>
<div class="Loading_" style="display: none"><p><img src="/resources/images/ui-loading2.gif">正在加载数据...</p></div>
<form id="ol" method="get"></form>
<script>
    if($(".bDiv")){
        window.onscroll=function(){
            var $this =$(this),
                    viewH =$(this).height(),//可见高度
                    contentH =$(this).get(0).scrollHeight,//内容高度
                    scrollTop =$(this).scrollTop();//滚动高度
            //if(contentH - viewH - scrollTop <= 100) { //到达底部100px时,加载新内容
            if ($(document).scrollTop() + $(window).height() >= $(document).height() && $("#nep").val()=="true") {
                $('.Loading_').show();
				var ind = parseInt($("#cup").val())+1;
				$("#ol").attr("action","/order/list/"+ind).submit();
            }else if($(document).scrollTop()<= 0 &&  $("#prp").val()=="true"){
                $('.Info_TIEM').show();
                var ind = parseInt($("#cup").val())-1;
                $("#ol").attr("action","/order/list/"+ind).submit();
			}
        }
    }
</script>
</body>
</html>