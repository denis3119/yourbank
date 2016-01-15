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
      <label class="col-sm-3 control-label" uib-tooltip="Personal number" tooltip-placement="bottom">Personal number</label>
      <div class="col-md-7">
        <input class="form-control" required type="text" ng-model="credit.personalNumber">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label" uib-tooltip="Passport number" tooltip-placement="bottom">Passport number</label>
      <div class="col-md-7">
        <input class="form-control" required type="text" ng-model="credit.passportNumber">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Credit sum</label>
      <div class="col-md-7">
        <input class="form-control" required type="number" ng-model="credit.sum">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Credit period</label>
      <div class="col-md-7">
        <input class="form-control" required type="number" ng-model="credit.period">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">Credit percent</label>
      <div class="col-md-7">
        <input class="form-control" required type="number" ng-model="credit.percent">
      </div>
    </div>
  </form>
</div>

<div class="modal-footer">
  <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
  <button class="btn btn-primary" type="button" ng-click="$close(credit)">Save</button>
</div>