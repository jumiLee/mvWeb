<!DOCTYPE html>
<html>
<head>
	<title>Attend Event</title>
	<link type="text/css" href="/mvWeb/css/style.css" rel="stylesheet" />
</head>

<body>
  <section align="center">
    <header>
        <h1>DAILY BONUS</h1>
        <h3>매일 출석하고 쏟아지는 보상을 받아가세요!</h3>
    </header>
    
    <main align="center">
		<div class="buttons">
		<p>
		<#assign x = 0>
      	<#if userAttendList??> 
		<#list userAttendList as item>
			<#if x%3=0>
			</p><p>
			</#if>
			<#assign x++>
			<#if item.rwd_rcv_flag?number == 1>
				<#assign bgColor="#8650B0">
			<#else>
				<#assign bgColor="#FFF3D4">
			</#if>
			<button class="button" style="background-color:${bgColor};">
				${item.day_no!} 일차 <br> 
				${item.rwd_id!} ${item.rwd_nm!}
			</button>
			<#if x = userAttendList?size>
			</p>
			</#if>
		</#list>
		</#if>
		</div>
    </main>
    <ol>출석체크는 매일 자동으로 지급됩니다.</ol> 
	<ol>하루라도 놓치면 처음부터 다시 시작해야해요.</ol>
  </section>
</body>
</html>