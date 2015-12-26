<div class="login-content">
    <form class="public-form login" name="loginForm" ng-submit="login.submit(loginForm)" novalidate>
        <div class="form-group"
             ng-class="{ 'has-error': (loginForm.login.$touched || loginForm.login.$dirty) && loginForm.login.$invalid }">
            <input type="text" class="form-control" ng-model="login.user.username">
        </div>

        <div class="form-group"
             ng-class="{ 'has-error': (loginForm.password.$touched || loginForm.password.$dirty) && loginForm.password.$invalid }">
            <input type="password" class="form-control" ng-model="login.user.password">
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <span>Login</span>
        </button>
    </form>
</div>