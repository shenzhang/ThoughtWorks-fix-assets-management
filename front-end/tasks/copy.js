import gulp from 'gulp'
import gutil from 'gulp-util'
import path from 'path'
import newer from 'gulp-newer'
import rename from 'gulp-rename'
import _ from 'lodash'
import mergeSteam from 'merge-stream'

import watcher from './libs/watcher'


const defaultConfig = {
  'files': [
    {
    //   'src': 'src/docs*/index.html',
    //   'dest': 'public/'
    // },{
      'src': 'src/index.html',
      'dest': 'public/'
    }
  ]
};

let conf;

setOptions(); // init

const TASK_NAME = 'copy';
const task =  gulp.task(TASK_NAME, function () {

  function bundleThis(fileConf = {}) {

    function bundle() {
      return gulp.src(fileConf.src)
        .pipe(newer(fileConf.dest))
        .pipe(gulp.dest(fileConf.dest))
        .pipe(watcher.pipeTimer(TASK_NAME));
    }

    if (watcher.isWatching()) {
      gulp.watch(fileConf.src, function (evt) {
        bundle();
      });
    }

    return bundle()
  }

  return mergeSteam.apply(gulp, _.map(conf.files, bundleThis));

});


task.setOptions = setOptions;

export default task;

function setOptions(opts) {
  conf = _.merge({}, defaultConfig, opts)
}
