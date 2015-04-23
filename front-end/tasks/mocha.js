import gulp from 'gulp'
import gutil from 'gulp-util'
import mocha from 'gulp-mocha'
import _ from 'lodash'
import path from 'path'

import watcher from './libs/watcher'
import './libs/jsdom'

const TASK_NAME = 'mocha';

const defaultConfig = {
  'entry': [
    'src/{,**/}__test__/*.spec.js*',
    'components/{,**/}__test__/*.spec.js*'
  ],
  'src': [
    'src/{,**/}*.js*',
    'components/{,**/}*.js*'
  ],
  'options': {
    'ui': 'bdd',
    'reporter': 'spec'
  }
};

let conf
setOptions();

const task = gulp.task(TASK_NAME, function () {
  function bundle() {
    process.env.NODE_ENV = process.env.NODE_ENV || 'test'
    
    return gulp.src(conf.entry, {read: false})
      .pipe(mocha(conf.options))
      .on('error', gutil.log.bind(this));
  }

  if (watcher.isWatching()) {
    gulp.watch([].concat(conf.src), function (evt) {
      gutil.log(evt.path, evt.type);
      bundle();
    });
  }

  return bundle();
})

task.setOptions = setOptions;

export default task;

function setOptions(opts) {
  conf = _.merge({}, defaultConfig, opts)
}
