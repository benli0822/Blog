/**
 * Created by jamesRMBP on 11/12/14.
 */
function postArticle() {
    var article = {
        "content": "this is a article created by rest",
        "title": "rest artcile",
        "username": "lemattmatt"


    };

    $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        dataType: 'application/json',
        url: "http://localhost:8080/api/restPostArticle",
        data: JSON.stringify(article),// Note it is important
        success: function (result) {
            if (data.status == 'OK') alert('Person has been added');
            else alert('Failed adding person: ' + data.status + ', ' + data.errorMessage);
        }
    });
}