// Karma configuration
// Generated on Mon Nov 07 2016 16:35:30 GMT+0100 (Paris, Madrid)

module.exports = function (config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
        'bower_components/angular/angular.js',
        'bower_components/jquery/dist/jquery.min.js',
        'bower_components/jquery-ui/jquery-ui.min.js',
        'bower_components/highcharts/highstock.src.js',
        'bower_components/highcharts-ng/dist/highcharts-ng.js',
        'bower_components/angular-messages/angular-messages.min.js',
        'bower_components/angular-aria/angular-aria.js',
        'bower_components/angular-animate/angular-animate.js',
        'bower_components/angular-material/angular-material.js',
        'bower_components/angular-ui-router/release/angular-ui-router.min.js',
        'bower_components/angular-cookies/angular-cookies.min.js',
        'bower_components/tether/dist/js/tether.min.js',
        'bower_components/bootstrap/dist/js/bootstrap.min.js',
        'bower_components/crypto-js/crypto-js.js',
        'bower_components/crypto-js/hmac-sha256.js',
        'bower_components/crypto-js/hmac-sha1.js',
        'bower_components/crypto-js/hmac-md5.js',
        'bower_components/angular-utf8-base64/angular-utf8-base64.js',
        'bower_components/angular-gettext/dist/angular-gettext.min.js',
        'bower_components/angular-ui-grid/ui-grid.min.js',
        'bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
        'bower_components/angular-sanitize/angular-sanitize.min.js',
        'bower_components/tv4/tv4.js',
        'bower_components/objectpath/lib/ObjectPath.js',
        'bower_components/angular-schema-form/dist/schema-form.min.js',
        'bower_components/angular-schema-form/dist/bootstrap-decorator.min.js',
        'bower_components/moment/min/moment-with-locales.min.js',
      'bower_components/angular-mocks/angular-mocks.js',
      'app/app.js',
      'modules/options/optionsController.js',
      'modules/nav/navService.js',
      'modules/nav/navController.js',
      'modules/nav/navDirective.js',
      'modules/common/commonService.js',
      'modules/common/http-hmac-interceptors.js',
      'modules/common/httpSecurityInterceptor.js',
      'modules/common/is-authorized.directive.js',
      'modules/home/homeController.js',
      'modules/home/homeService.js',
      'modules/authentication/authenticationController.js',
      'modules/authentication/authenticationService.js',
      'modules/authentication/sessionService.js',
      'modules/authentication/loginFactory.js',
      'modules/options/optionsController.js',
      'modules/authentication/login.spec.js'
    ],


    // list of files to exclude
    exclude: [
    ],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['spec'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser should be started simultaneous
    concurrency: Infinity
  })
}
