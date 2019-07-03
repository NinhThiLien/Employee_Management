<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-6">
							<h3>Login</h3>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<c:if test="${param.error == 'true'}">
         						<div style="color:red;margin:10px 0px;">
          
                					Login Failed!!!<br />
                					Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         						</div>
    						</c:if>
							<form id="login-form" action="${pageContext.request.contextPath}/login_check" method="post" role="form" style="display: block;">
								<div class="form-group">
									<input type="text" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
								</div>
								<div class="form-group">
									<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
								</div>
								<div class="form-group text-center">
									<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
									<label for="remember"> Remember Me</label>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" name="submit" id="submit" tabindex="4" class="form-control btn btn-login" value="submit">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="#" tabindex="5" class="forgot-password">Forgot Password?</a>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>