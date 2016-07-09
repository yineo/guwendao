<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="app" ng-csp>

    <head>
        <meta charset="utf-8" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="mobile-web-app-capable" content="yes" />
        <meta http-equiv="Content-Security-Policy" content="default-src * data: gap: 121.9.234.5:8027 'unsafe-eval'; style-src 'self' 'unsafe-inline'; media-src *" />
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi" />
        
        <title>顾问岛</title>
        
        <!-- CSS dependencies -->
        <link rel="stylesheet" href="assets/common/css/onsenui.css" />
        <link rel="stylesheet" href="assets/common/css/onsen-css-components.css"/>
        <link rel="stylesheet" href="assets/common/css/app.css"/>
        
        <!-- <script type="text/javascript" src="assets/common/js/onsenui_all.min.js"></script>  -->
        <script type="text/javascript" src="assets/common/js/angular.min.js"></script>
        <script type="text/javascript" src="assets/common/js/onsenui.js"></script>
        <script type="text/javascript" src="assets/common/js/app.js"></script>
        
        <!-- Controllers & Service -->
        <script type="text/javascript" src="assets/consultant/consultant.js"></script>
        <script type="text/javascript" src="assets/answer/answer.js"></script>
        <script type="text/javascript" src="assets/me/me.js"></script>
        
    </head>
    
    <body>
	    <ons-navigator var="appNavigator">
	    	<ons-page>
		        <ons-tabbar>
			      <ons-tab page="assets/consultant/list.html" label="顾问" active="true"></ons-tab>
			      <ons-tab page="assets/answer/list.html" label="悬赏"></ons-tab>
			      <ons-tab page="assets/me/me.html" label="我的"></ons-tab>
			    </ons-tabbar>
		    </ons-page>
	    </ons-navigator>
    </body>
    
</html>
        