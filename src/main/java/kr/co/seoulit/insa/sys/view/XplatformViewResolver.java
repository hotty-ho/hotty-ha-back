package kr.co.seoulit.insa.sys.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class XplatformViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return (map, httpServletRequest, httpServletResponse) -> {};
    }
}
