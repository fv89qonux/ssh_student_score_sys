<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ctx }/resources/css/common.css">
<link rel="stylesheet" href="${ctx }/resources/css/main.css">
<script type="text/javascript" src="${ctx }/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/colResizable-1.3.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/common.js"></script>
<script type="text/javascript" src="${ctx }/resources/prompt/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="${ctx }/resources/prompt/skin/qq/ymPrompt.css" />
</head>
<body>
<div class="container">
<div id="search_bar" class="mt10">
	<div class="box">
		<div class="box_border">
           	<div class="box_center pt10 pb10">
             	<table class="form_table" border="0" cellpadding="0" cellspacing="0">
               	<tr>
                	<td><input type="button" name="button" class="btn btn82 btn_add add_" value="新增"></td>
               	</tr>
				</table>
 			</div>
		</div>
	</div>
</div>

<div id="table" class="mt10">
	<div class="box span10 oh">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
			<tr>
           		<th width="5%">编号</th>
           		<th>姓名</th>
         		<th>数学</th>
         		<th>语文</th>
         		<th>英语</th>
         		<th>物理</th>
         		<th>化学</th>
         		<th>备注</th>
         		<th width="10%">操作</th>
            </tr>
            <c:if test="${fn:length(entitys) == 0}">
				<tr><td colspan="9" align="center">暂无记录</td></tr>
			</c:if>
            <c:forEach items="${entitys}" var="d" varStatus="v">
				<tr class="tr">
					<td class="td_center">${v.index + 1 }</td>
					<td class="td_center">${student.name }</td>
					<td class="td_center">${d.num1 }</td>
					<td class="td_center">${d.num1 }</td>
					<td class="td_center">${d.num3 }</td>
					<td class="td_center">${d.num4 }</td>
					<td class="td_center">${d.num5 }</td>
					<td class="td_center">${d.content }</td>
					<td class="td_center">
						<input type="button" data="${d.id }" class="ext_btn ext_btn_success edit_" value="编辑">
						<input type="button" data="${d.id }" class="ext_btn ext_btn_error delete_" value="删除">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</div> 
<script type="text/javascript">
var delete_id;
$(function(){
	$(".add_").click(function(){
        ymPrompt.win({title:'添加',height:'380',width:'500',dragOut:false,iframe:true,message:'${ctx}/course/toAdd.html',handler:refresh});
    })
    
	$(".edit_").click(function(){
        var id = $(this).attr("data");
        ymPrompt.win({title:'添加',height:'380',width:'500',dragOut:false,iframe:true,message:'${ctx}/course/toUpdate.html?course.id=' + id,handler:refresh});
    })
    
	$(".delete_").click(function(){
        delete_id = $(this).attr("data");
        ymPrompt.confirmInfo({message:'您确定删除此信息？',handler:handlerDel});
    })
});

function handlerDel(tp){
	if(tp=='ok'){
		$.ajax({
            type : "GET",
            url : '${ctx}/course/delete.html?course.id=' + delete_id,
            dataType : "text",
            success : function(result) {
				refresh();
            }
        });
	}
}

// 刷新页面
function refresh(){
	self.location.href="${ctx}/course/list.html";
}
</script>
</body>
</html>