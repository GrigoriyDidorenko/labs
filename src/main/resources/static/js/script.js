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
        'weight': $('.added_element li.weight').find('input').val(),
        'price': $('.added_element li.price').find('input').val(),
        'capacity': $('.added_element li.capacity').find('input').val(),
        'producer': $('.added_element li.producer').find('input').val()
    };

    console.log(JSON.stringify(testObject));
    $.ajax({
        type: "POST",
        url: '/add',
        data: JSON.stringify(testObject),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, request) {
            console.log('done');
        }
    });
});

$('#search').click(function () {

    let weight = $('.search_element li.weight').find('input').val();
    let price = $('.search_element li.price').find('input').val();
    let capacity = $('.search_element li.capacity').find('input').val();
    let producer = $('.search_element li.producer').find('input').val();

    let url;

    if(weight !== ''){
        url = '/search?weight='+weight;
    } else if(price !== ''){
        url = '/search?price='+price;
    } else if(capacity !== ''){
        url = '/search?capacity='+capacity;
    } else if(producer !== ''){
        url = '/search?producer='+producer;
    }

    $.ajax({
        type: "GET",
        url: url,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (json) {
            console.log(json);
            $('.search_element li').find('input').empty();
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

$('#delete').click(function () {
    $.ajax({
        type: "POST",
        url: '/remove/'+$('.delete_element li.id').find('input').val(),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, textStatus, request) {
            console.log('done');
        }
    });
});