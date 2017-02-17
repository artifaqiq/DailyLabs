app.controller('DiaryController', ['DiaryService', function (DiaryService) {
        var ctrl = this;
        ctrl.diary = DiaryService.async().then(function (data) {
            ctrl.diary = data;
        });

        console.log(ctrl.diary)

        ctrl.addNewSubject = function () {
            console.log("add new subject");
        }
    }]);