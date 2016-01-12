(function () {

  angular.module('yourbank')
      .controller('AdminController', AdminController);

  function AdminController($http) {
    var vm = this;

    vm.users = [];
    vm.credits = [];

    (function () {
      $http.get('admin/users/all').then(function (data) {
        vm.users = data.data;
      })
    })();
  }
})();
