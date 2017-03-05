var app = angular.module('DailyLabsApp', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/', {
                controller:'DiaryController as diaryCtrl',
                templateUrl:'diary/diary.html',
            })
            .otherwise({
                redirectTo:'/'
            });
    });





	