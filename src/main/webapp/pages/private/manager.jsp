<div class="manager-content">
    <div class="col-md-2 well well-sm">
        <fieldset class="form-horizontal">
            <legend>Filters</legend>
            <div class="form-group">
                <div class="col-md-12">
                    <input type="text" class="form-control" ng-model="search.$">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3">
                    <label class="control-label">Status</label>
                </div>
                <div class="col-md-9">
                    <select class="form-control" ng-model="filter.status">
                        <option>Approved</option>
                        <option selected="selected">Pending</option>
                        <option>Declined</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-3">
                    <label class="control-label">Period</label>
                </div>
                <div class="col-md-9">
                    <input type="number" class="form-control" ng-model="filter.period">
                </div>
            </div>
        </fieldset>
    </div>
    <div class="col-md-9 well well-sm" style="margin-left: 1%" cg-busy="manager.busy">
        <div ng-if="!(manager.requests | filter:search | filter:{status: filter.status, period: filter.period, expired: false}).length">
            No requests found
        </div>
        <uib-accordion>
            <uib-accordion-group ng-class="{'panel-success': request.status == 'APPROVED', 'panel-danger': request.status == 'DECLINED'}"
                                 heading="Request number {{request.id}}" ng-repeat="request in manager.requests
                                 | filter:search | filter:{status: filter.status, period: filter.period, expired: false}">
                <ul class="list-group">
                    <li class="list-group-item"><strong>FIO: </strong><em>{{request.firstName}} {{request.lastName}} {{request.patronymic}}</em></li>
                    <li class="list-group-item"><strong>Email: </strong><em>{{request.email}}</em></li>
                    <li class="list-group-item"><strong>Credit name: </strong><em>{{request.credit.name}}</em></li>
                    <li class="list-group-item"><strong>Credit sum: </strong><em>{{request.sum}}</em></li>
                    <li class="list-group-item"><strong>Credit period: </strong><em>{{request.period}}</em></li>
                    <li class="list-group-item"><strong>Target: </strong><em>{{request.target}}</em></li>
                </ul>
                <br/>
                <div ng-if="request.status == 'PENDING'">
                    <button class="btn btn-success" ng-click="manager.approve(request)">Approve</button>
                    <button class="btn btn-danger" ng-click="manager.decline(request)">Decline</button>
                </div>
                <div ng-if="request.status == 'APPROVED'">
                    <button class="btn btn-success" ng-click="manager.createCredit(request)">Create credit</button>
                </div>
            </uib-accordion-group>
        </uib-accordion>
    </div>
</div>