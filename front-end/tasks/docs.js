import gulp from 'gulp';
import gutil from 'gulp-util';
import _ from 'lodash';
import path from 'path';
import reactDocGen from './libs/gulp-react-doc';

import watcher from './libs/watcher'

const defaultConfig = {
  src: [
    'components/{,**/}*.jsx',
    '!components/{,**/}__tests__/*.jsx',
    '!components/{,**/}examples/*.jsx'
  ],
  dest:'src/docs/data/'
};

let conf;

setOptions(); // init

const TASK_NAME = 'docs';

const task = gulp.task(TASK_NAME, ()=> {

  function bundle() {
    return gulp.src(conf.src)
      .pipe(reactDocGen())
      .on('error', gutil.log.bind(gulp))
      .pipe(gulp.dest(conf.dest))
      .pipe(watcher.pipeTimer(TASK_NAME))
  }

  if (watcher.isWatching()) {
    gulp.watch([].concat(conf.src),  (evt)=> {
      bundle();
    });
  }

  return bundle();

});

task.setOptions = setOptions;

export default task;

function setOptions(opts) {
  conf = _.merge({}, defaultConfig, opts)
}
