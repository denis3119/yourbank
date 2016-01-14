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
        <div class="col-sm-offset-2 col-md-10">
          <button class="btn btn-success pull-right" type="submit">Create credit</button>
          <button class="btn btn-danger pull-right" style="margin-right: 1%" type="button" ng-click="$dismiss('qwerty')">Cancel</button>
        </div>
      </div>
    </form>
  </div>
</div>