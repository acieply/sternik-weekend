package pl.sternik.weekend.ac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class BaseFilter implements Filter, Serializable {
	private static final long serialVersionUID = -446119629965179030L;

	private static final Logger LOG = LoggerFactory.getLogger(BaseFilter.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		LOG.info("We/y init 1 config={}", config);
	}

	@Override
	public void destroy() {
		LOG.info("We/y destroy 1");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.info("We doFilter 1");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.addHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		httpResponse.addHeader("Cache-Control", "max-age=2592000");
		httpResponse.setHeader("Expires", "Fri, 12 Oct 2007 01:00:00 GMT");
		httpResponse.setHeader("Age", "0");
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		if (httpRequest.getServletPath().endsWith(".xhtml")) {
			LOG.warn("Próba wejścia na " + httpRequest.getContextPath() + httpRequest.getServletPath());
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
		} else {
			chain.doFilter(request, response);
		}

		LOG.info("Wy doFilter 1");
	}

}
