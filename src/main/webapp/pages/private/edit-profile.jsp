<div class="modal-header">
  <h3 class="modal-title">Edit profile</h3>
</div>

<div class="modal-body">
  <form class="form-horizontal" name="createCreditForm">
    <div class="form-group">
      <label class="col-sm-3 control-label">First name</label>
      <div class="col-md-8">
        <input class="form-control" disabled type="text" ng-model="user.userProfile.firstName">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3  control-label">Last name</label>
      <div class="col-md-8">
        <input class="form-control" disabled type="text" ng-model="user.userProfile.lastName">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Patronymic</label>
      <div class="col-md-8">
        <input class="form-control" disabled type="text" ng-model="user.userProfile.patronymic">
      </div>
    </div>
  </form>
  <br/>
  <form class="form-horizontal" name="changePasswordForm" ng-submit="changePassword()">
    <div class="form-group">
      <label class="col-sm-3 control-label">Change password</label>
      <div class="col-md-5">
        <input class="form-control" type="password" ng-model="newPassword">
      </div>
      <button type="submit" ng-disabled="!newPassword" class="btn btn-success">Change</button>
    </div>
  </form>
</div>

<div class="modal-footer">
  <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
  <button class="btn btn-primary" type="button" ng-click="$close(user)">Save</button>
</div>