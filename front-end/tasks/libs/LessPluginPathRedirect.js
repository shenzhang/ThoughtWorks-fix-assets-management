class LessPluginPathRedirect {
  constructor(options) {
    this.options = options;
  }

  install(less, pluginManager) {
    let PathRedirect = getPathRedirect(less);
    pluginManager.addFileManager(new PathRedirect(this.options));
  }
}

export default LessPluginPathRedirect;

function getPathRedirect(less) {

  class PathRedirect extends less.FileManager {
    constructor(options) {
      super();
      this.options = options;
    }

    supports(filename, currentDirectory, options, environment) {
      return (filename in this.options);
    }

    resolve(filename, currentDirectory) {
      if (filename in this.options) {
        filename = this.options[filename];
      }
      return filename;
    }

    loadFile(filename, currentDirectory, options, environment) {
      try {
        filename = this.resolve(filename, currentDirectory);
      } catch (e) {
        return new Promise((resolve, reject)=> {
            reject(e);
          }
        );
      }
      return super.loadFile(filename, "", options, environment);
    }

    loadFileSync(filename, currentDirectory, options, environment) {
      try {
        filename = this.resolve(filename, currentDirectory);
      } catch (e) {
        return {error: e};
      }
      return super.loadFileSync(filename, "", options, environment);
    }
  }

  return PathRedirect;
}
