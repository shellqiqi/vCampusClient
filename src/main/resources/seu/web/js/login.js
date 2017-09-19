function submitForm() {
    var account = $('#inputAccount').val();
    var password = $('#inputPassword').val();
    var role = $('#inputRole').val();
    var ex = /^\d+$/;
    var login = false;
    if (ex.test(account)) {
        login = loginController.login(account, password, role);
        if (login === 1) {
            $(location).attr('href', 'mainboard.html?role=' + role);
        } else {
            $('.alert-danger').text('用户名或密码错误');
            $('.alert-danger').slideDown();
        }
    } else {
        $('.alert-danger').text('账号格式错误');
        $('.alert-danger').slideDown();
    }
}
