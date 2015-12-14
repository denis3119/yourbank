<div align="center">
    <form name="registerForm">
        <div class="form-group">
            <label>User name: </label>
            <input type="text" ng-model="user.name"/>
        </div>
        <input type="submit" ng-click="update(user)" value="Register"/>
    </form>
</div>