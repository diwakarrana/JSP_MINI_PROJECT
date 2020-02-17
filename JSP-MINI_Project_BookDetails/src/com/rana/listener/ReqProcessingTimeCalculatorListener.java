package com.rana.listener;

import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;

public class ReqProcessingTimeCalculatorListener implements 
	ServletRequestListener 
	{
		private long start,end;
		
		@Override
		public void requestInitialized(ServletRequestEvent sre)
		{
			start= System.currentTimeMillis();
		}
	
		@Override
		public void requestDestroyed(ServletRequestEvent sre) 
		{
			end = System.currentTimeMillis();
			//write req processing time to log file
			ServletContext sc = sre.getServletContext();
			sc.log(((HttpServletRequest)sre.getServletRequest()).getRequestURL()+
					"has taken"+(end - start)+"ms");
			System.out.println(((HttpServletRequest)sre.getServletRequest()).
					getRequestURL()+"has taken"+(end - start)+"ms");
		}
	}
