
package org.owasp.webgoat.plugin;

import java.io.IOException;

/***************************************************************************************************
 * 
 * 
 * This file is part of WebGoat, an Open Web Application Security Project utility. For details,
 * please see http://www.owasp.org/
 * 
 * Copyright (c) 2002 - 20014 Bruce Mayhew
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 * 
 * Getting Source ==============
 * 
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software
 * projects.
 * 
 * For details, please see http://webgoat.github.io
 * 
 * @author Jeff Williams <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @created October 28, 2003
 */

public class Encoding {

    // local encoders

    private static sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    private static sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    /**
     * Returns the base 64 encoding of a string.
     *
     * @param str
     *            Description of the Parameter
     * @return Description of the Return Value
     */

    public static String base64Encode(String str)
    {

        byte[] b = str.getBytes();

        return (encoder.encode(b));
    }

    /**
     * Returns the base 64 decoding of a string.
     *
     * @param str
     *            Description of the Parameter
     * @return Description of the Return Value
     * @exception java.io.IOException
     *                Description of the Exception
     */

    public static String base64Decode(String str) throws IOException
    {

        byte[] b = decoder.decodeBuffer(str);

        return (new String(b));
    }
}
