<div class="manager-content">
    <div class="well well-sm">
        <div ng-if="!manager.requests.length">
            No request found
        </div>
        <uib-accordion>
            <uib-accordion-group ng-class="{'panel-success': request.status == 'APPROVED', 'panel-danger': request.status == 'DECLINED'}"
                                 heading="Request number {{request.id}}" ng-repeat="request in manager.requests">
                <ul class="list-group">
                    <li class="list-group-item"><strong>First name: </strong><em>{{request.firstName}}</em></li>
                    <li class="list-group-item"><strong>Last name: </strong><em>{{request.lastName}}</em></li>
                    <li class="list-group-item"><strong>Patronymic: </strong><em>{{request.patronymic}}</em></li>
                    <li class="list-group-item"><strong>Email: </strong><em>{{request.email}}</em></li>
                    <li class="list-group-item"><strong>Credit name: </strong><em>{{request.credit.name}}</em></li>
                    <li class="list-group-item"><strong>Credit period: </strong><em>{{request.period}}</em></li>
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