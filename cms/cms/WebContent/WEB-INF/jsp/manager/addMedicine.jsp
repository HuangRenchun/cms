<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
ul{
	list-style: none;
	padding-top:100px;
	padding-left:345px;
	
}

</style>
    <!-- jquery.form异步提交 -->
<script>
$(function(){
	var form=$("#addMedicineForm")
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			//form.not(":submit").val("");
			form[0].reset();
			alert("添加成功！");
		});
		
		return false;
	});
	
});
</script>
<h1>药品入库</h1>
<hr>
<form action="addMedicine.action"method="post" id="addMedicineForm">
<ul>
  <li style="padding:10px">入库编号:<input type="text" name="code"></li>
  <li style="padding:10px">入 库 员:<input type="text" name="operator"></li>
  <li style="padding:10px">药品名称:<input type="text" name="name"></li>
  <li style="padding:10px">生产厂商:<input type="text" name="manufacturer"></li>
  <li style="padding:10px">有效期限:<input type="text" name="effectiveDate"></li>
  <li style="padding:10px">销售单价:<input type="text" name="salePrice">元</li>
  <li style="padding:10px">进货单价:<input type="text" name="purchasePrice">元</li>
  <li style="padding:10px">入库数量:<input type="text" name="number"></li>
  <li style="padding:10px">适 应 症:<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="indication" rows="10" cols="20"></textarea></li>
  <li style="padding:10px"><input type="submit" value="提交">
      </li>
  </ul>
</form>