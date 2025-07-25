The Great Name Change of 2015
=============================

As of 1.17 CLM server is being renamed to Nexus IQ Server.

System Requirements
===================

Since release 89 (April 2020), Nexus IQ Server supports Java 8 or Java 11 as a runtime.

Internet Explorer 11+ or equivalent modern browsers from other vendors will be required for proper interaction with the web application.

Running the Nexus IQ Server
===========================

To start the Nexus IQ Server in a mode that is useful for a short evaluation run the demo script for your operating system: demo.bat or demo.sh.  This starts the server using the sample configuration file supplied in this bundle with the following defaults:
- listening on port 8070
- log to the console and ./log/clm-server.log
- data stored in ./sonatype-work/clm-server

Refer to the example config.yml in this bundle for additional options.

Authentication in the Nexus IQ Server
=====================================

Nexus IQ Server requires authentication to access the web interface.  The default username/password to access the system is admin/admin123
It is recommended that you change this password after logging in.

Documentation and Support
=========================

For more comprehensive documentation that includes full installation, configuration and usage instructions, please visit our documentation portal: http://links.sonatype.com/products/clm/doc.

If you are experiencing trouble with any part of Sonatype Nexus Lifecycle, you can always visit our support site at http://links.sonatype.com/products/clm/support. There you can view our knowledge base and contact our support team directly.
