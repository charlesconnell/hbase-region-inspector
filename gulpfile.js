// http://engineroom.teamwork.com/hassle-free-third-party-dependencies/
const gulp = require('gulp')
const concat = require('gulp-concat')
const rename = require('gulp-rename')
const base = 'bower_components/**/'

gulp.task('default', function (resolve) {
  gulp.src(['dist/jquery', 'jquery-ui', 'react', 'react-dom', 'prop-types',
    'react-create-class', 'husl', 'spin', 'bootstrap', 'html2canvas'].map(function (n) { return base + n + '.min.js' })
    .concat([base + 'underscore-min.js']))
    .pipe(concat('vendor.js'))
    .pipe(gulp.dest('resources/public/js/'))

  gulp.src(base + 'bootstrap.min.css')
    .pipe(rename(function (path) {
      path.dirname = ''
      return path
    }))
    .pipe(gulp.dest('resources/public/css/'))

  gulp.src(base + 'glyphicons-halflings*')
    .pipe(rename(function (path) {
      path.dirname = ''
      return path
    }))
    .pipe(gulp.dest('resources/public/fonts/'))

  resolve()
})
