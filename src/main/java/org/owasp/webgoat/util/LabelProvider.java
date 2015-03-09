
package org.owasp.webgoat.util;

import org.owasp.webgoat.plugins.ResourceBundleClassLoader;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;


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
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for
 * free software projects.
 * 
 * For details, please see http://webgoat.github.io
 */
@Component
public class LabelProvider
{
	public final static String DEFAULT_LANGUAGE = Locale.ENGLISH.getLanguage();

	private final HashMap<Locale, ResourceBundle> labels = new HashMap<Locale, ResourceBundle>();
	private final WebGoatResourceBundleController localeController = new WebGoatResourceBundleController();

	public String get(Locale locale, String strName)
	{
		if (!labels.containsKey(locale))
		{
			ClassLoader classLoader = ResourceBundleClassLoader.createPropertyFilesClassLoader(ResourceBundle.class.getClassLoader());
			ResourceBundle resBundle = ResourceBundle.getBundle("WebGoatLabels", locale, classLoader, localeController);
			labels.put(locale, resBundle);
		}
		return labels.get(locale).getString(strName);
	}

	private class WebGoatResourceBundleController extends ResourceBundle.Control
	{
		private final Locale fallbackLocale = new Locale(DEFAULT_LANGUAGE);

		@Override
		public Locale getFallbackLocale(String baseName, Locale locale)
		{
			if (!fallbackLocale.equals(locale)) { return fallbackLocale; }
			return Locale.ROOT;
		}
	}

}
