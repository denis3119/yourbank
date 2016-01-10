<div class="manager-content">
    <div class="well well-sm">
        <uib-accordion>
            <uib-accordion-group heading="tipo info o zaiavke" ng-repeat="request in manager.requests">
                <span>info info info</span>
                <br/>
                <button class="btn btn-success" ng-click="manager.approve">Approve</button>
                <button class="btn btn-danger" ng-click="manager.decline">Decline</button>
            </uib-accordion-group>
        </uib-accordion>

    </div>
</div>