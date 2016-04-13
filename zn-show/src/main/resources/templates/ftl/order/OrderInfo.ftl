<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
	<meta content="yes" name="apple-mobile-web-app-capable"/>
	<meta content="black" name="apple-mobile-web-app-status-bar-style"/>
	<meta content="telephone=no" name="format-detection"/>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
	<meta name="renderer" content="webkit"/>  
    <title>二维码订单</title>
    <link rel="stylesheet" href="/resources/static/css/base.css">
    <link rel="stylesheet" href="/resources/static/css/dialog.css">
	<link rel="stylesheet" href="/resources/static/css/public.css">
	<script src="/resources/static/js/seajs/2.2.1/sea.js"></script>
    <script src="/resources/static/js/config.js"></script>
</head>
<body class="Body_">
<section>
	<div class="Head_ Head_2">
		<h1>${bestbuyBusiInfo.name}</h1>
	</div>
</section>
<section class="main PAD">
	<div class="ItemInfo2">
		<h1>客户：${bestbuyCustomerInfo.name}</h1>
		<ul>
			<li>商品：${bestbuyGoods.productName}</li>
			<li>商品总价：￥${bestbuyGoods.productPrice} </li>
			<li>申请分期金额：￥${bestbuyOrder.periodPrice}</li>
			<li>客户电话：${custphone}</li>
			<li class="OTHer_"><span class="Time_">2016/01/27 12:20</span></li>
		</ul>
		<h3><form action="/order/agree/${bestbuyOrder.id}" method="get"><input type="submit" class="ui-btn ui-btn-disabled ui-btn-finish" id="btn-bg" value="同意"></form></h3>
	</div>
	
</section>

</body>
</html>