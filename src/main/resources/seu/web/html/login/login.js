function submitForm() {
    var account = $('#inputAccount').val();
    var password = $('#inputPassword').val();
    var role = $("input[name='options']:checked").val();
    if (isAllNumber(account)) {
        var login = loginController.login(account, password, role);
        if (login === 1) {
            $(location).attr('href', '../mainboard/mainboard.html?role=' + role + '&account=' + account);
        } else {
            $('.alert-danger').text('用户名或密码错误');
            $('.alert-danger').slideDown();
        }
    } else {
        $('.alert-danger').text('账号格式错误');
        $('.alert-danger').slideDown();
    }
}
