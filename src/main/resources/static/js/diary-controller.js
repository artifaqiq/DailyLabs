app.controller('DiaryController', ['DiaryService', '$interval', function (DiaryService, $interval) {
    var ctrl = this;

    ctrl.diary = DiaryService.get().then(function (data) {
        ctrl.diary = data;
        ctrl.diaryUpToDate = true;
    });

    $interval(function () {
        console.log("INTERVAL");

    }, 1000).then(function () {
        console.log("THEN");
    });

    ctrl.updateSubject = function(subject, name, description) {
        subject.name = name;
        subject.description = description;
        ctrl.diaryUpToDate = false;
    }

    ctrl.addNewSubject = function (newSubjectName) {
        //TODO Validation

        if(newSubjectName) {
            var newSubject = {};
            newSubject.name = newSubjectName;
            newSubject.description = "";
            newSubject.labs = [];

            ctrl.diary.subjects.push(newSubject);
            ctrl.diaryUpToDate = false;
        } else {
            //TODO Show notice
        }
    }

    ctrl.deleteSubject = function (deletingSubject) {

        ctrl.diary.subjects = ctrl.diary.subjects.filter(function (subject) {
            return subject != deletingSubject;
        })
        ctrl.diaryUpToDate = false;
    }

    ctrl.updateLab = function(lab, name, description) {
        //TODO Validation

        if(name) {
            lab.name = name;
            lab.description = description;
            ctrl.diaryUpToDate = false;
        } else {
            //TODO Show notice
        }
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
                    element.labs.push(newLab)
                }
            })

            ctrl.diaryUpToDate = false;
        } else {
            //TODO Show notice
        }
    }

    ctrl.deleteLab = function (subject, deletingLab) {
        subject.labs = subject.labs.filter(function (lab) {
            return lab != deletingLab;
        })

        ctrl.diaryUpToDate = false;
    }

    ctrl.switchPassed = function (lab) {
        lab.passed = !lab.passed;

        ctrl.diaryUpToDate = false;
    }

    ctrl.save = function () {
        DiaryService.put(ctrl.diary).then(function (response) {
            if(response.status == 200) {
                ctrl.diaryUpToDate = true;
            }

        })
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