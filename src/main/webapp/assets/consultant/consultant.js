app.factory('CstService', ['$http', function ($http) {
    return {
        getList: function (params) {
            return $http.post("rest/api/public/cst/list", params);
        },
        getConsultant: function (cstId) {
        	return $http.get("rest/api/public/cst/" + cstId);
        }
    };
}]);

app.controller("CstListCtrl", ["$scope", "CstService", function($scope, CstService){
	
	$scope.loading = true;
    $scope.loadingMore = false;
    $scope.hasMore = true;
    $scope.page = 1;
    $scope.pageSize = 20;
    $scope.cstList = [];
    
    $scope.load = function() {
    	var params = {page:$scope.page, pageSize:$scope.pageSize};
    	CstService.getList(params).success(function(response){
    		$scope.cstList = $scope.cstList.concat(response.data);
    		$scope.hasMore = (response.data.length == $scope.pageSize);
            $scope.loading = false;
            $scope.loadingMore = false;
    	});
    };
    
    $scope.load();
    
    //加载更多
    $scope.loadMore = function() {
        if ($scope.loadingMore || !$scope.hasMore)
            return;
        
        $scope.loadingMore = true;
        $scope.page = $scope.page+1;
        $scope.load();
    };
    
    $scope.viewCst = function(cst) {
    	appNavigator.pushPage("assets/consultant/detail.html", {cst:cst});
    };
	
}])
.controller("CstDetailCtrl", ["$scope", "CstService", function($scope, CstService){
	$scope.cst = appNavigator.getCurrentPage().options.cst;
	$scope.loading = true;
	
	CstService.getConsultant($scope.cst.id).success(function(response) {
		$scope.cst = response.data;
		$scope.goodAt = $scope.cst.goodAt.split(",");
		
		$scope.loading = false;
	});
	
}]);

