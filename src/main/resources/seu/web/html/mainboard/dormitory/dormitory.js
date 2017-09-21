var dormitoryObjs = jQuery.parseJSON(dormitoryController.getAllDormitory());
var template = $.templates('#dormitoryTemplate');
for (var i = 0; i < dormitoryObjs.length; i++) {
    dormitoryObjs[i].studentObjs = jQuery.parseJSON(dormitoryController.getStudentByDormitoryId(dormitoryObjs[i].dormitoryId));
}
var app = {
    course: dormitoryObjs
};
template.link('#dormitoryBoard', app);
