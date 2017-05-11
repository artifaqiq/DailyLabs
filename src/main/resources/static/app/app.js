var BASE_URL = "http://dailylabs.herokuapp.com";
// var BASE_URL = "http://localhost:3000";

var app = angular.module('DailyLabsApp', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/', {
                controller:'DiaryController as diaryCtrl',
                templateUrl:'./app/diary/diary.html'
            })
            .when('/login', {
                controller: 'LoginController as loginCtrl',
                templateUrl: './app/login/login.html'
            })
            .when('/register', {
                controller: 'RegisterController as regCtrl',
                templateUrl: './app/register/register.html'
            })
            .otherwise({
                redirectTo:'/'
            });
    });





	