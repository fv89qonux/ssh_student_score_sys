<%@ page contentType="text/html;charset=UTF-8" %>
<div class="side">
	<div class="sideMenu" style="margin:0 auto">
		<h3>个人管理</h3>
		<ul>
			<li><a href="${ctx }/info.html" target="rightFrame">个人信息</a></li>
			<li><a href="#" onclick="ymPrompt.win({title:'修改密码',height:'230',width:'500',dragOut:false,iframe:true,message:'${ctx }/toPsw.html'});">密码修改</a></li>
		</ul>
		<h3>管理员管理</h3>
		<ul>
			<li><a href="${ctx }/admin/list.html" target="rightFrame">管理员列表</a></li>
		</ul>
		<h3>学生管理</h3>
		<ul>
			<li><a href="${ctx }/classs/list.html" target="rightFrame">班级列表</a></li>
			<li><a href="${ctx }/student/toList.html" target="rightFrame">学生列表</a></li>
		</ul>
   </div>
</div>