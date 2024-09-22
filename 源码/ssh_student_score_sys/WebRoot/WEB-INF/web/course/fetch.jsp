<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx }/resources/css/common.css">
<link rel="stylesheet" href="${ctx }/resources/css/main.css">
<script type="text/javascript" src="${ctx }/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/common.js"></script>
<script type="text/javascript" src="${ctx }/resources/prompt/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="${ctx }/resources/prompt/skin/qq/ymPrompt.css" />
  
<div class="container">
	<div id="forms" class="mt10">
		<div class="box">
			<div class="box_border">
				<div class="box_center">
					<form action="${ctx }/course/update.html" class="jqtransform" onsubmit="return toVaild()" method="post">
					<input type="hidden" name="course.id" value="${entity.id }">
					<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="td_right">数学：</td>
							<td><input type="number" name="course.num1" id="num1" class="input-text lh30" size="40" maxlength="20" value="${entity.num1 }"></td>
						</tr>
						<tr>
							<td class="td_right">语文：</td>
							<td><input type="number" name="course.num2" id="num2" class="input-text lh30" size="40" maxlength="20" value="${entity.num2 }"></td>
						</tr>
						<tr>
							<td class="td_right">英语：</td>
							<td><input type="number" name="course.num3" id="num3" class="input-text lh30" size="40" maxlength="20" value="${entity.num3 }"></td>
						</tr>
						<tr>
							<td class="td_right">物理：</td>
							<td><input type="number" name="course.num4" id="num4" class="input-text lh30" size="40" maxlength="20" value="${entity.num4 }"></td>
						</tr>
						<tr>
							<td class="td_right">化学：</td>
							<td><input type="number" name="course.num5" id="num5" class="input-text lh30" size="40" maxlength="20" value="${entity.num5 }"></td>
						</tr>
						<tr>
							<td class="td_right">备注：</td>
							<td><input type="text" name="course.content" id="content" class="input-text lh30" size="40" maxlength="20" value="${entity.content }"></td>
						</tr>
         				<tr>
              				<td class="td_right">&nbsp;</td>
               				<td class="">
                				<input type="submit" name="button" class="btn btn82 btn_save2" value="保存"> 
               					<input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
               					<span id="err" style="color: red;text-align: center;">${msg }</span>
               				</td>
              			</tr>
           			</table>
           			</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function toVaild(){
	var num1 = $('#num1').val().trim();
	if (num1.length == 0){
		$('#err').text('数学不能为空');
		return false;
	}
	var num2 = $('#num2').val().trim();
	if (num2.length == 0){
		$('#err').text('语文不能为空');
		return false;
	}
	var num3 = $('#num3').val().trim();
	if (num3.length == 0){
		$('#err').text('英语不能为空');
		return false;
	}
	var num4 = $('#num4').val().trim();
	if (num4.length == 0){
		$('#err').text('物流不能为空');
		return false;
	}
	var num5 = $('#num5').val().trim();
	if (num5.length == 0){
		$('#err').text('化学不能为空');
		return false;
	}
	return true;
}
</script>