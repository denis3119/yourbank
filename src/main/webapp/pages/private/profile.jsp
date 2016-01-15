<div class="tab-content col-md-offset-1 col-md-10">
  <div class="row well well-lg">
    <h1 class="text-center">Profile info</h1>
  </div>
  <div class="row well well-sm">
    <ul class="nav nav-pills nav-stacked col-md-2">
      <li data-toggle="tab" role="presentation" class="active">
        <a href="javascript:void(0)" ng-click="profile.view = 'general'">General</a>
      </li>
      <li data-toggle="tab" role="presentation">
        <a href="javascript:void(0)" ng-click="profile.view = 'credits'">Credits</a>
      </li>
    </ul>
    <div class="tab-content">
      <div ng-if="profile.view == 'general'" class="col-md-offset-1 col-md-9">
        <ul class="list-group col-md-9">
          <li class="list-group-item"><strong>First name: </strong><em>{{global.current.user.userProfile.firstName}}</em></li>
          <li class="list-group-item"><strong>Last name: </strong><em>{{global.current.user.userProfile.lastName}}</em></li>
          <li class="list-group-item"><strong>Patronymic: </strong><em>{{global.current.user.userProfile.patronymic}}</em></li>
          <li class="list-group-item"><strong>Personal number: </strong><em>{{global.current.user.userProfile.personalNumber}}</em></li>
          <li class="list-group-item"><strong>Passport number: </strong><em>{{global.current.user.userProfile.passportNumber}}</em></li>
        </ul>
        <div class="col-md-3">
          <button ng-click="profile.editUser()" class="btn btn-default form-control">Edit</button>
        </div>
      </div>

      <div ng-if="profile.view == 'credits'" class="col-md-10">
        <div class="col-md-3">
          <h3>Filters</h3>
        </div>
        <div class="col-md-9">
          <div class="col-md-9 well well-sm" style="margin-left: 1%" cg-busy="profile.busy">
            <uib-accordion>
              <uib-accordion-group ng-class="{'panel-success': credit.paid, 'panel-danger': !credit.paid}"
                                   heading="Credit {{credit.id}}" ng-repeat="credit in global.current.user.userProfile.userCredits
                                 | filter:search | filter:{expired: false}">
                <ul class="list-group">
                  <li class="list-group-item"><strong>Name: </strong><em>{{credit.name}}</em></li>
                  <li class="list-group-item"><strong>Percent: </strong><em>{{credit.percent}}</em></li>
                  <li class="list-group-item"><strong>Term: </strong><em>{{credit.term}}</em></li>
                </ul>
                <br/>
                <div ng-if="!(global.current.user.userProfile.userCredits.accruals | filter:search | filter:{ paid:false, expired: false}).length">
                  <button class="btn-default btn">Pay</button>
                </div>
              </uib-accordion-group>
            </uib-accordion>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

