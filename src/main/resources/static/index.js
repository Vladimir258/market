angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8189/market/api/v1/products/').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8189/market/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8189/market/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();

    $scope.loadCart = function () {
        $http.get('http://localhost:8189/market/api/v1/products/cart').then(function (response) {
            $scope.inCartList = response.data;
        });
    }

    $scope.addProductInCart = function (productId) {
        $http.get('http://localhost:8189/market/api/v1/products/cart/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteProductByIdFromCart = function (productId) {
        $http.delete('http://localhost:8189/market/api/v1/products/cart/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadCart();
});

