//main goat application file
//TODO: reorg

/* ### GOAT CONTROLLERS ### */

/** Lesson Controller (includes menu stuff)
 *  prepares and updates menu topic items for the view
 */
//<<<<<<< Updated upstream
//goat.controller('goatLesson', function($scope, $http, $modal, $log, $sce) { //$templateCache
//=======
var goatMenu = function($scope, $http, $modal, $log, $templateCache) {
    $scope.cookies = [];
    $scope.params = [];
    $scope.renderMenu = function() {
	goat.data.loadMenu($http).then( //$http({method: 'GET', url: goatConstants.lessonService})
	    function(menuData) {
		var menuItems = goat.utils.addMenuClasses(goatConstants.menuPrefix.concat(menuData.data));
		for (var i=0;i<menuItems.length;i++) {
		    if (menuItems[i].name) {
			menuItems[i].id = menuItems[i].name.replace(/\s|\(|\)/g,'');
		    }
		}

		$scope.menuTopics = menuItems;
	    },
	    function(error) {
		// TODO - handle this some way other than an alert
		console.error("Error rendering menu: " + error);
	    }	
	);
    };

    $scope.renderLesson = function(url) {
        //console.log(url + ' was passed in');
        // use jquery to render lesson content to div
        $scope.hintIndex = 0;
        var curScope = $scope;
      
        curScope.parameters = goat.utils.scrapeParams(url);
        goat.data.loadLessonContent($http,url).then(
	    function(reply) {
		goat.data.loadLessonTitle($http).then(
		    function(reply) {
			    $("#lessonTitle").text(reply.data);
		    }
		);
		$("#lesson_content").html(reply.data);
		$('#leftside-navigation').height($('#main-content').height()+15)
	    }
    )};
    $scope.accordionMenu = function(id) {
	if ($('ul#'+id).attr('isOpen') == 0) {
	    $scope.expandMe = true;    
	} else {
	    $('ul#'+id).slideUp(300).attr('isOpen',0);
	    return;
	}
	$('.lessonsAndStages').not('ul#'+id).slideUp(300).attr('isOpen',0);
	if ($scope.expandMe) {
	    $('ul#'+id).slideDown(300).attr('isOpen',1);
	}
	console.log('accordion for ' + id);
    }
    $scope.renderMenu();
    //can be augmented later to 'resume' for a given user ... currently kluged to start at fixed lesson
    var url = 'attack?Screen=32&menu=5';
    angular.element($('#leftside-navigation')).scope().renderLesson(url);
}

/*goatMenu.animation('.slideDown', function() {
    var NgHideClassName = 'ng-hide';
    return {
        beforeAddClass: function(element, className, done) {
            if (className === NgHideClassName) {
                $(element).slideUp(done);
            }
        },
        removeClass: function(element, className, done) {
            if (className === NgHideClassName) {
                $(element).hide().slideDown(done);
            }
        }
    };


});*/

var goatLesson = function($scope,$http,$log) {
    //hook forms

    $('#hintsView').hide();
	// adjust menu to lessonContent size if necssary
	//@TODO: this is still clunky ... needs some TLC
	if ($('div.panel-body').height() > 400) {
		    $('#leftside-navigation').height($(window).height());
		}
		//cookies
		goat.data.loadCookies($http).then(
			function(resp) {
			    curScope.cookies = resp.data;
			}
		);
		//hints
		curScope = $scope; //TODO .. update below, this curScope is probably not needed
		curScope.hintIndex = 0;
		goat.data.loadHints($http).then(
			function(resp) {
			    curScope.hints = resp.data;
			    if (curScope.hints.length > 0 && curScope.hints[0].hint.indexOf(goatConstants.noHints) === -1) {
				goat.utils.displayButton('showHintsBtn', true);
			    } else {
				goat.utils.displayButton('showHintsBtn', false);
			    }
			}
		);
		//source
		goat.data.loadSource($http).then(
			function(resp) {
			    curScope.source = resp.data;
			}
		);
		//plan
		goat.data.loadPlan($http).then(
			function(resp) {
			    curScope.plan = resp.data;
			}
		);
		//solution
		goat.data.loadSolution($http).then(
			function(resp) {
			    curScope.solution = resp.data;
			}
		);
		goat.utils.scrollToTop();


    $scope.showLessonSource = function() {
        $('.lessonHelp').hide();
        $('#lesson_source_row').show();
        goat.utils.scrollToHelp();
    }

    $scope.showLessonPlan = function() {
        $('.lessonHelp').hide();
        $("#lesson_plan").html($scope.plan);
        $('#lesson_plan_row').show();
        goat.utils.scrollToHelp();
    }

    $scope.showLessonSolution = function() {
        $('.lessonHelp').hide();
        $("#lesson_solution").html($scope.solution);
        $('#lesson_solution_row').show();
        goat.utils.scrollToHelp();
    }

    $scope.manageHintButtons = function() {
        if ($scope.hintIndex === $scope.hints.length - 1) {
            $('#showNextHintBtn').css('visibility', 'hidden');
        } else if ($scope.hintIndex < $scope.hints.length - 1) {
            $('#showNextHintBtn').css('visibility', 'visible');
        }
        //
        if ($scope.hintIndex === 0) {
            $('#showPrevHintBtn').css('visibility', 'hidden');
        } else if ($scope.hintIndex > 0) {
            $('#showPrevHintBtn').css('visibility', 'visible');
        }
    };

    $scope.viewHints = function() {
        if (!$scope.hints) {
            return;
        }

        $('.lessonHelp').hide();
        $('#lesson_hint_row').show();
        //goat.utils.scrollToHelp();
	//TODO
        $scope.curHint = $scope.hints[$scope.hintIndex].hint;
	//$scope.curHint = $sce.trustAsHtml($scope.hints[$scope.hintIndex].hint);
	//TODO get html binding workin in the UI ... in the meantime ...
	$scope.renderCurHint();
        $scope.manageHintButtons();
    };

    $scope.viewNextHint = function() {
        $scope.hintIndex++;
        $scope.curHint = $scope.hints[$scope.hintIndex].hint;
	$scope.renderCurHint();
        $scope.manageHintButtons();
    };

    $scope.viewPrevHint = function() {
        $scope.hintIndex--;
        $scope.curHint = $scope.hints[$scope.hintIndex].hint;
	$scope.renderCurHint();
        $scope.manageHintButtons();
    };
    
    $scope.renderCurHint = function() {
	$('#curHintContainer').html($scope.curHint);
    }

    $scope.hideHints = function() {

    };

    $scope.showAbout = function() {
        $('#aboutModal').modal({
            //remote: 'about.mvc'
        });
    };
}


