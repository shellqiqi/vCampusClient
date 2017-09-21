$('#addBook').click(function () {
    var inputBookId = $('#inputAddBookId').val();
    var inputBookName = $('#inputAddBookName').val();
    if (isAllNumber(inputBookId) && inputBookName !== '') {
        var flag = libraryController.addBook(inputBookId, inputBookName);
        if (flag === 1) {
            $('#addBookModal').modal('hide');
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

$('#deleteBook').click(function () {
    var inputBookId = $('#inputDeleteBookId').val();
    if (isAllNumber(inputBookId)) {
        var flag = libraryController.deleteBook(inputBookId);
        if (flag === 1) {
            $('#deleteBookModal').modal('hide');
            $('#deleteAlert').hide();
        } else {
            $('#deleteAlert').text('删除失败');
            $('#deleteAlert').slideDown();
        }
    } else {
        $('#deleteAlert').text('请填写所有字段且确保符合规范');
        $('#deleteAlert').slideDown();
    }
});

$('#addBookModal').on('hidden.bs.modal', function () {
    $('#libraryBoard').load('library/admin/admin.html');
});

$('#deleteBookModal').on('hidden.bs.modal', function () {
    $('#libraryBoard').load('library/admin/admin.html');
});

var allBooksJson = libraryController.getAllBooks();
var borrowedObjs = jQuery.parseJSON(allBooksJson);
var template = $.templates('#bookListTemplate');
for (var i = 0; i < borrowedObjs.length; i++) {
    bookDate = new Date(borrowedObjs[i].startDate);
    borrowedObjs[i].dateStr = bookDate.toLocaleDateString();
}
var app = {
    books: borrowedObjs
};
template.link('#bookList', app);
