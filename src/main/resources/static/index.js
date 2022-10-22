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
});

//    const contextPath = 'http://localhost:8189/market';
//
//    $scope.fillTable = function() {
//        $http.get(contextPath + '/api/v1/products')
//            .then(function(response) {
//                $scope.ProductList = response.data;
//            });
//    };
//
//    $scope.submitCreateNewProduct = function () {
//        $http.post(contextPath + 'api/v1/products', $scope.newProduct)
//            .then(function (response) {
//                $scope.fillTable();
//            });
//    };
//
//    $scope.applyFilter = function () {
//        $http({
//            url: contextPath + 'api/v1/product',
//            method: "GET",
//            params: {book_title: $scope.productFilter.title}
//        }).then(function (response) {
//            $scope.ProductList = response.data;
//        });
//    }
//
//    $scope.deleteProductById = function(productId) {
//        console.log('deleteTest');
//        $http({
//                   url: contextPath + 'api/v1/products' + productId,
//                   method: "DELETE",
//                   params: {book_title: $scope.bookFilter.title}
//               }).then(function (response) {
//                   $scope.fillTable();
//               });
//    }
//    $scope.fillTable();
//});