// Validation validate.js
/*
 * validate.js 2.0.1
 * Copyright (c) 2011 - 2015 Rick Harrison, http://rickharrison.me
 * validate.js is open sourced under the MIT license.
 * Portions of validate.js are inspired by CodeIgniter.
 * http://rickharrison.github.com/validate.js
 */
(function(r, t, l) {
    var u = {
            required: "The %s field is required.",
            matches: "The %s field does not match the %s field.",
            "default": "The %s field is still set to default, please change.",
            valid_email: "The %s field must contain a valid email address.",
            valid_emails: "The %s field must contain all valid email addresses.",
            min_length: "The %s field must be at least %s characters in length.",
            max_length: "The %s field must not exceed %s characters in length.",
            exact_length: "The %s field must be exactly %s characters in length.",
            greater_than: "The %s field must contain a number greater than %s.",
            less_than: "The %s field must contain a number less than %s.",
            alpha: "The %s field must only contain alphabetical characters.",
            alpha_numeric: "The %s field must only contain alpha-numeric characters.",
            alpha_dash: "The %s field must only contain alpha-numeric characters, underscores, and dashes.",
            numeric: "The %s field must contain only numbers.",
            integer: "The %s field must contain an integer.",
            decimal: "The %s field must contain a decimal number.",
            is_natural: "The %s field must contain only positive numbers.",
            is_natural_no_zero: "The %s field must contain a number greater than zero.",
            valid_ip: "The %s field must contain a valid IP.",
            valid_base64: "The %s field must contain a base64 string.",
            valid_credit_card: "The %s field must contain a valid credit card number.",
            is_file_type: "The %s field must contain only %s files.",
            valid_url: "The %s field must contain a valid URL.",
            greater_than_date: "The %s field must contain a more recent date than %s.",
            less_than_date: "The %s field must contain an older date than %s.",
            greater_than_or_equal_date: "The %s field must contain a date that's at least as recent as %s.",
            less_than_or_equal_date: "The %s field must contain a date that's %s or older."
        },
        v = function(a) {},
        w = /^(.+?)\[(.+)\]$/,
        g = /^[0-9]+$/,
        x = /^\-?[0-9]+$/,
        m = /^\-?[0-9]*\.?[0-9]+$/,
        q = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
        y = /^[a-z]+$/i,
        z = /^[a-z0-9]+$/i,
        A = /^[a-z0-9_\-]+$/i,
        B = /^[0-9]+$/i,
        C = /^[1-9][0-9]*$/i,
        D = /^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})$/i,
        E = /[^a-zA-Z0-9\/\+=]/i,
        F = /^[\d\-\s]+$/,
        G = /^((http|https):\/\/(\w+:{0,1}\w*@)?(\S+)|)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?$/,
        H = /\d{4}-\d{1,2}-\d{1,2}/,
        f = function(a, c, b) {
            this.callback = b || v;
            this.errors = [];
            this.fields = {};
            this.form = this._formByNameOrNode(a) || {};
            this.messages = {};
            this.handlers = {};
            this.conditionals = {};
            a = 0;
            for (b = c.length; a < b; a++) {
                var d = c[a];
                if ((d.name || d.names) && d.rules)
                    if (d.names)
                        for (var n = 0, f = d.names.length; n < f; n++) this._addField(d, d.names[n]);
                    else this._addField(d, d.name);
                else console.warn("validate.js: The following field is being skipped due to a misconfiguration:"),
                    console.warn(d), console.warn("Check to ensure you have properly configured a name and rules for this field")
            }
            var e = this.form.onsubmit;
            this.form.onsubmit = function(a) {
                return function(b) {
                    try {
                        return a._validateForm(b) && (e === l || e())
                    } catch (c) {}
                }
            }(this)
        },
        p = function(a, c) {
            var b;
            if (0 < a.length && ("radio" === a[0].type || "checkbox" === a[0].type))
                for (b = 0, elementLength = a.length; b < elementLength; b++) {
                    if (a[b].checked) return a[b][c]
                } else return a[c]
        };
    f.prototype.setMessage = function(a, c) {
        this.messages[a] = c;
        return this
    };
    f.prototype.registerCallback = function(a, c) {
        a && "string" === typeof a && c && "function" === typeof c && (this.handlers[a] = c);
        return this
    };
    f.prototype.registerConditional = function(a, c) {
        a && "string" === typeof a && c && "function" === typeof c && (this.conditionals[a] = c);
        return this
    };
    f.prototype._formByNameOrNode = function(a) {
        return "object" === typeof a ? a : t.forms[a]
    };
    f.prototype._addField = function(a, c) {
        this.fields[c] = {
            name: c,
            display: a.display || c,
            rules: a.rules,
            depends: a.depends,
            id: null,
            element: null,
            type: null,
            value: null,
            checked: null
        }
    };
    f.prototype._validateForm = function(a) {
        this.errors = [];
        for (var c in this.fields)
            if (this.fields.hasOwnProperty(c)) {
                var b = this.fields[c] || {},
                    d = this.form[b.name];
                d && d !== l && (b.id = p(d, "id"), b.element = d, b.type = 0 < d.length ? d[0].type : d.type, b.value = p(d, "value"), b.checked = p(d, "checked"), b.depends && "function" === typeof b.depends ? b.depends.call(this, b) && this._validateField(b) : b.depends && "string" === typeof b.depends && this.conditionals[b.depends] ? this.conditionals[b.depends].call(this, b) && this._validateField(b) : this._validateField(b))
            }
            "function" ===
        typeof this.callback && this.callback(this.errors, a);
        0 < this.errors.length && (a && a.preventDefault ? a.preventDefault() : event && (event.returnValue = !1));
        return !0
    };
    f.prototype._validateField = function(a) {
        var c, b, d = a.rules.split("|"),
            f = a.rules.indexOf("required"),
            I = !a.value || "" === a.value || a.value === l;
        c = 0;
        for (ruleLength = d.length; c < ruleLength; c++) {
            var e = d[c];
            b = null;
            var h = !1,
                k = w.exec(e);
            if (-1 !== f || -1 !== e.indexOf("!callback_") || !I)
                if (k && (e = k[1], b = k[2]), "!" === e.charAt(0) && (e = e.substring(1, e.length)), "function" ===
                    typeof this._hooks[e] ? this._hooks[e].apply(this, [a, b]) || (h = !0) : "callback_" === e.substring(0, 9) && (e = e.substring(9, e.length), "function" === typeof this.handlers[e] && !1 === this.handlers[e].apply(this, [a.value, b, a]) && (h = !0)), h) {
                    k = this.messages[a.name + "." + e] || this.messages[e] || u[e];
                    h = "An error has occurred with the " + a.display + " field.";
                    k && (h = k.replace("%s", a.display), b && (h = h.replace("%s", this.fields[b] ? this.fields[b].display : b)));
                    var g;
                    for (b = 0; b < this.errors.length; b += 1) a.id === this.errors[b].id && (g = this.errors[b]);
                    e = g || {
                        id: a.id,
                        display: a.display,
                        element: a.element,
                        name: a.name,
                        message: h,
                        messages: [],
                        rule: e
                    };
                    e.messages.push(h);
                    g || this.errors.push(e)
                }
        }
    };
    f.prototype._getValidDate = function(a) {
        if (!a.match("today") && !a.match(H)) return !1;
        var c = new Date;
        a.match("today") || (a = a.split("-"), c.setFullYear(a[0]), c.setMonth(a[1] - 1), c.setDate(a[2]));
        return c
    };
    f.prototype._hooks = {
        required: function(a) {
            var c = a.value;
            return "checkbox" === a.type || "radio" === a.type ? !0 === a.checked : null !== c && "" !== c
        },
        "default": function(a, c) {
            return a.value !==
                c
        },
        matches: function(a, c) {
            var b = this.form[c];
            return b ? a.value === b.value : !1
        },
        valid_email: function(a) {
            return q.test(a.value)
        },
        valid_emails: function(a) {
            a = a.value.split(/\s*,\s*/g);
            for (var c = 0, b = a.length; c < b; c++)
                if (!q.test(a[c])) return !1;
            return !0
        },
        min_length: function(a, c) {
            return g.test(c) ? a.value.length >= parseInt(c, 10) : !1
        },
        max_length: function(a, c) {
            return g.test(c) ? a.value.length <= parseInt(c, 10) : !1
        },
        exact_length: function(a, c) {
            return g.test(c) ? a.value.length === parseInt(c, 10) : !1
        },
        greater_than: function(a,
            c) {
            return m.test(a.value) ? parseFloat(a.value) > parseFloat(c) : !1
        },
        less_than: function(a, c) {
            return m.test(a.value) ? parseFloat(a.value) < parseFloat(c) : !1
        },
        alpha: function(a) {
            return y.test(a.value)
        },
        alpha_numeric: function(a) {
            return z.test(a.value)
        },
        alpha_dash: function(a) {
            return A.test(a.value)
        },
        numeric: function(a) {
            return g.test(a.value)
        },
        integer: function(a) {
            return x.test(a.value)
        },
        decimal: function(a) {
            return m.test(a.value)
        },
        is_natural: function(a) {
            return B.test(a.value)
        },
        is_natural_no_zero: function(a) {
            return C.test(a.value)
        },
        valid_ip: function(a) {
            return D.test(a.value)
        },
        valid_base64: function(a) {
            return E.test(a.value)
        },
        valid_url: function(a) {
            return G.test(a.value)
        },
        valid_credit_card: function(a) {
            if (!F.test(a.value)) return !1;
            var c = 0,
                b = 0,
                d = !1;
            a = a.value.replace(/\D/g, "");
            for (var f = a.length - 1; 0 <= f; f--) b = a.charAt(f), b = parseInt(b, 10), d && 9 < (b *= 2) && (b -= 9), c += b, d = !d;
            return 0 === c % 10
        },
        is_file_type: function(a, c) {
            if ("file" !== a.type) return !0;
            var b = a.value.substr(a.value.lastIndexOf(".") + 1),
                d = c.split(","),
                f = !1,
                g = 0,
                e = d.length;
            for (g; g < e; g++) b.toUpperCase() ==
                d[g].toUpperCase() && (f = !0);
            return f
        },
        greater_than_date: function(a, c) {
            var b = this._getValidDate(a.value),
                d = this._getValidDate(c);
            return d && b ? b > d : !1
        },
        less_than_date: function(a, c) {
            var b = this._getValidDate(a.value),
                d = this._getValidDate(c);
            return d && b ? b < d : !1
        },
        greater_than_or_equal_date: function(a, c) {
            var b = this._getValidDate(a.value),
                d = this._getValidDate(c);
            return d && b ? b >= d : !1
        },
        less_than_or_equal_date: function(a, c) {
            var b = this._getValidDate(a.value),
                d = this._getValidDate(c);
            return d && b ? b <= d : !1
        }
    };
    r.FormValidator =
        f
})(window, document);
"undefined" !== typeof module && module.exports && (module.exports = FormValidator);

//Added new fallback methods for IE8
if (typeof String.prototype.trim !== 'function') {
    String.prototype.trim = function() {
        return this.replace(/^\s+|\s+$/g, '');
    };
}

if (!Array.prototype.indexOf) {
    Array.prototype.indexOf = function(elt /*, from*/ ) {
        var len = this.length >>> 0;
        var from = Number(arguments[1]) || 0;
        from = (from < 0) ? Math.ceil(from) : Math.floor(from);
        if (from < 0) from += len;

        for (; from < len; from++) {
            if (from in this && this[from] === elt) return from;
        }
        return -1;
    };
}


if (!Array.prototype.filter) {
    Array.prototype.filter = function(fun /*, thisp */ ) {
        "use strict";

        if (this === void 0 || this === null)
            throw new TypeError();

        var t = Object(this);
        var len = t.length >>> 0;
        if (typeof fun !== "function")
            throw new TypeError();

        var res = [];
        var thisp = arguments[1];
        for (var i = 0; i < len; i++) {
            if (i in t) {
                var val = t[i]; // in case fun mutates this
                if (fun.call(thisp, val, i, t))
                    res.push(val);
            }
        }

        return res;
    };
}


var LoginRadiusV2 = (function() {

    //IE postMessage fallback
    (function(a, b) {
        "use strict";
        var c = function() {
                var b = function() {
                    var b = a.location.hash ? a.location.hash.substr(1).split("&") : [],
                        c = {};
                    for (var d = 0; d < b.length; d++) {
                        var e = b[d].split("=");
                        c[e[0]] = decodeURIComponent(e[1])
                    }
                    return c
                };
                var c = function(b) {
                    var c = [];
                    for (var d in b) {
                        c.push(d + "=" + encodeURIComponent(b[d]))
                    }
                    a.location.hash = c.join("&")
                };
                return {
                    get: function(a) {
                        var c = b();
                        if (a) {
                            return c[a]
                        } else {
                            return c
                        }
                    },
                    add: function(a) {
                        var d = b();
                        for (var e in a) {
                            d[e] = a[e]
                        }
                        c(d)
                    },
                    remove: function(a) {
                        a = typeof a == "string" ? [a] : a;
                        var d = b();
                        for (var e = 0; e < a.length; e++) {
                            delete d[a[e]]
                        }
                        c(d)
                    },
                    clear: function() {
                        c({})
                    }
                }
            }
            ();
        a.hash = c
    })(window)
    var lrToken = hash.get('lr-token');
    if (lrToken && window.opener && window.opener.html5passToken) {
        window.opener.html5passToken(lrToken);
        document.write('<style type="text/css">body { display: none !important; } </style>');
        hash.remove('lr-token');
        window.close();
    }

    this.global = window;
    var context = this;
    var idPrefix = "loginradius-";
    var classPrefix = "loginradius-";
    var apidomain = "https://api.loginradius.com/identity/v2";
    var schemaCdnDomain = "https://cdn.loginradius.com/raas/regSchema/";
    var appJsonUrl = "https://cdn.loginradius.com/interface/json/";
    var cdnDomain = "https://cdn.loginradius.com/hub/prod/v1/";
    var hubdomain = "hub.loginradius.com";
    var cssPath = "hub";
    var isRegFormSchemaLock = false;
    var socialRegFormId = "";
    var module = this;
    var storedTokenName = "LRTokenKey";
    var storedUidName = "lr-user-uid";
    var tokencookie = "lr-user--token";
    var isSSOInitFired = false;
    module.dialogWindow = "";
    module.iconheight = "";
    module.iconheight = "";

    //    var cache = {};

    var lrOptions = {
        apikey: '',
        callback: '',
        interfaceBackground: '',
        socialLoginHeading: '',
        protocol: '',
        sameWindow: '',
        noOfColumns: '',
        interfaceContainer: '',
        interfaceSize: '',
        scope: '',
        isAccessToken: false,
        enableApiCaching: false,
        highlightPreviousProvider: false,
        noVirtualIframe: false,
        customwidth: 0,
        isParentWindowLogin: false,
        isConnectingTextOnInterface: false,
        isConnectingInsidePopup: true,
        ConnectingTextInsidePopup: '',
        ConnectingImageUrlInsidePopup: '',
        InsidePopupFavIcon: '',
        callbacktype: '',
        disableSignup: ''
    };

    module.openIdProvider = {
        'http://steamcommunity.com/openid': 'steamcommunity',
        'http://openid.aol.com/{username}': 'aol',
        'http://{username}.pip.verisignlabs.com/': 'verisign',
        'http://www.myvirgilio.it': 'virgilio',
        'http://openid.orange.fr/': 'orange',
        'http://{username}.livejournal.com/': 'livejournal',
        'https://openid.stackexchange.com/': 'stackexchange',
        'http://mixi.jp': 'mixi',
        'http://www.hyves.nl/': 'hyves',
        'openid': 'openid'
    };
    module.sessionData = {
            getUid: function() {
                return getBrowserStorage(storedUidName);
            },
            getToken: function() {
                return getBrowserStorage(storedTokenName);
            }
        }
        //start hook model
    module.$hooks = {
        processHook: {
            startProcess: function() {},
            endProcess: function() {}

        },
        loginProviderClick: function(provider) {},
        socialLoginHook: {
            onFormRender: function() {}
        },
        accountsHook: {
            //  onGetAccountDetails: function () { } 
        },
        filterRegistrationSchemaHook: function() {},
        loginHook: {
            expiredFormResetFormRender: function() {}
        },
        renderProfileEditorHook: function() {},
        setProcessHook: function(startProcess, endProcess) {
            module.$hooks.processHook.startProcess = startProcess;
            module.$hooks.processHook.endProcess = endProcess;
        },
        mapErrorMessagesHook: function(msg) {
            if (msg.code && msg.message) {
                module.errorMessages.push(msg);
            } else if (isArray(msg)) {
                for (var i = 0; i < msg.length; i++) {
                    if (msg[i].code && msg[i].message) {
                        module.errorMessages.push(msg[i]);
                    } else {
                        throw new Error('Error Message element not valid');
                    }
                }
            } else {
                throw new Error('Error Message not valid');
            }
        },
        setPasswordMeterConfigurationHook: function(config) {
            if (isArray(config)) {
                util.extend(module.passwordMeterConfiguration, config);
            } else {
                throw new Error('Password strength meter configuration is not valid.');
            }
        },
        mapValidationMessagesHook: function(msg) {
            if (msg.rule && msg.message) {
                module.validationMessages.push(msg);
            } else if (isArray(msg)) {
                for (var i = 0; i < msg.length; i++) {
                    if (msg[i].rule && msg[i].message) {
                        module.validationMessages.push(msg[i]);
                    } else {
                        throw new Error('Error Message element not valid');
                    }
                }
            } else {
                throw new Error('Error Message not valid');
            }
        },
        setRegistrationSchemaFilterHook: function(hook) {
            module.$hooks.filterRegistrationSchemaHook = hook;
        },
        setExpiredPasswordResetFormRnderHook: function(hook) {
            module.$hooks.loginHook.expiredFormResetFormRender = hook;
        },
        setFormCustomLabelHook: function(lables) {
            util.extend(module.formCustomLabel, lables);
        },
        setFormCustomPlaceholderHook: function(placeholders) {
            util.extend(module.formPlaceholder, placeholders);
        },
        setFormValidationRulesHook: function(validations) {
            util.extend(module.formValidations, validations);
        },
        setFormAttributesHook: function(attributes) {
            util.extend(module.formElementAttributes, attributes);
        },
        //gets localeinfo object as an input and populates module custom labels,placeholders ,validations and attributes based on locale.
        setLocaleBasedInfoHook: function(localeInfo) {
            for (var key in localeInfo) {
                if (localeInfo.hasOwnProperty(key)) {
                    switch (key) {
                        case "labels":
                            util.extend(module.formCustomLabel, localeInfo[key]);
                            break;
                        case "placeholders":
                            util.extend(module.formPlaceholder, localeInfo[key]);
                            break;
                        case "validationMessages":
                            module.$hooks.mapValidationMessagesHook(localeInfo[key]);
                            break;
                        case "errorMessages":
                            module.$hooks.mapErrorMessagesHook(localeInfo[key]);
                            break;
                        case "passwordMeterConfiguration":
                            module.$hooks.setPasswordMeterConfigurationHook(localeInfo[key]);
                            break;
                        default:
                            break;
                    }
                }
            }
        },

    };
    //end hook model


    var util = this.util = {};
    util.elementById = function(id) {
        return document.getElementById(id);
    };
    util.elementsByClass = function elementsByClass(classname, node) {
        node = node || document.body;
        var a = [],
            re = new RegExp('(^| )' + classname + '( |$)');
        var els = node.getElementsByTagName("*");
        for (var i = 0, j = els.length; i < j; i++) {
            if (re.test(els[i].className)) {
                a.push(els[i]);
            }
        }
        return a;
    };
    util.getThisObjectName = function() {
        for (var name in context.global)
            if (context.global[name] == context)
                return name;
    }
    util.isValidUrl = function(urlToValidate) {
        var myRegExp = /^(?:(?:https?|ftp):\/\/)(?:\S+(?::\S*)?@)?(?:(?!10(?:\.\d{1,3}){3})(?!127(?:\.\d{1,3}){3})(?!169\.254(?:\.\d{1,3}){2})(?!192\.168(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]+-?)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]+-?)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/[^\s]*)?$/i;

        if (!myRegExp.test(urlToValidate)) {
            return false;
        } else {
            return true;
        }

    };
    util.isMobile = {
        android: function() {
            return navigator.userAgent.match(/Android/i);
        },
        blackBerry: function() {
            return navigator.userAgent.match(/BlackBerry/i);
        },
        iOS: function() {
            return navigator.userAgent.match(/iPhone|iPad|iPod/i);
        },
        opera: function() {
            return navigator.userAgent.match(/Opera Mini/i);
        },
        windows: function() {
            return navigator.userAgent.match(/IEMobile/i) || navigator.userAgent.match(/WPDesktop/i);
        },
        any: function() {
            return (util.isMobile.android() || util.isMobile.blackBerry() || util.isMobile.iOS() || util.isMobile.opera() || util.isMobile.windows());
        }
    };
    util.setOpenIdValue = function(lrOpenIdValue, isOpenPopup) {

        if (lrOpenIdValue != null && lrOpenIdValue != "") {
            var lrOpenIdiInput = util.elementsByClass('lr_hid_openidurl');

            for (var i = 0; i < lrOpenIdiInput.length; i++) {
                lrOpenIdiInput[i].value = lrOpenIdValue;
            }
            if (isOpenPopup) {
                // util.toggleOpenIdProcessing('block');
                util.validateOpenIdEndpoint(lrOpenIdValue);
            }
        } else {
            util.openIdValidationMessage('please enter openId value', 'block');
        }
    };
    util.hideOpenIdPopup = function() {
        var elem = util.elementById('lr_openid_popup');
        if (elem) {
            elem.style.display = 'none';
            util.resetLROpenIdPopup();
            return false;
        }
        return false;
    };
    util.resetLROpenIdPopup = function() {
        var lrPopupInput = util.elementsByClass('lr-pop-input');
        for (var j = 0; j < lrPopupInput.length; j++) {
            lrPopupInput[j].value = "";
            lrPopupInput[j].setAttribute('data-title', '');

        }
        util.toggleOpenIdProcessing('none');
        util.openIdValidationMessage('', 'none');
    };
    util.toggleOpenIdProcessing = function(displayStatus) {
        var lrOpenIdProcessiong = util.elementsByClass('lr-loading-frame');
        if (lrOpenIdProcessiong != undefined && lrOpenIdProcessiong != "") {
            lrOpenIdProcessiong[0].style.display = displayStatus;
        }
    };
    util.setLRCurrentProvider = function(activeProvider) {
        var lrLoginProvider = util.elementsByClass('lr_login_provider');
        var lrPopupPlaceholder = util.elementsByClass('lr-pop-placeholder');
        for (var i = 0; i < lrLoginProvider.length; i++) {
            lrLoginProvider[i].innerHTML = "Login with your " + activeProvider + " account";
            lrPopupPlaceholder[i].innerHTML = "Enter your  " + activeProvider + " ID";

        }
        var openIdPopupIcon = util.elementsByClass('lr-pop-icon')[0];
        openIdPopupIcon.className = '';
        util.addclass(openIdPopupIcon, 'lr-pop-icon');
        util.addclass(openIdPopupIcon, 'lr-img-icon-' + activeProvider.toLowerCase());
    }

    util.openIdValidationMessage = function(message, displayStatus) {
        var elem = util.elementsByClass('lr_pop_message')[0];
        elem.innerHTML = message;
        elem.style.display = displayStatus;
    };

    util.getInterfaceWidth = function(iconSize, noOfColumns, Margin, extraWidth) {
        return parseInt(iconSize * noOfColumns, 10) + parseInt(noOfColumns * Margin, 10) + parseInt(extraWidth, 10);

    };
    util.addCss = function(element, styles) {
        if (element && element.style) {
            for (var s in styles) {
                if (element.style[s]) {
                    element.style[s].cssText += styles[s];
                }
            }
            return true;
        }
        return false;
    };
    util.addExternalCss = function(stylesheet, context) {
        context = context || document;
        var head = context.getElementsByTagName('head')[0];
        var cssfile = context.createElement("link");
        cssfile.rel = 'stylesheet';
        cssfile.type = 'text/css';
        cssfile.media = 'all';
        cssfile.href = stylesheet;
        head.appendChild(cssfile);
        return true;
    };
    util.addEmbedCss = function(style, context) {
        context = context || document;
        var st = context.createElement('style');
        st.type = "text/css";
        //st.innerHTML = style;
        if (st.styleSheet) {
            // IE
            st.styleSheet.cssText = style;
        } else {
            st.appendChild(document.createTextNode(style));
        }

        context.getElementsByTagName('head')[0].appendChild(st);
        return true;
    };
    util.hasClass = function(ele, cls) {
        return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
    };
    util.addclass = function(ele, cls) {
        if (!util.hasClass(ele, cls)) {
            ele.className += " " + cls;
            return true;
        }
        return false;
    };
    util.removeclass = function(ele, cls) {
        if (util.hasClass(ele, cls)) {
            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
            ele.className = ele.className.replace(reg, ' ');
            return true;
        }
        return false;
    };
    util.getPosition = function(el) {
        for (var lx = 0, ly = 0; el != null; lx += el.offsetLeft, ly += el.offsetTop, el = el.offsetParent) {}
        return {
            x: lx,
            y: ly
        };
    };
    util.getPageSize = function() {
        var xScroll, pageHeight, pageWidth,
            yScroll;
        if (window.innerHeight && window.scrollMaxY) {
            xScroll = document.body.scrollWidth;
            yScroll = window.innerHeight + window.scrollMaxY;
        } else if (document.body.scrollHeight > document.body.offsetHeight) {
            // all but Explorer Mac
            xScroll = document.body.scrollWidth;
            yScroll = document.body.scrollHeight;
        } else {
            // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
            xScroll = document.body.offsetWidth;
            yScroll = document.body.offsetHeight;
        }

        var windowWidth = 0,
            windowHeight = 0;
        if (self.innerHeight) {
            // all except Explorer
            windowWidth = self.innerWidth;
            windowHeight = self.innerHeight;
        } else if (document.documentElement && document.documentElement.clientHeight) {
            // Explorer 6 Strict Mode
            windowWidth = document.documentElement.clientWidth;
            windowHeight = document.documentElement.clientHeight;
        } else if (document.body) {
            // other Explorers
            windowWidth = document.body.clientWidth;
            windowHeight = document.body.clientHeight;
        }

        // for small pages with total height less then height of the viewport
        if (yScroll < windowHeight)
            pageHeight = windowHeight;
        else
            pageHeight = yScroll;

        // for small pages with total width less then width of the viewport
        if (xScroll < windowWidth)
            pageWidth = windowWidth;
        else
            pageWidth = xScroll;

        if (navigator.userAgent.indexOf("Firefox") != -1) {
            pageWidth = pageWidth - 17;
        }

        return {
            "pageWidth": pageWidth,
            "pageHeight": pageHeight,
            "windowWidth": windowWidth,
            "windowHeight": windowHeight
        };
    };
    util.setOverlay = function(fadeElement) {
        ///Get screen dimesions
        var arrScrDim = util.getPageSize();

        ///Set dimensions of background div
        util.elementById(fadeElement).style.width = (arrScrDim["pageWidth"] + 'px');
        util.elementById(fadeElement).style.height = (arrScrDim["pageHeight"] + 'px');
    };
    ///Show popup
    util.showPopupInterface = function(container, fadeElement) {
        util.setOverlay(fadeElement);

        ///Display popup and background divs
        util.elementById(container).style.display = 'block';
        util.elementById(fadeElement).style.display = 'block';
    };

    ///Close popup
    util.closePopupInterface = function(container, fadeElement) {
        util.elementById(container).style.display = 'none';
        util.elementById(fadeElement).style.display = 'none';
    };
    util.contentIframe = function(parent, child, cssfile, afterload) {
        var iframe = document.createElement('iframe');
        iframe.id = ('Loginradius' + Math.floor((Math.random() * 1000000000000000000) + 1));
        iframe.frameBorder = '0';
        iframe.scrolling = 'no';
        iframe.marginWidth = '0';
        iframe.marginHeight = '0';
        iframe.hspace = '0';
        iframe.vspace = '0';
        iframe.allowTransparency = 'true';
        parent.innerHTML = '';
        parent.appendChild(iframe);

        var idocument;
        if (iframe.contentDocument) {
            idocument = iframe.contentDocument;
        } else if (iframe.contentWindow && iframe.contentWindow.document) {
            idocument = iframe.contentWindow.document;
        }
        idocument.open();
        idocument.write("<!DOCTYPE html>");
        idocument.write("<html>");
        idocument.write("<head></head>");
        idocument.write("<body></body>");
        idocument.write("</html>");
        idocument.close();

        window.setTimeout(function() {
            var iframeDoc;
            if (iframe.contentDocument) {
                iframeDoc = iframe.contentDocument;
            } else if (iframe.contentWindow && iframe.contentWindow.document) {
                iframeDoc = iframe.contentWindow.document;
            }

            if (iframeDoc && iframeDoc.readyState == "complete") {
                iframeDoc.body.innerHTML = child;
                if (lrOptions.isConnectingTextOnInterface) {
                    iframeDoc.body.innerHTML += module.processingMessage;
                }
                util.addExternalCss(cssfile, iframeDoc);
                util.addEmbedCss('body {margin:0px; padding:0px;background:transparent;} .lr_sociallogin_processing {display: block;padding: 4px 5px;background: #eee;width: 150px;margin: 0 auto;color: #444;text-align: left;border-radius: 5px;border: 1px solid #ccc;height: 13px;font-size: 13px;}.lr_sociallogin_processing:before {content: "";display: inline-block;width: 16px;height: 16px;margin-right: 5px;background: url(' + cdnDomain + '/images/loading_spinner_blank.gif);background-size: 16px;vertical-align: bottom;}', iframeDoc);




                if (!browser.msie) {
                    if (lrOptions.highlightPreviousProvider) {
                        if (getBrowserStorage('currentProvider') != undefined) {

                            var providerelements = iframeDoc.getElementsByClassName("lr_" + getBrowserStorage('currentProvider'));
                            providerelements[0].className = providerelements[0].className + " " + "provideractive";
                        }
                    }
                }
                  var scriptObj = iframeDoc.createElement("script");
            scriptObj.type = "text/javascript";
            var objectname = util.getThisObjectName();
            scriptObj.innerHTML = "var "+objectname+"=window.parent."+objectname;
           
                iframeDoc.head.appendChild(scriptObj);
                afterload(iframe, parent);
            }
        }, 1000);

        if (!module.WhiteLabel) {
            parent.insertAdjacentHTML('beforeend', module.securedByLrLink);
        }

        return iframe;
    };
    util.slider = function(container, itemclass, nextclass, prevclass, noofitemsinslide) {
        var items = util.elementsByClass(itemclass, container);

        var next = util.elementsByClass(nextclass, container)[0];
        var prev = util.elementsByClass(prevclass, container)[0];

        moveSlide(items, next, prev, noofitemsinslide, 1);

        util.addEvent('click', next, function() {
            moveSlide(items, next, prev, noofitemsinslide, 1);

            return false;
        });

        util.addEvent('click', prev, function() {
            moveSlide(items, next, prev, noofitemsinslide, -1);

            return false;
        });
    };
    util.isIE8Browser = function() {
        var ua = navigator.userAgent,
            tem,
            M = ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
        if (/trident/i.test(M[1])) {
            tem = /\brv[ :]+(\d+)/g.exec(ua) || [];
            return 'IE ' + (tem[1] || '');
        }
        if (M[1] === 'Chrome') {
            tem = ua.match(/\bOPR\/(\d+)/)
            if (tem != null) return 'Opera ' + tem[1];
        }
        M = M[2] ? [M[1], M[2]] : [navigator.appName, navigator.appVersion, '-?'];
        if ((tem = ua.match(/version\/(\d+)/i)) != null) M.splice(1, 1, tem[1]);


        if (M.join(' ') == "MSIE 8" || M.join(' ') == "MSIE 9") {
            return true;
        }
        return false;
    }
    util.isInt = function(n) {
        var a = typeof n === 'number' && parseFloat(n) == parseInt(n, 10) && !isNaN(n);
        return a;
    };

    function moveSlide(items, next, prev, noofitemsinslide, diff) {
        var noofpages = Math.ceil((items.length) / noofitemsinslide) - 1;

        if (noofitemsinslide == 1) {
            if (items.length <= 1) {
                next.style.display = "none";
                prev.style.display = "none";
            }
        } else {
            if ((items.length - 1) <= 1) {
                next.style.display = "none";
                prev.style.display = "none";
            }
        }
        var currentpage = parseInt(next.href.substring(next.href.indexOf("#") + 1)) + diff;

        var startindex;
        var endindex;

        if (currentpage <= noofpages && currentpage >= 0) {
            startindex = currentpage * noofitemsinslide;
            endindex = startindex + noofitemsinslide - 1;

            next.href = "#" + currentpage;
            prev.href = "#" + currentpage;
        } else if (currentpage == -1) {
            startindex = noofpages * noofitemsinslide;
            endindex = startindex + noofitemsinslide - 1;

            next.href = "#" + noofpages;
            prev.href = "#" + noofpages;
        } else {
            startindex = 0;
            endindex = noofitemsinslide - 1;

            next.href = "#0";
            prev.href = "#0";
        }

        for (var i = 0; i < items.length; i++) {
            if (i >= startindex && i <= endindex) {
                items[i].style.display = "block";
            } else {
                items[i].style.display = "none";
            }
        }
    }
    //highlight provider end show processing
    util.beforeLogin = function(displayStatus, currentProvider) {
            var lrInterfacediv = util.elementsByClass(lrOptions.interfaceContainer);

            for (var p = 0; p < lrInterfacediv.length; p++) {
                if (lrOptions.noVirtualIframe) {

                    var iframeDocument = document;

                    if (lrOptions.highlightPreviousProvider && !browser.msie) {

                        if (getBrowserStorage('currentProvider') != undefined) {
                            var providerClass = "lr_" + getBrowserStorage('currentProvider');
                            var providerElements = iframeDocument.getElementsByClassName(providerClass);

                            providerElements[0].className = providerElements[0].className.replace('provideractive', '');
                        }

                        providerClass = "lr_" + currentProvider;
                        providerElements = iframeDocument.getElementsByClassName(providerClass);
                        providerElements[0].className = providerElements[0].className + " " + "provideractive";
                    }

                    var pi = iframeDocument.getElementById('lr_sociallogin_processing');
                    if (pi != null) {
                        pi.style.display = displayStatus;
                    }

                } else {


                    var ifr = lrInterfacediv[p].getElementsByTagName('iframe')[0];
                    if (ifr) {
                        var iframeDocument = ifr.contentDocument || HTMLIFrameElement.window.contentDocument;

                        if (lrOptions.highlightPreviousProvider && !browser.msie) {

                            if (getBrowserStorage('currentProvider') != undefined) {
                                var providerClass = "lr_" + getBrowserStorage('currentProvider');
                                var providerElements = iframeDocument.getElementsByClassName(providerClass);

                                providerElements[0].className = providerElements[0].className.replace('provideractive', '');
                            }

                            providerClass = "lr_" + currentProvider;
                            providerElements = iframeDocument.getElementsByClassName(providerClass);
                            providerElements[0].className = providerElements[0].className + " " + "provideractive";
                        }

                        var pi = iframeDocument.getElementById('lr_sociallogin_processing');
                        if (pi != null) {
                            pi.style.display = displayStatus;
                        }
                    }
                }
            }
            if (lrOptions.highlightPreviousProvider && !browser.msie) {
                setBrowserStorage('currentProvider', currentProvider);
            }

        }
        //end highlight provider end show processing

    //validateOpenIdEndpoint
    util.validateOpenIdEndpoint = function(lrOpenIdValue) {
        var hiddenInputUrl = util.elementsByClass('lr_hid_url');
        var _url = hiddenInputUrl[0].value;
        var parser = document.createElement('a');
        parser.href = hiddenInputUrl[0].value;
        var provider = util.getQueryParameterByName("provider", parser.search);

        if (provider == "openid" && provider.indexOf("{username}") == -1) {
            if (!util.isValidUrl(lrOpenIdValue)) {
                util.openIdValidationMessage('The specified url is not a valid OpenID endpoint', 'block');
                util.toggleOpenIdProcessing('none');
                return false;
            }
        }
        _url = _url + "&openidusername=" + lrOpenIdValue;

        util.resetLROpenIdPopup();
        hiddenInputUrl[0].value = _url;
        util.openWindow(_url, true);
    };

    util.serialize = function(form) {
        if (!form || form.nodeName !== "FORM") {
            return;
        }
        var i,
            j,
            q = [];
        for (i = form.elements.length - 1; i >= 0; i = i - 1) {
            if (form.elements[i].name === "") {
                continue;
            }

            if (form.elements[i].name === "email") {
                form.elements[i].value = form.elements[i].value.toLowerCase();
            }

            switch (form.elements[i].nodeName) {
                case "INPUT":
                    switch (form.elements[i].type) {
                        case "text":
                        case "hidden":
                        case "button":
                        case "reset":
                        case "submit":
                            q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value.trim()));
                            break;
                        case "password":
                            q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value));
                            break;
                        case "email":
                            q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value));
                            break;
                        case "checkbox":
                        case "radio":
                            if (form.elements[i].checked) {
                                q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value));
                            }
                            break;
                        case "file":
                            break
                    }
                    break;
                case "TEXTAREA":
                    q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value.trim()));
                    break;
                case "SELECT":
                    switch (form.elements[i].type) {
                        case "select-one":
                            q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value.trim()));
                            break;
                        case "select-multiple":
                            for (j = form.elements[i].options.length - 1; j >= 0; j = j - 1) {
                                if (form.elements[i].options[j].selected) {
                                    q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].options[j].value.trim()));
                                }
                            }
                            break;
                    }
                    break;
                case "BUTTON":
                    switch (form.elements[i].type) {
                        case "reset":
                        case "submit":
                        case "button":
                            q.push(form.elements[i].name + "=" + encodeURIComponent(form.elements[i].value.trim()));
                            break;
                    }
                    break;
            }
        }
        return q.join("&");
    };

    util.addJs = function(url, context) {
        context = context || document;
        var head = context.getElementsByTagName('head')[0];
        var js = context.createElement('script');
        js.src = url;

        js.type = "text/javascript";
        head.appendChild(js);

        return js;
    };

    util.hashTmpl = function hashTmpl(str, data) {
        var fn = !/\W/.test(str) ? cache[str] = cache[str] ||
            hashTmpl(util.elementById(str).innerHTML) :
            new Function("obj",
                "var p=[],print=function(){p.push.apply(p,arguments);};" +
                "with(obj){p.push('" +
                str.replace(/[\r\t\n]/g, " ").split("<#")
                .join("\t").replace(
                    /((^|#>)[^\t]*)'/g, "$1\r")
                .replace(/\t=(.*?)#>/g, "',$1,'")
                .split("\t").join("');")
                .split("#>").join("p.push('")
                .split("\r").join("\\'") +
                "');}return p.join('');");
        return data ? fn(data) : fn;

    };


    util.addEvent = function addEvent(type, element, handle) {
        var elements = [];
        if (element instanceof Array) {
            elements = element;
        } else {
            elements.push(element);
        }
        for (var i = 0; i < elements.length; i++) {
            elements[i]["on" + type] = handle;
        }
    };

    var cache = {};
    util.tmpl = function tmpl(str, data) {
        var fn = !/\W/.test(str) ? cache[str] = cache[str] || tmpl(util.elementById(str).innerHTML) : new Function("obj", "var p=[],print=function(){p.push.apply(p,arguments);};" + "with(obj){p.push('" + str.replace(/[\r\t\n]/g, " ").split("<%").join("\t").replace(/((^|%>)[^\t]*)'/g, "$1\r").replace(/\t=(.*?)%>/g, "',$1,'").split("\t").join("');").split("%>").join("p.push('").split("\r").join("\\'") + "');}return p.join('');");
        return data ? fn(data) : fn;
    };

    util.getQueryParameterByName = function(name, search) {
        search = search || location.search;
        name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(search);
        return results == null ? null : decodeURIComponent(results[1].replace(/\+/g, " "));
    };

    util.getParameterByName = function(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }

    util.getQueryStringValue = function(url, key) {
        var href = url ? url : window.location.href;
        var reg = new RegExp('[?&]' + key + '=([^&#]*)', 'i');
        var string = reg.exec(href);

        return string ? string[1] : null;
    }
    util.extend = function(obj1, obj2) {
        for (var i in obj2) {
            if (obj2.hasOwnProperty(i)) {
                obj1[i] = obj2[i];
            }
        }
    };

    // Everything that has to do with properly supporting our document ready event. Brought over from the most awesome jQuery.
    var userAgent = navigator.userAgent.toLowerCase();

    // Figure out what browser is being used
    var browser = {
        version: (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1],
        safari: /webkit/.test(userAgent),
        opera: /opera/.test(userAgent),
        msie: (/msie/.test(userAgent) || /trident/.test(userAgent)) && (!/opera/.test(userAgent)),
        mozilla: (/mozilla/.test(userAgent)) && (!/(compatible|webkit)/.test(userAgent))
    };
    util.browser = browser;

    var readyBound = false;
    var isReady = false;
    var readyList = [];

    // Handle when the DOM is ready

    function domReady() {
        // Make sure that the DOM is not already loaded
        if (!isReady) {
            // Remember that the DOM is ready
            isReady = true;

            if (readyList) {
                for (var fn = 0; fn < readyList.length; fn++) {
                    readyList[fn].call(window, []);
                }

                readyList = [];
            }
        }
    }

    // From Simon Willison. A safe way to fire onload w/o screwing up everyone else.

    function addLoadEvent(func) {
        var oldonload = window.onload;
        if (typeof window.onload != 'function') {
            window.onload = func;
        } else {
            window.onload = function() {
                if (oldonload) {
                    oldonload();
                }
                func();
            };
        }
    };

    // does the heavy work of working through the browsers idiosyncracies (let's call them that) to hook onload.

    function bindReady() {
        if (readyBound) {
            return;
        }

        readyBound = true;

        // Mozilla, Opera (see further below for it) and webkit nightlies currently support this event
        if (document.addEventListener && !browser.opera) {
            // Use the handy event callback
            document.addEventListener("DOMContentLoaded", domReady, false);
        }

        // If IE is used and is not in a frame
        // Continually check to see if the document is ready
        if (browser.msie && window == top)
            (function() {
                if (isReady)
                    return;
                try {
                    // If IE is used, use the trick by Diego Perini
                    // http://javascript.nwbox.com/IEContentLoaded/
                    document.documentElement.doScroll("left");
                } catch (error) {
                    // setTimeout(arguments.callee, 0);
                    return;
                }
                // and execute any waiting functions
                domReady();
            })();

        if (browser.opera) {
            document.addEventListener("DOMContentLoaded", function() {
                if (isReady)
                    return;
                for (var i = 0; i < document.styleSheets.length; i++)
                    if (document.styleSheets[i].disabled) {
                        // setTimeout(arguments.callee, 0);
                        return;
                    }
                    // and execute any waiting functions
                domReady();
            }, false);
        }

        if (browser.safari) {
            var numStyles;
            (function() {
                if (isReady)
                    return;
                if (document.readyState != "loaded" && document.readyState != "complete") {
                    // setTimeout(arguments.callee, 0);
                    return;
                }
                if (numStyles === undefined) {
                    var links = document.getElementsByTagName("link");
                    for (var i = 0; i < links.length; i++) {
                        if (links[i].getAttribute('rel') == 'stylesheet') {
                            numStyles++;
                        }
                    }
                    var styles = document.getElementsByTagName("style");
                    numStyles += styles.length;
                }
                if (document.styleSheets.length != numStyles) {
                    //setTimeout(arguments.callee, 0);
                    return;
                }

                // and execute any waiting functions
                domReady();
            })();
        }

        // A fallback to window.onload, that will always work
        addLoadEvent(domReady);
    };

    // This is the public function that people can use to hook up ready.
    util.ready = function(fn, args) {
        // Attach the listeners
        bindReady();

        // If the DOM is already ready
        if (isReady) {
            // Execute the function immediately
            fn.call(window, []);
        } else {
            // Add the function to the wait list
            readyList.push(function() {
                return fn.call(window, []);
            });
        }
    };

    util.isJsonString = function(str) {
        try {
            return JSON.parse(str);
        } catch (e) {
            return false;
        }

    };
    util.jsonpCall = function(url, handle, callabck) {
        if (module.$hooks.processHook.startProcess) {
            module.$hooks.processHook.startProcess();
        }

        var func = callabck || 'Loginradius' + Math.floor((Math.random() * 1000000000000000000) + 1);
        window[func] = function(data) {

            // error mesage mapper
            if (data.errorCode) {
                setMappedMessage(data);
            }

            handle(data);

            if (module.$hooks.processHook.endProcess) {
                module.$hooks.processHook.endProcess();
            }
        };

        var endurl = url.indexOf('?') != -1 ? url + '&callback=' + func : url + '?callback=' + func;
        var js = util.addJs(endurl);
    };
    util.ajaxCall = function(method, url, data, successHandler, callback) {
        if (module.$hooks.processHook.startProcess) {
            module.$hooks.processHook.startProcess();
        }
        try {
            var xhr = new XMLHttpRequest();
            xhr.open(method, url, true);

            if (data) {
                if (typeof data === 'string' || data instanceof String) {
                    data = JSON.stringify(parseQueryString(data));
                } else {
                    data = JSON.stringify(data);
                }

              
                xhr.setRequestHeader('Content-Type', 'application/json');
                xhr.send(data);
            } else
                xhr.send(null);

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    var response = xhr.response;
                    if (xhr.status == "500") {
                        var _response = JSON.parse(response);
                        _response.ErrorCode = "500";
                        response = JSON.stringify(_response)


                    }
                    // else if (xhr.status == "200") {
                    var result;
                    if (result = util.isJsonString(response)) {
                        successHandler(result);
                    } else {
                        var func = callback || 'Loginradius' + Math.floor((Math.random() * 1000000000000000000) + 1);
                        window[func] = function(data) {
                            successHandler(data);
                        };
                        var endurl = url.indexOf('?') != -1 ? url + '&callback=' + func : url + '?callback=' + func;
                        var js = util.addJs(endurl);
                    }
                    //  }
                }

            };
        } catch (error) {
            console.log(error);
        }
        if (module.$hooks.processHook.endProcess) {
            module.$hooks.processHook.endProcess();
        }
    }




    // {"code" : 00,"Message" : "this is Message"}
    module.errorMessages = [];
    module.validationMessages = [];
    module.formCustomLabel = {};
    module.formValidations = {};
    module.formPlaceholder = {};
    module.formElementAttributes = {};
    module.passwordMeterConfiguration = [];




    //  var onGetAccountDetails = function () { };
    //end hook model

    function getPasswordMeterConfiguration() {
        var defaultCase = {
            0: "worst",
            1: "bad",
            2: "weak",
            3: "good",
            4: "strong",
            5: "secure"
        };
        var defaultColor = {
            0: "#dd514c",
            1: "orange",
            2: "yellow",
            3: "#5eb95e",
            4: "blue",
            5: "violet"
        };
        var defaultMessage = {
            0: "Your password should be at least 6 characters long.",
            1: "Bad",
            2: "Weak",
            3: "Good",
            4: "Strong",
            5: "Secure"
        };

        function config() {
            var temp = [];
            var input = module.passwordMeterConfiguration;
            for (var j in defaultCase) {
                if (input[j] && input[j].case) {
                    if (input[j].case.toLowerCase() == defaultCase[j]) {
                        temp.push({
                            color: input[j].color ? input[j].color : defaultColor[j],
                            Message: input[j].Message ? input[j].Message : defaultMessage[j]
                        });
                    }
                } else {
                    temp.push({
                        color: defaultColor[j],
                        Message: defaultMessage[j]
                    });
                }
            }
            return temp;
        }
        return config();
    }

    function setMappedMessage(lrMessage) {
        for (var i = 0; i < module.errorMessages.length; i++) {
            if (module.errorMessages[i].code == lrMessage.ErrorCode) {
                lrMessage.Message = module.errorMessages[i].Message || lrMessage.Message;
                lrMessage.Description = module.errorMessages[i].Description || lrMessage.Description;
            }
        }
        return lrMessage;
    }

    function setCustomLabel(schema) {
        for (var i = 0; i < schema.length; i++) {
            if (module.formCustomLabel[schema[i].name]) {
                schema[i].display = module.formCustomLabel[schema[i].name];
            }
        }
    }

    function setPlaceholder(schema) {
        for (var i = 0; i < schema.length; i++) {
            if (module.formPlaceholder[schema[i].name]) {
                schema[i].placeholder = module.formPlaceholder[schema[i].name];
            }
        }
    }

    function setValidation(schema) {
        if (module.formValidations[schema.name]) {
            if (schema.rules && schema.rules != '') {
                var str = module.formValidations[schema.name];

                schema.rules = schema.rules + "|" + module.formValidations[schema.name];
                if (str.indexOf("min_length") > -1) {
                    var minlength = str.match(/min_length\[(.*?)\]/);
                    if (minlength[1])
                        schema.rules = schema.rules.replace("min_length[6]", "min_length[" + minlength[1] + "]");
                } else if (str.indexOf("max_length") > -1) {
                    var maxlength = str.match(/min_length\[(.*?)\]/);
                    if (maxlength[1])
                        schema.rules = schema.rules.replace("max_length[32]", "max_length[" + maxlength[1] + "]");
                }

            } else {
                schema.rules = module.formValidations[schema.name];
            }
        }
    }

    function setAttribute(schema, elem) {
        if (module.formElementAttributes[schema.name]) {
            var attribites = module.formElementAttributes[schema.name].split('&');
            for (var i = 0; i < attribites.length; i++) {
                var attribute = attribites[i].split('=');
                var key = attribute[0];
                var value = attribute[1];
                elem.setAttribute(key, value);
            }

        }
    }


    function isArray(o) {
        return Object.prototype.toString.call(o) === '[object Array]';
    }

    function parseQueryString(qs) {
        var obj = {};
        if (qs || qs != '') {
            var nodes = qs.split('&');
            for (var i = 0; i < nodes.length; i++) {
                var keyValue = nodes[i].split("=");
                obj[decodeURIComponent(keyValue[0])] = decodeURIComponent(keyValue[1]);
            }
        }
        return obj;
    }


    function jsonToQueryString(json) {
        return Object.keys(json).map(function(key) {
            if (json[key]) {
                return encodeURIComponent(key) + '=' + encodeURIComponent(json[key]);
            }
        }).join('&');
    }

    function isCustomValidation(fieldValue, parmValue) {
        parmValue = parmValue.split('###')[0];

        var regex = new RegExp(parmValue, 'g');
        if (!regex.test(fieldValue)) {
            return false;
        }

        return true;

    }

    function isValidDate(dateString) {
        // First check for the pattern
        if (!/^\d{2}-\d{2}-\d{4}$/.test(dateString))
            return false;

        // Parse the date parts to integers
        var parts = dateString.split("-");
        var day = parseInt(parts[1], 10);
        var month = parseInt(parts[0], 10);
        var year = parseInt(parts[2], 10);

        // Check the ranges of month and year
        if (year < 1000 || year > 3000 || month == 0 || month > 12)
            return false;

        var monthLength = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        // Adjust for leap years
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
            monthLength[1] = 29;

        // Check the range of the day
        return day > 0 && day <= monthLength[month - 1];
    };

    function loginRadiusErrorToJsError(lrerror) {
        var jserror = [];
        jserror.push(lrerror);
        return jserror;
    }

    function createForm(schema, name, containerId, buttonName, onSuccess, onError, classPrefixName) {
        var _idPrefix = classPrefixName || idPrefix;
        var _classPrefix = classPrefixName || classPrefix;

        isRegFormSchemaLock = false;

        setCustomLabel(schema);
        setPlaceholder(schema);

        if (schema.length > 0) {
            var validationSchema = [];

            var form = document.createElement('form');
            form.setAttribute("name", _idPrefix + name);
            form.setAttribute("method", "POST");

            for (var i = 0; i < schema.length; i++) {
                if (schema[i]) {

                    setValidation(schema[i]);

                    validationSchema[i] = {};
                    validationSchema[i].name = schema[i].name;
                    validationSchema[i].display = schema[i].display;
                    validationSchema[i].rules = schema[i].rules;

                    var elem;
                    switch (schema[i].type) {
                        case 'text':
                            {
                                elem = document.createElement('textarea');
                                break;
                            }
                        case 'html':
                            {
                                elem = document.createElement('div');
                                break;
                            }

                        case 'password':
                            {
                                elem = document.createElement('input');
                                elem.type = "password";
                                break;
                            }
                        case 'hidden':
                            {
                                elem = document.createElement('input');
                                elem.type = "hidden";
                                elem.value = schema[i].value;
                                break;
                            }
                        case 'option':
                            {
                                elem = document.createElement('select');
                                var selectLable = document.createElement('option');
                                selectLable.appendChild(document.createTextNode("-- select --"));
                                selectLable.setAttribute('value', '');
                                elem.appendChild(selectLable);

                                for (var j = 0; j < schema[i].options.length; j++) {
                                    var option = document.createElement('option');
                                    option.setAttribute('value', schema[i].options[j].value);
                                    option.appendChild(document.createTextNode(schema[i].options[j].text));
                                    elem.appendChild(option);
                                }
                                break;
                            }
                        case 'multi':
                            {
                                elem = document.createElement('input');
                                elem.type = "checkbox";
                                break;
                            }
                        case 'email':
                            {
                                elem = document.createElement('input');
                                elem.type = "email";
                                break;
                            }
                        case 'eventclick':
                            {
                                elem = document.createElement("input");
                                elem.type = "button";
                                elem.value = "Resend OTP";



                                break;
                            }
                        default:
                            {
                                elem = document.createElement('input');
                                elem.type = "text";
                                break;
                            }
                    }

                    setAttribute(schema[i], elem);

                    if (schema[i].placeholder) {
                        elem.placeholder = schema[i].placeholder;
                    }

                    if (schema[i].type == 'html') {

                        var div = document.createElement('div');
                        div.setAttribute("class", _classPrefix + '-form-element-content' + ' content-' + _idPrefix + schema[i].name);

                        div.innerHTML = schema[i].html;

                        form.appendChild(div);
                    } else {
                        elem.setAttribute("name", schema[i].name);

                        if (schema[i].name == "email") {
                            util.addEvent("keyup", elem, function(event) {
                                if (event.keyCode == 32) {
                                    this.value = this.value.trim();
                                }
                            });
                        }

                        elem.setAttribute("id", _idPrefix + name + "-" + schema[i].name);

                        if (schema[i].type == 'hidden') {
                            form.appendChild(elem);
                        } else {
                            var label = document.createElement('label');
                            label.setAttribute("for", _idPrefix + name + "-" + schema[i].name);
                            label.innerHTML = schema[i].display;

                            elem.setAttribute("class", _classPrefix + schema[i].type + ' ' + _idPrefix + schema[i].name);

                            var containerDiv = document.createElement('div');
                            containerDiv.setAttribute("class", _classPrefix + '-form-element-content' + ' content-' + _idPrefix + schema[i].name);

                            if (schema[i].type == "multi") {
                                containerDiv.appendChild(elem);
                                containerDiv.appendChild(label);

                            } else {
                                containerDiv.appendChild(label);
                                containerDiv.appendChild(elem);
                            }

                            if (lrOptions.inFormvalidationMessage) {
                                var validationdiv = document.createElement('div');
                                validationdiv.setAttribute("id", "validation-" + _idPrefix + name + "-" + schema[i].name);
                                validationdiv.setAttribute("class", _classPrefix + "validation-message" + " validation-" + _idPrefix + schema[i].name);
                                containerDiv.appendChild(validationdiv);
                            }

                            if (lrOptions.checkPasswordStrength && (elem.name == "password" || elem.name == "newpassword") && (name == "registration" || name == "resetpassword" || name == "setpassword" || name == "changepassword" || name == "social-registration")) {
                                var minlength = 6,
                                    maxlength = 32;
                                if (schema[i].rules) {
                                    var rules = schema[i].rules.split("|");
                                    for (var r in rules) {
                                        if (rules[r].indexOf("min_length") > -1) {
                                            minlength = rules[r].substring(11, (rules[r].length - 1));
                                        } else if (rules[r].indexOf("max_length") > -1) {
                                            maxlength = rules[r].substring(11, (rules[r].length - 1));
                                        }
                                    }
                                }

                                var meterElement = document.createElement("meter");
                                meterElement.setAttribute("max", "4");
                                meterElement.setAttribute("id", name + "-password-strength-meter");
                                var textElement = document.createElement("div");
                                textElement.setAttribute("id", name + "-password-strength-text");
                                elem.parentNode.appendChild(meterElement);
                                elem.parentNode.appendChild(textElement);
                                var meterConfig = getPasswordMeterConfiguration();
                                var cssId = Math.random();
                                util.addEvent("keyup", elem, function(event) {
                                    var txtpass = this.value;

                                    var meter = util.elementById(name + "-password-strength-meter");
                                    var text = util.elementById(name + "-password-strength-text");
                                    text.innerHTML = "";
                                    var score = 0;
                                    if (txtpass.length >= minlength) {
                                        score++;
                                        if ((txtpass.match(/[a-z]/)) && (txtpass.match(/[A-Z]/))) score++;
                                        if (txtpass.match(/\d+/)) score++;
                                        if (txtpass.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/)) score++;
                                        if (txtpass.length > 12) score++;
                                    }
                                    meter.value = score;

                                    var css = util.elementById(cssId) ? util.elementById(cssId) : document.createElement("style");
                                    css.type = "text/css";
                                    css.id = cssId;
                                    css.innerHTML = "#" + name + "-password-strength-meter::-webkit-meter-optimum-value { background: " + meterConfig[score].color + " !important; }";
                                    document.body.appendChild(css);

                                    if (txtpass !== "" && score > 0) {
                                        text.innerHTML = "Strength: " + meterConfig[score].Message;
                                        text.style.color = '';
                                    } else {
                                        if (meterConfig[score].Message.indexOf("#min_length") > -1) {
                                            meterConfig[score].Message = meterConfig[score].Message.replace("#min_length", minlength)
                                        }
                                        text.innerHTML = meterConfig[score].Message;
                                        text.style.color = meterConfig[score].color;
                                    }
                                });
                            }
                            form.appendChild(containerDiv);
                        }
                    }

                }
            }

            var submit = document.createElement('input');

            submit.type = "submit";
            submit.value = buttonName;
            submit.id = _idPrefix + "submit-" + buttonName;
            submit.setAttribute("class", _classPrefix + "submit" + " submit-" + _idPrefix + buttonName);

            form.appendChild(submit);


            //            if (lrOptions.oneClickSignin && name == 'login') {
            //                createOneClickSigninButton(form, submit, _idPrefix, "oneclicksignin", _classPrefix);
            //            }

            var containerElem = util.elementById(containerId);
            containerElem.innerHTML = '';
            containerElem.appendChild(form);

            var validator = new FormValidator(_idPrefix + name, validationSchema, function(errors, evt) {
                var validationdivs = util.elementsByClass(_classPrefix + "validation-message");
                for (var i = 0; i < validationdivs.length; i++) {
                    validationdivs[i].innerHTML = '';
                }


                if (errors.length > 0) {
                    if (lrOptions.inFormvalidationMessage) {
                        for (var i = 0; i < errors.length; i++) {
                            if (errors[i].id == _idPrefix + "" + name + "-password" && lrOptions.oneClickSignin && name == 'login' && window["lroneclicksignin"]) {
                                onSuccess(util.serialize(form));
                                return true;
                                // errors[e].splice(e, 1);
                            } else {
                                util.elementById("validation-" + _idPrefix + name + "-" + errors[i].name).innerHTML = errors[i].message;
                            }
                        }
                    }

                    onError(errors);

                } else {
                    onSuccess(util.serialize(form));
                }

                if (evt && evt.preventDefault) {
                    evt.preventDefault();
                } else if (event) {
                    event.returnValue = false;
                }
            });

            var validDateErrorMessage;
            if (module.validationMessages && module.validationMessages.length > 0) {
                for (var i = 0; i < module.validationMessages.length; i++) {
                    validator.setMessage(module.validationMessages[i].rule, module.validationMessages[i].message);
                    if (module.validationMessages[i].rule == 'valid_date' || module.validationMessages[i].rule == 'callback_valid_date') {
                        validDateErrorMessage = module.validationMessages[i].message;
                    }
                }
            }

            validator.registerCallback('valid_date', function(value) {
                return isValidDate(value);
            }).setMessage('valid_date', (validDateErrorMessage || 'The %s field must contain a valid date (mm-dd-yyyy).'));

            validator.registerCallback('custom_validation', function(value, parm) {
                return isCustomValidation(value, parm);
            }).setMessage('custom_validation', 'The %s field is not valid.');


            module.Validator = validator;
        }
    }

    function invalidatePasswordValidation(name, errors) {
        for (var e = 0; e < errors.length; e++) {
            if (errors[i].id == _idPrefix + "" + name + "-password" && lrOptions.oneClickSignin && name == 'login' && window["lroneclicksignin"]) {
                errors[e].splice(e, 1);
            }
        }
    }

    function createOneClickSigninButton(form, btnLoginSubmit, _idPrefix, buttonName, _classPrefix) {

        if (!lrOptions.oneClickLoginButtonLabel || lrOptions.oneClickLoginButtonLabel == "") {
            lrOptions.oneClickLoginButtonLabel = "Email me a link to sign in";
        }

        var submit = document.createElement('input');

        submit.type = "submit";
        submit.value = lrOptions.oneClickLoginButtonLabel;
        submit.id = _idPrefix + "linksignin-" + buttonName;
        submit.setAttribute("class", _classPrefix + "linksignin" + " linksignin-" + _idPrefix + buttonName);

        form.appendChild(submit);



        util.addEvent("click", btnLoginSubmit, function(event) {
            window["lroneclicksignin"] = false;

        });
        util.addEvent("click", submit, function(event) {
            window["lroneclicksignin"] = true;
        });
    }

    function mapSchema(schema, userprofile) {
        for (var i = 0; i < schema.length; i++) {

            if (lrOptions.enableUserName && !lrOptions.promptPasswordOnSocialLogin) {
                lrOptions.promptPasswordOnSocialLogin = true;
            }


            if (schema[i] && schema[i].name.toLowerCase() == 'firstname' && userprofile.FirstName && userprofile.FirstName != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'lastname' && userprofile.LastName && userprofile.LastName != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'emailid' && userprofile.Email && userprofile.Email.length > 0 && userprofile.Email[0].Value && userprofile.Email[0].Value != '') {

                if (userprofile.EmailVerified) {
                    schema[i] = null;
                } else {
                    if (!lrOptions.askEmailAlwaysForUnverified) {
                        schema[i] = null;
                    }
                }

            } else if (schema[i] && schema[i].name.toLowerCase() == 'birthdate' && userprofile.BirthDate && userprofile.BirthDate != '') {
                var birthdate = userprofile.BirthDate.replace('-', '/').replace('-', '/').split("/");
                if (birthdate[2] && birthdate[2] != '') {
                    schema[i] = null;
                }
            } else if (schema[i] && schema[i].name.toLowerCase() == 'gender' && userprofile.Gender && userprofile.Gender != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'prefix' && userprofile.Prefix && userprofile.Prefix != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'suffix' && userprofile.Suffix && userprofile.Suffix != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'username') {
                if (userprofile.UserName && userprofile.UserName != '') {

                    schema[i] = null;
                } else if (!lrOptions.enableUserName) {
                    schema[i] = null;
                }


            } else if (schema[i] && schema[i].name.toLowerCase() == 'password' && !lrOptions.promptPasswordOnSocialLogin) {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'confirmpassword' && !lrOptions.promptPasswordOnSocialLogin) {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'country' && userprofile.Country && userprofile.Country.Name != null && userprofile.Country.Name != '' && userprofile.Country.Name.toLowerCase() != 'unknown') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'state' && userprofile.State && userprofile.State != '' && userprofile.State.toLowerCase() != 'unknown') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'city' && userprofile.City && userprofile.City != '' && userprofile.City.toLowerCase() != 'unknown') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'phonenumber' && userprofile.PhoneNumbers && userprofile.PhoneNumbers.length > 0 && userprofile.PhoneNumbers[0].PhoneNumber && userprofile.PhoneNumbers[0].PhoneNumber != '') {
                schema[i] = null;
            } else if (schema[i] && schema[i].name.toLowerCase() == 'postalcode' && userprofile.Addresses && userprofile.Addresses.length > 0) {
                for (var p = 0; p < userprofile.Addresses.length; p++) {
                    if (userprofile.Addresses[p].PostalCode != null && userprofile.Addresses[p].PostalCode != "") {
                        schema[i] = null;
                    }
                }
            } else if (schema[i] && schema[i].name.toLowerCase() == 'address1' && userprofile.Addresses && userprofile.Addresses.length > 0) {
                for (var p = 0; p < userprofile.Addresses.length; p++) {
                    if (userprofile.Addresses[p].Address1 != null && userprofile.Addresses[p].Address1 != "") {
                        schema[i] = null;
                    }
                }
            } else if (schema[i] && schema[i].name.toLowerCase() == 'address2' && userprofile.Addresses && userprofile.Addresses.length > 0) {
                for (var p = 0; p < userprofile.Addresses.length; p++) {
                    if (userprofile.Addresses[p].Address2 != null && userprofile.Addresses[p].Address2 != "") {
                        schema[i] = null;
                    }
                }
            } else if (schema[i] && schema[i].name.indexOf("cf_") == 0 && userprofile.CustomFields && userprofile.CustomFields[schema[i].name.replace('cf_', '')]) {
                schema[i] = null;
            }


        }
        schema = schema.filter(function(n) {
            return n
        });

        for (var i = 0; i < schema.length; i++) {
            if (schema[i].rules != null && schema[i].rules != "" && schema[i].rules.indexOf('required') > -1) {
                return schema;
            }
        }

        return [];
    }

    function renderCustomInterface(selector, linkedProvider) {
        var renderedhtml = "";
        util.ajaxCall('get', appJsonUrl + lrOptions.apikey + ".json", "", function(data) {
            var providerstoshow = lrOptions.ProvidersList;
            var templatecompiler = lrOptions.hashTemplate ? util.hashTmpl : util.tmpl;
            var providers = [];
            for (var i = 0; i < data.Providers.length; i++) {
                var provider = {};
                provider.islinked = false;
                provider.providerId = false;

                if (linkedProvider && linkedProvider[data.Providers[i].Name.toLowerCase()]) {
                    provider.islinked = true;
                    provider.providerId = linkedProvider[data.Providers[i].Name.toLowerCase()];
                }

                data.Providers[i].isLinked = provider.islinked;
                data.Providers[i].providerId = provider.providerId;

                var value = data.Providers[i];
                providers.push(value);
            }
            var temp = [];

            for (var i = 0; i < providers.length; i++) {
                if (providers[i].isLinked) {
                    temp.push(providers[i]);
                }
            }
            if (temp.length > 0) {
                for (var i = 0; i < providers.length; i++) {
                    if (!providers[i].isLinked) {
                        temp.push(providers[i]);
                    }
                }
                providers = temp;
            }
            for (var i = 0; i < providers.length; i++) {
                if (providerstoshow !== undefined) {
                    var search = providerstoshow.indexOf(providers[i].Name);
                    if (search != -1) {
                        renderedhtml += templatecompiler(lrOptions.templatename, providers[i]);

                    }
                } else {
                    renderedhtml += templatecompiler(lrOptions.templatename, providers[i]);
                }

            }

            if (selector.indexOf('.') == 0) {
                selector = selector.replace('.', '');
                var elems = util.elementsByClass(selector);
                if (elems && elems.length > 0) {
                    for (var j = 0; j < elems.length; j++) {
                        elems[j].innerHTML = renderedhtml;
                    }
                }
            } else {
                var elem = util.elementById(selector);
                if (elem) {
                    elem.innerHTML = renderedhtml;
                }
            }
        }, "loginRadiusAppJsonLoaded");
    };

    function setPasswordRule(field) {

        lrOptions.passwordLength = lrOptions.passwordlength || lrOptions.passwordLength;

        if (field && lrOptions.passwordLength && lrOptions.passwordLength.min && lrOptions.passwordLength.max) {
            field.rules = field.rules || "";
            field.rules = field.rules.replace("min_length[6]", "min_length[" + lrOptions.passwordLength.min + "]")
                .replace("max_length[32]", "max_length[" + lrOptions.passwordLength.max + "]");
        }
    }

    function isLocalStorageNameSupported(lsname) {
        if (window[lsname]) {
            var testKey = 'test',
                storage = window[lsname];
            try {
                storage.setItem(testKey, '1');
                storage.removeItem(testKey);
                return true;
            } catch (error) {
                return false;
            }
        } else {
            return false;
        }
    }

    module.documentCookies = {
        getItem: function(sKey) {
            if (!sKey) {
                return null;
            }
            return decodeURIComponent(document.cookie.replace(new RegExp("(?:(?:^|.*;)\\s*" + encodeURIComponent(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=\\s*([^;]*).*$)|^.*$"), "$1")) || null;
        },
        setItem: function(sKey, sValue, vEnd, sPath, sDomain, bSecure) {
            if (!sKey || /^(?:expires|max\-age|path|domain|secure)$/i.test(sKey)) {
                return false;
            }
            var sExpires = "";
            var vExpiryDate = {
                getInStringFormat: function(nMaxAge) { //"max-age" in second
                    if (nMaxAge === Infinity) {
                        return "Fri, 31 Dec 9999 23:59:59 GMT";
                    }
                    var dDate = new Date();
                    dDate.setTime(dDate.getTime() + (nMaxAge * 1000));
                    return dDate.toGMTString();
                }
            }
            if (vEnd) {
                switch (vEnd.constructor) {
                    case Number:
                        sExpires = "; expires=" + vExpiryDate.getInStringFormat(vEnd) + vEnd === Infinity ? "" : "; max-age=" + vEnd;
                        break;
                    case String:
                        sExpires = "; expires=" + vEnd;
                        break;
                    case Date:
                        sExpires = "; expires=" + vEnd.toUTCString();
                        break;
                }
            }
            document.cookie = encodeURIComponent(sKey) + "=" + encodeURIComponent(sValue) + sExpires + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "") + (bSecure ? "; secure" : "");
            return true;
        },
        removeItem: function(sKey, sPath, sDomain) {
            if (!this.hasItem(sKey)) {
                return false;
            }
            document.cookie = encodeURIComponent(sKey) + "=; expires=Thu, 01 Jan 1970 00:00:00 GMT" + (sDomain ? "; domain=" + sDomain : "") + (sPath ? "; path=" + sPath : "");
            return true;
        },
        hasItem: function(sKey) {
            if (!sKey) {
                return false;
            }
            return (new RegExp("(?:^|;\\s*)" + encodeURIComponent(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=")).test(document.cookie);
        },
        keys: function() {
            var aKeys = document.cookie.replace(/((?:^|\s*;)[^\=]+)(?=;|$)|^\s*|\s*(?:\=[^;]*)?(?:\1|$)/g, "").split(/\s*(?:\=[^;]*)?;\s*/);
            for (var nLen = aKeys.length, nIdx = 0; nIdx < nLen; nIdx++) {
                aKeys[nIdx] = decodeURIComponent(aKeys[nIdx]);
            }
            return aKeys;
        }
    };

    function setBrowserStorage(key, value) {
        var cookieFallback = true;
        if (isLocalStorageNameSupported('localStorage')) {
            localStorage.setItem(key, value);
            cookieFallback = false;
        }

        if (isLocalStorageNameSupported('sessionStorage')) {
            sessionStorage.setItem(key, value);
            cookieFallback = false;
        }

        if (cookieFallback) {
            module.documentCookies.setItem(key, value);
        }
    }

    function getBrowserStorage(key) {

        if (isLocalStorageNameSupported('localStorage')) {
            return localStorage.getItem(key);
        }

        if (isLocalStorageNameSupported('sessionStorage')) {
            return sessionStorage.getItem(key);
        }

        return module.documentCookies.getItem(key);
    }

    function removeBrowserStorage(key) {
        var cookieFallback = true;
        if (isLocalStorageNameSupported('localStorage')) {
            localStorage.removeItem(key);
            cookieFallback = false;
        }
        if (isLocalStorageNameSupported('sessionStorage')) {
            sessionStorage.removeItem(key);
            cookieFallback = false;
        }

        if (cookieFallback) {
            module.documentCookies.removeItem(key);
        }
    }

    function LoginHandleToken(regResponse, data, onSuccess, onError) {
        var userprofile = regResponse.Profile;
        if (userprofile.ErrorCode) {
            onError(loginRadiusErrorToJsError(userprofile));
        } else {

            setBrowserStorage(storedUidName, userprofile.Uid);
            setBrowserStorage(storedTokenName, regResponse.access_token);

            if (isSSOInitFired) {
                setToken(regResponse.access_token);
            }
            //Safari change
            var isSafari = !!(navigator.userAgent.toLowerCase().indexOf('crios') == -1 &&
                navigator.userAgent.toLowerCase().indexOf('chrome') == -1 &&
                navigator.userAgent.toLowerCase().indexOf('safari') >= 0);

            var iOS = /iPad|iPhone|iPod/.test(navigator.userAgent) && !window.MSStream;
            var isUc = navigator.userAgent.toLowerCase().indexOf('ucbrowser') >= 0;

            if ((isSafari && isSSOInitFired) || (iOS && isUc)) {

                if (lrOptions.enableRememberMe) {


                    var rememberme = getBrowserStorage('lr-rememberme');
                    removeBrowserStorage('lr-rememberme');
                    window.location = "http://" + lrOptions.appName + "." + hubdomain + "/ssologin/setCustomSafariToken?token=" + regResponse.access_token + "&apikey=" + lrOptions.apikey + "&isrememberme=" + rememberme + "&callback=" + window.location.href;
                } else {
                    window.location = "http://" + lrOptions.appName + "." + hubdomain + "/ssologin/setSafariToken?token=" + regResponse.access_token + "&apikey=" + lrOptions.apikey + "&callback=" + window.location.href;
                }
            } else {
                var rememberme = '';
                var api_string = 'setToken';
                if (lrOptions.enableRememberMe) {
                    rememberme = "&isrememberme=" + getBrowserStorage('lr-rememberme');
                    removeBrowserStorage('lr-rememberme');
                    api_string = 'setCustomToken';
                }
                // util.ajaxCall("GET", "https://" + lrOptions.appName + "." + hubdomain + "/ssologin/" + api_string + "?token=" + regResponse.access_token + "&apikey=" + lrOptions.apikey + rememberme, "", function() {
                util.jsonpCall("https://" + lrOptions.appName + "." + hubdomain + "/ssologin/" + api_string + "?token=" + regResponse.access_token + "&apikey=" + lrOptions.apikey + rememberme, function() {
                    if (data != null && data != "") {
                        onSuccess(regResponse, parseQueryString(data));
                    } else {
                        onSuccess(regResponse);
                    }
                });


            }
        }
    }

    function traditionalLoginReceiveToken(userprofile, loginResponse, data, requiredField, onSuccess, onError) {
        setBrowserStorage(storedTokenName, loginResponse.access_token);
        util.ajaxCall("get", schemaCdnDomain + lrOptions.apikey + ".json", "", function(regSchema) {

            if (!userprofile.IsDeleted) {

                setPasswordRule(findInSchema(regSchema, "name", "password"));
                setPasswordRule(findInSchema(regSchema, "name", "confirmpassword"));

                module.registrationFormSchema = mapSchema(regSchema, userprofile);

                module.$hooks.filterRegistrationSchemaHook(regSchema, userprofile);

                if (module.registrationFormSchema.length > 0) {
                    requiredField(userprofile, loginResponse, loginResponse.access_token, data, onSuccess, onError);
                } else {
                    LoginHandleToken(loginResponse, data, onSuccess, onError);
                }
            } else {
                onError(loginRadiusErrorToJsError(userprofile));
            }

        }, "loginRadiusAppRaasSchemaJsonLoaded");

    };

    function loginController(data, onSuccess, onError, passwordExpiry, requiredField) {
        util.ajaxCall('get', apidomain + "/auth/login?apikey=" + lrOptions.apikey + "&login_url=" + lrOptions.loginUrl + "&email_template=" + lrOptions.emailTemplate + "&verification_url=" + lrOptions.emailVerificationUrl + "&" + data, "", function(loginResponse) {
            if (loginResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(loginResponse));
            } else {
                //
                var userprofile = loginResponse.Profile;
                if (lrOptions.enableRememberMe) {
                    var remCheckValue = util.getQueryStringValue(apidomain + "/auth/login?apikey=" + lrOptions.apikey + "&" + data, 'rememberme');
                    setBrowserStorage('lr-rememberme', remCheckValue);
                }

                //                if (lrOptions.periodicPasswordReset && userprofile.PasswordExpirationDate && new Date(userprofile.PasswordExpirationDate) <= new Date()) {
                //
                //
                //                    setPasswordRule(module.resetPasswordFormSchema[0]);
                //                    setPasswordRule(module.resetPasswordFormSchema[1]);
                //
                //                    module.resetPasswordFormSchema[2].name = "token";
                //                    module.resetPasswordFormSchema[2].value = loginResponse.access_token;
                //
                //                    passwordExpiry(userprofile, loginResponse);
                //
                //                    module.$hooks.loginHook.expiredFormResetFormRender();
                //                } else
                if (lrOptions.askRequiredFieldOnTraditionalLogin) {
                    traditionalLoginReceiveToken(userprofile, loginResponse, data, requiredField, onSuccess, onError);
                } else {
                    LoginHandleToken(loginResponse, data, onSuccess, onError);
                }
            }
        });
    }

    function login(containerId, onSuccess, onError, classPrefix) {
        var loginSchema = module.loginFormSchema;

        if (lrOptions.enableUserName) {
            loginSchema = module.loginByUsernameSchema;
        }

        if (lrOptions.enableRememberMe) {

            var addRememberMeCheck = true;
            for (var t = 0; t < loginSchema.length; t++) {
                if (loginSchema[t].name == "rememberme") {
                    addRememberMeCheck = false;
                }

            }

            if (addRememberMeCheck) {


                var rememberMeObj = {
                    type: "multi",
                    name: "rememberme",
                    display: "Rembember me",
                    rules: null,
                    permission: "w"
                }

                loginSchema.push(rememberMeObj);
            }

        }
        setPasswordRule(loginSchema[1]);

        createForm(loginSchema, "login", containerId, 'Login', function(loginData) {

            if (window["lroneclicksignin"]) {
                sendSignInEmail(loginData, onSuccess, onError);
            } else {

                loginController(loginData, onSuccess, onError, function(userprofile, loginResponse) {
                    //this event fires only when periodic password reset enabled and 11
                    createForm(module.resetPasswordFormSchema, "resetpassword", containerId, "Reset Password", function(resetData) {
                        periodicalPasswordRestController(resetData, onSuccess, onError, userprofile, loginResponse, loginData);
                    }, function(errors) {
                        onError(errors);
                    });
                }, function(userprofile, loginResponse, access_token, data, onSuccess, onError) {

                    //this event fires only when askRequiredFieldForm is enabled on traditional login
                    var RequiredFieldFormButtonLabel = "Login";
                    if (lrOptions.askRequiredFieldFormButtonLabel) {
                        RequiredFieldFormButtonLabel = lrOptions.askRequiredFieldFormButtonLabel;
                    }

                    createForm(module.registrationFormSchema, "social-registration", containerId, RequiredFieldFormButtonLabel, function(data) {

                        var updateProfileData = mapRegistrationSchema(data);
                        util.ajaxCall("put", apidomain + "/auth/account?apikey=" + lrOptions.apikey + "&access_token=" + access_token + "&verificationUrl=" + lrOptions.emailVerificationUrl + "&emailTemplate=" + lrOptions.emailVerificationTemplate, updateProfileData, function(regResponse) {
                            if (regResponse.ErrorCode) {
                                onError(loginRadiusErrorToJsError(regResponse));
                            } else {
                                LoginHandleToken(loginResponse, data, onSuccess, onError);
                            }
                        });
                    }, function(errors) {
                        onError(errors);
                    });
                });
            }


        }, function(errors) {
            onError(errors);
        }, classPrefix);
    };

    function mapRegistrationSchema(data) {
        var objData = parseQueryString(data);

        for (var i in objData) {
            switch (i) {
                case "email":
                case "emailid":
                    objData["email"] = [{
                        'type': 'Primary',
                        'value': objData[i]
                    }];

                    // delete objData[i];
                    break;
                case "country": //update this part as per country object Format.
                    objData["country"] = {
                        'code': 'test',
                        'name': objData[i]
                    };
                    //delete objData[i];
                    break;
                case "phonenumber": //update this part as per country object Format.
                    objData["phonenumbers"] = [{
                        'phonetype': 'mobile',
                        'phoneNumber': objData[i]
                    }];
                    delete objData[i];
                    break;

                    //add more cases as per data.
                default:
                    break;
            }
        }
        return objData;
    }

    function resendOtpController(data, onSuccess, onError) {
        util.ajaxCall("post", apidomain + "/auth/phone/otp?apikey=" + lrOptions.apikey + "&smsTemplate=" + lrOptions.smsTemplate, data, function(response) {
            if (response.ErrorCode) {
                onError(loginRadiusErrorToJsError(response));
            } else {
                onSuccess(response);
            }
        });
    }

    function resendOtp(phoneData, onSuccess, onError) {
        var phoneObj;
        if (module.useraction == "updatephone") {
            phoneData = parseQueryString(phoneData);
        }
        if (phoneData.phoneId) {
            phoneObj = {
                "phone": phoneData.phoneId
            };
        } else if (phoneData.phone) {
            phoneObj = phoneData;
        }
        var resendOtpBtn = document.createElement("input");
        resendOtpBtn.setAttribute("type", "button");
        resendOtpBtn.setAttribute("value", "Resend OTP");
        var formElement = document.getElementsByName("loginradius-otp")[0];
        formElement.appendChild(resendOtpBtn);
        util.addEvent("click", resendOtpBtn, function(event) {
            resendOtpController(phoneObj, onSuccess, onError);
        });
    }


    function verifyOTPController(data, phoneToVerify, onSuccess, onError) {
        util.ajaxCall("put", apidomain + "/auth/phone/otp?apikey=" + lrOptions.apikey + "&otp=" + data.otp, phoneToVerify, function(response) {
            if (response.ErrorCode) {
                onError(loginRadiusErrorToJsError(response));
            } else {
                onSuccess(response, data);
            }
        });
    }

    function verifyOTP(containerId, phoneData, onSuccess, onError) {
        createForm(module.otpSchema, 'otp', containerId, 'Verify OTP', function(data) {
            if (module.useraction == "updatephone") {
                phoneData = parseQueryString(phoneData);
            }
            data = parseQueryString(data);
            var phoneToVerify;
            if (phoneData.phone) {
                phoneToVerify = {
                    "phone": phoneData.phone
                };
            } else if (phoneData.phoneId) {
                phoneToVerify = {
                    "phone": phoneData.phoneId
                };
            }
            verifyOTPController(data, phoneToVerify, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        });
    }

    function loginByPhoneController(data, onSuccess, onError) {
        util.ajaxCall('get', apidomain + "/auth/login?apikey=" + lrOptions.apikey + "&loginUrl=" + lrOptions.loginUrl + "&verificationUrl=" + lrOptions.verificationUrl + "&emailTemplate=" + lrOptions.emailTemplate + "&" + data, "", function(loginResponse) {
            if (loginResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(loginResponse));
            } else {
                if (lrOptions.askRequiredFieldOnTraditionalLogin) {
                    traditionalLoginReceiveToken(userprofile, loginResponse, data, requiredField, onSuccess, onError);
                } else {
                    LoginHandleToken(loginResponse, data, onSuccess, onError);

                }
            }

        });
    }

    function loginByPhone(containerId, onSuccess, onError, classPrefix) {

        createForm(module.loginByPhoneSchema, 'loginbyphone', containerId, 'Login', function(data) {

            loginByPhoneController(data, onSuccess, onError);

        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function registrationByPhoneController(containerId, data, onSuccess, onError) {
        util.ajaxCall('post', apidomain + "/auth/register?apikey=" + lrOptions.apikey + "&verificationUrl=" + lrOptions.verificationUrl + "&smsTemplate=" + lrOptions.smsTemplate + "&sott=" + lrOptions.sott, data, function(regResponse) {
            if (regResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(regResponse));
            } else {
                verifyOTP(containerId, data, onSuccess, onError);
                resendOtp(data, onSuccess, onError);
            }
        });
    }

    function registrationByPhone(containerId, onSuccess, onError, classPrefix) {

        OnRegistrationByPhoneLoaded = function(registrationByPhoneSchema) {
            module.$hooks.filterRegistrationSchemaHook(registrationByPhoneSchema);
            registrationByPhoneSchema.push({
                type: 'html',
                name: 'termsandcondition',
                html: lrOptions.termsAndConditionHtml || ''
            });

            setPasswordRule(findInSchema(registrationByPhoneSchema, "name", "password"));
            setPasswordRule(findInSchema(registrationByPhoneSchema, "name", "confirmpassword"));


            module.registrationByPhoneSchema = registrationByPhoneSchema;

            createForm(registrationByPhoneSchema, "registerbyphone", containerId, 'Register', function(data) {
                var registerbyPhoneData = mapRegistrationSchema(data);
                registrationByPhoneController(containerId, registerbyPhoneData, onSuccess, onError);
            }, function(errors) {

                onError(errors);
            }, classPrefix);


        };
        if (lrOptions.RegistrationFormSchema) {
            OnRegistrationByPhoneLoaded(lrOptions.RegistrationFormSchema);
        } else {
            util.ajaxCall('get', schemaCdnDomain + lrOptions.apikey + ".json", "", OnRegistrationByPhoneLoaded, "loginRadiusAppRaasSchemaJsonLoaded");
        }

    }

    function checkPhoneNumberAvailabilityController(data, onSuccess, onError) {
        util.ajaxCall("get", apidomain + "/auth/phone?apikey=" + lrOptions.apikey + "&" + data, "", function(response) {
            if (response.ErrorCode) {
                onError(loginRadiusErrorToJsError(response));
            } else {
                onSuccess(response, data);
            }
        });
    }

    function checkPhoneNumberAvailability(containerId, onSuccess, onError, classPrefix) {

        createForm(module.checkPhoneNumberSchema, 'checkphone', containerId, 'Check', function(data) {
                checkPhoneNumberAvailabilityController(data, onSuccess, onError);
            },
            function(errors) {
                onError(errors);
            }, classPrefix);
    }

    function updatePhoneNumberController(containerId, data, onSuccess, onError) {
        var token = getBrowserStorage(storedTokenName);
        if (!token) {
            onError([
                setMappedMessage({
                    "Message": "Access token is not valid",
                    "Description": "LoginRadius Access Token is invalid, please verify the authentication response",
                    "ErrorCode": 905
                })
            ]);
        } else {
            util.ajaxCall("put", apidomain + "/auth/phone?apikey=" + lrOptions.apikey + "&access_token=" + token + "&smsTemplate=" + lrOptions.smsTemplate, data, function(response) {
                if (response.ErrorCode) {
                    onError(loginRadiusErrorToJsError(response));
                } else {
                    verifyOTP(containerId, data, onSuccess, onError);
                    resendOtp(data, onSuccess, onError);
                }

            });
        }
    }

    function updatePhoneNumber(containerId, onSuccess, onError, classPrefix) {

        createForm(module.checkPhoneNumberSchema, 'updatephone', containerId, 'Update', function(data) {

                updatePhoneNumberController(containerId, data, onSuccess, onError);
            },
            function(errors) {
                onError(errors);
            }, classPrefix);
    }

    function resetPasswordByPhoneController(data, onSuccess, onError) {
        util.ajaxCall("put", apidomain + "/auth/password/otp?apikey=" + lrOptions.apikey + "&smsTemplate=" + lrOptions.smsTemplate, data, function(response) {
            if (response.ErrorCode) {
                onError(loginRadiusErrorToJsError(response));
            } else {
                onSuccess(response, data);
            }
        });
    }

    function resetPasswordByPhone(containerId, data, onSuccess, onError, classPrefix) {
        var phoneNo = "&" + data;
        createForm(module.resetPasswordByPhoneSchema, 'resetpasswordbyphone', containerId, 'Reset', function(data) {
                resetPasswordByPhoneController(data + phoneNo, onSuccess, onError);
            },
            function(errors) {
                onError(errors);
            }, classPrefix);
    }

    function forgotPasswordbyPhoneController(containerId, data, onSuccess, onError, classPrefix) {
        util.ajaxCall("post", apidomain + "/auth/password/otp?apikey=" + lrOptions.apikey + "&smsTemplate=" + lrOptions.smsTemplate, data, function(response) {
            if (response.ErrorCode) {
                onError(loginRadiusErrorToJsError(response));
            } else {
                resetPasswordByPhone(containerId, data, onSuccess, onError, classPrefix)
            }

        });
    }

    function forgotPasswordbyPhone(containerId, onSuccess, onError, classPrefix) {

        createForm(module.forgotPasswordByPhoneSchema, 'forgotpasswordbyphone', containerId, 'Send', function(data) {

                forgotPasswordbyPhoneController(containerId, data, onSuccess, onError, classPrefix);
            },
            function(errors) {
                onError(errors);
            }, classPrefix);

    }

    function periodicalPasswordRestController(resetData, onSuccess, onError, userprofile, loginResponse, loginData) {
        util.jsonpCall(apidomain + "/raas/client/password/periodic-reset?apikey=" + lrOptions.apikey + "&" + resetData, function(resetPasswordReeonse) {
            if (resetPasswordReeonse.ErrorCode) {
                onError(loginRadiusErrorToJsError(resetPasswordReeonse));
            } else {
                LoginHandleToken(loginResponse, loginData, onSuccess, onError);
            }
        });
    }

    function registrationController(data, onSuccess, onError) {
        var registrationData = mapRegistrationSchema(data);
        util.ajaxCall("post", apidomain + "/auth/register?apikey=" + lrOptions.apikey + "&verificationUrl=" + lrOptions.emailVerificationUrl + "&emailTemplate=" + lrOptions.emailVerificationTemplate + "&sott=" + lrOptions.sott, registrationData, function(regResponse) {
            if (regResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(regResponse));
            } else {
                if (lrOptions.DisabledEmailVerification || lrOptions.OptionalEmailVerification) {
                    loginController(data, onSuccess, onError, function() {}, function() {});


                } else {
                    onSuccess(regResponse, data);
                }
            }
        });
    }

    function registration(containerId, onSuccess, onError, classPrefix) {

        OnRegistrationLoaded = function(regSchema) {
            module.$hooks.filterRegistrationSchemaHook(regSchema);
            regSchema.push({
                type: 'html',
                name: 'termsandcondition',
                html: lrOptions.termsAndConditionHtml || ''
            });

            setPasswordRule(findInSchema(regSchema, "name", "password"));
            setPasswordRule(findInSchema(regSchema, "name", "confirmpassword"));


            module.registrationFormSchema = regSchema;

            createForm(regSchema, "registration", containerId, 'Register', function(data) {
                registrationController(data, function(loginResponse, formData) {

                    onSuccess(loginResponse, formData);
                }, function(errors) {

                    onError(errors);
                });
            }, function(errors) {

                onError(errors);
            }, classPrefix);


        };
        if (lrOptions.RegistrationFormSchema) {
            OnRegistrationLoaded(lrOptions.RegistrationFormSchema);
        } else {
            util.ajaxCall('get', schemaCdnDomain + lrOptions.apikey + ".json", "", OnRegistrationLoaded, "loginRadiusAppRaasSchemaJsonLoaded");
        }
    };

    function findInSchema(schema, key, value) {
        for (var i = 0; i < schema.length; i++) {
            if (schema[i][key] == value) {
                return schema[i];
            }
        }

        return null;
    }

    function resetPasswordController(data, onSuccess, onError) {
        util.ajaxCall('put', apidomain + "/auth/password?apikey=" + lrOptions.apikey, data, function(resetPasswordResponse) {
            if (resetPasswordResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(resetPasswordResponse));
            } else {
                onSuccess(resetPasswordResponse, parseQueryString(data));
            }
        });
    }

    function resetPassword(containerId, onSuccess, onError) {

        var vtoken = getVtoken();
        if (vtoken) {
            module.resetPasswordFormSchema[2].value = vtoken;
            //
            setPasswordRule(module.resetPasswordFormSchema[0]);
            setPasswordRule(module.resetPasswordFormSchema[1]);

            createForm(module.resetPasswordFormSchema, "resetpassword", containerId, 'Reset Password', function(data) {
                resetPasswordController(data, onSuccess, onError);
                //   resetPasswordController(data, onSuccess, onError);
            }, function(errors) {
                onError(errors);
            });
        } else {
            onError([{
                Message: 'Verification Token not found in query string.'
            }]);
        }
    };

    function forgotPasswordController(data, onSuccess, onError) {
        util.ajaxCall('post', apidomain + "/auth/password?apikey=" + lrOptions.apikey + "&resetPasswordUrl=" + lrOptions.forgotPasswordUrl + "&emailTemplate=" + lrOptions.forgotPasswordTemplate, data, function(forgotPasswordResponse) {
            if (forgotPasswordResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(forgotPasswordResponse));
            } else {
                onSuccess(forgotPasswordResponse, parseQueryString(data));
            }
        });
    }

    function forgotPassword(containerId, onSuccess, onError, classPrefix) {
        createForm(module.forgotPasswordFormSchema, "forgotpassword", containerId, 'Send', function(data) {
            forgotPasswordController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    };

    function changePasswordController(data, onSuccess, onError) {
        util.ajaxCall('put', apidomain + "/auth/password?apikey=" + lrOptions.apikey + "&access_token=" + getBrowserStorage(storedTokenName), data, function(changePasswordResponse) {
            if (changePasswordResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(changePasswordResponse));
            } else {
                onSuccess(changePasswordResponse, parseQueryString(data));
            }
        });
    }

    function changePassword(containerId, onSuccess, onError, classPrefix) {
        createForm(module.changePasswordFormSchema, "changepassword", containerId, 'Save', function(data) {
            changePasswordController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function resendEmailVerificationController(data, onSuccess, onError) {
        util.ajaxCall('put', apidomain + "/auth/register?apikey=" + lrOptions.apikey + "&verificationUrl=" + lrOptions.verificationUrl + "&emailTemplate=" + lrOptions.emailVerificationTemplate, data, function(emailVerificationResponse) {
            if (emailVerificationResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(emailVerificationResponse));
            } else {
                onSuccess(emailVerificationResponse, parseQueryString(data));
            }
        });
    }

    function resendEmailVerification(containerId, onSuccess, onError, classPrefix) {
        createForm(module.emailSchema, "resendemailverification", containerId, 'Send', function(data) {
            resendEmailVerificationController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function addEmailController(data, onSuccess, onError) {
        var token = getBrowserStorage(storedTokenName);
        if (!token) {
            onError([
                setMappedMessage({
                    "Message": "Access token is not valid",
                    "Description": "LoginRadius Access Token is invalid, please verify the authentication response",
                    "ErrorCode": 905
                })
            ]);
        } else {
            util.ajaxCall('post', apidomain + "/auth/email?apikey=" + lrOptions.apikey + "&access_token=" + token + "&verificationUrl=" + lrOptions.verificationUrl + "&emailTemplate=" + lrOptions.emailVerificationTemplate, data, function(addEmailResponse) {
                if (addEmailResponse.ErrorCode) {
                    onError(loginRadiusErrorToJsError(addEmailResponse));
                } else {
                    onSuccess(addEmailResponse, parseQueryString(data));
                }
            });
        }
    }

    function addEmail(containerId, onSuccess, onError, classPrefix) {
        createForm(module.addEmailSchema, "addemail", containerId, 'Send', function(data) {
            addEmailController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function removeEmailController(data, onSuccess, onError) {
        var token = getBrowserStorage(storedTokenName);
        if (!token) {
            onError([
                setMappedMessage({
                    "Message": "Access token is not valid",
                    "Description": "LoginRadius Access Token is invalid, please verify the authentication response",
                    "ErrorCode": 905
                })
            ]);
        } else {
            util.ajaxCall('delete', apidomain + "/auth/email?apikey=" + lrOptions.apikey + "&access_token=" + token, data, function(removeEmailResponse) {
                if (removeEmailResponse.ErrorCode) {
                    onError(loginRadiusErrorToJsError(removeEmailResponse));
                } else {
                    onSuccess(removeEmailResponse, parseQueryString(data));
                }
            });
        }
    }

    function removeEmail(containerId, onSuccess, onError, classPrefix) {
        createForm(module.emailSchema, "removeemail", containerId, 'Send', function(data) {
            removeEmailController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function changeUsernameController(data, onSuccess, onError) {
        var token = getBrowserStorage(storedTokenName);
        if (!token) {
            onError([
                setMappedMessage({
                    "Message": "Access token is not valid",
                    "Description": "LoginRadius Access Token is invalid, please verify the authentication response",
                    "ErrorCode": 905
                })
            ]);
        } else {
            util.ajaxCall('put', apidomain + "/auth/username?apikey=" + lrOptions.apikey + "&access_token=" + token, data, function(changeUsernameResponse) {
                if (changeUsernameResponse.ErrorCode) {
                    onError(loginRadiusErrorToJsError(changeUsernameResponse));
                } else {
                    onSuccess(changeUsernameResponse, parseQueryString(data));
                }
            });
        }
    }

    function changeUsername(containerId, onSuccess, onError, classPrefix) {
        createForm(module.changeUsernameFormSchema, "changeusername", containerId, 'Submit', function(data) {
            changeUsernameController(data, onSuccess, onError);
        }, function(errors) {
            onError(errors);
        }, classPrefix);
    }

    function sendSignInEmail(data, onSuccess, onError) {

        if (lrOptions.oneClickSigninUrl && lrOptions.oneClickSigninUrl == "") {
            lrOptions.oneClickSigninUrl = window.location.href;;
        }

        util.jsonpCall(apidomain + "/raas/client/auth/signin?apikey=" + lrOptions.apikey + "&url=" + lrOptions.oneClickSigninUrl + "&template=" + lrOptions.signInEmailTemplate + "&" + data, function(signinResponse) {
            if (signinResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(signinResponse));
            } else {
                onSuccess(signinResponse, parseQueryString(data));
            }
        });
    }

    function getVtoken() {
        var vtoken;
        var matches = window.location.hash.match(new RegExp('vtoken=([^&]*)'));
        if (window.location.hash && matches != null) {
            vtoken = matches[1];
        } else {
            vtoken = util.getQueryParameterByName("vtoken");
        }
        return vtoken;
    }

    //    function emailSignin(onSuccess, onError) {
    //        var vtoken = getVtoken();
    //        emailSigninController(vtoken, onSuccess, onError);
    //    };
    //
    //    function emailSigninController(vtoken, onSuccess, onError) {
    //        if (vtoken) {
    //            util.jsonpCall(apidomain + "/raas/client/auth/verifysigninemail?apikey=" + lrOptions.apikey + "&vtoken=" + vtoken + "&welcomeEmailTemplate=" + lrOptions.welcomeEmailTemplate, function(emailSignInResponse) {
    //                if (emailSignInResponse.ErrorCode) {
    //                    onError(loginRadiusErrorToJsError(emailSignInResponse));
    //                } else {
    //
    //                    if (emailSignInResponse.data == null || emailSignInResponse.data.access_token === undefined) {
    //                        onSuccess(emailSignInResponse);
    //                    } else {
    //                        util.jsonpCall(apidomain + "/api/v2/userprofile?access_token=" + emailSignInResponse.data.access_token + "&welcomeEmailTemplate=" + lrOptions.welcomeEmailTemplate, function(userprofile) {
    //                            LoginHandleToken(emailSignInResponse.data, "", onSuccess, onError);
    //                        });
    //                    }
    //
    //
    //                }
    //            });
    //        } else {
    //            onError([{
    //                Message: 'Verification Token not found in query string.'
    //            }]);
    //        }
    //    }

    function emailVerificationController(vtoken, onSuccess, onError) {
        if (vtoken) {
            util.ajaxCall('get', apidomain + "/auth/email?apikey=" + lrOptions.apikey + "&verificationtoken=" + vtoken + "&welcomeEmailTemplate=" + lrOptions.welcomeEmailTemplate + "&url=" + lrOptions.emailVerificationUrl, "", function(emailVerificationResponse) {
                if (emailVerificationResponse.ErrorCode) {
                    onError(loginRadiusErrorToJsError(emailVerificationResponse));
                } else {
                    if (lrOptions.enableLoginOnEmailVerification) {

                        if (emailVerificationResponse.Data == null) {
                            onSuccess(emailVerificationResponse);
                        } else {

                            LoginHandleToken(emailVerificationResponse.Data, "", onSuccess, onError);
                        }

                    } else {
                        if (isSSOInitFired) {
                            ssoLogout(onSuccess(emailVerificationResponse), true);
                        }

                        onSuccess(emailVerificationResponse);
                    }
                }
            });
        } else {
            onError([{
                Message: 'Verification Token not found in query string.'
            }]);
        }
    }

    function emailVerification(onSuccess, onError) {
        var vtoken = getVtoken();
        emailVerificationController(vtoken, onSuccess, onError);
    };

    function deleteUser(onSuccess, onError) {

        var vtoken = module.sessionData.getToken();

        //        var matches = window.location.hash.match(new RegExp('vtoken=([^&]*)'));
        //        if (window.location.hash && matches != null) {
        //            vtoken = matches[1];
        //        } else {
        //            vtoken = util.getQueryParameterByName("vtoken");
        //        }

        if (vtoken) {
            util.ajaxCall('delete', apidomain + "/auth/account?apikey=" + lrOptions.apikey + "&access_token=" + vtoken + "&verificationUrl=" + lrOptions.verificationUrl + "&emailTemplate=" + lrOptions.emailTemplate, {}, function(regResponse) {
                if (regResponse.ErrorCode) {
                    onError(loginRadiusErrorToJsError(regResponse));
                } else {
                    onSuccess(regResponse);
                }
            });
        } else {
            onError([{
                Message: 'Token not found.'
            }]);
        }
    };

    function sociallogin(containerId, onSuccess, onError) {

        containerId = socialRegFormId || containerId;

        window.html5passToken = function(tok) {
            socialLoginReceiveToken(tok, containerId, onSuccess, onError);
        };
        var lrToken = hash.get('lr-token');
        if (lrToken) {
            window.html5passToken(lrToken);
            hash.remove('lr-token');
        }
        module.loginradiushtml5passToken = window.html5passToken;

        util.addEvent("message", window, function(event) {
            if (event.origin.indexOf(hubdomain) == -1) {
                return;
            }
            containerId = socialRegFormId || containerId
            socialLoginReceiveToken(event.data, containerId, onSuccess, onError);
        });

    }

    function socialDataUpdate(tok, data, userprofile, onSuccess, onError) {
        var profileData = mapRegistrationSchema(data);
        util.ajaxCall("put", apidomain + "/auth/account?apikey=" + lrOptions.apikey + "&access_token=" + tok + "&verificationUrl=" + lrOptions.emailVerificationUrl + "&emailTemplate=" + lrOptions.emailVerificationTemplate, profileData, function(regResponse) {
            if (regResponse.ErrorCode) {
                onError(loginRadiusErrorToJsError(regResponse));
            } else {
                var isemail;
                for (var i = 0; i < module.registrationFormSchema.length; i++) {
                    if (module.registrationFormSchema[i].name == 'email') {
                        isemail = true;
                        break;
                    }
                }

                isemail = !userprofile.EmailVerified;

                setBrowserStorage(storedUidName, userprofile.Uid);
                if (!isemail || lrOptions.DisabledEmailVerification || lrOptions.OptionalEmailVerification) {
                    onSuccess(tok, parseQueryString(data))
                    if (isSSOInitFired) {
                        setToken(tok);
                    }
                } else {
                    onSuccess(regResponse, parseQueryString(data));
                }
            }
        });
    }

    function socialLoginReceiveToken(tok, containerId, onSuccess, onError, onMissingField) {

        setBrowserStorage(storedTokenName, tok);

        util.ajaxCall('get', schemaCdnDomain + lrOptions.apikey + ".json", '', function(regSchema) {

            util.ajaxCall('get', apidomain + "/auth/account?apikey=" + lrOptions.apikey + "&access_token=" + tok, '', function(userprofile) {
                if (userprofile.ErrorCode) {
                    onError(loginRadiusErrorToJsError(userprofile));
                } else {

                    if (!userprofile.IsDeleted) {

                        setPasswordRule(findInSchema(regSchema, "name", "password"));
                        setPasswordRule(findInSchema(regSchema, "name", "confirmpassword"));


                        module.registrationFormSchema = mapSchema(regSchema, userprofile);


                        module.$hooks.filterRegistrationSchemaHook(regSchema, userprofile);

                        if (module.registrationFormSchema.length > 0) {
                            if (containerId) {
                                module.$hooks.socialLoginHook.onFormRender();
                                createForm(module.registrationFormSchema, "social-registration", containerId, 'Register', function(data) {
                                    socialDataUpdate(tok, data, userprofile, onSuccess, onError);
                                }, function(errors) {
                                    onError(errors);
                                });
                            } else {
                                onMissingField(tok, module.registrationFormSchema, userprofile);
                            }
                        } else {
                            if (userprofile.EmailVerified || lrOptions.DisabledEmailVerification || lrOptions.OptionalEmailVerification) {
                                setBrowserStorage(storedUidName, userprofile.Uid);
                                if (isSSOInitFired) {
                                    setToken(tok);
                                }
                                onSuccess(tok);
                            } else {
                                onError([
                                    setMappedMessage({
                                        "Message": "The email is not verified, please verify the link in your email",
                                        "Description": "The email is not verified, please verify the link in your email",
                                        "ErrorCode": 970
                                    })
                                ]);
                            }
                        }
                    } else {
                        onError([
                            setMappedMessage({
                                "Message": "User is blocked",
                                "Description": "This user is blocked by site admin",
                                "ErrorCode": 991
                            })
                        ]);
                    }
                }
            });

        }, "loginRadiusAppRaasSchemaJsonLoaded");

    };

    function accountLinkingReceiveToken(tok, onSuccess, onError) {
        util.ajaxCall('get', apidomain + "/auth/socialidentity?apikey=" + lrOptions.apikey + '&access_token=' + tok, '', function(userprofile) {
            util.ajaxCall('put', apidomain + "/auth/socialidentity?apikey=" + lrOptions.apikey + '&access_token=' + getBrowserStorage(storedTokenName), 'candidatetoken=' + tok, function(response) {
                if (response.ErrorCode) {
                    onError(loginRadiusErrorToJsError(response));
                } else {
                    onSuccess(response);

                }
            });
        });
    };

    function accountLinking(containerId, onSuccess, onError) {

        util.ajaxCall('get', apidomain + "/auth/account?apikey=" + lrOptions.apikey + "&access_token=" + getBrowserStorage(storedTokenName), '', function(response) {
            if (!response.ErrorCode) {
                if (response.EmailVerified) {
                    //  module.$hooks.accounts.onGetAccountDetails(response);
                    //  onGetAccountDetails(response);

                    var providers = {};
                    if (response.Identities) {
                        for (var i = 0, len = response.Identities.length; i < len; i++) {
                            providers[response.Identities[i].Provider] = response.Identities[i].ID;
                        }
                    }
                    renderCustomInterface(containerId, providers);

                    window.html5passToken = function(tok) {
                        accountLinkingReceiveToken(tok, onSuccess, onError);
                    };
                    util.addEvent("message", window, function(event) {
                        if (event.origin.indexOf(hubdomain) == -1) {
                            return;
                        }
                        accountLinkingReceiveToken(event.data, onSuccess, onError);
                    });
                } else {
                    onError([
                        setMappedMessage({
                            "Message": "This Uid have only traditional unverified account",
                            "Description": "This Uid have only traditional unverified account",
                            "ErrorCode": 1028
                        })
                    ]);

                    //onGetAccountDetails(response);
                }

            } else {
                onError(loginRadiusErrorToJsError(response));
            }
        });

    }

    function nativeSocialLogin() {

        module.providers = [];
        module.iconsize = '';
        module.interfacetheme = '';
        module.userinterface = '';
        module.noofrow = '';
        module.IsPaid = false;
        module.WhiteLabel = false;
        module.Isslide = false;
        module.sameWindow = 0;
        module.appName = '';
        module.background = '';
        module.ispersona = false;
        module.isiframe = false;
        module.noVirtualIframe = false;
        module.IsNoFollowEnabled = false;

        module.LRCacheTime = 'LRCACHE_TIMEOUTKEY';
        module.LRSiteSettings = 'LRSITE_SETTINGSKEY';
        module.objectName = util.getThisObjectName();
        //## templates 
        module.commonTemplateBasic = function(theme, height, width, extraheight, extrawidth) {
            var objectName = module.objectName;
            var Obj = eval(objectName);
            
            var src = '<%= "//' + Obj.options.appName +'.'+hubdomain+'/Control/PersonaInterface.aspx?apikey=' + Obj.options.apikey + '&theme=' + theme + '" %>&callback=' + Obj.options.callback  + Obj.options.sameWindow;

            return ['<% if(Interface.providers[i].Name.toLowerCase() == "persona") { %>', '<div><iframe src="' + src + '" height="' + height + '", width="' + width + '" scrolling="no" frameborder="0"></iframe></div>', '<% ' + module.objectName + '.ispersona = true; } else {%>', '<div style="width:' + width + ';height:' + height + '"><span class="lr_providericons lr_<%=Interface.providers[i].Name.toLowerCase() %>"  onclick="return ' + objectName + '.util.openWindow(\'<%=Interface.providers[i].Endpoint.toLowerCase()%>&callback=' + Obj.options.callback +'&same_window='+Obj.options.sameWindow+'&is_access_token=' + Obj.options.isAccessToken  + '&scope=' + Obj.options.scope + '&callbacktype=' + Obj.options.callbacktype + '&disablesignup=' + Obj.options.disableSignup + '\')"); " rel="nofollow" title="Login with <%=Interface.providers[i].Name.replace(\'Mailru\',\'Mail.ru\') %>" alt="Login with <%=Interface.providers[i].Name.replace(\'Mailru\',\'Mail.ru\') %>" style="display:block;background-color: transparent;width:' + width + ';height:' + height + '">&nbsp;</span></div>', '<%}%>', '<% "' + (Obj.iconheight = (+height.replace("px", '') + (extraheight || 0)).toString()) + '"; %>', '<% "' + (Obj.iconwidth = (+width.replace('px', '') + (extrawidth || 0)).toString()) + '"; %>'].join('\n');
        };
        module.commonTemplateStd = function(theme, height, width, extraheight, extrawidth) {
            var objectName = module.objectName;
            var Obj = eval(objectName);
            var src = '<%= "//' + Obj.options.appName +'.'+hubdomain+'/Control/PersonaInterface.aspx?apikey=' + Obj.options.apikey + '&theme=' + theme + '" %>&callback=' + Obj.options.callback  + Obj.options.sameWindow;

            var ie8browser = '';
            if (util.isIE8Browser()) {
                ie8browser = 'lrie8';
            }
            return ['<% if(Interface.providers[i].Name.toLowerCase() == "persona") { %>', '<div #width-style#><iframe src="' + src + '" height="' + height + '", width="100%" scrolling="no" frameborder="0"></iframe></div>', '<% ' + module.objectName + '.ispersona = true; } else {%>', '<div #width-style#><span class="lr_providericons lr_<%=Interface.providers[i].Name.toLowerCase() %> ' + ie8browser + ' lr-icon-<%=Interface.providers[i].Name.toLowerCase() %>"  onclick="return ' + objectName + '.util.openWindow(\'<%=Interface.providers[i].Endpoint.toLowerCase()%>&callback=' + Obj.options.callback +'&same_window='+Obj.options.sameWindow+'&is_access_token=' + Obj.options.isAccessToken  + '&scope=' + Obj.options.scope + '&callbacktype=' + Obj.options.callbacktype + '&disablesignup=' + Obj.options.disableSignup + '\')"); rel="nofollow" title="Login with <%=Interface.providers[i].Name.replace(\'Mailru\',\'Mail.ru\') %>" alt="<%=Interface.providers[i].Name.replace(\'Steamcommunity\',\'Steam\').replace(\'Stackexchange\',\'Stack\').replace(\'Mailru\',\'Mail.ru\') %>"></span></div>', '<%}%>', '<% "' + (Obj.iconheight = (+height.replace("px", '') + (extraheight || 0)).toString()) + '"; %>', '<% "' + (Obj.iconwidth = (+width.replace('px', '') + (extrawidth || 0)).toString()) + '"; %>'].join("\n");
        };


        module.securedByLoginradius = [
            '<lr-tooltip class="lr-tip"  id="lr-secure-div" style="display:none"><lr-top class="lr-toptext"><strong>#domain#</strong> complies with your privacy and data security. We confirm that:</lr-top>', '<lr-mid class="lr-midspace">', '<lr-midlist class="lr-midlist-box">', '<lr-list class="lr-midlist-bg"> <lr-listtext  class="lr-midlist-text">This site <strong>will not capture</strong> your contacts/friends\' information</lr-listtext></lr-list>', '<lr-list class="lr-midlist-bg"> <lr-listtext  class="lr-midlist-text"> This site <strong>will not send </strong>any messages to your friends</lr-listtext></lr-list>', '<lr-list class="lr-midlist-bg"> <lr-listtext  class="lr-midlist-text">This site <strong>will not post</strong> any messages on your timeline</lr-listtext></lr-list>', '</lr-midlist>', '</lr-mid>', '<lr-footer class="lr-bottom"><lr-link class="lr-bottom-link"> <a target="_blank"  rel="#nofollow"  href="https://www.loginradius.com/?utm_source=customerweb&utm_medium=interface&utm_campaign=securebylr" style="">Learn more</a></lr-link></lr-footer></lr-tooltip>'
        ].join("\n");
        module.securedByLrLink = '<lr-secured class="lr-secured-linkbox"><lr-securedbox class="lr-secured-link"><div class="lr-secured-linkboxtext">Secured by LoginRadius</div></lr-securedbox></lr-secured>';

        module.processingMessage = '<div class="lr_sociallogin_processing"  id="lr_sociallogin_processing" style="display:none">Connecting...</div>';

        module.openIdPopup = '<div id="lr_openid_popup" style="display:none"><div class="lr-pop-wrap" ><div class="lr-pop-frame"><div class="lr-pop-heading lr-pop-container"><span class="lr-pop-header"><span class="lr-pop-icon lr-img-icon-openID"></span><span id="lr_login_provider" class="lr_login_provider">Login with your account</span></span><span class="lr-pop-close" onclick="module.util.hideOpenIdPopup();"></span></div><div class="lr-pop-innerframe lr-pop-container cf"><label class="lr-pop-input-group"><input type="text" class="lr-pop-input" onkeyup="this.setAttribute(\'data-title\', this.value);" data-title=""><div class="lr-pop-placeholder">Enter your ID here</div></label><input type="button" class="lr-pop-submit" onclick="module.util.setOpenIdValue(module.util.elementsByClass(\'lr-pop-input\')[0].value,true);" value="Sign me in"></div><div id="lr_pop_message" class="lr_pop_message" style="display:none;" ></div></div></div><div class="lr-pop-overlay"></div><input id="lr_hid_openidurl" class="lr_hid_openidurl" type="hidden" /> <input id="lr_hid_url" class="lr_hid_url" type="hidden" /> <div class="lr-loading-frame"><div class="lr-loading-box"><span class="lr-loading-text-box">Loading...</span></div></div></div>';
        
        module.templates = {


            loginradius_social_single_glider_150: ['<div class="lr_singleglider_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 3,6,32) %>px"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="95%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div style="padding:0 2px 0 0px"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td style="padding-left:2px;">', '<% ' + module.objectName + '.rows =1;  ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 3); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<% if(i % ' + module.objectName + '.options.noOfColumns  == 0) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateBasic('loginradius-social-single-glider-150', '38px', '38px', 0, 0), '<%}%>', '</td>', '<td><div style="padding:0 14px 0 0;"><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),
            loginradius_social_single_glider_200: ['<div class="lr_singleglider_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 4,6,35) %>px"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="96%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div style="padding:0 6px 0 0;"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<% ' + module.objectName + '.rows =1;  ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 4); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%  if(i % ' + module.objectName + '.options.noOfColumns == 0) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateBasic('loginradius-social-single-glider-200', '38px', '38px', 0, 2), '<%}%>', '</td>', '<td><div style="padding:0 8px 0 0;"><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),
            loginradius_social_embed_type_150: ['<div class="lr_embed_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 3,4,10) %>px"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">', '<tr>', '<td>', '<% ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 3); %>', '<div class="lr_icons_box">', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % ' + module.objectName + '.options.noOfColumns == 0 && i > 0) {%></div> <div class="lr_icons_box"><%}%>', module.commonTemplateBasic('loginradius-social-embed-type-150', '38px', '38px', 0, 0), '<%}%>', '</td>', '</tr></table>', '</div>'].join('\n'),
            loginradius_social_embed_type_200: ['<div class="lr_embed_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 4,4,10) %>px;"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">', '<tr>', '<td>', '<% ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 4); %>', '<div class="lr_icons_box">', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % ' + module.objectName + '.options.noOfColumns == 0 && i > 0) {%></div> <div class="lr_icons_box"><%}%>', module.commonTemplateBasic('loginradius-social-embed-type-200', '38px', '38px', 0, 0), '<%}%></div>', '</td>', '</tr></table>', '</div>'].join('\n'),
            loginraidus_social_double_glider_150: ['<div class="lr_doubleglider_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 3,4,32) %>px;"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="97%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div style="padding:0 4px 0 0px"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<%  ' + module.objectName + '.rows =2; ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 3); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % (' + module.objectName + '.options.noOfColumns * 2) == 0 ) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateBasic('loginraidus-social-double-glider-150', '38px', '38px', 3, 0), '<%}%>', '</td>', '<td><div style="padding:0 14px 3px 0;"><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),
            loginraidus_social_double_glider_200: ['<div class="lr_doubleglider_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(38,' + module.objectName + '.options.noOfColumns || 4,4,32) %>px;"><%=' + module.objectName + '.options.socialLoginHeading %>', '<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div style="padding:0 6px 0 3px;"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<% ' + module.objectName + '.rows =2; ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 4); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % (' + module.objectName + '.options.noOfColumns * 2) == 0 ) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateBasic('loginraidus-social-double-glider-200', '38px', '38px', 3, 1), '<%}%>', '</td>', '<td><div style="padding:0 10px 3px 0;"><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),

            // loginradius_social_login_theme_150: ['<div class="lr_social_login_basic_150 lr_logininterface_container" style="background:<%='+module.objectName+'.background %>;width:<%='+module.objectName+'.util.getInterfaceWidth(60,'+module.objectName+'.options.noOfColumns || 2,6,31) %>px;"><%='+module.objectName+'.options.socialLoginHeading %>', '<table id="lr_providers" width="95%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div style="padding: 0 4px 0 0px;"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<% '+module.objectName+'.rows =2;  '+module.objectName+'.options.noOfColumns = ('+module.objectName+'.options.noOfColumns || 2); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<'+module.objectName+'.providers.length;i++) { %>', '<%if(i % ('+module.objectName+'.options.noOfColumns * 2) == 0) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateStd('loginradius-social-login-theme-150', '26px', '60px', 0, 0), '<%}%>', '</td>', '<td><div style="padding: 0 11px 0 0;"><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),
            //loginradius_social_login_theme_200: ['<div class="lr_social_login_basic_200 lr_logininterface_container" style="background:<%='+module.objectName+'.background %>;width:<%='+module.objectName+'.util.getInterfaceWidth(80,'+module.objectName+'.options.noOfColumns || 2,6,32) %>px;"><%='+module.objectName+'.options.socialLoginHeading %>', '<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">', '<tr><td><div class="lr_arrow_prev_div"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td style="padding-left:3px;">', '<%  '+module.objectName+'.rows =2; '+module.objectName+'.options.noOfColumns = ('+module.objectName+'.options.noOfColumns || 2); %>', '<% var count=0;var index=1;%>', '<%for(var i=0;i<'+module.objectName+'.providers.length;i++) { %>', '<%if(i % ('+module.objectName+'.options.noOfColumns * 2) == 0) {%></div> <div class="lr_icons_box slide"><%}%>', module.commonTemplateStd('loginradius-social-login-theme-200', '34px', '80px', 1, 4), '<%}%>', '</td>', '<td><div class="lr_arrow_next_div" ><a class="lr_providericons lr_arrow_next" ></a></div></td>', '</tr></table>', '</div>'].join('\n'),
            // login basic 150
            loginradius_social_login_theme_150: ['<div class="lr_social_login_basic_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>"><%=' + module.objectName + '.options.socialLoginHeading %>\n<table id="lr_providers" width="95%" border="0" cellspacing="0" cellpadding="0">\n<td class="lr_arrow"><div class="lr_arrow_prev_div"><a class="lr_arrow_prev" ></a></div></td>\n<td style="padding-left:3px;">\n<% ' + module.objectName + '.rows =2;  ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 2); %>\n<% var count=0;var index=1;%>\n<%for(var i=0;i<' + module.objectName + '.length;i++) { %>\n<%if(i % (' + module.objectName + '.options.noOfColumns * 2) == 0) {%></div> <div class="lr_icons_box slide"><%}%>',
                module.commonTemplateStd("loginradius-social-login-theme-150", "26px", "60px", 0, 0), '<%}%>\n</td>\n<td class="lr_arrow"><div class="lr_arrow_next_div" ><a class="lr_arrow_next" ></a></div></td>\n</tr></table>\n</div>'
            ].join("\n"),

            loginradius_social_login_theme_200: ['<div class="lr_social_login_basic_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>"><%=' + module.objectName + '.options.socialLoginHeading %>\n<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">\n<tr><td class="lr_arrow"><div class="lr_arrow_prev_div"><a class="lr_arrow_prev" ></a></div></td>\n<td style="padding-left:3px;">\n<%  ' + module.objectName + '.rows =2; ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 2); %>\n<% var count=0;var index=1;%>\n<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>\n<%if(i % (' + module.objectName + '.options.noOfColumns * 2) == 0) {%></div> <div class="lr_icons_box slide"><%}%>',
                module.commonTemplateStd("loginradius-social-login-theme-200", "34px", "80px", 1, 4), '<%}%>\n</td>\n<td class="lr_arrow"><div class="lr_arrow_next_div" ><a class="lr_arrow_next" ></a></div></td>\n</tr></table>\n</div>'
            ].join("\n"),

            loginradius_social_popup_type_150: ['<div class="lr_social_popup_type_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;width:<%=' + module.objectName + '.util.getInterfaceWidth(165,' + module.objectName + '.options.noOfColumns || 2,6,45) %>px;"><div class="lr_social_interface_box" id="lr_social_interface_continer">', '<a href="#" rel="popuprel" class="popup lr_providericons mainimg" onclick=' + module.objectName + '.util.showpopupinterface("popuprel","fade")></a></div>', '<div class="lr_social_interface_popupbox" id="popuprel">', '<div id="lr_provider_intabdiv"><h4><%=' + module.objectName + '.options.socialLoginHeading %><a onclick=' + module.objectName + '.util.closepopupinterface("popuprel","fade") ><span class="lr_popup_close">X</span></a></h4>', '<table border="0" cellspacing="0" cellpadding="0" class="lr_maintable">', '<tr><td class="valign"><div class="lr_arrow_prev_div"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<% ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 2); %>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % (' + module.objectName + '.options.noOfColumns * 2)  == 0) {%></div> <div class="lr_interface_providers slide"><%}%>', module.commonTemplateStd('loginradius-social-popup-type-150', '50px', '165px', 0, 0), '<%}%>', '</td>', '<td class="valign"><div class="arrow_next_div">', '<a class="lr_providericons lr_arrow_next" ></a> </div></td>', '</tr>', '</table>', '</div>', '</div></div><div id="fade" class="black_overlay" onclick=' + module.objectName + '.util.closepopupinterface("popuprel","fade");></div>'].join('\n'),
            loginradius_social_popup_type_200: ['<div class="lr_social_popup_type_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>;px;"><div class="lr_social_interface_box" id="lr_social_interface_continer">', '<a href="#" rel="popuprel" class="popup lr_providericons mainimg" onclick=' + module.objectName + '.util.showpopupinterface("popuprel","fade")></a></div>', '<div class="lr_social_interface_popupbox" id="popuprel" style="width:<%=' + module.objectName + '.util.getInterfaceWidth(165,' + module.objectName + '.options.noOfColumns || 2,6,45) %>px;left:<%=(' + module.objectName + '.util.getInterfaceWidth(165,' + module.objectName + '.options.noOfColumns || 2,6,10))/2 %>px">', '<div id="lr_provider_intabdiv"><h4><%=' + module.objectName + '.options.socialLoginHeading %><a onclick=' + module.objectName + '.util.closepopupinterface("popuprel","fade") ><span class="lr_popup_close">X</span></a></h4>', '<table border="0" cellspacing="0" cellpadding="0" class="lr_maintable">', '<tr><td class="valign"><div class="lr_arrow_prev_div"><a class="lr_providericons lr_arrow_prev" ></a></div></td>', '<td>', '<% ' + module.objectName + '.options.noOfColumns = (' + module.objectName + '.options.noOfColumns || 2); %>', '<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>', '<%if(i % (' + module.objectName + '.options.noOfColumns * 2) == 0) {%></div> <div class="lr_interface_providers slide"><%}%>', module.commonTemplateStd('loginradius-social-popup-type-200', '50px', '165px', 0, 0), , '<%}%>', '</td>', '<td class="valign"><div class="lr_arrow_next_div">', '<a class="lr_providericons lr_arrow_next" ></a> </div></td>', '</tr>', '</table>', '</div>', '</div></div><div id="fade" class="black_overlay" onclick=' + module.objectName + '.util.closepopupinterface("popuprel","fade");></div>'].join('\n'),


            loginradius_social_embed_bricks_150: ['<div class="lr_embed_bricks_150 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>"><%=' + module.objectName + '.options.socialLoginHeading %>\n<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">\n<tr>\n<td>\n<% ' + module.objectName + '.options.noOfColumns = 1; %>\n<div class="lr_icons_box">\n<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>\n<%if(i % ' + module.objectName + '.options.noOfColumns  == 0 && i > 0) {%></div> <div class="lr_icons_box"><%}%>',
                module.commonTemplateStd("loginradius-social-embed-bricks-150", "31px", "135px", 1, 0), "<%}%>\n</td>\n</tr></table>\n</div>"
            ].join("\n"),

            loginradius_social_embed_bricks_200: ['<div class="lr_embed_bricks_200 lr_logininterface_container" style="background:<%=' + module.objectName + '.background %>"><%=' + module.objectName + '.options.socialLoginHeading %>\n<table id="lr_providers" width="100%" border="0" cellspacing="0" cellpadding="0">\n<tr>\n<td>\n<% ' + module.objectName + '.options.noOfColumns =1; %>\n<div class="lr_icons_box">\n<%for(var i=0;i<' + module.objectName + '.providers.length;i++) { %>\n<%if(i % ' + module.objectName + '.options.noOfColumns == 0 && i > 0) {%></div> <div class="lr_icons_box"><%}%>',
                module.commonTemplateStd("loginradius-social-embed-bricks-200", "34px", "165px", 1, 1), "<%}%></div>\n</td>\n</tr></table>\n</div>"
            ].join("\n")
        };

        //#end
        try {
            var timeout = getBrowserStorage(module.LRCacheTime);
            if (new Date().getTime() > timeout) {
                loadAppJson();
            } else {
                var siteSettings = getBrowserStorage(module.LRSiteSettings);
                appsettings(JSON.parse(siteSettings));
            }
        } catch (e) {
            loadAppJson();
        }
       
        actionHandler("sociallogin");
    }

    function actionHandler(action) {

        var onSuccess = lrOptions.onSuccess || function() {};
        var onError = lrOptions.onError || function() {};
        var containerId = lrOptions.containerId || '';
        var classPrefix = lrOptions.classPrefix || '';
        var ssoCallback = lrOptions.ssoCallback || '';
        var expireToken = lrOptions.expireToken || false;
        var logoutCallback = lrOptions.logoutCallback || '';
        var loggedinCallback = lrOptions.loggedinCallback || '';
        switch (action) {
            case 'nativesociallogin':
                {
                    nativeSocialLogin();

                    break;
                }
            case 'login':
                {
                    login(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'registration':
                {
                    var formInterval;
                    var isClear = 1;
                    formInterval = setInterval(
                        function() {
                            if (!isRegFormSchemaLock) {
                                isRegFormSchemaLock = true;
                                registration(containerId, onSuccess, onError, classPrefix);

                                if (isClear > 0) {
                                    clearInterval(formInterval);
                                }
                            }

                        }, 1000);

                    break;
                }
            case 'resetpassword':
                {
                    resetPassword(containerId, onSuccess, onError);
                    break;
                }
            case 'forgotpassword':
                {
                    forgotPassword(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'emailverification':
                {
                    emailVerification(onSuccess, onError);
                    break;
                }
            case 'changepassword':
                {
                    changePassword(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'sociallogin':
                {
                    var elem = util.elementById(containerId);

                    if (elem) {
                        util.addEvent("click", elem, function() {
                            socialRegFormId = this.id;
                        });
                    }

                    socialRegFormId = containerId;
                    sociallogin(containerId, onSuccess, onError);
                    break;
                }
            case 'accountlinking':
                {
                    accountLinking(containerId, onSuccess, onError);
                    break;
                }
            case 'deleteuser':
                {
                    deleteUser(onSuccess, onError);
                    break;
                }
                //            case 'oneclicksignin':
                //                {
                //                    emailSignin(onSuccess, onError);
                //                    break;
                //                }
            case 'loginbyphone':
                {
                    loginByPhone(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'registerbyphone':
                {


                    var formInterval;
                    var isClear = 1;
                    formInterval = setInterval(
                        function() {
                            if (!isRegFormSchemaLock) {
                                isRegFormSchemaLock = true;
                                registrationByPhone(containerId, onSuccess, onError, classPrefix);

                                if (isClear > 0) {
                                    clearInterval(formInterval);
                                }
                            }

                        }, 1000);
                    break;
                }

            case 'forgotpasswordbyphone':
                {
                    forgotPasswordbyPhone(containerId, onSuccess, onError);
                    break;
                }
            case 'checkphone':
                {
                    checkPhoneNumberAvailability(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'updatephone':
                {
                    updatePhoneNumber(containerId, onSuccess, onError, classPrefix);
                    break;
                }

            case 'changeusername':
                {
                    changeUsername(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'resendemailverification':
                {
                    resendEmailVerification(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'addemail':
                {
                    addEmail(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'removeemail':
                {
                    removeEmail(containerId, onSuccess, onError, classPrefix);
                    break;
                }
            case 'ssologin':
                {
                    ssoLogin(ssoCallback);
                    break;
                }
            case 'ssologout':
                {
                    ssoLogout(ssoCallback, expireToken);
                    break;
                }
            case 'ssonotloginthenlogout':
                {
                    ssoNotLoginThenLogout(logoutCallback, loggedinCallback);
                    break;
                }
            default:
                {
                    throw new Error("This action is not valid");
                }
        }
    }

    function validateAndCall(func) {
        if (isSSOInitFired) {
            if (lrOptions.appName) {
                func();
            } else {
                module.log("LoginRadius site name (app name) required to do SSO");
            }
        } else {
            module.log("Init method should be called first then login.");
        }
    }
    module.init = function(action, options) {
        module.useraction = action;

lrOptions = util.mergeOptions(lrOptions, options) || {};
      //  lrOptions = options || {};
        module.options = lrOptions;

        if (!lrOptions.appName) {
            console.warn("SSO will not work, please set option.appName for SSO");
        } else {
            isSSOInitFired = true;
        }

        lrOptions.formRenderDelay = lrOptions.formRenderDelay || 0;

        if (lrOptions.apikey) {
            if (lrOptions.formRenderDelay > 0) {
                setTimeout(function() {
                    actionHandler(action);
                }, lrOptions.formRenderDelay);
            } else {
                actionHandler(action);
            }
        } else {
            throw new Error("API key must be set.");
        }
    };
    module.customInterface = function(selector, options) {
        lrOptions = options;
        renderCustomInterface(selector);
    };
    module.clearSession = function() {
        removeBrowserStorage(storedTokenName);
        removeBrowserStorage(storedUidName);
    };
    module.registrationFormSchema = [{
        type: "string",
        name: "firstname",
        display: "First name",
        rules: "required",
        permission: "r"
    }, {
        type: "string",
        name: "lasttname",
        display: "Last name",
        rules: "required",
        permission: "r"
    }, {
        type: "string",
        name: "email",
        display: "Email Id",
        rules: "required|valid_email",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }, {
        type: "password",
        name: "confirmpassword",
        display: "Confirm Password",
        rules: "required|matches[password]|min_length[6]|max_length[32]",
        permission: "w"
    }, {
        type: "date",
        name: "birthdate",
        display: "Date of Birth",
        rules: "required|callback_valid_date",
        permission: "w"
    }, {
        type: "option",
        name: "gender",
        display: "Gender",
        rules: "required",
        permission: "w",
        options: [{
            id: 'm',
            text: "Male"
        }, {
            id: 'f',
            text: "Female"
        }]
    }];
    module.loginFormSchema = [{
        type: "string",
        name: "email",
        display: "Email Id",
        rules: "required|valid_email",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }];

    module.resetPasswordByPhoneSchema = [{
        type: "string",
        name: "otp",
        display: "OTP",
        rules: "required",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }];
    module.checkPhoneNumberSchema = [{
        type: "string",
        name: "phone",
        display: "Phone Number",
        rules: "required",
        permission: "r"
    }];
    module.forgotPasswordByPhoneSchema = [{
        type: "string",
        name: "phone",
        display: "Phone Number",
        rules: "required",
        permission: "r"
    }];
    module.otpSchema = [{
        type: "string",
        name: "otp",
        display: "OTP",
        rules: "required",
        permission: "r"
    }];

    module.loginByPhoneSchema = [{
        type: "string",
        name: "phone",
        display: "Phone Number",
        rules: "required|valid_phoneno",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }];

    module.registrationByPhoneSchema = [{
        type: "string",
        name: "phoneId",
        display: "Phone Number",
        rules: "required|valid_phoneno",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }, {
        type: "string",
        name: "email",
        display: "Email Id",
        rules: "required|valid_email",
        permission: "r"
    }, {
        type: "string",
        name: "firstname",
        display: "First name",
        rules: "required",
        permission: "r"
    }, {
        type: "option",
        name: "gender",
        display: "Gender",
        rules: "required",
        permission: "w",
        options: [{
            id: 'm',
            text: "Male"
        }, {
            id: 'f',
            text: "Female"
        }]
    }];

    module.loginByUsernameSchema = [{
        type: "string",
        name: "username",
        display: "Email/Username",
        rules: "required",
        permission: "r"
    }, {
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }];


    module.forgotPasswordFormSchema = [{
        type: "string",
        name: "email",
        display: "Email",
        rules: "required|valid_email",
        permission: "r"
    }];
    module.changePasswordFormSchema = [{
            type: "password",
            name: "oldpassword",
            display: "Old Password",
            rules: "required|min_length[6]|max_length[32]",
            permission: "w"
        },

        {
            type: "password",
            name: "newpassword",
            display: "Password",
            rules: "required|min_length[6]|max_length[32]",
            permission: "w"
        },

        {
            type: "password",
            name: "confirmnewpassword",
            display: "Confirm Password",
            rules: "required|min_length[6]|max_length[32]|matches[newpassword]",
            permission: "w"
        }

    ];
    module.emailSchema = module.forgotPasswordFormSchema;
    module.addEmailSchema = [{
        type: "string",
        name: "email",
        display: "Email",
        rules: "required|valid_email",
        permission: "r"
    }, {
        type: "string",
        name: "type",
        display: "Type",
        rules: "required",
        permission: "r"
    }];
    module.changeUsernameFormSchema = [{
        type: "string",
        name: "username",
        display: "Username",
        rules: "required",
        permission: "r"
    }];
    module.resetPasswordFormSchema = [{
        type: "password",
        name: "password",
        display: "Password",
        rules: "required|min_length[6]|max_length[32]",
        permission: "w"
    }, {
        type: "password",
        name: "confirmpassword",
        display: "Confirm Password",
        rules: "required|matches[password]|min_length[6]|max_length[32]",
        permission: "w"
    }, {
        type: "hidden",
        name: "resettoken",
        display: "",
        rules: "required",
        permission: "w",
        value: ""
    }];

    //API
    module.api = {};
    module.api.init = function(options) {
        lrOptions = options;
    }
    module.api.login = function(data, onSuccess, onError, onPasswordExpiry) {
        loginController(jsonToQueryString(data), onSuccess, onError, onPasswordExpiry);
    }

    //    module.api.periodicPasswordReset = function(data, userprofile, accessToken, onSuccess, onError) {
    //        periodicalPasswordRestController(jsonToQueryString(data), onSuccess, onError, userprofile, accessToken, {});
    //    }

    module.api.registration = function(data, onSuccess, onError) {
        registrationController(jsonToQueryString(data), onSuccess, onError);
    }

    module.api.forgotPassword = function(data, onSuccess, onError) {
        forgotPasswordController(jsonToQueryString(data), onSuccess, onError);
    }

    module.api.resetPassword = function(data, onSuccess, onError) {
        resetPasswordController(jsonToQueryString(data), onSuccess, onError);
    }

    module.api.emailVerification = function(data, onSuccess, onError) {
        emailVerificationController(data.vtoken, onSuccess, onError);
    }
    module.api.socialLogin = function(data, onSuccess, onError, onMissingField) {
        socialLoginReceiveToken(data.token, null, onSuccess, onError, onMissingField);
    }
    module.api.resendEmailVerification = function(data, onSuccess, onError) {
        resendEmailVerificationController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.addEmail = function(data, onSuccess, onError) {
        addEmailController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.removeEmail = function(data, onSuccess, onError) {
        removeEmailController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.changeUsername = function(data, onSuccess, onError) {
        changeUsernameController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.loginByPhone = function(data, onSuccess, onError) {
        loginByPhoneController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.registrationByPhone = function(containerId, data, onSuccess, onError, classPrefix) {
        registrationByPhoneController(containerId, jsonToQueryString(data), onSuccess, onError, classPrefix)
    }
    module.api.checkPhoneNumberAvailability = function(data, onSuccess, onError) {
        checkPhoneNumberAvailabilityController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.resetPasswordByPhone = function(data, onSuccess, onError) {
        resetPasswordByPhoneController(jsonToQueryString(data), onSuccess, onError);
    }
    module.api.forgotPasswordbyPhone = function(containerId, data, onSuccess, onError, classPrefix) {
        forgotPasswordbyPhoneController(containerId, jsonToQueryString(data), onSuccess, onError, classPrefix);
    }
    module.api.updateSocialData = function(data, userprofile, onSuccess, onError) {

            var token = data.token;
            data.token = null;

            socialDataUpdate(token, jsonToQueryString(data), userprofile, onSuccess, onError);
        }
        util.mergeOptions  =function (obj1,obj2){
    var obj3 = {};
    for (var attrname in obj1) { obj3[attrname] = obj1[attrname]; }
    for (var attrname in obj2) { obj3[attrname] = obj2[attrname]; }
    return obj3;
};
        //module.util = util;
    util.openWindow = function(_url, isDirectPopupOpen, isSingleChildWindow) {
        if (util.isMobile.any()) {
            lrOptions.isParentWindowLogin = true;
        }
        _url = _url || this.href;

        var parser = document.createElement('a');
        parser.href = _url;
        var provider = util.getQueryParameterByName("provider", parser.search);

        //Hightlight provider start code
        var openIdProvider = module.openIdProvider[provider];

        var lrOpenIdProvider = false;

        if (provider.indexOf("{username}") > -1 || provider == "openid") {
            if (!isDirectPopupOpen) {
                lrOpenIdProvider = true;
                util.setOpenIdValue(provider, false);

            }
        }

        if (openIdProvider != undefined) {
            provider = openIdProvider;
            util.setLRCurrentProvider(provider);
        }

        module.$hooks.loginProviderClick(provider);
        util.hideOpenIdPopup();

        if (lrOpenIdProvider) {
            util.elementById('lr_openid_popup').style.display = 'block';

            var hiddenInputUrl = util.elementsByClass('lr_hid_url');
            for (var i = 0; i < hiddenInputUrl.length; i++) {
                hiddenInputUrl[i].value = _url;
            }

        } else {
            //highlight provider end processing
            util.beforeLogin('block', provider);
            // var dialogWindow;
            var dialogTimer;
            if (!lrOptions.isConnectingInsidePopup) {
                _url += "&cip=false";
            }
            if (lrOptions.ConnectingTextInsidePopup != "") {
                _url += "&ctip=" + lrOptions.ConnectingTextInsidePopup;
            }
            if (lrOptions.ConnectingImageUrlInsidePopup != "") {
                _url += "&ciip=" + lrOptions.ConnectingImageUrlInsidePopup;
            }
            if (lrOptions.InsidePopupFavIcon != "") {
                _url += "&cfip=" + lrOptions.InsidePopupFavIcon;
            }
            if (lrOptions.disableSignup != "") {
                _url += "&disableSignup=" + lrOptions.disableSignup;
            }

            if (lrOptions.isParentWindowLogin) {
                if (!lrOptions.sameWindow) {
                    _url = _url + "&same_window=1";
                }

                if (lrOptions.isAccessToken && !lrOptions.callbacktype) {
                    _url = _url.replace("&callbacktype=", "");
                    _url = _url + "&callbacktype=hash";
                }

                window.location.href = _url;

            } else {
                var windowname = isSingleChildWindow ? "lrpopupchildwindow" : "";
                // module.dialogWindow = window.open(_url, 'lrpopupchildwindow', 'menubar=1,resizable=1,width=450,height=450,scrollbars=1');
                module.dialogWindow = window.open(_url, windowname, 'menubar=1,resizable=1,width=450,height=450,scrollbars=1');

            }
            dialogTimer = setInterval(function() {
                var dialogClosed = module.dialogWindow.closed;
                if (dialogClosed) {
                    clearInterval(dialogTimer);
                    util.beforeLogin('none', provider);
                }
            }, 1000);
            if (module.dialogWindow && module.dialogWindow.focus) {
                module.dialogWindow.focus();
            }


        }
        return false;
    };

    module.log = function() {
        if (arguments.length > 0) {
            if (typeof console !== "undefined") {
                console.log("[LoginRadius - Initializing login interface.] ", arguments);
            }
        }
    };
   

    function ssoLogin(callback) {
        validateAndCall(function() {
            //  util.ajaxCall("get","https://" + lrOptions.appName + "."+hubdomain + "/ssologin/login", "",function (data) {
            util.jsonpCall("https://" + lrOptions.appName + "." + hubdomain + "/ssologin/login", function(data) {
                if (data.isauthenticated) {

                    if (module.loginradiushtml5passToken) {
                        module.loginradiushtml5passToken(data.token);
                    } else {
                        if (typeof callback == 'string' || callback instanceof String) {
                            var form = document.createElement('form');
                            form.action = callback || window.location.href;
                            form.method = 'POST';

                            var hidden = document.createElement('input');
                            hidden.type = 'hidden';
                            hidden.name = 'token';
                            hidden.value = data.token;

                            form.appendChild(hidden);
                            document.body.appendChild(form);
                            form.submit();
                        } else if (typeof(callback) == "function") {
                            callback(data.token);
                        }
                    }
                }
            });
        });
    }

    function ssoLogout(callback, tokenExpire) {
        validateAndCall(function() {

            var tokenExpiryParameter = tokenExpire ? "?tokenExpire=1" : "";
            var action = tokenExpire ? "tokenExpire" : "logout";

            //  util.ajaxCall("get", "https://" + lrOptions.appName + "."+hubdomain+"/ssologin/" + action + tokenExpiryParameter,"", function (data) {
            util.jsonpCall("https://" + lrOptions.appName + "." + hubdomain + "/ssologin/" + action + tokenExpiryParameter, function(data) {
                module.documentCookies.removeItem(tokencookie, lrOptions.appPath);
                if (typeof callback == 'string' || callback instanceof String) {
                    window.location = callback || window.location.href;
                } else if (typeof(callback) == "function") {
                    callback();
                }
            });
        });
    }

    function setToken(token) {
        module.documentCookies.setItem(tokencookie, token, lrOptions.appPath);
    }

    function ssoNotLoginThenLogout(logoutCallback, loggedinCallback) {
        validateAndCall(function() {
            // util.ajaxCall("get", "https://" + lrOptions.appName + "."+hubdomain+"/ssologin/login","", function (data) {
            util.jsonpCall("https://" + lrOptions.appName + "." + hubdomain + "/ssologin/login", function(data) {
                if (data.isauthenticated) {
                    var cookietoken = module.documentCookies.getItem(tokencookie);
                    if (cookietoken && cookietoken != data.token) {
                        if (typeof logoutCallback == 'string' || logoutCallback instanceof String) {
                            window.location = logoutCallback || window.location.href;
                        } else if (typeof(logoutCallback) == "function") {
                            logoutCallback(data.token);
                        }
                    } else {
                        if (loggedinCallback && typeof(loggedinCallback) == "function") {
                            loggedinCallback(data.token);
                        } else if (typeof loggedinCallback == 'string' || loggedinCallback instanceof String) {
                            if (module.loginradiushtml5passToken) {
                                module.loginradiushtml5passToken(data.token);
                            }
                        }

                    }
                } else {
                    if (typeof logoutCallback == 'string' || logoutCallback instanceof String) {
                        window.location = logoutCallback || window.location.href;
                    } else if (typeof(logoutCallback) == "function") {
                        logoutCallback();
                    }
                }
            });
        });
    }

    function appsettings(data) {
        var interfacecontainer;
        if (data.errorcode) {
            interfacecontainer = util.elementsByClass(lrOptions.interfaceContainer);
            for (var i = 0; i < interfacecontainer.length; i++) {
                interfacecontainer[i].innerHTML = ["<b style='color:red;'>" + data.errormessage + ".</b>"].join("");
            }
        } else {

            if ((!module.util.isInt(lrOptions.noOfColumns)) || (lrOptions.noOfColumns < 2)) {
                lrOptions.noOfColumns = '';
            }

            module.providers = data.Providers;
            module.size = data.IconSize;
            module.iconsize = data.IconSize;
            module.userinterface = lrOptions.interfaceSize == 'small' ? data.Interface + "-150" : data.Interface + "-200";

            module.WhiteLabel = data.WhiteLabel;
            module.IsPaid = data.IsPaid;
            module.IsHttps = data.IsHttps;
            module.appName = data.SubDomain;
            module.Isslide = data.IsSlide;
            module.IsNoFollowEnabled = data.IsNoFollowEnabled;

            if (lrOptions.socialLoginHeading !== '') {
                lrOptions.socialLoginHeading = ['<h3>', lrOptions.socialLoginHeading, '</h3>'].join(" ");
            }

            lrOptions.socialLoginHeading = lrOptions.socialLoginHeading;

            module.background = lrOptions.interfaceBackground || "transparent";
            module.sameWindow = (lrOptions.sameWindow == 1) ? '&same_window=1' : '';

            module.noVirtualIframe = lrOptions.noVirtualIframe;
            module.noofrow = 1;

            module.log("LoginRadius - API settings success.");

            Providerloaded();
        }
    }

    function loadAppJson() {
        util.ajaxCall('get', appJsonUrl + lrOptions.apikey + ".json", "", function(data) {
            appsettings(data);
            if (lrOptions.enableApiCaching) {
                setBrowserStorage(module.LRSiteSettings, JSON.stringify(data));
                setBrowserStorage(module.LRCacheTime, new Date().getTime() + 2 * 60 * 1000);
            }
        }, 'loginRadiusAppJsonLoaded');
    }

    function createtemplate() {

    }

    function Providerloaded() {

        var objectName = window[util.getThisObjectName()];
        module.interfacetheme = module.interfacetheme || 'loginraidus-social-double-glider-200';
        var cssfilepath = cdnDomain + 'logintheme_' + cssPath + '/' + module.userinterface + '/css/style.css';
        var popupcssfilepath = cdnDomain + 'css/LoginRadiusPopup.css';

        //var commjsfilepath =  cdnDomain + 'js/LoginRadius.comm.js';

        module.log("LoginRadius - Initializing CSS.");
        module.log("LoginRadius - CSS load successful.");

        module.Interface = {};

        var interfacecontainer = util.elementsByClass(lrOptions.interfaceContainer);

        module.log("LoginRadius - Initializing login interface template.");
        var userInterface = module.userinterface.replace(/\-/g, '_');
        //       if(userInterface == 'loginradius_social_embed_bricks_150' || userInterface == 'loginradius_social_embed_bricks_200'){
        //           lrOptions.noOfColumns = 1;
        //       }
        //       else if(userInterface == 'loginradius_social_popup_type_150' || userInterface == 'loginradius_social_popup_type_200'){
        //           lrOptions.noOfColumns = (lrOptions.noOfColumns || 2);
        //           
        //       }
        //       else if(userInterface == 'loginradius_social_login_theme_150' || userInterface == 'loginradius_social_login_theme_200'){
        //           lrOptions.noOfColumns = (lrOptions.noOfColumns || 2);
        //           module.rows =2;
        //           
        //       }
        //       else if(userInterface == 'loginraidus_social_double_glider_150' || userInterface == 'loginraidus_social_double_glider_200'){
        //          
        //           if(userInterface == 'loginraidus_social_double_glider_150'){
        //               lrOptions.noOfColumns = (lrOptions.noOfColumns || 3);
        //           }
        //           else{
        //                lrOptions.noOfColumns = (lrOptions.noOfColumns || 4);
        //           }
        //           module.rows =2;
        //           
        //       }
        //       else if(userInterface == 'loginradius_social_embed_type_150' || userInterface == 'loginradius_social_embed_type_200'){
        //          
        //           if(userInterface == 'loginradius_social_embed_type_150'){
        //               lrOptions.noOfColumns = (lrOptions.noOfColumns || 3);
        //           }
        //           else{
        //                lrOptions.noOfColumns = (lrOptions.noOfColumns || 4);
        //           }
        //        
        //           
        //       }
        //       else if(userInterface == 'loginradius_social_single_glider_150' || userInterface == 'loginradius_social_single_glider_200'){
        //             module.rows =1;
        //           if(userInterface == 'loginradius_social_single_glider_150'){
        //               lrOptions.noOfColumns = (lrOptions.noOfColumns || 3);
        //               
        //           }
        //           else{
        //                lrOptions.noOfColumns = (lrOptions.noOfColumns || 4);
        //           }
        //        
        //           
        //       }

        var renderedinteface = util.tmpl(module.templates[module.userinterface.replace(/\-/g, '_')], {
            Interface: module
        });

        lrOptions.noOfColumns = lrOptions.noOfColumns || objectName.options.noOfColumns;
        module.rows = module.rows || objectName.rows;
        module.iconheight = module.iconheight || objectName.iconheight;
        module.iconwidth = module.iconwidth || objectName.iconwidth;
        if (lrOptions.noOfColumns != '') {
            var customwidth = (100 / parseInt(lrOptions.noOfColumns)) + '%"';
            renderedinteface = renderedinteface.split('#width-style#').join('style="width:' + customwidth);
        } else {
            renderedinteface = renderedinteface.split('#width-style#').join('');
        }

        util.addEmbedCss([
            ".lr-loading-frame {background: #f2f2f2;background: rgba(242, 242, 242, 0.7);text-align: center;height: 100%;position: fixed;bottom: 0;top: 0;left: 0;right: 0;z-index: 9999;}.lr-loading-frame:before, .lr-loading-box:before {content: '';display: inline-block;height: 100%;vertical-align: middle;margin-right: -0.25em;}",
            ".lr-loading-box {font-family: Verdana, Arial, Helvetica, sans-serif;width: 230px;height: 230px;background: url(" + lrOptions.protocol + "//" + hubdomain + "/cdn/include/images/loading_spinner_blank.gif) no-repeat center center;text-align: center;color: #444;font-size: 18px;line-height: 230px;display: inline-block;vertical-align: middle;}.lr-loading-text-box {width: 140px;line-height: normal;display: inline-block;vertical-align: middle;}"
        ].join('\n'));
        util.addExternalCss(popupcssfilepath);
        module.log("LoginRadius - Interface template load successful.");
        var i;
        if (module.noVirtualIframe) {
            util.addExternalCss(cssfilepath);
            for (i = 0; i < interfacecontainer.length; i++) {

                interfacecontainer[i].style.display = 'inline-block';
                interfacecontainer[i].innerHTML = renderedinteface;

                interfacecontainer[i].insertAdjacentHTML('beforeend', LoginRadius_SocialLogin.openIdPopup);
                if (lrOptions.isConnectingTextOnInterface) {
                    interfacecontainer[i].insertAdjacentHTML('beforeend', LoginRadius_SocialLogin.Processing_Message);
                }
                util.addEmbedCss('.lr_sociallogin_processing {display: block;padding: 4px 5px;background: #eee;width: 150px;margin: 0 auto;color: #444;text-align: left;border-radius: 5px;border: 1px solid #ccc;height: 13px;font-size: 13px;}.lr_sociallogin_processing:before {content: "";display: inline-block;width: 16px;height: 16px;margin-right: 5px;background: url(https://' + cdnDomain + '/images/loading_spinner_blank.gif);background-size: 16px;vertical-align: bottom;}');

                if (!module.WhiteLabel) {
                    interfacecontainer[i].insertAdjacentHTML('beforeend', LoginRadius_SocialLogin.secured_by_lr_link);
                }
                if (module.Isslide) {
                    util.slider(interfacecontainer[i], "slide", "lr_arrow_next", "lr_arrow_prev", module.noofrow);
                }
            }
        } else {
            for (i = 0; i < interfacecontainer.length; i++) {
                util.contentIframe(interfacecontainer[i], renderedinteface, cssfilepath, function(ifr, parent) {
                    var iframeDoc = ifr.contentDocument || ifr.contentWindow.document;

                    var extraHeight = 4;
                    if (lrOptions.interfaceSize.toLowerCase() == "small") {
                        extraHeight = 8;
                    }

                    if (lrOptions.isConnectingTextOnInterface) {
                        extraHeight = 26;
                    }
                    var dim;

                    if (module.Isslide) {
                        util.slider(iframeDoc.body, "slide", "lr_arrow_next", "lr_arrow_prev", module.noofrow);

                        var noofpages = module.rows;
                        if (module.providers.length <= lrOptions.noOfColumns) {
                            noofpages = 1;
                        }

                        if (noofpages <= 1) {
                            dim = calculateHeightWidth(+module.iconheight, +module.iconwidth.replace("px", ''), extraHeight, lrOptions.noOfColumns, noofpages, 22);
                        } else {
                            dim = calculateHeightWidth(+module.iconheight, +module.iconwidth.replace("px", ''), extraHeight, lrOptions.noOfColumns, noofpages, 22);
                        }


                    } else {
                        dim = calculateHeightWidth(+module.iconheight, +module.iconwidth.replace("px", ''), extraHeight, lrOptions.noOfColumns, (module.providers.length / lrOptions.noOfColumns), 0);
                    }

                    if (parseInt(lrOptions.customwidth) > 0) {
                        dim.width = parseInt(lrOptions.customwidth);
                    }

                    parent.style.display = 'inline-block';
                    //  parent.style.width = dim.width + 'px';
                    ifr.height = dim.height;

                    if (module.userinterface == 'loginraidus-social-double-glider-150' || module.userinterface == 'loginraidus-social-double-glider-200' || module.userinterface == 'loginradius-social-single-glider-150' || module.userinterface == 'loginradius-social-single-glider-200') {
                        ifr.width = dim.width + 'px';
                        ifr.style.width = dim.width + 'px';
                        //  ifr.style.maxWidth = dim.width + 'px';
                    } else {
                        ifr.width = "100%";
                        ifr.style.width = '100%';
                        ifr.style.maxWidth = dim.width + 'px';
                    }

                    ifr.style.height = dim.height + 'px';

                    if (browser.msie && dim.width <= 410) {
                        if (module.Isslide) {
                            util.addEmbedCss('.lr_providericons:after {content: " ";}', iframeDoc);
                        }
                    }
                    util.addCss(ifr, {
                        'max-width': dim.width + 'px'
                    });


                });
            }
        }

        document.body.insertAdjacentHTML('beforeend', module.openIdPopup);
        if (!module.WhiteLabel) {
            var securedbylrhtml = module.securedByLoginradius.replace('#domain#', window.location.hostname);
            if (module.IsNoFollowEnabled) {
                securedbylrhtml = securedbylrhtml.replace('#nofollow', 'nofollow');
            } else {
                securedbylrhtml = securedbylrhtml.replace('rel="#nofollow"', '');
            }
            util.addEmbedCss([
                '.lr-tip:hover {display:block !important;} .lr-secured-linkboxtext {width: 100%; text-align:center;} .lr-secured-linkbox{ width:100%}',
                '.lr-secured-link{color:#0080ff; text-decoration:underline; font-family:Arial,Helvetica,sans-serif;font-size:12px;cursor:pointer;}',
                '.lr-secured-link:hover{color:#0080ff; text-decoration: none;}',
                '.lr-tip {position: absolute;background:#fff; float:left;border:1px solid #ccc;	border-radius: 8px;font-size: 1.2em;width: 340px; z-index:9999;}',
                '.lr-tip:before {content:\'\';position: absolute;top: -7px;left: 42px;display:inline-block;border-right: 7px solid transparent;	border-bottom: 7px solid #ccc;',
                'border-left: 7px solid transparent;border-bottom-color:rgba(0, 0, 0, 0.2);}',
                '.lr-tip:after {content:\'\';position: absolute;	top: -6px;left:42px;display: inline-block;	border-right: 6px solid transparent;border-bottom: 6px solid #ccc;',
                'border-left: 6px solid transparent;}',
                '.lr-toptext{height:auto; float:left;font-size:11px;font-family: Arial, Helvetica, sans-serif; color:#444; padding: 7px 15px 0px;line-height: 22px;}',
                '.lr-midspace{height:auto; float:left;padding: 0 15px;}',
                '.lr-midlist-box{width:100%; height:auto; float:left;}',
                '.lr-midlist-bg{background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAACXBIWXMAAAsTAAALEwEAmpwYAAAKT2lDQ1BQaG90b3Nob3AgSUNDIHByb2ZpbGUAAHjanVNnVFPpFj333vRCS4iAlEtvUhUIIFJCi4AUkSYqIQkQSoghodkVUcERRUUEG8igiAOOjoCMFVEsDIoK2AfkIaKOg6OIisr74Xuja9a89+bN/rXXPues852zzwfACAyWSDNRNYAMqUIeEeCDx8TG4eQuQIEKJHAAEAizZCFz/SMBAPh+PDwrIsAHvgABeNMLCADATZvAMByH/w/qQplcAYCEAcB0kThLCIAUAEB6jkKmAEBGAYCdmCZTAKAEAGDLY2LjAFAtAGAnf+bTAICd+Jl7AQBblCEVAaCRACATZYhEAGg7AKzPVopFAFgwABRmS8Q5ANgtADBJV2ZIALC3AMDOEAuyAAgMADBRiIUpAAR7AGDIIyN4AISZABRG8lc88SuuEOcqAAB4mbI8uSQ5RYFbCC1xB1dXLh4ozkkXKxQ2YQJhmkAuwnmZGTKBNA/g88wAAKCRFRHgg/P9eM4Ors7ONo62Dl8t6r8G/yJiYuP+5c+rcEAAAOF0ftH+LC+zGoA7BoBt/qIl7gRoXgugdfeLZrIPQLUAoOnaV/Nw+H48PEWhkLnZ2eXk5NhKxEJbYcpXff5nwl/AV/1s+X48/Pf14L7iJIEyXYFHBPjgwsz0TKUcz5IJhGLc5o9H/LcL//wd0yLESWK5WCoU41EScY5EmozzMqUiiUKSKcUl0v9k4t8s+wM+3zUAsGo+AXuRLahdYwP2SycQWHTA4vcAAPK7b8HUKAgDgGiD4c93/+8//UegJQCAZkmScQAAXkQkLlTKsz/HCAAARKCBKrBBG/TBGCzABhzBBdzBC/xgNoRCJMTCQhBCCmSAHHJgKayCQiiGzbAdKmAv1EAdNMBRaIaTcA4uwlW4Dj1wD/phCJ7BKLyBCQRByAgTYSHaiAFiilgjjggXmYX4IcFIBBKLJCDJiBRRIkuRNUgxUopUIFVIHfI9cgI5h1xGupE7yAAygvyGvEcxlIGyUT3UDLVDuag3GoRGogvQZHQxmo8WoJvQcrQaPYw2oefQq2gP2o8+Q8cwwOgYBzPEbDAuxsNCsTgsCZNjy7EirAyrxhqwVqwDu4n1Y8+xdwQSgUXACTYEd0IgYR5BSFhMWE7YSKggHCQ0EdoJNwkDhFHCJyKTqEu0JroR+cQYYjIxh1hILCPWEo8TLxB7iEPENyQSiUMyJ7mQAkmxpFTSEtJG0m5SI+ksqZs0SBojk8naZGuyBzmULCAryIXkneTD5DPkG+Qh8lsKnWJAcaT4U+IoUspqShnlEOU05QZlmDJBVaOaUt2ooVQRNY9aQq2htlKvUYeoEzR1mjnNgxZJS6WtopXTGmgXaPdpr+h0uhHdlR5Ol9BX0svpR+iX6AP0dwwNhhWDx4hnKBmbGAcYZxl3GK+YTKYZ04sZx1QwNzHrmOeZD5lvVVgqtip8FZHKCpVKlSaVGyovVKmqpqreqgtV81XLVI+pXlN9rkZVM1PjqQnUlqtVqp1Q61MbU2epO6iHqmeob1Q/pH5Z/YkGWcNMw09DpFGgsV/jvMYgC2MZs3gsIWsNq4Z1gTXEJrHN2Xx2KruY/R27iz2qqaE5QzNKM1ezUvOUZj8H45hx+Jx0TgnnKKeX836K3hTvKeIpG6Y0TLkxZVxrqpaXllirSKtRq0frvTau7aedpr1Fu1n7gQ5Bx0onXCdHZ4/OBZ3nU9lT3acKpxZNPTr1ri6qa6UbobtEd79up+6Ynr5egJ5Mb6feeb3n+hx9L/1U/W36p/VHDFgGswwkBtsMzhg8xTVxbzwdL8fb8VFDXcNAQ6VhlWGX4YSRudE8o9VGjUYPjGnGXOMk423GbcajJgYmISZLTepN7ppSTbmmKaY7TDtMx83MzaLN1pk1mz0x1zLnm+eb15vft2BaeFostqi2uGVJsuRaplnutrxuhVo5WaVYVVpds0atna0l1rutu6cRp7lOk06rntZnw7Dxtsm2qbcZsOXYBtuutm22fWFnYhdnt8Wuw+6TvZN9un2N/T0HDYfZDqsdWh1+c7RyFDpWOt6azpzuP33F9JbpL2dYzxDP2DPjthPLKcRpnVOb00dnF2e5c4PziIuJS4LLLpc+Lpsbxt3IveRKdPVxXeF60vWdm7Obwu2o26/uNu5p7ofcn8w0nymeWTNz0MPIQ+BR5dE/C5+VMGvfrH5PQ0+BZ7XnIy9jL5FXrdewt6V3qvdh7xc+9j5yn+M+4zw33jLeWV/MN8C3yLfLT8Nvnl+F30N/I/9k/3r/0QCngCUBZwOJgUGBWwL7+Hp8Ib+OPzrbZfay2e1BjKC5QRVBj4KtguXBrSFoyOyQrSH355jOkc5pDoVQfujW0Adh5mGLw34MJ4WHhVeGP45wiFga0TGXNXfR3ENz30T6RJZE3ptnMU85ry1KNSo+qi5qPNo3ujS6P8YuZlnM1VidWElsSxw5LiquNm5svt/87fOH4p3iC+N7F5gvyF1weaHOwvSFpxapLhIsOpZATIhOOJTwQRAqqBaMJfITdyWOCnnCHcJnIi/RNtGI2ENcKh5O8kgqTXqS7JG8NXkkxTOlLOW5hCepkLxMDUzdmzqeFpp2IG0yPTq9MYOSkZBxQqohTZO2Z+pn5mZ2y6xlhbL+xW6Lty8elQfJa7OQrAVZLQq2QqboVFoo1yoHsmdlV2a/zYnKOZarnivN7cyzytuQN5zvn//tEsIS4ZK2pYZLVy0dWOa9rGo5sjxxedsK4xUFK4ZWBqw8uIq2Km3VT6vtV5eufr0mek1rgV7ByoLBtQFr6wtVCuWFfevc1+1dT1gvWd+1YfqGnRs+FYmKrhTbF5cVf9go3HjlG4dvyr+Z3JS0qavEuWTPZtJm6ebeLZ5bDpaql+aXDm4N2dq0Dd9WtO319kXbL5fNKNu7g7ZDuaO/PLi8ZafJzs07P1SkVPRU+lQ27tLdtWHX+G7R7ht7vPY07NXbW7z3/T7JvttVAVVN1WbVZftJ+7P3P66Jqun4lvttXa1ObXHtxwPSA/0HIw6217nU1R3SPVRSj9Yr60cOxx++/p3vdy0NNg1VjZzG4iNwRHnk6fcJ3/ceDTradox7rOEH0x92HWcdL2pCmvKaRptTmvtbYlu6T8w+0dbq3nr8R9sfD5w0PFl5SvNUyWna6YLTk2fyz4ydlZ19fi753GDborZ752PO32oPb++6EHTh0kX/i+c7vDvOXPK4dPKy2+UTV7hXmq86X23qdOo8/pPTT8e7nLuarrlca7nuer21e2b36RueN87d9L158Rb/1tWeOT3dvfN6b/fF9/XfFt1+cif9zsu72Xcn7q28T7xf9EDtQdlD3YfVP1v+3Njv3H9qwHeg89HcR/cGhYPP/pH1jw9DBY+Zj8uGDYbrnjg+OTniP3L96fynQ89kzyaeF/6i/suuFxYvfvjV69fO0ZjRoZfyl5O/bXyl/erA6xmv28bCxh6+yXgzMV70VvvtwXfcdx3vo98PT+R8IH8o/2j5sfVT0Kf7kxmTk/8EA5jz/GMzLdsAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAAATxJREFUeNo00D0rhWEYwPH/dd3Pc7wMFi9HQgabskiKLOqEQQYGBikhGeQgCzMlTvIFZHFKMulEWZSySdkonSgsFKXO83bfBvw+wk/YmgXrgaMLkRWgG/CBW2yyg+o5kqD8WkH0EmQUpAG0ljjJ+KnyMxWTA1Cs6QDdBMr4FwW0N7ZwN71GW7oxS5hMK5h1wCOJwTlwFvE88sNTFD8/uH97Bq8sq+C6jSjN1XWAgzBgqWeA1qpq5s/yBFEIInWKtabCT3E9ucpyTz/pmnq2e4eYuzji8fUJ/BSAGjJdg2FQail+f7LbN8JEWycPX+8sFPJYY0AE4EVxdgPP5+TmivHTAwKbMFM4JI5CkL8UZ/fl99HPgWSJI1LllYRhCdT8Hxwj0Zgh0wFOz8G9ol5TEseKmhJQBLsHbhFxyc8AOlZxvYEO+M0AAAAASUVORK5CYII=) no-repeat 2px 4px;float:left; height:auto;}',
                '.lr-midlist-text{float:left; padding-left:17px; line-height:20px; color:#444; font-size:11px; font-family:Arial, Helvetica, sans-serif;}',
                '.lr-bottom{border-top: 1px solid #CCCCCC; float: left;font-family: Arial,Helvetica,sans-serif; font-size: 11px; height: auto; line-height: 22px; margin-top:8px; padding-bottom: 4px; padding-top: 2px; width: 100%;}',
                '.lr-bottom-link{padding-left:20px; padding-right:20px;float:right;}',
                '.lr-bottom-link a{color:#0080ff; text-decoration: underline;font-family:Arial, Helvetica, sans-serif; font-size:12px;}',
                '.lr-bottom-link a:hover{color:#0080ff; text-decoration: none;}'
            ].join('\n'));
            document.body.insertAdjacentHTML('beforeend', securedbylrhtml);



            var securebylrlinks = util.elementsByClass('lr-secured-linkboxtext');
            for (var j = 0; j < securebylrlinks.length; j++) {
                util.addEvent('mouseover', securebylrlinks[j], function() {
                    var pos = util.getPosition(this);
                    var tooltip = util.elementById('lr-secure-div');
                    tooltip.style.display = 'block';
                    tooltip.style.left = pos.x + 'px';
                    tooltip.style.top = pos.y + 20 + 'px';
                    if (window['lrsecuredbytooltiptimeout']) {
                        clearInterval(window['lrsecuredbytooltiptimeout']);
                    }
                });

                util.addEvent('mouseout', securebylrlinks[j], function() {
                    window['lrsecuredbytooltiptimeout'] = setTimeout(function() {
                        var tooltip = util.elementById('lr-secure-div');
                        tooltip.style.display = 'none';
                    }, 500);
                });
            }

            var tooltipdiv = util.elementById('lr-secure-div');
            util.addEvent('mouseover', tooltipdiv, function() {
                var _this = this;
                setTimeout(function() {
                    _this.style.display = 'none';
                }, 500);

                clearTimeout(window['lrsecuredbytooltiptimeout']);
            });
        }

    }

    function calculateHeightWidth(iconHeight, iconWidth, extraHeight, noOfColumns, noOfRows, extraWidth) {
        if (lrOptions.socialLoginHeading !== '') {
            extraHeight = extraHeight + 28;
        }
        var x = {};
        x.height = ((iconHeight + 4) * Math.ceil(noOfRows)) + extraHeight;
        x.width = ((iconWidth + 3) * noOfColumns) + extraWidth;

        return x;
    }
    return module;


});
