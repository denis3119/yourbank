<div class="modal-header">
  <h3 class="modal-title">Create credit</h3>
</div>

<div class="modal-body">
  <form class="form-horizontal" name="createCreditForm">
    <div class="form-group">
      <label class="col-sm-3 control-label">FIO</label>
      <div class="col-md-7">
        <p class="form-control-static">{{credit.firstName}} {{credit.lastName}} {{credit.patronymic}}</p>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Email</label>
      <div class="col-md-7">
        <p class="form-control-static">{{credit.email}}</p>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Phone</label>
      <div class="col-md-7">
        <p class="form-control-static">+{{credit.phoneNumber}}</p>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Target</label>
      <div class="col-md-7">
        <input class="form-control" required type="text" ng-model="request.target">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label" uib-tooltip="In months" tooltip-placement="bottom">Period</label>
      <div class="col-md-7">
        <input class="form-control" required type="number" ng-model="request.period">
      </div>
    </div>
  </form>
</div>

<div class="modal-footer">
  <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
  <button class="btn btn-primary" type="button" ng-click="$close(credit)">Save</button>
</div>