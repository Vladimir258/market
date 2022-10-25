angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {
    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/market/auth', $scope.user)
            .then(function successCallback(response) {
                if(response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.springWebUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.springWebUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.springWebUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.checkAuth = function () {
        $http.get('http://localhost:8189/market/auth_check').then(function (response) {
            alert(response.data.value);
        });
    };

    if($localStorage.springWebUser) {
        try {
            let jwt = $localStorage.springWebUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime()/1000);
            if(currentTime > payload.exp) {
                console.log("Token is expired!");
                delete $localStorage.springWebUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.springWebUser.token;
    }

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



    $scope.loadCart = function () {
        $http.get('http://localhost:8189/market/api/v1/cart').then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:8189/market/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.deleteFromCart = function (productId) {
        $http.delete('http://localhost:8189/market/api/v1/cart/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.clearCart = function () {
            $http.get('http://localhost:8189/market/api/v1/cart/clear').then(function (response) {
                $scope.loadCart();
            });
        }

    $scope.loadProducts();
    $scope.loadCart();
});

