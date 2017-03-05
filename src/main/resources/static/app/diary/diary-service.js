/**
 * Created by artifaqiq on 3/5/17.
 */
app.factory('DiaryService', function ($http) {

    // var BASE_URL = "http://dailylabs.herokuapp.com";
    var BASE_URL = "http://localhost:3000";

    var diaryService = {
        get: function() {
            var promise = $http.get(BASE_URL + "/api/test/diary.json").then(function (response) {
                return response.data;
            });
            return promise;
        },

        put: function (data) {

            var correctData = JSON.parse(JSON.stringify(data));
            delete correctData.lastModifiedDate;

            var request = {
                method: 'PUT',
                url: (BASE_URL + '/api/test/diary.json'),
                data: angular.toJson(correctData)
            }

            return $http(request);
        }
    };
    return diaryService;

})