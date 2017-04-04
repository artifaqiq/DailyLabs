/**
 * Created by artifaqiq on 3/5/17.
 */

app.controller('LoginController', ['LoginService', '$location', function (LoginService, $location) {
    var self = this;

    self.message = ''

    self.login = function (username, password) {

        LoginService.login(username, password)
            .then(function (response) {
                setCookie("jwt_token", response.data.token, {"path": "/"})
                $location.path('/')

            }, function (response) {
                if(response.status == 401) {
                    self.message = "Incorrect login or password";
                }
            })

            document.getElementById("username").innerHTML = "";
            document.getElementById("password").innerHTML = "";

    }

}])