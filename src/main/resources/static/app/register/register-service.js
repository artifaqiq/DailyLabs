/**
 * Created by artifaqiq on 3/5/17.
 */

app.factory('RegisterService', function ($http) {
    var registerService = {
        register: function (username, password, password_confirm) {
            return $http({
                method: 'POST',
                url: BASE_URL + '/api/auth/register',
                data: {
                    password: password,
                    password_confirm: password_confirm,
                    username: username
                }
            })
        }
    }

    return registerService;
})