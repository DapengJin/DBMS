/*
 * @Author: Jin X
 * @Date: 2020-02-17 23:58:08
 * @LastEditTime: 2020-02-23 10:20:14
 */
$(function () {
    var $tb = $('#tb');
    $("#submit").click(function () {
        $tb.bootstrapTable('showLoading');
        var timeBegin = new Date();
        $.ajax({
            type: "POST",
            dataType:"json",
            url: "/sql/e",
            data: $('#fm').serializeArray(),
            contentType: "application/x-www-form-urlencoded",
            success: function (result) {
                $tb.bootstrapTable('destroy');
                var $tr = $('#colh').find('tr')
                $tr.children().remove();
                var first = result[0];
                Object.keys(first).forEach(function(e){
                    $tr.append($('<th></th>').text(e).attr('data-field',e))
                })
                $tb.bootstrapTable();
                $tb.bootstrapTable('load', result);
                $tb.bootstrapTable('hideLoading')
                var timeEnd = new Date();
                $('#time').text((timeEnd-timeBegin)+'ms')
                console.log('load data')
            },
            error: function () {
                alert("error");
            }
        });
    });
   

    // $("#submit").click(function () {
    //     $.ajax({
    //         type: "GET",
    //         dataType:"json",
    //         url: "/sql/getaisles",
    //         contentType: "application/json;charset=utf-8",
    //         success: function (result) {
    //             $tb.bootstrapTable('destroy');
    //             var $tr = $('#colh').find('tr')
    //             $tr.children().remove();
    //             var first = result[0];
    //             Object.keys(first).forEach(function(e){
    //                 $tr.append($('<th></th>').text(e).attr('data-field',e))
    //             })
    //             $tb.bootstrapTable();
    //             $tb.bootstrapTable('load',result);
    //             console.log('load data')
    //         },
    //         error: function () {
    //             alert("error");
    //         }
    //     });
    // });
});