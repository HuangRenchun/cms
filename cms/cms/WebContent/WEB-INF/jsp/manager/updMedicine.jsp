<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jquery.form异步提交 -->
<script>
$(function(){
	var fram=$("#updMedicineForm")
	fram.off();
	fram.on("submit",function(){
		fram.ajaxSubmit(function(){
			fram[0].reset();
			alert("修改成功！");
			 $(".baseUI li :contains('库存药品管理')").trigger("click");
		})
		
		return false;
	})
	
})
</script>
<h1>修改药品页面</h1>
<hr>
<form action="updMedicine.action" method="post" id="updMedicineForm">
    <ul>
   <li>  <input type="hidden" name="id" value="${medicine.id }"/></li>
  <li style="padding:10px">入库编号:<input type="text" name="code" value="${medicine.code }"></li>
  <li style="padding:10px">入 库 员:<input type="text" name="operator" value="${medicine.operator }"></li>
  <li style="padding:10px">药品名称:<input type="text" name="name" value="${medicine.name }"></li>
  <li style="padding:10px">生产厂商:<input type="text" name="manufacturer" value="${medicine.manufacturer }"></li>
  <li style="padding:10px">有效期限:<input type="text" name="effectiveDate" value="${medicine.effectiveDate }"></li>
  <li style="padding:10px">销售单价:<input type="text" name="salePrice" value="${medicine.salePrice }">元</li>
  <li style="padding:10px">进货单价:<input type="text" name="purchasePrice" value="${medicine.purchasePrice }">元</li>
  <li style="padding:10px">入库数量:<input type="text" name="number" value="${medicine.number }"></li>
  <li style="padding:10px">适 应 症:<input type="text" name="indication" value="${medicine.indication }"></li>
  <li style="padding:10px"><input type="submit" value="提交">
      </li>
  </ul>
   </form>