<div class="create-request-content">
  <div class="col-md-offset-3 col-md-6 well well-sm">
    <form class="form-horizontal" name="createCreditForm" ng-submit="$close(credit)">
      <div class="form-group">
        <label class="col-sm-2 control-label">FIO</label>
        <div class="col-md-10">
          <p class="form-control-static">{{credit.firstName}} {{credit.lastName}} {{credit.patronymic}}</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Email</label>
        <div class="col-md-10">
          <p class="form-control-static">{{credit.email}}</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Phone</label>
        <div class="col-md-10">
          <p class="form-control-static">+{{credit.phoneNumber}}</p>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Target</label>
        <div class="col-md-10">
          <input class="form-control" required type="text" ng-model="request.target">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label" uib-tooltip="In months" tooltip-placement="bottom">Period</label>
        <div class="col-md-10">
          <input class="form-control" required type="number" ng-model="request.period">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label" uib-tooltip="Personal number" tooltip-placement="bottom">Personal number</label>
        <div class="col-md-10">
          <input class="form-control" required type="text" ng-model="request.personalNumber">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label" uib-tooltip="Passport number" tooltip-placement="bottom">Passport number</label>
        <div class="col-md-10">
          <input class="form-control" required type="text" ng-model="request.passportNumber">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label" uib-tooltip="Passport number" tooltip-placement="bottom">Sum</label>
        <div class="col-md-10">
          <input class="form-control" required type="number" ng-model="request.sum">
        </div>
      </div>
  </form>
</div>
</div>

<div class="modal-footer">
  <button class="btn btn-danger" type="button" ng-click="$dismiss()">Cancel</button>
  <button class="btn btn-primary" type="button" ng-click="$close(credit)">Save</button>
</div>