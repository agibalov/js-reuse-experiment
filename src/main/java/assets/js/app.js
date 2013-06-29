angular.module("app", [], function() {});

angular.module("app").factory("nativeApi", function($http) {
	return {
		addNumbers: function(a, b, onResult) {
			$http.get("/api/native/addNumbers", { params: {
				a: a,
				b: b
			}}).success(function(response) {
				onResult(response);
			});
		}
	};
});

angular.module("app").factory("jsApi", function($http) {
    return {
        addNumbers: function(a, b, onResult) {
            $http.get("/api/js/addNumbers", { params: {
                a: a,
                b: b
            }}).success(function(response) {
                onResult(response);
            });
        }
    };
});

angular.module("app").factory("offlineApi", function($http) {
    return {
        addNumbers: function(a, b, onResult) {            
            var result = calculatorService.addNumbers(a, b);
            onResult({
                "a": a,
                "b": b,
                "result": result
            });
        }
    };
});

angular.module("app").controller("AddNumbersController", function($scope, nativeApi, jsApi, offlineApi) {
	$scope.a = 0;
	$scope.b = 0;
	$scope.nativeResult = "";
	$scope.jsResult = "";
	$scope.offlineResult = "";
	
	$scope.run = function() {
	    var sanitizedA = parseInt($scope.a);
        var sanitizedB = parseInt($scope.b);
        
		nativeApi.addNumbers(sanitizedA, sanitizedB, function(response) {
			$scope.nativeResult = response; 
		});
		
		jsApi.addNumbers(sanitizedA, sanitizedB, function(response) {
            $scope.jsResult = response; 
        });
		
		offlineApi.addNumbers(sanitizedA, sanitizedB, function(response) {
            $scope.offlineResult = response; 
        });
	};
});