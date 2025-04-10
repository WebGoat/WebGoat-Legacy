<!DOCTYPE html>sp.webgoat;
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->eDateFormat;
<html class="no-js">e;
<!--<![endif]-->.Locale;
import java.util.TimeZone;
<head> javax.servlet.ServletContext;
    <meta charset="utf-8">etException;
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>WebGoat</title>HttpServletRequest;
    <meta name="description" content="">ponse;
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <!-- Favicon -->goat.lessons.AbstractLesson;
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
    <!-- Bootstrap core CSS -->s.admin.WelcomeAdminScreen;
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Fonts from Font Awsome -->rorScreen;
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <!-- CSS Animate -->.session.UserTracker;
    <link rel="stylesheet" href="assets/css/animate.css">
    <!-- Custom styles for this theme -->ontext;
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- Vector Map  -->actory;
    <link rel="stylesheet" href="assets/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css">
    <!-- ToDos  -->
    <link rel="stylesheet" href="assets/plugins/todo/css/todos.css">********************************
    <!-- Morris  -->
    <link rel="stylesheet" href="assets/plugins/morris/css/morris.css">
    <!-- Fonts -->rt of WebGoat, an Open Web Application Security Project
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <!-- Feature detection -->Bruce Mayhew
    <script src="assets/js/modernizr-2.6.2.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>NU General Public License as published by the Free Software
    <script src="assets/js/html5shiv.js"></script> (at your option) any later
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head> program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
<body class="animated fadeIn">ee the GNU General Public License for more
    <section id="container">
        <header id="header">
            <!--logo start--> copy of the GNU General Public License along with
            <div class="brand">to the Free Software Foundation, Inc., 59 Temple
                <a href="index.html" class="logo"><span>Web</span>Goat</a>
            </div>
            <!--logo end-->=====
            <div class="toggle-navigation toggle-left">
                <button type="button" class="btn btn-default" id="toggle-left" data-toggle="tooltip" data-placement="right" title="Toggle Navigation">
                    <i class="fa fa-bars"></i>
                </button>
            </div><!--toggle navigation end-->ub.io
            <div class="lessonTitle">
            	<h1>Lesson Title in here</h1>
            </div><!--lesson title end-->www.aspectsecurity.com">Aspect
            <div class="user-nav pull-right">
            	<button type="button" class="btn btn-default" data-toggle="modal" data-target="#aboutModal">
                	<i class="fa fa-info"></i>
                </button>
                <button type="button" class="btn btn-default">
                	<i class="fa fa-envelope"></i>
                </button> LoggerFactory.getLogger(HammerHead.class);
                <button type="button" class="btn btn-default">
                	<i class="fa fa-user"></i>"welcomed";
                </button>
            </div>
        </header>
        <!--sidebar left start-->
        <aside class="sidebar">erialVersionUID = 645640331343188020L;
            <div id="leftside-navigation" class="nano">
                <ul class="nano-content">
                	<li class="sub-menu">
                        <a href=""><i class="fa fa-bars"></i><span>LESSONS</span></a>
                    </li>leDateFormat httpDateFormat;
                    <li class="sub-menu">
                        <a href="javascript:void(0);"><span>General</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>ut to be 2 days
                            <li><a href="httpBasics.html">Http Basics</a></li>
                            <li><a href="httpSplitting.html">Http Splitting</a></li>
                            <li><a href="threadSafetyProblem.html">Thread Safety Problem</a></li>
                        </ul>nt sessionTimeoutSeconds = 1;
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:void(0);"></i><span>Broken Authentication & Session Management</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>pertiesPath = null;
                            <li><a href="#">Basic Authentication</a></li>
                            <li><a href="#">Weak Authentication Code</a></li>
                        </ul>ethods for getting setup information from the
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:void(0);"><span>Broken Access Control</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>
                            <li><a href="#">Access Control Matrix</a></li>
                            <li><a href="#">Path Based Access Control</a></li>
                            <li><a href="#">Role Based Access Control</a></li>
                        </ul>tion of the Parameter
                    </li>scription of the Parameter
                    <li class="sub-menu"> of the Exception
                        <a href="javascript:void(0);"><span>Cross-Site Scripting (XSS)</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>
                            <li><a href="#">Stored XSS</a></li>
                            <li><a href="#">Reflected XSS</a></li>nse response) throws IOException, ServletException {
                            <li><a href="#">CSRF</a></li>
                            <li><a href="#">CSRF Prompt Bypass</a></li>
                            <li><a href="#">CSRF Token Bypass</a></li>
                        </ul>
                    </li> Method
                    <li class="sub-menu">
                        <a href="javascript:void(0);"><span>Unvalidated Parameters</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>iption of the Parameter
                            <li><a href="#">Hidden Field Tampering</a></li>
                            <li><a href="#">Java Script Validation</a></li>
                            <li><a href="#">Unchecked Email</a></li>
                        </ul>
                    </li>tpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                    <li class="sub-menu">
                        <a href="javascript:void(0);"><span>Insecure Storage</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul> = null;
                            <li><a href="#">Encoding</a></li>
                        </ul>ering doPost");
                    </li>"request: " + request);
                    <li class="sub-menu">request.getUserPrincipal());
                        <a href="javascript:void(0);"><span>Injection Flaws</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>ontext = getServletContext();
                            <li><a href="#">SQL Numeric Injection</a></li>
                            <li><a href="#">SQL String Injection</a></li>
                            <li><a href="#">Command Injection</a></li>
                            <li><a href="#">Log Spoofing</a></li>;
                        </ul>
                    </li>isCommitted()) {
                    <li class="sub-menu">ready committed, exiting");
                        <a href="javascript:void(0);"><span>Improper Error Handling</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>
                            <li><a href="#">Fail Open Authentication</a></li>
                        </ul>(request.getParameter("start")) || request.getQueryString() == null) {
                    </li>rn("Redirecting to start controller");
                    <li class="sub-menu">art.mvc");
                        <a href="javascript:void(0);"><span>Code Quality</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>
                            <li><a href="#"><span>HTML Clues</span></a></li>
                        </ul>lesson to track the status, we need to update
                    </li> tracker object
                    <li class="sub-menu">ent() method. The create content is
                        <a href="javascript:void(0);"><span>Web Services</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>son "knows" what has happened. To track it at a
                            <li><a href="#">Soap Request</a></li>
                            <li><a href="#">WSDL Scanning</a></li>
                            <li><a href="#">WS SQL Injection</a></li>
                        </ul> lesson's
                    </li>est()
                    <li class="sub-menu">
                        <a href="javascript:void(0);"><span>New Lesson</span><i class="arrow fa fa-angle-right pull-right"></i></a>
                        <ul>
                            <li><a href="#">How to Add New Lesson</a></li>
                        </ul>-specific tracking activities
                    </li>stanceof AbstractLesson) {
                </ul>actLesson lesson = (AbstractLesson) screen;
            </div>
                // we do not count the initial display of the lesson screen as a visit
        </aside>if ("GET".equals(request.getMethod())) {
        <!--sidebar left end-->= request.getRequestURI() + "?" + request.getQueryString();
        <!--main content start-->With(lesson.getLink())) {
        <section class="main-content-wrapper">r(mySession).incrementNumVisits();
            <section id="main-content">
            	<div class="row">ST".equals(request.getMethod())
            		<div class="col-md-8">.getPreviousScreen() == mySession.getCurrentScreen()) {
            			<div class="col-md-12" align="left">on).incrementNumVisits();
            				<div class="panel">
            					<div class="panel-body">
            						<button type="button" class="btn btn-primary">Java [Source]</button>
            						<button type="button" class="btn btn-primary">Solution</button>
            					</div> userTracker = UserTracker.instance();
            				</div>r.update(mySession, screen);
            			</div>st, screen.getClass().getName() + " | " + mySession.getParser().toString());
            			<div class="col-md-12">
               				<div class="panel"> our View servlet
                            	<div class="panel-body">r-agent");
               						<h1>About WebGoat</h1>wn!";
               						<hr />= null) {
               						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque volutpat feugiat nunc, non vulputate urna dictum ut. Nam consectetur porttitor diam ut ultricies. Aenean dolor dolor, congue sed ornare non, elementum in mauris. Phasellus orci sem, rhoncus eu laoreet eu, aliquam nec ante. Suspendisse sit amet justo eget eros tempor tincidunt vel quis justo. Sed pulvinar enim id neque pellentesque, eu rhoncus lorem eleifend. Morbi congue tortor sit amet pulvinar posuere.</p>
              						<p>Integer rhoncus gravida arcu, at bibendum magna feugiat sit amet. Vivamus id lacinia massa. Praesent eu quam ullamcorper, tempor elit nec, lobortis massa. In in eros eu augue rhoncus semper. Vestibulum ornare purus vitae bibendum vulputate. Cras eleifend commodo lectus, eget pharetra justo mollis quis. Donec tempor magna lectus, vitae suscipit turpis venenatis et. Nulla facilisi.</p>
              						<p>Nam placerat magna in massa euismod fringilla. Pellentesque in cursus risus, eu hendrerit ligula. Quisque ultrices eget tortor ut eleifend. Praesent auctor libero nec quam fringilla faucibus. Curabitur cursus risus eu faucibus rutrum. Morbi dapibus nulla risus, et euismod eros posuere volutpat. Quisque ut diam diam. Quisque sed enim tortor. Suspendisse commodo magna nec felis ultricies laoreet. Donec sit amet vehicula eros. Phasellus at dapibus enim. Sed massa quam, aliquet eu mattis at, porttitor a nisi.</p>
              						<hr />his is being done in updateSession call
              						<p>Nam placerat magna in massa euismod fringilla. Pellentesque in cursus risus, eu hendrerit ligula. Quisque ultrices eget tortor ut eleifend. Praesent auctor libero nec quam fringilla faucibus. Curabitur cursus risus eu faucibus rutrum. Morbi dapibus nulla risus, et euismod eros posuere volutpat. Quisque ut diam diam. Quisque sed enim tortor. Suspendisse commodo magna nec felis ultricies laoreet. Donec sit amet vehicula eros. Phasellus at dapibus enim. Sed massa quam, aliquet eu mattis at, porttitor a nisi.</p>
               					</div>y this is being set in the session?
               				</div>Session().setAttribute(WebSession.COURSE, mySession.getCourse());
               			</div>age = getViewPage(mySession);
               		</div><!--col-md-8 end-->ew: " + viewPage);
            		<div class="col-md-4">+ screen);
            			<div class="col-md-12">er(viewPage).forward(request, response);
            			<div class="panel">
            				<div class="panel-body"> request", t);
            					<div align="left">n(mySession, t);
            						<button type="button" class="btn btn-default btn-sm">Params</button>
            						<button type="button" class="btn btn-default btn-sm">Hints</button>
            						<button type="button" class="btn btn-default btn-sm">Cookies</button>
            					</div>s.writeScreen(mySession, screen, response);
            					<hr />
            					<h3>Hints</h3>thr) {
            					<p>Nam placerat magna in massa euismod fringilla. Pellentesque in cursus risus, eu hendrerit ligula. Quisque ultrices eget tortor ut eleifend. Praesent auctor libero nec quam fringilla faucibus. Curabitur cursus risus eu faucibus rutrum. Morbi dapibus nulla risus, et euismod eros posuere volutpat. Quisque ut diam diam. Quisque sed enim tortor. Suspendisse commodo magna nec felis ultricies laoreet. Donec sit amet vehicula eros. Phasellus at dapibus enim. Sed massa quam, aliquet eu mattis at, porttitor a nisi.</p>
            				</div>
            			</div>n.returnConnection(mySession);
            			</div>bug("Leaving doPost: ");
            		</div><!--col-md-4 end-->              		
				</div>
                <div id="lesson-content-root"></div>
                <script src="assets/js/lessonContent.js"></script>
            </section>ng getViewPage(WebSession webSession) {
        </section>x.html";
        <!--main content end-->
        
  	<!-- Basic Modal -->
    <div class="modal fade" id="aboutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">meter
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h3 class="modal-title" id="myModalLabel">About WebGoat</h3>tring formatHttpDate(Date date) {
                </div>
                <div class="modal-body modal-scroll">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis posuere sapien, at ornare neque. Curabitur commodo efficitur ante, at finibus ex faucibus ut. Vivamus id diam blandit, convallis justo sed, vehicula sem. Cras a semper ex. Etiam dignissim tempus metus, sit amet blandit arcu pulvinar ac. Mauris dignissim rutrum ante sit amet posuere. Proin mollis sapien augue, at tempor metus iaculis eu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Cras elementum finibus tincidunt.</p>
                    <p>Version</p>
                    <p>OWASP Reference - probably text and image</p>
                    <div class="row">
                    	<div class="col-md-6">vlet
                  		  <p>WebGoat Authors
                    			<ul>
                    				<li>name...</li>
                    				<li>name...</li>
                    				<li>name...</li>Info() {
                    			</ul>sponsored by Aspect Security.";
                  		  	</p>
                    	</div>
                    	<div class="col-md-6">
							<p>WebGoat Design Teamn properties path
								<ul>
									<li>name...</li>let.ServletException
									<li>name...</li>
									<li>name...</li>
								</ul>void init() throws ServletException {
							</p>er.info("Initializing main webgoat servlet");
						</div>pDateFormat = new SimpleDateFormat("EEE, dd MMM yyyyy HH:mm:ss z", Locale.US);
					</div>.setTimeZone(TimeZone.getTimeZone("GMT"));
					<div class="row">).getRealPath("/WEB-INF/webgoat.properties");
                    	<div class="col-md-6">WebgoatContext(this);
							<p>Active Contributors
								<ul>
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>n of the Parameter
									<li>name... (Role)</li>n of the Parameter
									<li>name... (Role)</li>
									<li>name... (Role)</li>equest request, String message) {
									<li>name... (Role)</li>() + " | " + request.getRemoteHost() + ":" + request.getRemoteAddr() + " | " + message;
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>
								</ul>ic List getLessons(Category category, String role) { Course course =
							</p>sion.getCourse(); // May need to clone the List before returning it. //return new
						</div>essons(category, role)); return course.getLessons(category, role); }
						<div class="col-md-6">
							<p>Past Contributors
								<ul>
									<li>name... (Role)</li>
									<li>name... (Role)</li>he Parameter
									<li>name... (Role)</li>e Return Value
									<li>name... (Role)</li>
									<li>name... (Role)</li>WebSession s) {
									<li>name... (Role)</li>
									<li>name... (Role)</li>reen();
									<li>name... (Role)</li>rse();
									<li>name... (Role)</li>
									<li>name... (Role)</li>allenge()) {
									<li>name... (Role)</li>n.WELCOME) {
									<li>name... (Role)</li>comeScreen(s);
									<li>name... (Role)</li>
									<li>name... (Role)</li>esson = course.getLesson(s, scr, AbstractLesson.USER_ROLE);
									<li>name... (Role)</li>ll && s.isHackedAdmin()) {
									<li>name... (Role)</li>was hacked, let the user see some of the
									<li>name... (Role)</li>eens
									<li>name... (Role)</li>rse.getLesson(s, scr, AbstractLesson.HACKED_ADMIN_ROLE);
									<li>name... (Role)</li>
									<li>name... (Role)</li>
									<li>name... (Role)</li>ll) {
									<li>name... (Role)</li>son;
									<li>name... (Role)</li>
									<li>name... (Role)</li>o do some bookkeeping for the hackable admin
									<li>name... (Role)</li>.
									<li>name... (Role)</li>       // This is the only place we can tell if the user
								</ul>         // successfully hacked the hackable
							</p>        // admin and has actually accessed an admin screen. You
						</div>         // need BOTH pieces of information
					</div> in order to satisfy the remote admin lesson.
                </div>screen.getRole());
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>sson.handleRequest(s);
                </div>  s.setCurrentMenu(lesson.getCategory().getRanking());
            </div>  } else {
        </div>          screen = new ErrorScreen(s, "Invalid screen requested.  Try: http://localhost/WebGoat/attack");
    </div>
    <!-- End Basic Modal -->    }
         if (s.isAdmin()) {
    </section>== WebSession.WELCOME) {
    <!--Global JS-->
    <script src="assets/js/jquery-1.10.2.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/plugins/waypoints/waypoints.min.js"></script>ist of roles.
    <script src="assets/js/application.js"></script>on(s, scr, AbstractLesson.ADMIN_ROLE);
</body>                if (lesson == null) {
             lesson = course.getLesson(s, scr, AbstractLesson.HACKED_ADMIN_ROLE);
</html>                }
                }

                if (lesson != null) {
                    screen = lesson;

                    // We need to do some bookkeeping for the hackable admin
                    // interface.
                    // This is the only place we can tell if the user
                    // successfully hacked the hackable
                    // admin and has actually accessed an admin screen. You
                    // need BOTH pieces of information
                    // in order to satisfy the remote admin lesson.
                    s.setHasHackableAdmin(screen.getRole());

                    lesson.handleRequest(s);
                    s.setCurrentMenu(lesson.getCategory().getRanking());
                } else {
                    screen = new ErrorScreen(s,
                            "Invalid screen requested.  Try Setting Admin to false or Try: http://localhost/WebGoat/attack");
                }
            }
        }

        return (screen);
    }

    /**
     * This method sets the required expiration headers in the response for a
     * given RunData object. This method attempts to set all relevant headers,
     * both for HTTP 1.0 and HTTP 1.1.
     *
     * @param response The new cacheHeaders value
     * @param expiry The new cacheHeaders value
     */
    protected static void setCacheHeaders(HttpServletResponse response, int expiry) {
        if (expiry == 0) {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expires", formatHttpDate(new Date()));
        } else {
            Date expiryDate = new Date(System.currentTimeMillis() + expiry);
            response.setHeader("Expires", formatHttpDate(expiryDate));
        }
    }

    /**
     * Description of the Method
     *
     * @param request Description of the Parameter
     * @param response Description of the Parameter
     * @param context Description of the Parameter
     * @return Description of the Return Value
     * @throws java.io.IOException
     */
    protected WebSession updateSession(HttpServletRequest request, HttpServletResponse response, ServletContext context)
            throws IOException {
        HttpSession hs;
        // session should already be created by spring security
        hs = request.getSession(false);

        logger.debug("HH Entering Session_id: " + hs.getId());
        // dumpSession( hs );
        // Get our session object out of the HTTP session
        WebSession session = null;
        Object o = hs.getAttribute(WebSession.SESSION);

        if ((o != null) && o instanceof WebSession) {
            session = (WebSession) o;
            hs.setAttribute(WebSession.COURSE, session.getCourse());
        } else {
            // Create new custom session and save it in the HTTP session
            logger.warn("HH Creating new WebSession");
            session = new WebSession(webgoatContext, context);
            // Ensure splash screen shows on any restart
            // rlawson - removed this since we show splash screen at login now
            //hs.removeAttribute(WELCOMED);
            hs.setAttribute(WebSession.SESSION, session);
            // reset timeout
            hs.setMaxInactiveInterval(sessionTimeoutSeconds);
        }

        session.update(request, response, this.getServletName());
        // update last attack request info (cookies, parms)
        // this is so the REST services can have access to them via the session 
        session.updateLastAttackRequestInfo(request);

        // to authenticate
        logger.debug("HH Leaving Session_id: " + hs.getId());
        //dumpSession( hs );
        return (session);
    }

    /**
     * Description of the Method
     *
     * @param s Description of the Parameter
     * @param screen
     * @param response Description of the Parameter
     * @exception IOException Description of the Exception
     */
    protected void writeScreen(WebSession s, Screen screen, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (s == null) {
            screen = new ErrorScreen(s, "Page to display was null");
        }

        // set the content-length of the response.
        // Trying to avoid chunked-encoding. (Aspect required)
        response.setContentLength(screen.getContentLength());
        response.setHeader("Content-Length", screen.getContentLength() + "");

        screen.output(out);
        out.flush();
        out.close();
    }
}
