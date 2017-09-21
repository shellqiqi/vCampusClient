$('#adminSelectedCourse').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.teacherDelectCourseSelect(dataItem.studentId, dataItem.courseId)) {
        $('#courseBoard').load('course/admin/admin.html');
    }
});

$('#adminCourse').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.deleteCourseById(dataItem.courseId)) {
        $('#courseBoard').load('course/admin/admin.html');
    }
});

$('#addCourse').click(function () {
    var courseId = $('#inputAddCourseId').val();
    var courseName = $('#inputAddCourseName').val();
    var credit = $('#inputAddCredit').val();
    var period = $('#inputAddPeriod').val();
    var teacherId = $('#inputAddTeacherId').val();
    if (isAllNumber(courseId) && courseName !== '' && isAllNumber(credit) && isAllNumber(period) && isAllNumber(teacherId)) {
        var flag = courseController.addCourse(courseId, courseName, credit, period, teacherId);
        if (flag === 1) {
            $('#courseAddModal').modal('hide')
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

$('#courseAddModal').on('hidden.bs.modal', function () {
    $('#courseBoard').load('course/admin/admin.html');
});

var courseSelectJson = courseController.getAllCourseSelect();
var courseSelectObjs = jQuery.parseJSON(courseSelectJson);
var template1 = $.templates('#courseSelectTemplate');
for (var i = 0; i < courseSelectObjs.length; i++) {
    courseSelectObjs[i].studentName = jQuery.parseJSON(courseController.getStudent(courseSelectObjs[i].studentId)).studentName;
    courseSelectObjs[i].courseName = jQuery.parseJSON(courseController.getCourse(courseSelectObjs[i].courseId)).courseName;
}
var app1 = {
    courseSelect: courseSelectObjs
};
template1.link('#adminSelectedCourse', app1);

var courseJson = courseController.getAllCourse();
var courseObjs = jQuery.parseJSON(courseJson);
var template2 = $.templates('#courseTemplate');
for (var i = 0; i < courseObjs.length; i++) {
    courseObjs[i].teacherName = jQuery.parseJSON(studentRollController.getTeacherById(courseObjs[i].teacherId)).teacherName;
}
var app2 = {
    course: courseObjs
};
template2.link('#adminCourse', app2);
