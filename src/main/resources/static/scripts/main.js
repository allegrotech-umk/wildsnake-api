function wildsnakeCtrl($http) {
  $http.get('/api/v1/products?limit=4').then(response => this.products = response.data);
}

function wildsnakeConfig ($interpolateProvider) {
  $interpolateProvider.startSymbol('[[').endSymbol(']]');
}

angular.module('wildsnake', [])
  .config(wildsnakeConfig)
  .controller('WildsnakeCtrl', wildsnakeCtrl);

