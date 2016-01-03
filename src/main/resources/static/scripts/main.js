function wildsnakeCtrl($http) {
  $http.get('/products').then(response => this.products = response.data);
}

function wildsnakeConfig ($interpolateProvider) {
  $interpolateProvider.startSymbol('[[').endSymbol(']]');
}

angular.module('wildsnake', [])
  .config(wildsnakeConfig)
  .controller('WildsnakeCtrl', wildsnakeCtrl);
