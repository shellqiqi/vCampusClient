$('#borrowed').on('click', '.returnButton', function () {
    var dataItem = $.view(this).data;
    if (libraryController.returnBook(dataItem.bookId)) {
        $('#libraryBoard').load('library/student/student.html');
    }
});

$('#available').on('click', '.borrowButton', function () {
    var dataItem = $.view(this).data;
    if (libraryController.borrowBook(dataItem.bookId)) {
        $('#libraryBoard').load('library/student/student.html');
    }
});

var borrowedObjs = jQuery.parseJSON(libraryController.getBorrowedBooks());
var template1 = $.templates('#borrowedTemplate');
for (var i = 0; i < borrowedObjs.length; i++) {
    bookDate = new Date(borrowedObjs[i].startDate);
    borrowedObjs[i].dateStr = bookDate.toLocaleDateString();
}
var app1 = {
    books: borrowedObjs
};
template1.link('#borrowed', app1);

var availableObjs = jQuery.parseJSON(libraryController.getAvailableBooks());
var template2 = $.templates('#availableTemplate');
var app2 = {
    books: availableObjs
};
template2.link('#available', app2);
