import gulp from 'gulp';
import gutil from 'gulp-util';
import watcher from './tasks/libs/watcher';

import clean from './tasks/clean'
import browserify from './tasks/browserify'
import copy from './tasks/copy'
import less from './tasks/less'
import server from './tasks/server'
import mocha from './tasks/mocha'
import build from './tasks/build'

build.setOptions({
  taskQueue: [
    'clean',
    'copy',
    'less',
    'browserify'
  ]
});

if (gutil.env.prod) {
  process.env.NODE_ENV = 'production';
}

if (gutil.env.dev) {
  process.env.NODE_ENV = 'development';
}

if (gutil.env.watch) {
  watcher.setWatcher();
}

gulp.task('dev', () => {
  watcher.setWatcher();
  gulp.start(['server', 'build']);
});

gulp.task('default', ['build']);
