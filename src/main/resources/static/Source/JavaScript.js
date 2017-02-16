	var countryApp = angular.module('countryApp', []);
countryApp.controller('CountryCtrl', function ($scope, $http) {
    $http.get('http://dailylabs.herokuapp.com/api/test/diary.json').success(function (data) {
        console.log(data.subjects[0]);

        $scope.diary = data;
    });
});
	