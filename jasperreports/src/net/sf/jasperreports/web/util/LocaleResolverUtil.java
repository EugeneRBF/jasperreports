/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2018 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.web.util;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.web.WebLocaleResolver;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 */
public class LocaleResolverUtil
{

	public static LocaleResolverUtil instance(JasperReportsContext jasperReportsContext)
	{
		return new LocaleResolverUtil(jasperReportsContext);
	}

	private List<WebLocaleResolver> resolvers;

	public LocaleResolverUtil(JasperReportsContext jasperReportsContext)
	{
		resolvers = jasperReportsContext.getExtensions(WebLocaleResolver.class);
	}
	
	public Locale getLocale(HttpServletRequest request)
	{
		Locale locale;
		for (WebLocaleResolver resolver : resolvers)
		{
			locale = resolver.getLocale(request);
			if (locale != null)
			{
				return locale;
			}
		}
		//default
		return Locale.getDefault();
	}
}
