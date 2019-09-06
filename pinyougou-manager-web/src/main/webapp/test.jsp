
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../js/bootstrap/css/bootstrap.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-treeview/bootstrap-treeview.min.css">
    <script src="../js/bootstrap-treeview/bootstrap-treeview.min.js"></script>
    <link rel="stylesheet" href="../js/bootStrap-addTabs/bootstrap.addtabs.css">
    <script src="../js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-table/bootstrap-table.css">
    <script src="../js/bootstrap-table/bootstrap-table.js"></script>
    <script src="../js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
    <script src="../js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script src="../js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css">
    <script src="../js/bootstrap-bootbox/bootbox.all.min.js"></script>
</head>
<body>
<button onclick="openDialog()" type="button" class="btn btn-success"><i class="glyphicon glyphicon-minus"></i>新增</button>
<div class="table" id="BranTable"></div>

</body>
<script>

    $(function(){
        initBranTable();
    })

    //新增保存
    function saveBrand(){
        $.ajax({
            url:'../brand/addBrand.do',
            type:'post',
            data:$("#BookForm").serialize(),
            success:function(data){
                if (data) {
                  $("#BranTable").bootstrapTable("refresh");
                }
                else{
                    bootbox.alert({
                        message: "保存失败",
                        size:'small'
                    });
                }
            }
        })


    }


    //弹框
    function openDialog(){
        bootbox.dialog({
            title:'<i class="glyphicon glyphicon-book"></i>新增',
            message:loadPage('../AddBrand.jsp'),
            size:'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function(){
                    }
                },
                ok: {
                    label: "保存",
                    className: 'btn-info',
                    callback: function(){
                        alert("保存");
                        saveBrand();
                    }
                }
            }
        })
    }

    function loadPage(url){
        var res='';
        $.ajax({
            url:url,
            async:false,
            success:function(data){
                res=data;
            }
        });
        return res;
    }
    //删除
    function deleteBrand(id){
     alert(id);
     $.ajax({
       url:'../brand/deleteBrand.do',
       type:'post',
       data:{id:id},
       success:function(){
           alert("删除");
         $("#BranTable").bootstrapTable("refresh");
         }
     })

    }

    function initBranTable(){
        $("#BranTable").bootstrapTable({
            url : '../brand/queryBrandList.do',
            method : 'post',
            contentType : 'application/x-www-form-urlencoded',//post请求按照表
            pagination : true, //是否展示分页
            pageSize : 5,
            toolbar:'#toolbar',
            sidePagination : 'server',//分页方式：client客户端分页，server服务端分页（*)
            clickToSelect : true, //是否启用点击选中行
            striped : true, //斑马线
            queryParams : function() {
                return {
                    page : this.pageNumber,
                    rows : this.pageSize,
                };
            },
            columns : [
                {checkbox : true},
                {field : 'id',title : '主键'},
                {field : 'typename',title : '品牌名称'},
                {field : 'brand',title : '品牌首字母'},
                {field : 'tool',title : '操作',formatter : function(value, row, index) {
                        return ' <a href="javascript:deleteBrand('+row.id+')">删除 </a>'
                    }
                },
            ]
        })

    }


</script>


</html>
