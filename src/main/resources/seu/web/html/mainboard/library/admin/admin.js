$('#borrowed').on('click', '.returnButton', function () {
    var dataItem = $.view(this).data;
    if (libraryController.returnBook(dataItem.bookId)) {
        $('#main-board').load('library/library.html');
    }
});

$('#addBook').click(function () {
    var inputBookId = $('#inputBookId').val();
    var inputBookName = $('#inputBookName').val();
    if (isAllNumber(inputBookId) && inputBookName !== '') {
        var flag = libraryController.borrowBook(inputBookName, inputBookId);
        if (flag === 1) {
            $('#borrowModal').modal('hide');
            $('#addAlert').hide();
        } else {
            $('#addAlert').text('添加失败');
            $('#addAlert').slideDown();
        }
    } else {
        $('#addAlert').text('请填写所有字段且确保符合规范');
        $('#addAlert').slideDown();
    }
});

$('#borrowModal').on('hidden.bs.modal', function () {
    $('#main-board').load('library/library.html');
});

var borrowJson = libraryController.getBorrowedBooks();
var borrowObjs = jQuery.parseJSON(borrowJson);
var template = $.templates('#borrowTemplate');
var app = {
    books: borrowObjs
};
template.link('#borrowed', app);
