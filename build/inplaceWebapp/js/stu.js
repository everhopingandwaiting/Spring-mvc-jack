$(document).ready(function () {
    $(":checkbox:first").click(function () {
        var checked = $(this).prop("checked");
        $(":checkbox").prop("checked", checked);
    });

    $("#selectAllButton").click(function () {
        $(":checkbox").prop("checked", true);
    });

    $("tbody :checkbox").click(function () {
        var isAllSelected = $(":checkbox:first").prop("checked");
        var selected = $(this).prop("checked");
        if (!selected && isAllSelected) {
            $(":checkbox:first").prop("checked", false);
        } else {
            isAllSelected = true;
            $("tbody :checkbox").each(function () {
                if (!$(this).prop("checked")) {
                    isAllSelected = false;
                    return false;
                }
            });
            $(":checkbox:first").prop("checked", isAllSelected);
        }
    });

    $("#deletebtn").click(function (e) {
        var selected = [];
        var ids = [];
        $("tbody :checkbox").each(function () {
            if ($(this).prop('checked')) {
                selected.push($(this).attr('id'));
                ids.push(selected.val());
            }
        });

        if (selected.length == 0) {
            alert("please select at least one book");
            e.preventDefault();
        }
        $.ajax({
            url: "/stu-manager/students/delete/"+ids,
            method: 'post',
            dataType: 'json',
            async: false,
            success: function () {
                alert("删除成功！");
            },
            error: function () {
                alert("删除失败！");
            }
        });

    });
});
