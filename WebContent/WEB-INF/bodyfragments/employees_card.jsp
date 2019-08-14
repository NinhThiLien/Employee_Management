<%@ page import="com.hrsmanager.model.EmployeeInfo, com.hrsmanager.dao.impl.*,java.util.List" %>
<style>
#team .card {
    border: none;
    background: #ffffff;
}

.image-flip:hover .backside,
.image-flip.hover .backside {
    -webkit-transform: rotateY(0deg);
    -moz-transform: rotateY(0deg);
    -o-transform: rotateY(0deg);
    -ms-transform: rotateY(0deg);
    transform: rotateY(0deg);
    border-radius: .25rem;
}

.image-flip:hover .frontside,
.image-flip.hover .frontside {
    -webkit-transform: rotateY(180deg);
    -moz-transform: rotateY(180deg);
    -o-transform: rotateY(180deg);
    transform: rotateY(180deg);
}

.mainflip {
    -webkit-transition: 1s;
    -webkit-transform-style: preserve-3d;
    -ms-transition: 1s;
    -moz-transition: 1s;
    -moz-transform: perspective(1000px);
    -moz-transform-style: preserve-3d;
    -ms-transform-style: preserve-3d;
    transition: 1s;
    transform-style: preserve-3d;
    position: relative;
}

.frontside {
    position: relative;
    -webkit-transform: rotateY(0deg);
    -ms-transform: rotateY(0deg);
    z-index: 2;
    margin-bottom: 30px;
}

.backside {
    position: absolute;
    top: 0;
    left: 0;
    background: white;
    -webkit-transform: rotateY(-180deg);
    -moz-transform: rotateY(-180deg);
    -o-transform: rotateY(-180deg);
    -ms-transform: rotateY(-180deg);
    transform: rotateY(-180deg);
    -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
}

.frontside,
.backside {
    -webkit-backface-visibility: hidden;
    -moz-backface-visibility: hidden;
    -ms-backface-visibility: hidden;
    backface-visibility: hidden;
    -webkit-transition: 1s;
    -webkit-transform-style: preserve-3d;
    -moz-transition: 1s;
    -moz-transform-style: preserve-3d;
    -o-transition: 1s;
    -o-transform-style: preserve-3d;
    -ms-transition: 1s;
    -ms-transform-style: preserve-3d;
    transition: 1s;
    transform-style: preserve-3d;
}

.frontside .card,
.backside .card {
    min-height: 312px;
    min-width: 356px;
}

.frontside .card .card-body,
.backside .card .card-body {
    padding: 20px;
    font-size: 16px;
}

.backside .card a {
    font-size: 18px;
    color: #007b5e !important;
}

.frontside .card .card-title,
.backside .card .card-title {
    color: #007b5e !important;
    font-size: 27px;
    font-weight: bold;
}

.frontside .card .card-body img {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}
</style>
<div class="list-group">
	<section id="team" class="pb-5">
		<div class="row">
		<c:forEach items="${list}" var="employee">
			<div class="col-xs-12 col-sm-6 col-md-4">
	           <div class="image-flip">
	               <div class="mainflip">
	                   <div class="frontside">
	                       <div class="card">
	                           <div class="card-body text-center">
	                               <p><img class=" img-fluid" src="<c:url value="/resources/img/no_avatar.jpg"/>" alt="card image"></p>
	                               <h4 class="card-title">${employee.employee_id}</h4>
	                               <h4 class="card-title">${employee.employee_name}</h4>
	           	               	   <a href="employee/${employee.employee_id}" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></a>
	                           </div>
	                       </div>
	                   </div>
	                   <div class="backside">
	                       <div class="card">
	                           <div class="card-body text-center mt-4">
	                               <a href="employee/${employee.employee_id}"><h4 class="card-title">${employee.employee_name}</h4></a>
	                               <p class="card-text">
	                               <ul>
	                               <li type=none>Birthday: ${employee.birthday}</li>
	                               <li type=none>Email: ${employee.email}</li>
	                               <li type=none>Address: ${employee.address}</li>
	                               <li type=none>
	                               		<c:forEach items="${listDepartments}" var="dep">
	                               			<c:if test="${dep.department_id == employee.department_id}">
	                  	            			Department: ${dep.department_name}
	                               			</c:if>
	                               		</c:forEach></li>
	                               <li type=none>
	                               		<c:forEach items="${listPositions}" var="posi">
	                               			<c:if test="${posi.position_id == employee.position_id}">
	                  	            			Positon: ${posi.position_name}
	                               			</c:if>
	                               		</c:forEach></li>
	                               </ul>
	                               </p>
	                               
	                    		   <div class="action pull-right">
			               				<button type="button" onclick="location.href='employee/${employee.employee_id}/edit'" class="btn btn-primary btn-xs" title="Edit">
			                   				<span class="glyphicon glyphicon-pencil"></span>
			               				</button>
			               				<button type="button" class="btn btn-danger btn-xs" title="Delete">
			                   				<span class="glyphicon glyphicon-trash"></span>
			               				</button>
	              					</div>                              
	                           </div>
	                       </div>
	                   </div>
	               </div>
	           </div>
	       </div>  
		</c:forEach>
		</div>
	</section>
</div>

<div>
	<ul>
		<% 
			int total_pages= (int)session.getAttribute("total_pages");
			for(int k = 1 ; k<=total_pages; k++){
				request.setAttribute("pageid", k); %>
			<ul>
				<li><a href="${pageContext.request.contextPath}/employees"><%=k%></a></li>
			</ul>
		<% }%>
	</ul>
</div>
 