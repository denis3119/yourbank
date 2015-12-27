<div class="login-content">
    <form class="public-form register" name="registerForm" ng-submit="register.submit(registerForm)" novalidate>
        <div class="form-group"
             ng-class="{ 'has-error': (registerForm.login.$touched || registerForm.login.$dirty) && registerForm.login.$invalid }">
            <input type="text" name="username" class="form-control" ng-model="register.user.username">
        </div>

        <div class="form-group"
             ng-class="{ 'has-error': (registerForm.email.$touched || registerForm.email.$dirty) && registerForm.email.$invalid }">
            <input type="email" name="email" class="form-control" ng-model="register.user.email">
        </div>

        <div class="form-group"
             ng-class="{ 'has-error': (registerForm.password.$touched || registerForm.password.$dirty) && registerForm.password.$invalid }">
            <input type="password" name="password" class="form-control" ng-model="register.user.password">
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <span>Register</span>
        </button>
    </form>
</div>