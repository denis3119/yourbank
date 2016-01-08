<div class="login-content col-md-offset-3 col-md-6 well well-lg">
    <form class="public-form login" name="loginForm" ng-submit="login.submit(loginForm)" action="/login" method="post">
        <div class="row">
            <label class="col-md-3" for="login_username">Email:</label>
            <div class="col-md-9 form-group"
                 ng-class="{ 'has-error': (loginForm.email.$touched || loginForm.email.$dirty) && loginForm.email.$invalid }">
                <input type="text" id="login_username" name="username" required placeholder="Username"
                       class="form-control" ng-model="login.user.username">
            </div>
        </div>

        <div class="row">
            <label class="col-md-3" for="login_password">Password:</label>
            <div class="col-md-9 form-group"
                 ng-class="{ 'has-error': (loginForm.password.$touched || loginForm.password.$dirty) && loginForm.password.$invalid }">
                <input type="password" id="login_password" name="password" required placeholder="Password"
                       class="form-control" ng-model="login.user.password">
            </div>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <span>Login</span>
        </button>
    </form>
</div>