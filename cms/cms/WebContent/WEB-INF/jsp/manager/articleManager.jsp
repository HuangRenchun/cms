<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  th{
    background:lightblue;
  }
  td{
    text-align:center;
    font-famliy:宋体；
    font-size:14px;
  }
</style>
<script>
  $(function(){
	 $(".upd").off();
	 $(".upd").on("click",function(){
		 alert("功能没完成");
	 });
	 
	 $(".del").off();
	 $(".del").on("click",function(){
		 var flag=confirm("确定要删除吗");
		 if(flag){
		 var id=$(this).attr("val");//获取id
		 $.post("delArticle.action",{id:id},function(){
			 alert("删除成功");
			 $(".baseUI li :contains('栏目管理')").trigger("click");
		 });
		 }
	 });
  });
</script>
<h1>栏目管理</h1>
<hr>
<table border="1" style="width: 100%;border-collapse:collapse;margin-top: 10px">
  <tr>
     <th>编号</th>
     <th>标题</th>
     <th>作者</th>
     <th>发布时间</th>
     <th>点击次数</th>
     <th>操作</th>
  </tr>
  <c:forEach items="${articleList }" var="c">
  <tr>
     <td><input type="checkbox" value="${c.id }"/></td>
     <td>${c.title }</td>
     <td>${c.auther }</td>
     <td>${c.publisurDate }</td>
     <td>${c.clickTimes }</td>
     <td><a href="javascript:void(0);" val="${c.id }"class="upd">修改</a>|
     <a href="javascript:void(0);" val="${c.id }"class="del">删除</a>
     </td>
  </tr>
  </c:forEach>
</table>