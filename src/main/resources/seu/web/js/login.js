function submitForm() {
    var account = $('#inputAccount').val();
    var password = $('#inputPassword').val();
    var role = $('#inputRole').val();
    var ex = /^\d+$/;
    var login = false;
    if (ex.test(account)) {
        login = loginController.login(account, password, role);
        if (login === 1) {
            $(location).attr('href', 'main.html');
        } else {
            $('.alert-danger').text('用户名或密码错误');
            $('.alert-danger').show()
        }
    } else {
        $('.alert-danger').text('账号格式错误');
        $('.alert-danger').show()
    }
}
