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


      <div ng-if="profile.view == 'general'" class="col-md-offset-1 col-md-7">


        <ul class="list-group">
          <li class="list-group-item"><strong>First name: </strong><em>{{global.current.user.userProfile.firstName}}</em></li>
          <li class="list-group-item"><strong>Last name: </strong><em>{{global.current.user.userProfile.lastName}}</em></li>
          <li class="list-group-item"><strong>Patronymic: </strong><em>{{global.current.user.userProfile.patronymic}}</em></li>
          <li class="list-group-item"><strong>Birthday date: </strong><em>{{global.current.user.userProfile.birthday}}</em></li>
          <li class="list-group-item"><strong>Personal number: </strong><em>{{global.current.user.userProfile.personalNumber}}</em></li>
          <li class="list-group-item"><strong>Passport number: </strong><em>{{global.current.user.userProfile.passportNumber}}</em></li>
        </ul>

      </div>
        <button ng-click="profile.editUser()" class="btn btn-default">Edit</button>
      <div ng-if="profile.view == 'credits'" class="col-md-10">
        <div class="col-md-3">
          <h3>Filters</h3>
        </div>
        <div class="col-md-9">
          adfasdfasdf
        </div>
      </div>
    </div>
  </div>
</div>

