package practice.docs.spring.mvc;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class MyErrorViewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if (status.is4xxClientError()) {
            return new ModelAndView("client-error.html");
        }
        if (status.is5xxServerError()) {
            return new ModelAndView("server-error.html");
        }
        return new ModelAndView("normal-error.html");
    }
}
