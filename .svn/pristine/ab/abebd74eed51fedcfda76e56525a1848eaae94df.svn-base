//jqGrid extend
(function ($) {
    // change the default settings
    $.jgrid = $.jgrid || {};
    $.extend($.jgrid,{
        jqGrid_setting : {
            url: "",
            mtype: "POST",
            height: 330,
            page: 1,
            rowNum: 20,
            rowTotal : null,
            records: 0,
            pager: "",
            pgbuttons: true,
            pginput: true,
            colModel: [],
            rowList: [],
            colNames: [],
            sortorder: "asc",
            sortname: "",
            datatype: "xml",
            altRows: false,
            selarrrow: [],
            savedRow: [],
            shrinkToFit: false,
            xmlReader: {},
            jsonReader: {},
            subGrid: false,
            subGridModel :[],
            reccount: 0,
            lastpage: 0,
            lastsort: 0,
            selrow: null,
            beforeSelectRow: null,
            onSelectRow: null,
            onSortCol: null,
            ondblClickRow: null,
            onRightClickRow: null,
            onPaging: null,
            onSelectAll: null,
            onInitGrid : null,
            loadComplete: function() {
                var table = this;
                setTimeout(function(){
                    styleCheckbox(table);

                    updateActionIcons(table);
                    updatePagerIcons(table);
                    enableTooltips(table);
                }, 0);
            },
            gridComplete: null,
            loadError: null,
            loadBeforeSend: null,
            afterInsertRow: null,
            beforeRequest: null,
            beforeProcessing : null,
            onHeaderClick: null,
            viewrecords: false,
            loadonce: false,
            multiselect: true,
            multikey: false,
            editurl: null,
            search: false,
            caption: "",
            hidegrid: true,
            hiddengrid: false,
            postData: {},
            userData: {},
            treeGrid : false,
            treeGridModel : 'nested',
            treeReader : {},
            treeANode : -1,
            ExpandColumn: null,
            tree_root_level : 0,
            prmNames: {page:"page",rows:"rows", sort: "sidx",order: "sord", search:"_search", nd:"nd", id:"id",oper:"oper",editoper:"edit",addoper:"add",deloper:"del", subgridid:"id", npage: null, totalrows:"totalrows"},
            forceFit : false,
            gridstate : "visible",
            cellEdit: false,
            cellsubmit: "remote",
            nv:0,
            loadui: "enable",
            toolbar: [true,"top"],
            scroll: false,
            multiboxonly : true,
            deselectAfterSort : true,
            scrollrows : false,
            autowidth: false,
            scrollOffset :18,
            cellLayout: 5,
            subGridWidth: 20,
            multiselectWidth: 20,
            gridview: false,
            rownumWidth: 25,
            rownumbers : false,
            pagerpos: 'center',
            recordpos: 'right',
            footerrow : false,
            userDataOnFooter : false,
            hoverrows : true,
            altclass : 'ui-priority-secondary',
            viewsortcols : [false,'vertical',true],
            resizeclass : '',
            autoencode : false,
            remapColumns : [],
            ajaxGridOptions :{},
            direction : "ltr",
            toppager: false,
            headertitles: false,
            scrollTimeout: 40,
            data : [],
            _index : {},
            grouping : false,
            groupingView : {groupField:[],groupOrder:[], groupText:[],groupColumnShow:[],groupSummary:[], showSummaryOnHide: false, sortitems:[], sortnames:[], summary:[],summaryval:[], plusicon: 'ui-icon-circlesmall-plus', minusicon: 'ui-icon-circlesmall-minus', displayField: [], groupSummaryPos:[], formatDisplayField : [], _locgr : false},
            ignoreCase : false,
            cmTemplate : {},
            idPrefix : "",
            multiSort :  false
        },
        navGrid_setting:{
            edit: false,
            editicon: "ace-icon fa fa-pencil blue",
            add: false,
            addicon:"ace-icon fa fa-plus-circle purple",
            del: false,
            delicon:"ace-icon fa fa-trash-o red",
            search: false,
            searchicon:"ace-icon fa fa-search orange",
            refresh: false,
            refreshicon:"ace-icon fa fa-refresh green",
            refreshstate: 'firstpage',
            view: false,
            viewicon : "ace-icon fa fa-search-plus grey",
            position : "left",
            closeOnEscape : true,
            beforeRefresh : null,
            afterRefresh : null,
            cloneToTop : false,
            alertwidth : 200,
            alertheight : 'auto',
            alerttop: null,
            alertleft: null,
            alertzIndex : null
        },
        editGridRow_setting_new:{
            top : 0,
            left: 0,
            width: 300,
            datawidth: 'auto',
            height: 'auto',
            dataheight: 'auto',
            modal: false,
            overlay : 30,
            drag: true,
            resize: true,
            url: null,
            mtype : "POST",
            clearAfterAdd :true,
            closeAfterAdd: true,
            closeAfterEdit : false,
            reloadAfterSubmit : true,
            onInitializeForm: null,
            beforeInitData: null,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
                    .wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            },
            afterShowForm: null,
            beforeSubmit: null,
            afterSubmit: null,
            onclickSubmit: null,
            afterComplete: null,
            onclickPgButtons : null,
            afterclickPgButtons: null,
            editData : {},
            recreateForm : true,
            jqModal : true,
            closeOnEscape : false,
            addedrow : "first",
            topinfo : '',
            bottominfo: '',
            saveicon : [],
            closeicon : [],
            savekey: [false,13],
            navkeys: [false,38,40],
            checkOnSubmit : false,
            checkOnUpdate : false,
            _savedData : {},
            processing : false,
            onClose : null,
            ajaxEditOptions : {},
            serializeEditData : null,
            viewPagerButtons : false,
            overlayClass : 'ui-widget-overlay'
        },
        editGridRow_setting_edit:{
            top : 0,
            left: 0,
            width: 300,
            datawidth: 'auto',
            height: 'auto',
            dataheight: 'auto',
            modal: false,
            overlay : 30,
            drag: true,
            resize: true,
            url: null,
            mtype : "POST",
            clearAfterAdd :true,
            closeAfterEdit : false,
            reloadAfterSubmit : true,
            onInitializeForm: null,
            beforeInitData: null,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            },
            afterShowForm: null,
            beforeSubmit: null,
            afterSubmit: null,
            onclickSubmit: null,
            afterComplete: null,
            onclickPgButtons : null,
            afterclickPgButtons: null,
            editData : {},
            recreateForm : true,
            jqModal : true,
            closeOnEscape : false,
            addedrow : "first",
            topinfo : '',
            bottominfo: '',
            saveicon : [],
            closeicon : [],
            savekey: [false,13],
            navkeys: [false,38,40],
            checkOnSubmit : false,
            checkOnUpdate : false,
            _savedData : {},
            processing : false,
            onClose : null,
            ajaxEditOptions : {},
            serializeEditData : null,
            viewPagerButtons : true,
            overlayClass : 'ui-widget-overlay'
        },
        delGridRow_setting:{
            top : 0,
            left: 0,
            width: 240,
            height: 'auto',
            dataheight : 'auto',
            modal: false,
            overlay: 30,
            drag: true,
            resize: true,
            url : '',
            mtype : "POST",
            reloadAfterSubmit: true,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                if(form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick : function(e) {
                alert(1);
            },
            beforeInitData : null,
            afterShowForm: null,
            beforeSubmit: null,
            onclickSubmit: null,
            afterSubmit: null,
            jqModal : true,
            closeOnEscape : false,
            delData: {},
            delicon : [],
            cancelicon : [],
            onClose : null,
            ajaxDelOptions : {},
            processing : false,
            serializeDelData : null,
            useDataProxy : false,
            recreateForm: true
        },
        searchGrid_setting:{
            recreateFilter: false,
            recreateForm: true,
            drag: true,
            sField:'searchField',
            sValue:'searchString',
            sOper: 'searchOper',
            sFilter: 'filters',
            loadDefaults: true, // this options activates loading of default filters from grid's postData for Multipe Search only.
            beforeShowSearch: null,
            afterShowSearch: function(e){
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function(){
                style_search_filters($(this));
            },
            onInitializeSearch: null,
            afterChange: null,
            closeAfterSearch : false,
            closeAfterReset: false,
            closeOnEscape : false,
            searchOnEnter : false,
            multipleSearch : true,
            multipleGroup : false,
            //cloneSearchRowOnAdd: true,
            top : 0,
            left: 0,
            jqModal : true,
            modal: false,
            resize : true,
            width: 450,
            height: 'auto',
            dataheight: 'auto',
            showQuery: false,
            errorcheck : true,
            sopt: null,
            stringResult: undefined,
            onClose : null,
            onSearch : null,
            onReset : null,
            toTop : true,
            overlay : 30,
            columns : [],
            tmplNames : null,
            tmplFilters : null,
            tmplLabel : ' Template: ',
            showOnLoad: false,
            layer: null,
            operands : { "eq" :"=", "ne":"<>","lt":"<","le":"<=","gt":">","ge":">=","bw":"LIKE","bn":"NOT LIKE","in":"IN","ni":"NOT IN","ew":"LIKE","en":"NOT LIKE","cn":"LIKE","nc":"NOT LIKE","nu":"IS NULL","nn":"ISNOT NULL"}
        },
        viewGridRow_setting:{
            top : 0,
            left: 0,
            width: 0,
            datawidth: 'auto',
            height: 'auto',
            dataheight: 'auto',
            modal: false,
            overlay: 30,
            drag: true,
            resize: true,
            jqModal: true,
            closeOnEscape : false,
            labelswidth: '30%',
            closeicon: [],
            navkeys: [false,38,40],
            onClose: null,
            beforeShowForm: function(e){
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
            },
            beforeInitData : null,
            viewPagerButtons : true,
            recreateForm : true
        }
    });

    //enable search/filter toolbar
    //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
    //jQuery(grid_selector).filterToolbar({});


    //switch element when editing inline
    function aceSwitch( cellvalue, options, cell ) {
        setTimeout(function(){
            $(cell) .find('input[type=checkbox]')
                .addClass('ace ace-switch ace-switch-5')
                .after('<span class="lbl"></span>');
        }, 0);
    }
    //enable datepicker
    function pickDate( cellvalue, options, cell ) {
        setTimeout(function(){
            $(cell) .find('input[type=text]')
                .datepicker({format:'yyyy-mm-dd' , autoclose:true});
        }, 0);
    }

    function style_edit_form(form) {
        //enable datepicker on "sdate" field and switches for "stock" field
        form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
            .end().find('input[name=stock]')
            .addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').hide();
        buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
    }

    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
        buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }
    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
    }

    function beforeDeleteCallback(e) {
        var form = $(e[0]);
        if(form.data('styled')) return false;

        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_delete_form(form);

        form.data('styled', true);
    }

    function beforeEditCallback(e) {
        var form = $(e[0]);
        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_edit_form(form);
    }



    //it causes some flicker when reloading or navigating grid
    //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
    //or go back to default browser checkbox styles for the grid
    function styleCheckbox(table) {
        /**
         $(table).find('input:checkbox').addClass('ace')
         .wrap('<label />')
         .after('<span class="lbl align-top" />')


         $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
         .find('input.cbox[type=checkbox]').addClass('ace')
         .wrap('<label />').after('<span class="lbl align-top" />');
         */
    }


    //unlike navButtons icons, action icons in rows seem to be hard-coded
    //you can change them like this in here if you want
    function updateActionIcons(table) {
        /**
         var replacement =
         {
             'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue',
             'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red',
             'ui-icon-disk' : 'ace-icon fa fa-check green',
             'ui-icon-cancel' : 'ace-icon fa fa-times red'
         };
         $(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
         */
    }

    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
        {
            'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
        };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
        })
    }

    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container:'body'});
        $(table).find('.ui-pg-div').tooltip({container:'body'});
    }
})(jQuery);

