<div class="modal-header">
  <h3 class="modal-title">Edit profile</h3>
</div>

<div class="modal-body">
  <form class="form-horizontal" name="editProfileForm">
    <div class="form-group">
      <label class="col-sm-3 control-label">Email</label>
      <div class="col-md-5">
        <input class="form-control" required type="email" ng-model="user.email">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Phone</label>
      <div class="col-md-5">
        <input class="form-control" required ui-mask="+99999-999-99-99" type="tel" ng-model="user.phone">
      </div>
    </div>
  </form>
  <hr/>
  <form class="form-horizontal" name="changePasswordForm" ng-submit="changePassword()">
    <div class="form-group">
      <label class="col-sm-3 control-label">Change password</label>
      <div class="col-md-5">
        <input class="form-control" minlength="6" type="password" ng-model="newPassword">
      </div>
      <button type="submit" ng-disabled="!newPassword" class="btn btn-success">Change</button>
    </div>
  </form>
</div>

<div class="modal-footer">
  <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
  <button class="btn btn-primary" type="button" ng-click="$close(user)">Save</button>
</div>