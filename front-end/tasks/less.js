import path from 'path'
import _ from 'lodash'
import gulp from 'gulp'
import mergeSteam from 'merge-stream'

import gutil from 'gulp-util'
import less from 'gulp-less'

import LessPluginAutoPrefix from 'less-plugin-autoprefix'
import LessPluginPathRedirect from './libs/LessPluginPathRedirect'

import minifyCSS from 'gulp-minify-css';

import watcher from './libs/watcher'

const defaultConfig = {
  'files': [
    {
      'entry': 'src/index.less',
      'src': [
        'src/{,**/}*.less',
        'less/{,**/}*.less'
      ],
      'dest': 'public/assets/css',
      'options': {
        'watch': true
      }
    }
  ],
  'options': {
    'paths': [
      path.join(process.cwd(), 'node_modules/material-ui/src'),
      path.join(process.cwd(), 'node_modules')
    ],
    'plugins': [
      new LessPluginPathRedirect({
        '../../theme.config': 'theme.config'
      }),
      new LessPluginAutoPrefix({
        browsers: [
          "last 2 versions"
        ]
      })
    ]
  }
};

let conf;

setOptions(); // init

const TASK_NAME = 'less';

const task = gulp.task(TASK_NAME, function () {

  function bundleThis(fileConf = {}) {

    fileConf.options = _.merge({}, conf.options, fileConf.options);

    function bundle() {
      return gulp.src(fileConf.entry)
        .pipe(less(fileConf.options))
        .pipe(whenInProductionDoMinify())
        .pipe(gulp.dest(fileConf.dest))
        .pipe(watcher.pipeTimer(TASK_NAME))
    }

    if (fileConf.options.watch && watcher.isWatching()) {
      console.log(fileConf.src)
      gulp.watch([].concat(fileConf.src), function (evt) {
        gutil.log(evt.path, evt.type);
        bundle();
      });
    }

    return bundle();
  }

  return mergeSteam.apply(gulp, _.map(conf.files, bundleThis));

});

task.setOptions = setOptions;

export default task;

function setOptions(opts) {
  conf = _.merge({}, defaultConfig, opts)
}


function whenInProductionDoMinify() {
  return process.env.NODE_ENV === 'production' || gutil.env.debug ? minifyCSS({
    keepBreaks:true
  }) : gutil.noop()
}
