app.controller('DiaryController', ['DiaryService', function (DiaryService) {
    var ctrl = this;
    ctrl.diary = DiaryService.async().then(function (data) {
        ctrl.diary = data;
    });



    ctrl.addNewSubject = function (newSubjectName) {
        //TODO Validation

        if(newSubjectName) {
            var newSubject = {};
            newSubject.name = newSubjectName;
            newSubject.description = "";
            newSubject.labs = [];

            ctrl.diary.subjects.push(newSubject);
        } else {
            //TODO Show notice
        }

        //TODO Clear input
    }

    ctrl.addNewLab = function (subject, newLabName) {
        //TODO Validation


        if(newLabName) {
            var newLab = {};
            newLab.name = newLabName;
            newLab.description = "";
            newLab.passed = false;

            ctrl.diary.subjects.find(function (element, index, array) {
                if(element == subject) {
                    element.labs.push(newLab);
                }

            })
        } else {
            //TODO Show notice
        }

        //TODO Clear input

    }



    ctrl.save = function () {
        //TO-DO
    }

    ctrl.getJsonDiary = function () {
        return angular.toJson(ctrl.diary)
    }

    ctrl.getPercentPasssedLabs = function (labs) {
        if(labs.length == 0) return 0;

        var countPassedLabs = labs.filter(function (lab) {
            return lab.passed == true;
        }).length;

        return Math.floor(countPassedLabs * 100 / labs.length);

    }

}]);