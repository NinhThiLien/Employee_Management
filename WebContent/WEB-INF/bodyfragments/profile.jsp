<div class="container">
    <div class="row">
  		<div class="col-sm-10"><h1 class="text-center">${emp.employee_name}</h1></div>
    </div><br><br>
    <div class="row">
  		<div class="col-sm-3"><!--left col-->
			<div class="text-center">
				<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
			</div><br><br><br>

			<div class="panel panel-default">
				<div class="panel-heading">Position</div>
				<div class="panel-body">${position}</div>
			</div>
		</div><!--/col-3-->
    	
    	<div class="col-sm-9">
        	<ul class="nav nav-tabs">
				<li class="active"><h4>Profile</h4></li>
             </ul>
             
             <div class="tab-content">
             	<div class="tab-pane active">
             	
             		<div class="form-horizontal">
             		
	             		<div class="form-group form-margin">
	             			<label class="col-sm-4 control-label" for="EmployeeID">EmployeeID</label>  
	             			<div class="col-sm-5">
	             				<h4 class="">
	             					${emp.employee_id}
	             				</h4>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Name (Full name)">Name (Full name)</label>  
	             			<div class="col-sm-5">
	             				<h4 class="">
	             					${emp.employee_name}
	             				</h4>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Date Of Birth">Date Of Birth</label>  
	             			<div class="col-sm-5">
	             				<h4 class="">
	             					${emp.birthday}
	             				</h4>
	             			</div>
	             		</div>
	             		
	             		<div class="form-group">
							<label class="col-sm-4 control-label" for="Gender">Gender</label>
							<div class="col-sm-5"> 
	             				<h4 class="">
	             					${emp.gender}
	             				</h4>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-4 control-label col-xs-12" for="Permanent Address">Permanent Address</label>  
							<div class="col-sm-5"> 
	             				<h4 class="">
	             					${emp.address}
	             				</h4>
							</div>
						</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Phone number">Phone number</label>
							<div class="col-sm-5"> 
	             				<h4 class="">
	             					${emp.phone}
	             				</h4>
							</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Email Address">Email Address</label>
							<div class="col-sm-5"> 
	             				<h4 class="">
	             					${emp.email}
	             				</h4>
							</div>
	             		</div>
	             		
	             		<div class="form-group">
	             			<label class="col-sm-4 control-label" for="Started Day">Started Day</label>
							<div class="col-sm-5"> 
	             				<h4 class="">
	             					${emp.started_day}
	             				</h4>
							</div>
	             		</div>
	             	</div>
             	</div>
             </div><!--/tab-content-->
		</div><!--/col-9-->
	</div><!--/row-->
</div>