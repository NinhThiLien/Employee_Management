<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.widget .panel-body { padding:20px; background: #eee !important;}
.widget .list-group { margin-bottom: 0; }
.widget .panel-title { display:inline }
.widget .label-info { float: right; }
.widget li.list-group-item {border-radius: 12px; border: 1px solid #ddd; margin-bottom: 20px;}
.widget li.list-group-item:hover { background-color: rgba(86,61,124,.1); }
.widget .mic-info { color: #666666;font-size: 12px; }
.widget .comment-text { font-size: 12px; }
.widget .action button { 
	min-height: 28px;
	min-width: 28px;
}
.panel .panel-body .list-group .list-group-item .row {
	margin-top: 10px;
	margin-bottom: 10px;
}
.name {
	font-size: 20px;
}
</style>

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<button class="dropdown btn btn-default dropdown-toggle">
				<span>Sort by</span>
				<div class="dropdown-content">
					<p>ASC Users</p>
					<p>DESC Users</p>
					<p>ASC Departments</p>
					<p>DESC Departments</p>
				</div>
			</button>
		</div>
		
		<div class="col-md-1">
	        <button type="button" class="button2" onclick="location.href='employee/new'" title="Add">
	            <span class="glyphicon glyphicon-plus"></span> Add
	        </button>
        </div>
        
        <div class="col-md-4">
	        <div id="custom-search-input">
	        	<div class="input-group">
	        		<input type="text" class="search-query form-control" placeholder="Search" />
	        		<span class="input-group-btn">
	        			<button class="btn btn-danger" type="button">
	        				<span class=" glyphicon glyphicon-search"></span>
	        			</button>
	        		</span>
	        	</div>
	        </div>
        </div>
		<% String type = null; %>
		<div class="col-md-1" style="padding:0px">
	        <a href="${pageContext.request.contextPath}/list">
				<img src="<c:url value="/resources/img/button_list.png"/>" alt="" width="42" height="42"/>
			</a>
	        <a href="${pageContext.request.contextPath}/card">
	        	<% type = "card"; %>
	        	<%request.setAttribute("type",type); %>
				<img src="<c:url value="/resources/img/button_card.png"/>" alt="" width="42" height="42">
			</a>
        </div>
	</div>
	
    <div class="row" style="margin-top:50px;">
        <div class="panel panel-default widget">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-comment"></span>
                <h3 class="panel-title">
                    All Users</h3>
                <span class="label label-info">
                    78</span>
            </div>
            <div class="panel-body">
            	<%if ((String) request.getAttribute("type") == "card"){ %>
                	<%@include file="employees_list.jsp"%>
                <%} else {%>
                	<%@include file="employees_list.jsp"%>
                <%} %>
            </div>
        </div>
    </div>
</div>