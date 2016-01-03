const grunt = require('grunt');

grunt.initConfig({
  sync: {
    templates: {
      files: [{
        expand: true,
        cwd: 'src/main/resources/templates/',
        src: '**',
        dest: 'build/resources/main/templates'
      }]
    },
    statics: {
      files: [{
        expand: true,
        cwd: 'src/main/resources/static/',
        src: '**',
        dest: 'build/resources/main/static'
      }]
    }
  },
  watch: {
    scripts: {
      files: ['src/main/resources/templates/**', 'src/main/resources/static/**'],
      tasks: ['sync'],
      options: {
        interrupt: true
      }
    }
  }
});

grunt.loadNpmTasks('grunt-contrib-watch');
grunt.loadNpmTasks('grunt-sync');
