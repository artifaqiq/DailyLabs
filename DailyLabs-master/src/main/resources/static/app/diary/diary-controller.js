app.controller('DiaryController', ['DiaryService', '$interval', '$location', function (DiaryService, $interval, $location) {
    var self = this;
    var username = getCookie("username")
    self.diary = DiaryService.get()
        .then(function (data) {
        self.diary = data;
        self.diaryUpToDate = true;

    }, function (response) {
            self.isLogined = false;
            $location.path('/login')
    });


    self.updateSubject = function(subject, name, description) {
        subject.name = name;
        subject.description = description;
        self.diaryUpToDate = false;
    }

    self.addNewSubject = function (newSubjectName) {
        //TODO Validation

        if(newSubjectName) {
            var newSubject = {};
            newSubject.name = newSubjectName;
            newSubject.description = "";
            newSubject.labs = []

            self.diary.subjects.push(newSubject);
            self.diaryUpToDate = true;
        } else {
            //TODO Show notice
        }
    }

    self.deleteSubject = function (deletingSubject) {

        self.diary.subjects = self.diary.subjects.filter(function (subject) {
            return subject != deletingSubject;
        })
        self.diaryUpToDate = false;
    }

    self.updateLab = function(lab, name, description) {
        //TODO Validation

        if(name) {
            lab.name = name;
            lab.description = description;
            self.diaryUpToDate = false;
        } else {
            //TODO Show notice
        }
    }

    self.addNewLab = function (subject, newLabName) {
        //TODO Validation

        if(newLabName) {
            var newLab = {};
            newLab.name = newLabName;
            newLab.description = "";
            newLab.passed = false;

            self.diary.subjects.find(function (element, index, array) {
                if(element == subject) {
                    element.labs.push(newLab)
                }
            })

            self.diaryUpToDate = false;
        } else {
            //TODO Show notice
        }
    }

    self.deleteLab = function (subject, deletingLab) {
        subject.labs = subject.labs.filter(function (lab) {
            return lab != deletingLab;
        })

        self.diaryUpToDate = false;
    }

    self.switchPassed = function (lab) {
        lab.passed = !lab.passed;

        self.diaryUpToDate = false;
    }

    self.save = function () {
        DiaryService.put(self.diary).then(function (response) {
            if(response.status == 200) {
                self.diaryUpToDate = true;

                self.diary = DiaryService.get().then(function (data) {
                    self.diary = data;
                    self.diaryUpToDate = true;
                }, function (response) {
                });
            }

        })


    }

    self.getJsonDiary = function () {
        return angular.toJson(self.diary)
    }

    self.getPercentPasssedLabs = function (labs) {
        if(labs.length == 0) return 0;

        var countPassedLabs = labs.filter(function (lab) {
            return lab.passed == true;
        }).length;

        return Math.floor(countPassedLabs * 100 / labs.length);
    }

    self.logOut = function () {
      setCookie('jwt_token', '');
      $location.path('login');
    }

}]);