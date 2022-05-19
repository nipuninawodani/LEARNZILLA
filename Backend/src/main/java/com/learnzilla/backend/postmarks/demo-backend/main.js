$.ajax({
    type: "GET",
    contentType: "application/json",
    url: "http://localhost:8080/user/all",
    dataType: 'json',
    crossDomain: true,
    success: function (data) {
        for(i=0;i<data.length;i++){
            $('#tbl').append(
                '<tr><td>' + data[i].id + '</td>' +
                '<td>' + data[i].name + '</td>' +
                '<td>' + data[i].age + '</td></tr>'
            )
        }
    },
    error: function (e) {
        console.log("ERROR : ", e);
    }
});
