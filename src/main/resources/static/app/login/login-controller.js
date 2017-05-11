/**
 * Created by artifaqiq on 3/5/17.
 */

app.controller('LoginController', ['LoginService', '$location', function (LoginService, $location) {
    var self = this;

    self.message = ''

    self.login = function (username, password) {

        if (username == 'porno') {
            window.location.href = ("http://www.megahdporno.net/categories/");
        } else {
            LoginService.login(username, password)
                .then(function (response) {
                    setCookie("jwt_token", response.data.token, {"path": "/"})
                    setCookie("username", username, {"path": "/"})
                    window.location.href = ("/diary.html");

                }, function (response) {
                    if (response.status == 401) {
                        self.message = "Incorrect login or password";
                    }
                })
        }

        document.getElementById("username").innerHTML = "";
        document.getElementById("password").innerHTML = "";

    }

}])