<div class="manager-content">
    <div class="well well-sm">
        <div ng-if="!manager.requests.length">
            No request found
        </div>
        <uib-accordion>
            <uib-accordion-group heading="Request number {{request.id}}" ng-repeat="request in manager.requests">
                <ul class="list-group">
                    <li class="list-group-item"><strong>First name: </strong><em>{{request.firstName}}</em></li>
                    <li class="list-group-item"><strong>Last name: </strong><em>{{request.lastName}}</em></li>
                    <li class="list-group-item"><strong>Patronymic: </strong><em>{{request.patronymic}}</em></li>
                    <li class="list-group-item"><strong>Email: </strong><em>{{request.email}}</em></li>
                    <li class="list-group-item"><strong>Credit name: </strong><em>{{request.credit.name}}</em></li>
                    <li class="list-group-item"><strong>Credit period: </strong><em>{{request.period}}</em></li>
                </ul>
                <br/>
                <button class="btn btn-success" ng-click="manager.approve">Approve</button>
                <button class="btn btn-danger" ng-click="manager.decline">Decline</button>
            </uib-accordion-group>
        </uib-accordion>

    </div>
</div>