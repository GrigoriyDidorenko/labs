jQuery.ajax({
    type: "GET",
    url: '/element',
    dataType: "json",
    contentType: "application/json; charset=utf-8",
    success: function (json) {
        $('#result').html('');
        $.each(json, function (key, val) {
            $('#result').append('<p>'+key+' : '+val+'</p>');
        });
    }
});

$('button[name="btn"]').click(function () {
    let url = "/"+$(this).parents('tr').attr('id')+'/'+$(this).attr('class');
    jQuery.ajax({
        type: "GET",
        url: url,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (json) {
            $('#result').html('');
            $.each(json, function (key, val) {
                $('#result').append('<p>'+key+' : '+val+'</p>');
            });
        },
        error: function(){
            $('#result').html('');
            $('#result').append('<p>Element not exist :(</p>');
        }
    });
});

$('#added').click(function () {
    var testObject = {
        'weight': $('li.weight').find('input').val(),
        'price': $('li.price').find('input').val(),
        'capacity': $('li.capacity').find('input').val(),
        'producer': $('li.producer').find('input').val()
    };

    console.log(JSON.stringify(testObject));
    $.ajax({
        type: "POST",
        url: '/add',
        data: JSON.stringify(testObject),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (json) {
            console.log(json);
            $.each(json, function (key, val) {
                $('#result').append('<p>'+key+' : '+val+'</p>');
            });
        }
    });
});

$('#search').click(function () {
    var testObject = {
        'weight': $('li.weight').find('input').val(),
        'price': $('li.price').find('input').val(),
        'capacity': $('li.capacity').find('input').val(),
        'producer': $('li.producer').find('input').val()
    };

    console.log(JSON.stringify(testObject));
    $.ajax({
        type: "POST",
        url: '/search',
        data: JSON.stringify(testObject),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (json) {
            console.log(json);
            $.each(json, function (key, val) {
                $('#result').append('<p>'+key+' : '+val+'</p>');
            });
            $('#result').append('<p>Congratulations!</p>');
        }
    });
});