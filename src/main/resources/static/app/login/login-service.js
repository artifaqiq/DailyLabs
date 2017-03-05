/**
 * Created by artifaqiq on 3/5/17.
 */


app.factory('LoginService', function ($http) {
    var loginService = {
        login: function (username, password) {
            return $http({
                method: 'POST',
                url: BASE_URL + '/api/auth/login',
                data: {
                    password: password,
                    username: username
                }
            })

        }
    }

    return loginService;
})
