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
      <li data-toggle="tab" role="presentation">
        <a href="javascript:void(0)" ng-click="profile.view = 'scores'">Deposits</a>
      </li>
    </ul>
    <div class="tab-content">
      <div ng-if="profile.view == 'general'" class="col-md-offset-1 col-md-7">
        <ul class="list-group">
          <li class="list-group-item">
            First name: <em>{{global.current.user.userProfile.firstName}}</em>
          </li>
          <li class="list-group-item">Last name: <em>{{global.current.user.userProfile.lastname}}</em></li>
          <li class="list-group-item">Patronymic: <em>{{global.current.user.userProfile.patronymic}}</em></li>
          <li class="list-group-item">Birthday date: <em>{{global.current.user.userProfile.bithday}}</em></li>
          <li class="list-group-item">Personal number: <em>{{global.current.user.userProfile.personalNumber}}</em></li>
          <li class="list-group-item">Passport number: <em>{{global.current.user.userProfile.passportNumber}}</em></li>
        </ul>
      </div>
      <div ng-if="profile.view == 'credits'" class="col-md-10">credits</div>
      <div ng-if="profile.view == 'scores'">scores</div>
    </div>
  </div>
</div>

