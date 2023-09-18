/*!
 * Font Awesome Pro 5.0.4 by @fontawesome - http://fontawesome.com
 * License - http://fontawesome.com/license (Commercial License)
 */
(function () {
'use strict';

var _WINDOW = {};
try {
  if (typeof window !== 'undefined') _WINDOW = window;
  
} catch (e) {}

var _ref = _WINDOW.navigator || {};
var _ref$userAgent = _ref.userAgent;
var userAgent = _ref$userAgent === undefined ? '' : _ref$userAgent;

var WINDOW = _WINDOW;




var IS_IE = ~userAgent.indexOf('MSIE') || ~userAgent.indexOf('Trident/');

var NAMESPACE_IDENTIFIER = '___FONT_AWESOME___';







var PRODUCTION = function () {
  try {
    return "production" === 'production';
  } catch (e) {
    return false;
  }
}();

var oneToTen = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
var oneToTwenty = oneToTen.concat([11, 12, 13, 14, 15, 16, 17, 18, 19, 20]);



var RESERVED_CLASSES = ['xs', 'sm', 'lg', 'fw', 'ul', 'li', 'border', 'pull-left', 'pull-right', 'spin', 'pulse', 'rotate-90', 'rotate-180', 'rotate-270', 'flip-horizontal', 'flip-vertical', 'stack', 'stack-1x', 'stack-2x', 'inverse', 'layers', 'layers-text', 'layers-counter'].concat(oneToTen.map(function (n) {
  return n + 'x';
})).concat(oneToTwenty.map(function (n) {
  return 'w-' + n;
}));

function bunker(fn) {
  try {
    fn();
  } catch (e) {
    if (!PRODUCTION) {
      throw e;
    }
  }
}

var w = WINDOW || {};

if (!w[NAMESPACE_IDENTIFIER]) w[NAMESPACE_IDENTIFIER] = {};
if (!w[NAMESPACE_IDENTIFIER].styles) w[NAMESPACE_IDENTIFIER].styles = {};
if (!w[NAMESPACE_IDENTIFIER].hooks) w[NAMESPACE_IDENTIFIER].hooks = {};
if (!w[NAMESPACE_IDENTIFIER].shims) w[NAMESPACE_IDENTIFIER].shims = [];

var namespace = w[NAMESPACE_IDENTIFIER];

var _extends = Object.assign || function (target) {
  for (var i = 1; i < arguments.length; i++) {
    var source = arguments[i];

    for (var key in source) {
      if (Object.prototype.hasOwnProperty.call(source, key)) {
        target[key] = source[key];
      }
    }
  }

  return target;
};

function define(prefix, icons) {
  var normalized = Object.keys(icons).reduce(function (acc, iconName) {
    var icon = icons[iconName];
    var expanded = !!icon.icon;

    if (expanded) {
      acc[icon.iconName] = icon.icon;
    } else {
      acc[iconName] = icon;
    }
    return acc;
  }, {});

  if (typeof namespace.hooks.addPack === 'function') {
    namespace.hooks.addPack(prefix, normalized);
  } else {
    namespace.styles[prefix] = _extends({}, namespace.styles[prefix] || {}, normalized);
  }

  /**
   * Font Awesome 4 used the prefix of `fa` for all icons. With the introduction
   * of new styles we needed to differentiate between them. Prefix `fa` is now an alias
   * for `fas` so we'll easy the upgrade process for our users by automatically defining
   * this as well.
   */
  if (prefix === 'fas') {
    define('fa', icons);
  }
}

var icons = {
  "bars": [448, 512, [], "f0c9", "M436 124H12c-6.627 0-12-5.373-12-12V80c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12z"],
  "hashtag": [448, 512, [], "f292", "M443.524 190.109l4.286-24c1.313-7.355-4.342-14.109-11.813-14.109h-89.045l18.909-105.89c1.313-7.355-4.342-14.11-11.813-14.11h-24.38a12 12 0 0 0-11.813 9.89L298.192 152h-111.24l18.909-105.89c1.313-7.355-4.342-14.11-11.813-14.11h-24.38a12 12 0 0 0-11.813 9.89L138.192 152H44.86a12 12 0 0 0-11.813 9.891l-4.286 24C27.448 193.246 33.103 200 40.575 200h89.045l-20 112H16.289a12 12 0 0 0-11.813 9.891l-4.286 24C-1.123 353.246 4.532 360 12.003 360h89.045L82.139 465.891C80.826 473.246 86.481 480 93.953 480h24.38a12 12 0 0 0 11.813-9.891L149.808 360h111.24l-18.909 105.891c-1.313 7.355 4.342 14.109 11.813 14.109h24.38a12 12 0 0 0 11.813-9.891L309.808 360h93.331a12 12 0 0 0 11.813-9.891l4.286-24c1.313-7.355-4.342-14.109-11.813-14.109H318.38l20-112h93.331a12 12 0 0 0 11.813-9.891zM269.62 312H158.38l20-112h111.24l-20 112z"],
  "heart": [576, 512, [], "f004", "M257.3 475.4L92.5 313.6C85.4 307 24 248.1 24 174.8 24 84.1 80.8 24 176 24c41.4 0 80.6 22.8 112 49.8 31.3-27 70.6-49.8 112-49.8 91.7 0 152 56.5 152 150.8 0 52-31.8 103.5-68.1 138.7l-.4.4-164.8 161.5a43.7 43.7 0 0 1-61.4 0zM125.9 279.1L288 438.3l161.8-158.7c27.3-27 54.2-66.3 54.2-104.8C504 107.9 465.8 72 400 72c-47.2 0-92.8 49.3-112 68.4-17-17-64-68.4-112-68.4-65.9 0-104 35.9-104 102.8 0 37.3 26.7 78.9 53.9 104.3z"],
  "phone": [512, 512, [], "f095", "M476.536 22.921L382.288 1.18c-21.6-4.984-43.609 6.185-52.339 26.556l-43.5 101.492c-7.982 18.626-2.604 40.598 13.081 53.43l40.016 32.741c-28.537 52.375-71.771 95.609-124.147 124.147l-32.741-40.015c-12.832-15.685-34.804-21.063-53.43-13.081L27.736 329.949C7.365 338.68-3.804 360.691 1.18 382.287l21.742 94.25C27.74 497.417 46.072 512 67.5 512 312.347 512 512 313.731 512 67.5c0-21.429-14.583-39.761-35.464-44.579zM69.289 463.996l-20.921-90.669 98.212-42.091 55.716 68.094c98.805-46.353 150.588-98.036 197.036-197.035l-68.097-55.715 42.092-98.212 90.669 20.921c-.947 217.588-177.09 393.755-394.707 394.707z"]
};

bunker(function () {
  define('far', icons);
});

}());
