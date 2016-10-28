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
		 var id=$(this).attr("val");
		$(".right").load("toUpdMedicine.action",{id:id});
		
	 });
	 
	 $(".del").off();
	 $(".del").on("click",function(){
		 var flag=confirm("确定要删除吗");
		 if(flag){
		 var id=$(this).attr("val");//获取id
		 $.post("delMedicine.action",{id:id},function(){
			 alert("删除成功");
			 $(".baseUI li :contains('库存药品管理')").trigger("click");
		 });
		 }
	 });
  });
</script>

<h1>药品管理</h1>
<hr>
<table border="1" style="width: 100%;border-collapse:collapse;margin-top: 10px">
  <tr>
     <th>序号</th>
     <th>入库编号</th>
     <th>入 库 员</th>
     <th>药品名称</th>
     <th>生产厂商</th>
     <th>有效日期</th>
     <th>销售单价</th>
     <th>进货单价</th>
     <th>入库数量</th>
     <th>适 应 症</th>
     <th>操作</th>
  </tr>
  <c:forEach items="${medicineList }" var="c">
  <tr>
     <td><input type="checkbox" value="${c.id }"/></td>
     <td>${c.code }</td>
     <td>${c.operator }</td>
     <td>${c.name }</td>
     <td>${c.manufacturer }</td>
     <td>${c.effectiveDate }</td>
     <td>${c.salePrice }</td>
     <td>${c.purchasePrice }</td>
     <td>${c.number }</td>
     <td>${c.indication }</td>
     <td><a href="javascript:void(0);" val="${c.id }" class="upd" >修改</a>|
     <a href="javascript:void(0);" val="${c.id }"class="del">删除</a>
     </td>
  </tr>
  </c:forEach>
</table>



