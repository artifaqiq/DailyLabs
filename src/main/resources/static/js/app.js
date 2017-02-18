var app = angular.module('DailyLabsApp', ['ngRoute'])

    .factory('DiaryService', function ($http) {

        var BASE_URL = "http://dailylabs.herokuapp.com";

        var diaryService = {
            get: function() {
<<<<<<< HEAD
                var promise = $http.get(BASE_URL + "/api/test/diary.json").then(function (response) {
=======
                var promise = $http.get('http://dailylabs.herokuapp.com/api/test/diary.json').then(function (response) {
>>>>>>> frontend
                    return response.data;
                });
                return promise;
            },

            put: function (data) {

                var request = {
                    method: 'PUT',
<<<<<<< HEAD
                    url: (BASE_URL + '/api/test/diary.json'),
=======
                    url: 'http://dailylabs.herokuapp.com/api/test/diary.json',
>>>>>>> frontend
                    data: angular.toJson(data)
                }

                return $http(request);
            }
        };
        return diaryService;

    })

    .config(function($routeProvider) {
        $routeProvider
            .when('/', {
                controller:'DiaryController as diaryCtrl',
                templateUrl:'templates/diary.html',
            })
            .otherwise({
                redirectTo:'/'
            });
    });





	