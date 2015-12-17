<div align="center">
    <form username="registerForm">
        <div class="form-group">
            <label>User username: </label>
            <input type="text" ng-model="user.username"/>
        </div>
        <input type="submit" ng-click="update(user)" value="Register"/>
    </form>
</div>