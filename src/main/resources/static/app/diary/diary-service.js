/**
 * Created by artifaqiq on 3/5/17.
 */
app.factory('DiaryService', function ($http) {

    var diaryService = {
        get: function() {
            var promise = $http({
                method: 'GET',
                url: BASE_URL + "/api/diary",
                headers: {
                    "Authorization": getCookie('jwt_token')
                }

            }).then(function (response) {
                return response.data;
            });
            return promise;
        },

        put: function (data) {

            var correctData = JSON.parse(JSON.stringify(data));
            delete correctData.lastModifiedDate;

            var request = {
                method: 'PUT',
                url: (BASE_URL + '/api/diary'),
                data: angular.toJson(correctData),
                headers: {
                    "Authorization": getCookie("jwt_token")
                }
            }

            return $http(request);
        }
    };
    return diaryService;

})