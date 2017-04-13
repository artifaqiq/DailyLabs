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
                    setCookie("username", username, {"path": "/"})
                    window.location.href = ("/diary.html");

                }, function (response) {
                    if(response.status == "409") {
                        self.message = "User with some username already exists";
                    }
                })

        } else {
            self.message = "Both passwords aren't equals";
        }
    }

}])
