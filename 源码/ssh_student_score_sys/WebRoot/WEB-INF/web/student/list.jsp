<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
           	<div class="box_top"><b class="pl15">搜索栏目</b></div>
           	<div class="box_center pt10 pb10">
               	<form action="${ctx }/student/list.html" method="post">
             	<table class="form_table" border="0" cellpadding="0" cellspacing="0">
               	<tr>
               		<td>姓名</td>
               		<td><input type="text" name="student.name" class="input-text lh25" size="20" value="${entity.name }"></td>
               		<td>学号</td>
               		<td><input type="text" name="student.num" class="input-text lh25" size="20" value="${entity.num }"></td>
              		<td>
	                    <input type="radio" name="student.sex" value="0"> 全部
	                    <input type="radio" name="student.sex" value="1"> 男神
	                    <input type="radio" name="student.sex" value="2"> 女神
               		</td>
					<td>
                   		<span class="fl">
                   			<div class="select_border"> 
                       		<div class="select_containers "> 
		                        <select name="student.cid" class="select" id="_cid"> 
		                        <option value="0">--选择班级--</option> 
		                        <c:forEach var="item" items="${s_class }">
			                        <option value="${item.id }">${item.name }</option> 
		                        </c:forEach>
		                        </select> 
                       		</div> 
                     		</div> 
                   		</span>
                	</td>
                	<td><input type="submit" name="button" class="btn btn82 btn_search" value="查询"></td>
                	<td><input type="button" name="button" class="btn btn82 btn_add add_" value="新增"></td>
               	</tr>
				</table>
               	</form>
 			</div>
		</div>
	</div>
</div>
<div id="table" class="mt10">
	<div class="box span10 oh">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
			<tr>
           		<th width="5%">编号</th>
           		<th width="5%">ID</th>
           		<th width="15%">姓名</th>
           		<th width="15%">学号</th>
           		<th width="10%">性别</th>
           		<th>所在班级</th>
         		<th width="20%">操作</th>
            </tr>
            <c:if test="${pager.totalRecord == 0 }">
				<tr><td colspan="7" align="center">暂无记录</td></tr>
			</c:if>
            <c:forEach items="${pager.datas}" var="d" varStatus="v">
				<tr class="tr">
					<td class="td_center">${v.index + 1 }</td>
					<td class="td_center">${d.id }</td>
					<td class="td_center">${d.name }</td>
					<td class="td_center">${d.num }</td>
					<td class="td_center">
						<c:if test="${d.sex eq 1}">男神</c:if>
						<c:if test="${d.sex eq 2}">女神</c:if>
					</td>
					<td class="td_center">
                        <c:forEach var="item" items="${s_class }">
                        	<c:if test="${d.cid eq item.id}">${item.name }</c:if>
                        </c:forEach>
					</td>
					<td class="td_center">
						<input type="button" data="${d.id }" class="ext_btn ext_btn_success edit_" value="编辑">
						<input type="button" data="${d.id }" class="ext_btn ext_btn_error delete_" value="删除">
						<input type="button" data="${d.id }" class="ext_btn ext_btn_success fetch_" value="查看学生">
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<jsp:include page="../common/pager.jsp">
			<jsp:param value="${ctx }/student/list.html" name="url"/>
			<jsp:param value="${pager.totalRecord }" name="items"/>
		</jsp:include>
	</div>
</div>

</div> 
<script type="text/javascript">
$(function(){
	// 下拉框
	$('#_cid').val('${entity.cid}');
	// 单选
	$(":radio[name='student.sex'][value='${student.sex}']").attr("checked","checked");
});

var delete_id;
$(function(){
	$(".add_").click(function(){
        ymPrompt.win({title:'添加',height:'300',width:'500',dragOut:false,iframe:true,message:'${ctx}/student/toAdd.html',handler:refresh});
    })
    
	$(".edit_").click(function(){
        var id = $(this).attr("data");
        ymPrompt.win({title:'添加',height:'300',width:'500',dragOut:false,iframe:true,message:'${ctx}/student/toUpdate.html?student.id=' + id,handler:refresh});
    })
    
	$(".fetch_").click(function(){
        var id = $(this).attr("data");
        window.location.href='${ctx}/course/toList.html?course.sid=' + id;
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
            url : '${ctx}/student/delete.html?student.id=' + delete_id,
            dataType : "text",
            success : function(result) {
				refresh();
            }
        });
	}
}

// 刷新页面
function refresh(){
	self.location.href="${ctx}/student/list.html";
}
</script>
</body>
</html>