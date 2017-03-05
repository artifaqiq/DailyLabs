/**
 * Created by artifaqiq on 3/5/17.
 */

app.controller('RegisterController', ['RegisterService', '$location', function (RegisterService, $location) {
    var self = this;

    self.message = ''

    self.register = function (username, password, password_confirm) {
        if (password === password_confirm) {

            RegisterService.register(username, password, password_confirm)
                .then(function (response) {
                    setCookie("jwt_token", response.data.token, {"path": "/"})
                    $location.path('/')

                }, function (response) {
                    self.message = response.data.description
                })

        } else {
            self.message = "Both passwords aren't equals";
        }
    }

}])
