var $LRIC = {};
$LRIC.util = {};



//## Utility
//make utility
(function (util) {
    util.elementById = function (_id) {
        return document.getElementById(_id);
    };
    util.elementsByClass = function getElementsByClassName(classname, node) {
        node = node || document.body;
        var a = [], re = new RegExp('(^| )' + classname + '( |$)');
        var els = node.getElementsByTagName("*");
        for (var i = 0, j = els.length; i < j; i++) {
            if (re.test(els[i].className)) {
                a.push(els[i]);
            }
        }
        return a;
    };
    util.addEvent = function (type, element, handle) {
        var elements = [];
        if (element instanceof Array) {
            elements = element;
        }
        else {
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
    
    util.hashTmpl = function hashTmpl(str, data) {
			var fn = !/\W/.test(str) ? cache[str] = cache[str]
					|| tmpl($LRIC.util.elementById(str).innerHTML)
					: new Function("obj",
							"var p=[],print=function(){p.push.apply(p,arguments);};"
									+ "with(obj){p.push('"
									+ str.replace(/[\r\t\n]/g, " ").split("<#")
											.join("\t").replace(
													/((^|#>)[^\t]*)'/g, "$1\r")
											.replace(/\t=(.*?)#>/g, "',$1,'")
											.split("\t").join("');")
											.split("#>").join("p.push('")
											.split("\r").join("\\'")
									+ "');}return p.join('');");
			return data ? fn(data) : fn;
		};


    util.openWindow = function (_url) {
        _url = _url || this.href;
        window.open(_url, 'lrpopupchildwindow', 'menubar=1,resizable=1,width=450,height=500');
        return false;
    };
    util.addCss = function (element, styles) {
        for (var s in styles) {
            element.style[s].cssText += styles[s];
        }
        return true;
    };
    util.getPos = function getPos(el) {
        for (var lx = 0, ly = 0; el != null; lx += el.offsetLeft, ly += el.offsetTop, el = el.offsetParent) { }
        return {
            x: lx,
            y: ly
        };
    };
    util.containsStringArray = function (arr, q) {
        for (var j = 0; j < arr.length; j++) {
            if (arr[j].indexOf(q) !== -1)
                return true;
        }
        return false;
    };
    util.addExternalCss = function (stylesheet, context) {
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
    util.addEmbedCss = function appendStyle(style, context) {
        context = context || document;
        var st = context.createElement('style');
        st.type = "text/css";
        //st.innerHTML = style;
        if (st.styleSheet) {
            // IE
            st.styleSheet.cssText = style;
        }
        else {
            st.appendChild(document.createTextNode(style));
        }

        context.getElementsByTagName('head')[0].appendChild(st);
        return true;
    };
    util.addJs = function (url, context) {
        context = context || document;
        var head = context.getElementsByTagName('head')[0];
        var js = context.createElement('script');
        js.src = url;
        js.type = "text/javascript";
        head.appendChild(js);

        return js;
    }
    util.jsonpCall = function (url, handle) {
        var func = 'Loginradius' + Math.floor((Math.random() * 1000000000000000000) + 1);
        window[func] = function (data) {
            handle(data);

            window[func] = undefined;
            try {
                delete window[func];
            }
            catch (e) { }

            document.getElementsByTagName('head')[0].removeChild(js);
        }

        var endurl = url.indexOf('?') != -1 ? url + '&callback=' + func : url + '?callback=' + func;
        var js = util.addJs(endurl);
    }
    util.arrayIndexOf = function (arr, what, i) {
        i = i || 0;
        var L = arr.length;
        while (i < L) {
            if (arr[i] === what)
                return i; ++i;
        }
        return -1;
    }
    util.arrayRemove = function (arr) {
        var what,
        a = arguments, L = a.length, ax;
        while (L && arr.length) {
            what = a[--L];
            while ((ax = util.arrayIndexOf(arr, what)) != -1) {
                arr.splice(ax, 1);
            }
        }
        return this;
    }
    util.arrayContains = function (arr, obj, iscaseinsentive) {
        var i = arr.length;
        while (i--) {
            if (iscaseinsentive) {
                if (arr[i].toUpperCase() === obj.toUpperCase()) {
                    return true;
                }
            }
            else {
                if (arr[i] === obj) {
                    return true;
                }
            }
        }
        return false;
    }
    util.objectToArray = function (obj) {
        var arr = [];
        for (var i in obj) {
            if (obj.hasOwnProperty(i))
                arr.push(obj[i]);
        }
        return arr;
    }
    util.hasClass = function hasClassonelement(ele, cls) {
        return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
    };
    util.addclass = function addClassonelement(ele, cls) {
        if (!util.hasClass(ele, cls)) {
            ele.className += " " + cls;
            return true;
        }
    };
    util.removeclass = function removeClassonelement(ele, cls) {
        if (util.hasClass(ele, cls)) {
            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
            ele.className = ele.className.replace(reg, ' ');
            return true;
        }
    };
    util.isInt = function (n) {
        var a = typeof n === 'number' && parseFloat(n) == parseInt(n, 10) && !isNaN(n);
        return a;
    }
})($LRIC.util);

//Specially for dom ready method
(function (util) {
    // Everything that has to do with properly supporting our document ready event. Brought over from the most awesome jQuery.
    var userAgent = navigator.userAgent.toLowerCase();

    // Figure out what browser is being used
    var browser =
    {
        version: (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1],
        safari: /webkit/.test(userAgent),
        opera: /opera/.test(userAgent),
        msie: (/msie/.test(userAgent)) && (!/opera/.test(userAgent)),
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
    };

    // From Simon Willison. A safe way to fire onload w/o screwing up everyone else.

    function addLoadEvent(func) {
        var oldonload = window.onload;
        if (typeof window.onload != 'function') {
            window.onload = func;
        }
        else {
            window.onload = function () {
                if (oldonload) {
                    oldonload();
                }
                func();
            }
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
        if (browser.msie && window == top) (function () {
            if (isReady)
                return;
            try {
                // If IE is used, use the trick by Diego Perini
                // http://javascript.nwbox.com/IEContentLoaded/
                document.documentElement.doScroll("left");
            }
            catch (error) {
                setTimeout(arguments.callee, 0);
                return;
            }
            // and execute any waiting functions
            domReady();
        })();

        if (browser.opera) {
            document.addEventListener("DOMContentLoaded", function () {
                if (isReady)
                    return;
                for (var i = 0; i < document.styleSheets.length; i++)
                    if (document.styleSheets[i].disabled) {
                        setTimeout(arguments.callee, 0);
                        return;
                    }
                // and execute any waiting functions
                domReady();
            }, false);
        }

        if (browser.safari) {
            var numStyles; (function () {
                if (isReady)
                    return;
                if (document.readyState != "loaded" && document.readyState != "complete") {
                    setTimeout(arguments.callee, 0);
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
                    setTimeout(arguments.callee, 0);
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
    util.ready = function (fn, args) {
        // Attach the listeners
        bindReady();

        // If the DOM is already ready
        if (isReady) {
            // Execute the function immediately
            fn.call(window, []);
        }
        else {
            // Add the function to the wait list
            readyList.push(function () {
                return fn.call(window, []);
            });
        }
    };

    bindReady();
})($LRIC.util);
//#end

$LRIC.renderInterface = function(cls, options) {
    var lrhost = 'https://hub.loginradius.com';

    var renderedhtml = "";
    $LRIC.util.jsonpCall(lrhost + "/getinterfaceinfo/" + options.apikey, function(data) {

        var templatecompiler = options.hashTemplate ? $LRIC.util.hashTmpl : $LRIC.util.tmpl;

        for (var i = 0; i < data.Providers.length; i++) {
            var value = data.Providers[i];
            renderedhtml += templatecompiler(options.templatename, value);
        }

        var elems = $LRIC.util.elementsByClass(cls);
        for (var i = 0; i < elems.length; i++) {
            elems[i].innerHTML = renderedhtml;
        }
    });
};


