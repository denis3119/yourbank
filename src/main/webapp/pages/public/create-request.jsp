<div class="create-request-content">
  <div class="col-md-offset-3 col-md-6 well well-sm">
    <form class="form-horizontal" name="createRequestForm" ng-submit="request.submit(createRequestForm)">
      <div class="form-group">
        <label class="col-sm-2 control-label">First name</label>
        <div class="col-md-10">
          <input class="form-control" type="text" ng-model="request.request.firstName">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Last name</label>
        <div class="col-md-10">
          <input class="form-control"  type="text" ng-model="request.request.lastName">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Patronymic</label>
        <div class="col-md-10">
          <input class="form-control"  type="text" ng-model="request.request.patronymic">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Email</label>
        <div class="col-md-10">
          <input class="form-control"  type="email" ng-model="request.request.email">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">Phone</label>
        <div class="col-md-10">
          <input class="form-control"  type="text" ng-model="request.request.phone">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-md-10">
          <button class="btn btn-success" type="submit">Create request</button>
        </div>
      </div>
    </form>
  </div>
</div>