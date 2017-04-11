var gulp = require('gulp');
var jshint = require('gulp-jshint');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var ngAnnotate = require('gulp-ng-annotate');

var files = ['app/app.js',
    'modules/common/numberOnlyDirective.js',
    'modules/directives/myGrid/myGridController.js',
    'modules/directives/myGrid/myGridDirective.js',
    'modules/directives/myGrid/rowEditorService.js',
    'modules/directives/myGrid/rowEditCtrl.js',
    'modules/directives/myGrid/removeRowCtrl.js',
    'modules/directives/myGrid/removeRowService.js',
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
    'modules/signUp/signUpController.js',
    'modules/signUp/signUpService.js',
    'modules/purchase/purchaseCategoriesCtrl.js',
    'modules/purchase/purchaseService.js',
    'modules/purchase/purchaseCtrl.js'];


// Lint Task
gulp.task('lint', function () {
    return gulp.src(files)
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});


// Concatenate & Minify JS
gulp.task('scripts', function () {
    return gulp.src(files)
        .pipe(concat('all.js'))
        .pipe(ngAnnotate())
        .pipe(gulp.dest('dist'))
        .pipe(rename('all.min.js'))
        .pipe(uglify({
            mangle: false
        }, {
                compress: {
                    sequences: false
                }
            }))
        .pipe(gulp.dest('dist'));
});

gulp.task('typescript', function () {
return gulp.src(config.ts)
.pipe($.typescript({
target:'es5'
}))
.js
.pipe(gulp.dest(config.clientApp));
});

gulp.watch([config.ts], ['typescript'])
.on('change', changeEvent);

// Default Task
gulp.task('default', ['lint', 'scripts']);


