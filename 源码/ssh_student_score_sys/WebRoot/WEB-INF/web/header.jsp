<script type="text/javascript" src="${ctx }/resources/js/time.js"></script>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="top">
	<div id="top_t">
		<div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
			<div id="photo" class="fl">
            	<a href="info.html" target="rightFrame"><img src="${ctx }/resources/images/a.png" alt="" width="60" height="60"></a>
			</div>
			<div id="base_info" class="fr">
				<div class="help_info">
					<a href="${ctx }/main.html" id="hp">&nbsp;</a>
              		<a>&nbsp;</a>
              		<a href="${ctx }/logout.html">&nbsp;</a>
            	</div>
				<div class="info_center">${s_admin.username }<span id="nt"><a href="#" onclick="ymPrompt.win({title:'修改密码',height:'230',width:'500',dragOut:false,iframe:true,message:'${ctx }/toPsw.html'});" style="color: white;">修改密码</a></span></div>
			</div>
		</div>
	</div>
	<div id="side_here">
		<div id="side_here_l" class="fl"></div>
		<div class="fl" id="here_area" >现在时间：<span id="TimeDate" ></span></div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		setInterval("getTime('TimeDate')", 1000);
	});
</script>
