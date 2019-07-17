<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="list-group">
<c:forEach items="${list}" var="employee">
    <li class="list-group-item">
        <div class="row">
            <div class="col-xs-2 col-md-1">
                <img src="<c:url value="/resources/img/no_avatar.jpg"/>" class="img-circle img-responsive" alt="" /></div>
            <div class="col-xs-10 col-md-11">
	            <div class="row" style="">
	            	<div class="name col-xs-10 col-md-10"><a href="employee/${employee.employee_id}">${employee.employee_id}</a></div>
	            	<div class="name col-xs-10 col-md-10"><a href="employee/${employee.employee_id}">${employee.employee_name}</a></div>
	            	<div class="col-xs-2 col-md-2">
	            		<div class="action pull-right">
			               <button type="button" onclick="location.href='employee/${employee.employee_id}/edit'" class="btn btn-primary btn-xs" title="Edit">
			                   <span class="glyphicon glyphicon-pencil"></span>
			               </button>
			               <button type="button" class="btn btn-success btn-xs" title="Approved">
			                   <span class="glyphicon glyphicon-ok"></span>
			               </button>
			               <button type="button" class="btn btn-danger btn-xs" title="Delete">
			                   <span class="glyphicon glyphicon-trash"></span>
			               </button>
	              		</div>
	          		</div>
	          	</div>
                <div class="mic-info">
                    <a href="#">Department</a> | <a href="#">Position</a>
                </div>
            </div>
        </div>
    </li>
</c:forEach>
</ul>


