(function ($) {
    $.widget("nb.component", {
        options: {
            _uuid: -1,
            state: "edit",
            viewModel: "",
            dataModel: "",
            toggleSelect: false
        },
        _createWidget: function (options, element) {
            this._super(options, element);
            // 将widget实例保存到nbui中
            this.element.data("nbui", this);
        },
        _selectable: function (element) {
            var that = this;
            this._on(element, {
                click: function (event) {
                    if (that.options.toggleSelect) {
                        if ($(event.currentTarget).hasClass("ui-state-selected")) {
                            $(event.currentTarget).nbui().disSelect();
                        } else {
                            $(event.currentTarget).nbui().select();
                        }
                    } else {
                        if (!$(event.currentTarget).hasClass("ui-state-selected")) {
                            $(event.currentTarget).nbui().select();
                        }
                    }
                }
            });
        },
        is: function (selector) {
            return this.element.is(selector);
        },
        select: function () {
            this.element.addClass("ui-state-selected");
            this._trigger("selected", {currentTarget: this.element[0]});
            return this;
        },
        disSelect: function () {
            this.element.removeClass("ui-state-selected");
            this._trigger("disSelected", {currentTarget: this.element[0]});
            return this;
        },
        isSelected: function () {
            return this.element.hasClass("ui-state-selected");
        },
        option: function (key, value) {
            if (arguments.length === 0) {
                var op = $.extend(true, {}, this.options);
                $.each(op, function (key) {
                    if (key.charAt(0) === "_") {
                        delete op[key];
                    }
                });
                return op;
            }
            if (key.charAt(0) === "_") {
                return $.error("no such option '" + options + "' for " + key + " widget instance");
            }
            return this._super.apply(this,arguments);
        },
        _uuid: function () {
            this.options._uuid++;
            return this.options._uuid;
        },
        methodApply: function () {
            this[arguments[0]].apply(this, Array.prototype.slice.call(arguments, 1))
        },
        hide: function () {
            this.element.hide();
            return this;
        },
        get: function () {
            return this.element.val();
        },
        set: function (value) {
            this.element.val(value);
            return this;
        },
        clean: function () {
            this.element.val("");
            return this;
        },
        disable: function () {
            this.element.prop("disabled", true);
            return this;
        },
        enable: function () {
            this.element.prop("disabled", false);
            return this;
        }
    });

    $.fn.nbui = function () {
        var args = arguments;
        if (args.length == 0) {
            // 如果没有参数，则简单的将jquery实例切换到nbui实例中
            return this.data("nbui");
        } else {
            // 有参数，则调用相应的方法
            var returnValue = [];
            this.each(function () {
                var nbui = $(this).nbui(),
                    v = nbui.methodApply.apply(nbui, args);
                returnValue.push(v);
            });

            return returnValue;
        }
    };

    $.widget("nb.dialog", $.nb.component, {
        options: {
            title: "提示",
            cancel: false,
            body: null,
            small: true,
            open: true,
            callback: undefined
        },
        defaultElement: '<div class="modal" data-backdrop="true">\
                            <div class="modal-dialog">\
                                <div class="modal-content">\
                                    <div class="modal-header">\
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>\
                                        <h4 class="modal-title">提示</h4>\
                                    </div>\
                                    <div class="modal-body">\
                                        </div>\
                                        <div class="modal-footer">\
                                            <button type="button" class="btn btn-sm btn-primary ok" data-dismiss="modal">确定</button>\
                                        </div>\
                                    </div>\
                                </div>\
                                </div>',
        _create: function () {
            var that = this,
                $title = $(".modal-title", this.element),
                $body = $(".modal-body", this.element),
                $footer = $(".modal-footer", this.element);
            $title.html(this.options.title);
            $body.append(this.options.body);

            $("button.ok", $footer).click(function () {
                that.options.callback && that.options.callback(true, that);
            });
            var $cancel = $('<button type="button" class="btn btn-sm btn-danger" data-dismiss="modal">取消</button>').click(function () {
                that.options.callback && that.options.callback(false, that);
            });
            this.options.cancel && $footer.prepend($cancel);

            if (this.options.small) {
                $("div.modal-dialog", this.element).addClass("modal-sm")
            } else{
                $("div.modal-dialog", this.element).addClass("modal-lg")
            }

            this.element.on('shown.bs.modal', function () {
                $("button.ok", this).focus();
            });

            if (!this.element.parent().length){
                this.element.appendTo($("body"));
            }

            this.options.open && this.element.modal('show');
        },
        open: function () {
            this.element.modal('show');
            return this;
        },
        close: function () {
            this.element.modal('hide');
            return this;
        }
    });

    $.nb.alert = function (message) {
        return $.nb.dialog({body: message});
    };  
  
})(jQuery);